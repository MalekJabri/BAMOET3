# IBM Business Automation Manager Open Editions (IBM BAMOE) - Student Labs

# Overview
This repository includes all labs created by the student.

## Setting up for your labs
TBD...

## Guidelines
Use the supplied [Maven Archetypes](../bamoe-maven/README.md) in order to generate the lab project of your choice.  You can utilize a `multi-module` approach to your labs, creating a project for each appliation and then creating a master `pom.xml` that builds all of them in one step.  For example:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

  	<groupId>com.ibm.edu.bamoe.workshop</groupId>
  	<artifactId>student-labs</artifactId>
	<version>1.0.0</version>
	<packaging>pom</packaging>

	<!-- Add a <module> for each lab project you create here -->
	<modules>
	</modules>
</project>
```

You can now run Maven commands either in the root folder or each project's folder.  Any command performed at the root folder level will apply to all
projects. Common commands at the root project or entire repository level include:

- ***mvn clean install** - This command will build the project's standalone JAR files, in order to be able to be run using Quarkus Dev Mode:  `mvn clean quarkus:dev -Pdev`.  No container iamge is created during this phase.
- ***mvn clean package -Pdocker** - This command will build the docker container image and push it to the local docker registry.  Use the project's `docker-compose.yml` file in order to deploy the container image to your local Docker.
- ***mvn clean package -Popenshift** - This command will build and automatically deploy the container image to OpenShift, creating it's pods, services, and routes automatically.

> **_TIP:_** The location for which you run Maven commands determines the behavior.  Commands entered at the root of the entire student lab repository will apply to all projects within that repository, whereas commands entered at the root of each sub-module (project) will only apply to that project.  

## Additional Information (*Appendicies*)
This repository is focused on business automation using [**IBM Business Automation Manager Open Editions**](https://www.ibm.com/docs/en/ibamoe/9.2.x) products, specifically the IBM build of [**Kogito**](https://kogito.kie.org/) known as **IBM Decision Manager Open Edition (DMOE)** and **IBM Process Automation Manager Open Edition (PAMOE)**, leveraging [**Quarkus**](https://quarkus.io/) or [**Spring Boot** _(currently for Decisions only)_](https://spring.io/) as the assoicated container runtime.  The following online documentation is available in order to learn various aspects of these products and frameworks:

- [**Apache Maven**](https://maven.apache.org/) is a free and open source software project management and comprehension tool. Based on  the concept of a project object model (POM), Maven can manage a project’s build, reporting and documentation from a central piece of  information. A **getting started guide** is available [here](http://maven.apache.org/guides/getting-started/).

- [**Git**](https://git-scm.com//) is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency. There is a **handbook** available [here](https://guides.github.com/introduction/git-handbook/), as well as various **guides** for learning and working with Git available [here](https://guides.github.com/)

- [**Quarkus**](https://quarkus.io/) - Traditional Java stacks were engineered for monolithic applications with long startup times and large memory requirements in a world where the cloud, containers, and Kubernetes did not exist. Java frameworks needed to evolve to meet the needs of this new world.  Quarkus was created to enable Java developers to create applications for a modern, cloud-native world. Quarkus is a Kubernetes-native Java framework tailored for GraalVM and HotSpot, crafted from best-of-breed Java libraries and standards. The goal is to make Java the leading platform in Kubernetes and serverless environments while offering developers a framework to address a wider range of distributed application architectures.  You can find a useful introdution to this technology at [**Getting Started with Quarkus**](https://quarkus.io/get-started/).

- [**Spring Boot**](https://spring.io/) - Spring makes programming Java quicker, easier, and safer for everybody. Spring’s focus on speed, simplicity, and productivity has made it the world's most popular Java framework.  Spring’s flexible libraries are trusted by developers all over the world. Spring delivers delightful experiences to millions of end-users every day.  Spring’s flexible and comprehensive set of extensions and third-party libraries let developers build almost any application imaginable.  Spring Boot transforms how you approach Java programming tasks, radically streamlining your experience. Spring Boot combines necessities such as an application context and an auto-configured, embedded web server to make microservice development a cinch. To go even faster, you can combine Spring Boot with Spring Cloud’s rich set of supporting libraries, servers, patterns, and templates, to safely deploy entire microservices-based architectures into the cloud, in record time.  You can find a useful introdution to this technology at [**Getting Started with Spring Boot**](https://spring.io/quickstart).
