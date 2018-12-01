package com.ddlab.rnd.cassandra;

import com.datastax.driver.core.*;

import java.math.BigInteger;
import java.util.Date;

/**
 * This class provides a basic overview of using cassandra using java.
 *
 * @Author Debadatta Mishra
 */
public class BasicDBOperations {

    /**
     * Host name of connection points
     */
    private final String HOST_NAME = "192.168.119.131";
    /**
     * port number for cassandra
     */
    private final int PORT = 9042;
    /**
     * Cassandra Cluster information
     */
    private Cluster cluster = null;
    /**
     * Cassandra Session
     */
    private Session cassandraSession = null;

    /**
     * Method to get session to cassandra
     *
     * @param node, host name of Cassandra running system
     * @param port  , port number of Cassandra running system
     * @return
     */
    public Session getSession(String node, int port) {
        if (cassandraSession == null) {
            cassandraSession = createSession(node, port);
        }
        return cassandraSession;
    }

    /**
     * Method to create a session for cassandra
     *
     * @param node
     * @param port
     * @return
     */
    protected Session createSession(String node, int port) {
        cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
        return cluster.connect();
    }

    /**
     * Method to get all Employees information
     */
    public void getAllEmployeeInfo() {
        String cqlStatement = "select * from test1.employees";
        Session session = getSession(HOST_NAME, PORT);
        try {
            ResultSet results = session.execute(cqlStatement);
            System.out.printf("%s\t, %s\t, %s\t, %s\t, %s\t, %s\t,%s\t,%s\t",
                    "empId", "empName", "empDesgn", "empAddress", "empPhone",
                    "empSal", "createdDate", "updatedDate");
            System.out.println("\n");
            for (Row row : results) {
//                System.out.println(row.toString());
                System.out.printf("%d\t, %s\t, %s\t, %s\t, %d\t, %d\t", row.getInt("empId"),
                        row.getString("empName"), row.getString("empDesgn"),
                        row.getString("empAddress"), row.getVarint("empPhone"),
                        row.getVarint("empSal"));
                System.out.printf(",%s\t", row.getTimestamp("createdDate").toString());
                Date updatedSqlDate = row.getTimestamp("updatedDate");
                if (updatedSqlDate != null)
                    System.out.printf(",%s\t", row.getTimestamp("updatedDate").toString());
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to insert data into Cassandra table
     *
     * @param empId
     * @param empName
     * @param empDesgn
     * @param empAddress
     * @param empPhone
     * @param empSal
     * @param createdDate
     * @param updatedDate
     */
    public void insertRow(int empId, String empName, String empDesgn, String empAddress, int
            empPhone, int empSal, Date createdDate, Date updatedDate) {

        String cqlInsertQuery = "insert into test1.employees(empId,empName,empDesgn,empAddress," +
                "empPhone,empSal,createdDate,updatedDate)" +
                " values(?,?,?,?,?,?,?,?)";

        Session session = getSession(HOST_NAME, PORT);

        //Spring Support
        // http://docs.spring.io/spring-data/cassandra/docs/1.0.2
        // .RELEASE/reference/html/cassandra.core.html

        PreparedStatement prepared = session.prepare(cqlInsertQuery);

        BigInteger empPhone1 = BigInteger.valueOf(empPhone);
        BigInteger empSal1 = BigInteger.valueOf(empSal);

        BoundStatement bound = prepared.bind(empId, empName, empDesgn, empAddress, empPhone1,
                empSal1, createdDate, updatedDate);
        session.execute(bound);
        System.out.println("Data inserted successfully ...");
    }

    /**
     * Method to update data in Cassandra table
     *
     * @param empId
     * @param desgn
     * @param updatedDate
     */
    public void update(int empId, String desgn, Date updatedDate) {
        String cqlUpdateQuery = "update test1.employees set empDesgn = ?, updatedDate = ? where " +
                "empId = ?";
        Session session = getSession(HOST_NAME, PORT);
        PreparedStatement pStatement = session.prepare(cqlUpdateQuery);
        BoundStatement bound = pStatement.bind(desgn, updatedDate, empId);
        session.execute(bound);
        System.out.println("Data updated successfully ...");
    }

    /**
     * Method to close sessions and cluster
     */
    private void closeAll() {
        getSession(HOST_NAME, PORT).close();
        if (!cluster.isClosed())
            cluster.close();
    }

    /**
     * Method to execute
     *
     * @param args
     */
    public static void main(String[] args) {
        BasicDBOperations basicOp = new BasicDBOperations();
        basicOp.getAllEmployeeInfo();

        basicOp.insertRow(7, "Udita", "HR", "Bangalore", 223456, 2367, new Date(), null);
        basicOp.insertRow(8, "Ravi", "CTO", "Kolkatta", 123456, 4567, new Date(), null);
        basicOp.update(8, "Business HR", new Date());

        basicOp.closeAll();
    }
}
