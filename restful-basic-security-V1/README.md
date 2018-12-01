![ccc48c8549dce8790ed230d148a413c9.png](https://imgpile.com/images/2016/08/21/ccc48c8549dce8790ed230d148a413c9.png) Basic RESTful service with Spring Basic Security
=====

Introduction
============
Now a days most of the high end applications are powered by RESTful web services. It has become necessary to know the significance of RESTful web service.
Before jumping into the nitty-gritty of RESTful web service, let us learn the basics.
Through this tutorial I will provide you an insight into a basic RESTful web service creation using Spring's basic authentication and authorization.
It will also make you aware of how to create swagger documentation for RESTful web service for exposing the services. This tutorial will be
helpful for those who are new to RESTful web service. It covers all the CRUD operations involved in RESTful we service.

Technology Stack
================

The following frameworks have been used in this current sample application.

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
    <td>Maven</td>
    <td>3.3.9</td> 
  </tr>
  <tr>
    <td>Jersey</td>
    <td>2.6</td> 
  </tr>
  <tr>
    <td>Spring Core</td>
    <td>4.2</td> 
  </tr>
  <tr>
    <td>Spring Security</td>
    <td>3.2.5</td> 
  </tr>
  <tr>
    <td>Swagger</td>
    <td>1.5.9</td> 
  </tr>
</table>

Other tools used for development

* Eclipse 4.6.0 (Neon)
* Firefox REST Client addon
* Chrome Postman addon


What does it do?
===============

#### 1) Exposure to basic http methods

It provides the all the REST end-points for the http methods **GET**, **POST**, **PUT** and **DELETE**.

#### 2) Exposure to Swagger documentation

This project provides an exposure to usage of swagger api and the creation of swagger documentation. In this project, I have used Swagger UI 2.0 version.

#### 3) Exposure to Maven multi module project

To achieve better modularity, I have used maven multi module structure which will give an outline of better project structure.

#### 4) Exposure to Spring Basic Security

This sample project will give you idea of usage of Spring Basic Authentication and Authorization.


# Project Structure

The following is the eclipse project structure. This is a maven multi-module project.

![fcb69323fd691579e6f3e290461f3308.png](https://imgpile.com/images/2016/08/21/fcb69323fd691579e6f3e290461f3308.png)


## Build and Installation

Since it is a maven multi module project, to build the project, follow the steps below.

1. Download the project from Github.

2. Import the project in Eclipse.

3. Go to command prompt , go to the location of the project directory **restful-basic-security** and type the command given below

		mvn clean package

	OR

		mvn clean install

4. If the build is successful, go the location **restful-basic-security/restful-basic-security-web/target**, you will find the war file ie. **restful-basic-security-web.war**

5. Now deploy the directory in a web container. I have used Apache Tomcat version 9

## Configuration

You may have to change the username and password for your learning. Since it is a Spring Basic Authentication, you will find the usrname , password and roles in the file **springSecurity.xml** . This file is available in the module **spring-basic-security**. I provide below the XML code snnippet to have an understanding.

```xml
<security:authentication-manager>
			<security:authentication-provider>
				<security:user-service>
					<security:user name="deb"  password="deb"  authorities="ROLE_USER"/>
					<security:user name="piku"  password="piku"  authorities="ROLE_ADMIN"/>
				</security:user-service>
			</security:authentication-provider>
		</security:authentication-manager>
```
> **Note:**
This is not the only way to achieve Spring security, there are many ways to do it.

Run Demo
===

Once you have successfully built the project, you can deploy the war file ie **restful-basic-security-web.war** in tomcat webapps directory. Now start the tomcat server.

> **Note:** In my case, I had changed the port number of tomcat ie 8090, in your case it should be 8080 if have not yet changed the port number.

Once tomcat server gets started, click on the below url.

[http://localhost:8090/restful-basic-security-web/](http://localhost:8090/restful-basic-security-web/)

you will be able to see the Swagger documentation and exapand all the links to explore more.




Contributor
====
@Author : **Debadatta Mishra**

Bugs and Feedback
=================
This is a simple sample project about RESTful webservice using Spring and Jersey framework with Swagger documentations.
There may be some bugs, please report to me at debadatta.mishra@gmail.com

Further reading and References
==============================

[Swagger Annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#quick-annotation-overview)

Conclusion
==========
Hope you have enjoyed my post, try to learn and explore more.
