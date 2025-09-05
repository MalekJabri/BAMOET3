# IBM Business Automation Manager Open Editions (IBM BAMOE) - Maven Archetypes
This repository contains custom [**Maven Archetypes**](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html) for creating decision and process services based on [**IBM Business Automation Manager Open Edition**](https://www.ibm.com/docs/en/ibamoe/9.2.x) including legacy v8 as well as the latest cloud-native release of v9 (powered by Kogito).

# Overview
In short, Archetype is a Maven project template generation toolkit. An archetype is defined as an original pattern or model from which all other things of the same kind are made. The name fits as we are trying to provide a system that provides a consistent means of generating Maven projects. The archetype will help authors create Maven project templates for users, and provides users with the means to generate parameterized versions of those project templates.

# Repository Modules
This is a multi-module repository, with the following modules:

- [**Fact Model Archetype**](./fact-model-archetype) is an archetype that can create a reusable fact model project. 
- [**Classic Decision Service Archetype**](./classic-decision-service-archetype) is an archetype that can create a DMOE (v9) classic decision service project. 
- [**Decision Service Archetype**](./decision-service-archetype) is an archetype that can create a DMOE (v9) Kogito decision service project. 
- [**STP Orchstration Service Archetype**](./stp-orchstration-service-archetype) is an archetype that can create a DMOE (v9) STP Orchestration service project. 
- [**Process Service Archetype**](./process-service-archetype) is an archetype that can create a PAMOE (v9) stateful process service project. 

# How To Build 
In order to build the archetypes, you must perform a Maven `build` of the repository.  This repository is built using `mvn clean install` by either the CI/CD pipeline or on a local developer workstation.  If deploying artifacts to an enterprise Maven repository, please use `mvn clean deploy`, which requires configuration of the `distributionManagement` section of your project's parent pom.xml.  

# Using the Archetype from the Command Line via Scripts
Once the archetype has been built and installed into the enterprise artifact repository, navigate to the project folder for which you would like to create the new project, and run one of the following scripts, which are located in the `scripts` folder of this repository:

- **create-fact-model.sh <projectName>** - Generates a reusable fact-model project.
- **create-classic-decision-service.sh <projectName>>** - Generates a v9 classic decision (DMOE) service project.
- **create-decision-service.sh <projectName>** - Generates a v9 Kogito decision (DMOE) service project.
- **create-stp-service.sh <projectName>** - Generates a v9 statess STP Orchestration (DMOE) service project.
- **create-process-service.sh <projectName>>** - Generates a v9 stateful process (PAMOE) service project.

> [!TIP]
> You can always associate a sharable fact model as project dependency, by simply adding the following properties _(using -DpropertyName=value)_ to the archetype, as in the following exmaple:
>
> ```shell
> ./archetype-script-file.sh <my-project-name> "-DuseFactModel=true -DfactModelGroupId=com.ibm.edu.bamoe.workshop.student -DfactModelArtifactId=my-fact-model -DfactModelVersion=1.0.0-SNAPSHOT"
>```

> [!IMPORTANT]  
> Do not create a new project in the same working directory as the `bamoe-maven` repository was cloned into.  This will result in an incorrect Maven project file being generated.  Always create a separate folder to hold your BAMOE Maven projects!

> [!TIP]
> Using **Quarkus** is highly recommended over **Spring Boot**.  It is important to remember that you are not going to be writing Quarkus or Spring Boot code necessarily, you will simply be using the Quarkus or Spring Boot based runtime and supporting extensions/tools.  There is better support using Quarkus than Spring Boot, including the ability to generate Kubernetes container images directly from your Maven build process (CI/CD).  Furthermore, if deploying to Red Hat OpenShift, you can take advantage of the Red Hat build of Quarkus, and thus get enterprise support for Quarkus vs community support for Spring Boot.

## Additional Information (*Appendicies*)
This repository is focused on business automation using [**IBM Business Automation Manager Open Editions**](https://www.ibm.com/docs/en/ibamoe/9.2.x) products, specifically the IBM build of [**Kogito**](https://kogito.kie.org/) known as **IBM Decision Manager Open Edition (DMOE)** and **IBM Process Automation Manager Open Edition (PAMOE)**, leveraging [**Quarkus**](https://quarkus.io/) or [**Spring Boot** _(currently for Decisions only)_](https://spring.io/) as the assoicated container runtime.  The following online documentation is available in order to learn various aspects of these products and frameworks:

- [**Apache Maven**](https://maven.apache.org/) is a free and open source software project management and comprehension tool. Based on  the concept of a project object model (POM), Maven can manage a project’s build, reporting and documentation from a central piece of  information. A **getting started guide** is available [here](http://maven.apache.org/guides/getting-started/).

- [**Git**](https://git-scm.com//) is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency. There is a **handbook** available [here](https://guides.github.com/introduction/git-handbook/), as well as various **guides** for learning and working with Git available [here](https://guides.github.com/)

- [**Quarkus**](https://quarkus.io/) - Traditional Java stacks were engineered for monolithic applications with long startup times and large memory requirements in a world where the cloud, containers, and Kubernetes did not exist. Java frameworks needed to evolve to meet the needs of this new world.  Quarkus was created to enable Java developers to create applications for a modern, cloud-native world. Quarkus is a Kubernetes-native Java framework tailored for GraalVM and HotSpot, crafted from best-of-breed Java libraries and standards. The goal is to make Java the leading platform in Kubernetes and serverless environments while offering developers a framework to address a wider range of distributed application architectures.  You can find a useful introdution to this technology at [**Getting Started with Quarkus**](https://quarkus.io/get-started/).

- [**Spring Boot**](https://spring.io/) - Spring makes programming Java quicker, easier, and safer for everybody. Spring’s focus on speed, simplicity, and productivity has made it the world's most popular Java framework.  Spring’s flexible libraries are trusted by developers all over the world. Spring delivers delightful experiences to millions of end-users every day.  Spring’s flexible and comprehensive set of extensions and third-party libraries let developers build almost any application imaginable.  Spring Boot transforms how you approach Java programming tasks, radically streamlining your experience. Spring Boot combines necessities such as an application context and an auto-configured, embedded web server to make microservice development a cinch. To go even faster, you can combine Spring Boot with Spring Cloud’s rich set of supporting libraries, servers, patterns, and templates, to safely deploy entire microservices-based architectures into the cloud, in record time.  You can find a useful introdution to this technology at [**Getting Started with Spring Boot**](https://spring.io/quickstart).
