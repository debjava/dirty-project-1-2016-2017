<img src="http://www.apollo.edu/content/logo-images/_jcr_content/main_block/image.img.png/1384969726558.png">

# ITC-SUPPORT-STUDIO: Simple App to check health of services

This application is used to track the running health of all services in **PRODUCTION**, **DEV** and **QA** environment.


## Technology Stack Used
- **Core Spring framework**
- **Spring Boot for container management**
- **Stomp over Web Socket**
- **Netflix Hystrix Circuit Breaker for Latency and Fault Tolerance and graceful degradation**
- **Jackson library**
- **Maven**

## Build and Run
*Follow the steps below*
- Go to the parent directory **itc-support** in command prompt and execute the command **mvn clean package**
- If everything is fine, you will see the build successful
- Go to the directory **itc-support/itc-support-web** in command prompt and execute the command **mvn clean spring-boot:run**
- If you are able to find the Spring logo in command , open your internet browser Google Chrome.
- Type [http://localhost:8090/appstudio](http://localhost:8090/appstudio) in the browser


## Communication and References
To be done later

## Bugs and Feedback

To be done later

 
## LICENSE

Copyright 2016 Apollo Education Group
