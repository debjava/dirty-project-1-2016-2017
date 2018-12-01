package com.ddlab.rnd.spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;

/**
 * Created by PIKU on 11/18/2016.
 */
public class Temp1 {

    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        CassandraOperations cassandraOperations = appContext.getBean("cassandraTemplate", CassandraOperations.class);
        System.out.println(cassandraOperations);
    }
}
