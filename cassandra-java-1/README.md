![A22.png](https://s19.postimg.org/5hb03dwkj/A22.png) Persistence in Cassandra with Java
==========================================================================================

Introduction
============
**Apache Cassandra** is a highly scalable distributed database coming within the arena of NoSQL. It is the fastest growing NoSQL system which has become the choice of many popular products in the market. Now time has come to learn and implement at least one NoSQL system to enrich technology stack . I make an attempt to provide a basic outline to the novice developers about the usage of cassandra.

Advantages of Cassandra
================
There are many advantages of using Cassandra in a large scale product development. Few striking advantages are given below. 

* **No Failures bacause of Peer-to-Peer design.**
* **Linear scalability which is the requirement we always need.**
* **Easy integration with other Big Data system like Hadoop.**
* **Easy to work as it has been developed using pure java and it is open source.**
* **Elastic scalability by addition of nodes.**
* **Easy slicing of data because od Column Data Model.**


Technology Stack
================
The following framework/s and tool/s have been used in this current sample application.

<table border="1">
  <tr>
    <th>Name</th>
    <th>Version</th> 
  </tr>
  <tr>
    <td>Java</td>
    <td>1.8</td> 
  </tr>
  <tr>
    <td>Cassandra</td>
    <td>3.0.9</td> 
  </tr>
  <tr>
    <td>Debian OS</td>
    <td>Version 8 (Jesse)</td> 
  </tr>
  <tr>
    <td>DBeaver (An SQL type tool for Cassandra)</td>
    <td>3.7.8</td> 
  </tr>
</table>


What does it do?
===============
In this small tutorial project, we will perform the following tasks.

* **Creation of keysapce in Cassandra**
* **Creation of table and CRUD operation using CQL**
* **How to use CRUD operations using Java**

Basic Cassandra Queries
===============
Here find the basic queries to learn Cassandra.

**Creation of keyspace in Cassandra**

	CREATE KEYSPACE test1
	WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

Here the keyspace name is **test1**

**To see all available keyspaces**

	describe keyspaces;

**Creation of Table**

	CREATE TABLE test1.employees (
   	empId int PRIMARY KEY,
   	empName text,
   	empDesgn text,
   	empAddress text,
   	empPhone varint,
   	empSal varint,
   	createdDate timestamp,
   	updatedDate timestamp
	);

**Data Insertion in Cassandra table**	

	INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   	VALUES(1,'Deb', 'Technical Architect', 'Bangalore', 981234567, 5000,toTimestamp('2016-11-13'),null);	
	
**Update a row in Cassandra table**	

	update test1.employees set empDesgn = 'Team Member', updatedDate = toTimestamp('2016-11-13') where empId = 6;

**Delete a row**

	delete from test1.employees where empId = 7

**Select/Read opeation**

	select * from test1.employees;
	

# Project Structure
The basic structure for SOLR core is given below.
The name of the solr core is **anywordSearch**.

![Cassandra-Proj1.png](https://s3.postimg.org/8tq3e0do3/Cassandra_Proj1.png)

In the above project structure, you can find many cassandra queries to learn.


Build and Installation
=========
To use Cassandra with java, you have to use the libraries from Datastax which is dtribution of Cassandra. The following 3 libraries are required and maven dependencies are given below.

	<dependency>
            <groupId>com.datastax.cassandra</groupId>
            <artifactId>cassandra-driver-core</artifactId>
            <version>3.1.2</version>
        </dependency>
        <dependency>
            <groupId>com.datastax.cassandra</groupId>
            <artifactId>cassandra-driver-mapping</artifactId>
            <version>3.1.2</version>
        </dependency>
        <dependency>
            <groupId>com.datastax.cassandra</groupId>
            <artifactId>cassandra-driver-extras</artifactId>
            <version>3.1.2</version>
        </dependency>



## Execution and Test ##
Before you run the test class **BasicDBOperations.java**, ensure that you have created a table with appropriate keyspace. Execute the class and see the output by executing the CQL queries.

> **Note:**
I am using Datastax distribution of Cassandra here. It is better to use Dbeaver enterprize version tool which will give you a feeling of SQl tool.


Bugs and Feedback
=================
This is a simple sample project about Cassandra with java.
There may be some bugs or error in documentation, please report to me at debadatta.mishra@gmail.com

Further Reading and References
==============================

[DBeaver Free Universal SQL Client](http://dbeaver.jkiss.org/)

[Cassandra Installation](https://docs.datastax.com/en/cassandra/2.0/cassandra/install/installDeb_t.html)

Contributor
====
@Author : **Debadatta Mishra**

Conclusion
==========
Hope you have enjoyed my post, try to learn and explore more and share with all.