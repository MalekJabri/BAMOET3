# IBM Business Automation Manager Open Editions (IBM BAMOE) - Instructor Lab - STP Orchestration Service
This module contains an example `BAMOE STP Orchestration Service`, using using Kogito and packaged as a micro-service JAR. 

## How To Build 
Once you have configured your local development environment, you need to perform a Maven `build` of the repository.  This repository is built using `mvn clean install` by either the CI/CD pipeline or on a local developer workstation.  If deploying artifacts to an enterprise Maven repository, please use `mvn clean deploy`, which requires configuration of the `distributionManagement` section of your project's parent pom.xml.  This project is also configured to generate container images automatically by utilizing the `docker` or `openshift` profiles, as in the following examples:

```shell
mvn clean package -Pdocker
```

```shell
mvn clean package -Popenshift
```

## How To Run in Development Mode
Quarkus comes with a built-in development mode, which means you can update the application sources, resources and configurations. The changes are automatically reflected in your running application. This is great to do development spanning UI and database as you see changes reflected immediately.  Dev mode enables hot deployment with background compilation, which means that when you modify your Java files or your resource files and refresh your browser these changes will automatically take effect. This works too for resource files like the configuration property file. The act of refreshing the browser triggers a scan of the workspace, and if any changes are detected the Java files are compiled, and the application is redeployed, then your request is serviced by the redeployed application. If there are any issues with compilation or deployment an error page will let you know.  To run the service in Quarkus Dev Mode, use the following command:

```shell
mvn clean package quarkus:dev -Pdev
```

Click [here](https://quarkus.io/guides/maven-tooling#dev-mode) for more information on Quarkus Dev Mode.

## How To Test
There are various methods used to test this application's REST API endpoints.  Included in the `src/test/resources/rest` folder is a set of example test cases using the [VS Code REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client).  

### Start with Swagger
In order to determine which REST endpoints have been published by the application, you simply need to start your application, either in Quarkus Dev Mode or via the published container image, and then navigate to the published swagger page at:  [Swagger Page](http://localhost:8080/q/swagger-ui/).  

### Create Unit Tests
You are free to use any unit testing framework you choose, so long as it can call Java or REST API methods programmatically, such as:

- [Using REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
- [Using Quarkus for Unit Testing](https://quarkus.io/guides/getting-started-testing)
- [Using JUnit for Unit Testing](https://junit.org/junit5/docs/current/user-guide/)

## Additional Information (*Appendicies*)
This repository is focused on business automation using [**IBM Business Automation Manager Open Editions**](https://www.ibm.com/docs/en/ibamoe/9.2.x) products, specifically the IBM build of [**Kogito**](https://kogito.kie.org/) known as **IBM Decision Manager Open Edition (DMOE)** and **IBM Process Automation Manager Open Edition (PAMOE)**, leveraging [**Quarkus**](https://quarkus.io/) or [**Spring Boot** _(currently for Decisions only)_](https://spring.io/) as the assoicated container runtime.  The following online documentation is available in order to learn various aspects of these products and frameworks:

- [**Apache Maven**](https://maven.apache.org/) is a free and open source software project management and comprehension tool. Based on  the concept of a project object model (POM), Maven can manage a project’s build, reporting and documentation from a central piece of  information. A **getting started guide** is available [here](http://maven.apache.org/guides/getting-started/).

- [**Git**](https://git-scm.com//) is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency. There is a **handbook** available [here](https://guides.github.com/introduction/git-handbook/), as well as various **guides** for learning and working with Git available [here](https://guides.github.com/)

- [**Quarkus**](https://quarkus.io/) - Traditional Java stacks were engineered for monolithic applications with long startup times and large memory requirements in a world where the cloud, containers, and Kubernetes did not exist. Java frameworks needed to evolve to meet the needs of this new world.  Quarkus was created to enable Java developers to create applications for a modern, cloud-native world. Quarkus is a Kubernetes-native Java framework tailored for GraalVM and HotSpot, crafted from best-of-breed Java libraries and standards. The goal is to make Java the leading platform in Kubernetes and serverless environments while offering developers a framework to address a wider range of distributed application architectures.  You can find a useful introdution to this technology at [**Getting Started with Quarkus**](https://quarkus.io/get-started/).

- [**Spring Boot**](https://spring.io/) - Spring makes programming Java quicker, easier, and safer for everybody. Spring’s focus on speed, simplicity, and productivity has made it the world's most popular Java framework.  Spring’s flexible libraries are trusted by developers all over the world. Spring delivers delightful experiences to millions of end-users every day.  Spring’s flexible and comprehensive set of extensions and third-party libraries let developers build almost any application imaginable.  Spring Boot transforms how you approach Java programming tasks, radically streamlining your experience. Spring Boot combines necessities such as an application context and an auto-configured, embedded web server to make microservice development a cinch. To go even faster, you can combine Spring Boot with Spring Cloud’s rich set of supporting libraries, servers, patterns, and templates, to safely deploy entire microservices-based architectures into the cloud, in record time.  You can find a useful introdution to this technology at [**Getting Started with Spring Boot**](https://spring.io/quickstart).

