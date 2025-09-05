# Example :: Process Persistence

This example depicts the usage of persistence configuration for various databases like H2, Postgresql, MS SQL and Oracle. 
This application can be run in dev and in container modes.

This example also showcases a basic implementation of a **Hiring** Process that drives a _Candidate_ through different
interviews until they get hired. It features simple User Task orchestration including the use of DMN decisions to
generate the candidate's offer and timers to skip interviews. This example is based on `process-compact-architecture` 
example. You could find more details about that example from its README.

---

## Configuration

As mentioned earlier, this example can be run in quarkus development mode and in container mode. In dev mode, the 
example uses `h2` database. In container mode it can use `postgresql`, `mssql` or `oracle` databases.

The databases `h2`, `postgresql`, `mssql`, `oracle` are paired with a maven profile and a quarkus profile which are tied together.
```
<profile>
    <id>postgresql</id>   <!-- THIS IS THE MAVEN PROFILE NAME -->
    <properties>
         <quarkus.profile>postgresql</quarkus.profile>  <!-- SETTING THE QUARKUS PROFILE NAME TO BE USED IN APPLICATION.PROPERTIES -->
    </properties>
<profile>   
```
So in this example the maven profiles `postgresql`,`mssql` and `oracle` tied to quarkus profiles with similar 
name and `h2` database is defined by the profile `dev`. 
The `dev`,`postgresql`,`mssql` and `oracle` profiles defines their own specific database dependencies and configurations.

One of the common dependency across various database profile is Agroal. It is an advanced datasource connection pool 
implementation with integration with transaction and security.
```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-agroal</artifactId>
</dependency>
```

Let's take a look at each profile and the configurations in detail.

### Dev

In Dev mode, Quarkus provides us with a zero config database out of the box, a feature referred to as Dev Services.
The only main dependency required is the corresponding jdbc driver. Don’t configure a database URL,
username and password if you intend to use Dev Services.

Below are the dependency & configurations needed for H2 in dev profile.

```
 <profile>
     <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <quarkus.profile>dev</quarkus.profile>
        </properties>
        <dependencies>
            <dependency>
                <groupId>io.quarkus</groupId>
                <artifactId>quarkus-jdbc-h2</artifactId>
            </dependency>
        </dependencies>
 </profile>
```
The only dependency needed for H2  is the `quarkus-jdbc-h2` driver.

Below are the configurations needed for H2.
```
%dev.quarkus.datasource.db-kind=h2
%dev.quarkus.datasource.devservices.properties.NON_KEYWORDS=VALUE,KEY
```
The `%dev.quarkus.datasource.db-kind` configuration property is used to explicitly specify the type of database to connect. 
`quarkus.datasource.devservices.properties.NON_KEYWORDS=VALUE,KEY` is a generic property that is usually added
to the database connection url. The flyway scripts define tables with columns names like `key` and `value`. But
these are reserved words when working with H2. So this property effectively allows creating columns with these
names without any problems.
The H2 database runs in-process.

If you would still like to customize the database properties, you can refer
[this](https://quarkus.io/version/3.15/guides/databases-dev-services#configuration-reference). More information about
Dev Services can be found [here](https://quarkus.io/version/3.15/guides/databases-dev-services).

If you like to use your own database you could add necessary datasource properties from
[here](https://quarkus.io/version/3.15/guides/datasource#jdbc-configuration). When you add a direct datasource
property, Quarkus does not start a Dev Service database but instead will look for a user provided database.

### Postgresql

This is the maven profile for Postgresql
```
<profile>
    <id>postgresql</id>
    <properties>
        <quarkus.profile>postgresql</quarkus.profile>
    </properties>
    <dependencies>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-jdbc-postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-container-image-jib</artifactId>
        </dependency>
    </dependencies>
</profile>
```
The only dependency needed for postgres is the postgresql jdbc driver.
The `quarkus-container-image-jib` is an extension for the Quarkus framework that enables
building container images using Jib and helps to build the optimized container images directly.

Below are the database configuration required for the Postgresql
```
%postgresql.quarkus.datasource.db-kind=postgresql
```
The `%postgresql.quarkus.datasource.db-kind` configuration property is used to explicitly specify the type of database to connect.

Different properties configured using the `postgresql.quarkus.container-image` define image-related settings like
group, registry, tag & name needed to build the image.

```
%postgresql.quarkus.container-image.build=true
%postgresql.quarkus.container-image.push=false
%postgresql.quarkus.container-image.group=bamoe
%postgresql.quarkus.container-image.registry=dev.local
%postgresql.quarkus.container-image.tag=${project.version}
%postgresql.quarkus.container-image.name=process-persistence-postgresql
```

### MS SQL Server

This is the maven profile for MS SQL Server
```
<profile>
    <id>mssql</id>
    <properties>
        <quarkus.profile>mssql</quarkus.profile>
    </properties>
    <dependencies>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-jdbc-mssql</artifactId>
        </dependency>
        <dependency>
            <groupId>com.ibm.bamoe</groupId>
            <artifactId>bamoe-mssql-mappings</artifactId>
            <version>${version}</version>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-container-image-jib</artifactId>
        </dependency>
    </dependencies>
</profile>
```
The dependency needed by Mssql are the following,  the `quarkus-jdbc-mssql` is the jdbc driver and the `bamoe-mssql-mappings` is required to 
database-specific mappings to ensure the persistence layer works correctly with that database's dialect and limitations. 
The `quarkus-container-image-jib` is an extension for the Quarkus framework that enables building container 
images using Jib and helps to build the optimized container images directly.

The database configuration required for Mssql are mentioned below.
```
%mssql.quarkus.datasource.db-kind=mssql
```
The `%mssql.quarkus.datasource.db-kind` configuration property is used to explicitly specify the type of database to connect.

The `bamoe-mssql-mappings` is a utility library to help Job Service and Data Index storage work properly with
`MS SQL Server`. It contains the Hibernate orm.xml that will remap some of the JPA entities contained in both modules.

```
mssql.quarkus.hibernate-orm.mapping-files=META-INF/bamoe-data-index-orm.xml,META-INF/bamoe-job-service-orm.xml
```
The available orm's are:
- META-INF/bamoe-data-index-orm.xml: This file remaps some entities from the data-index component.
- META-INF/bamoe-job-service-orm.xml: This file remaps some entities from the job-service component.

Depending on the dependencies configured in our application it may be required to configure the ORMs to be used.
To configure which mapping files should be imported you can use the `quarkus.hibernate-orm.mapping-files` property to
configure a comma-separated list of ORM files to use.

Different properties configured using the `mssql.quarkus.container-image` define image-related settings like
group, registry, tag & name needed to build the image.

```
%mssql.quarkus.container-image.build=true
%mssql.quarkus.container-image.push=false
%mssql.quarkus.container-image.group=bamoe
%mssql.quarkus.container-image.registry=dev.local
%mssql.quarkus.container-image.tag=${project.version}
%mssql.quarkus.container-image.name=process-persistence-mssql
```

### Oracle

This is the maven profile for Oracle
```
  <profile>
        <id>oracle</id>
        <properties>
            <quarkus.profile>oracle</quarkus.profile>
        </properties>
        <dependencies>
            <dependency>
                <groupId>io.quarkus</groupId>
                <artifactId>quarkus-jdbc-oracle</artifactId>
            </dependency>
            <dependency>
                <groupId>com.ibm.bamoe</groupId>
                <artifactId>bamoe-oracle-mappings</artifactId> 
                <version>${version}</version>
            </dependency>
            <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-container-image-jib</artifactId>
        </dependency>
        </dependencies>
    </profile>
```
The dependencies needed are  the `quarkus-jdbc-oracle` , oracle jdbc driver and the `bamoe-oracle-mappings` is to database-specific mappings to ensure the
persistence layer (usually JPA/Hibernate)works correctly with that database's dialect and limitations.
The `quarkus-container-image-jib` is an extension for the Quarkus framework that enables
building container images using Jib and helps to build the optimized container images directly.

Below are the db configurations details for Oracle
```
%oracle.quarkus.datasource.db-kind=oracle
```
The `%oracle.quarkus.datasource.db-kind` configuration property is used to explicitly specify the type of database to connect.

The `bamoe-oracle-mappings` is a utility library to help Job Service and User Task storage work properly with 
`Oracle`. It contains the Hibernate orm.xml that will remap some of the JPA entities contained in both modules.

```
%oracle.quarkus.hibernate-orm.mapping-files=META-INF/bamoe-user-task-orm.xml,META-INF/bamoe-job-service-orm.xml
```
The available orm's are:
- META-INF/bamoe-user-task-orm.xml: This file remaps some entities from the jbpm-usertask-storage-jpa component.
- META-INF/bamoe-job-service-orm.xml: This file remaps some entities from the job-service component.

Depending on the dependencies configured in our application it may be required to configure the ORMs to be used.
To configure which mapping files should be imported you can use the `quarkus.hibernate-orm.mapping-files` property to 
configure a comma-separated list of ORM files to use.

Different properties configured using the `oracle.quarkus.container-image` define image-related settings like
group, registry, tag & name needed to build the image.

```
%oracle.quarkus.container-image.build=true
%oracle.quarkus.container-image.push=false
%oracle.quarkus.container-image.group=bamoe
%oracle.quarkus.container-image.registry=dev.local
%oracle.quarkus.container-image.tag=${project.version}
%oracle.quarkus.container-image.name=process-persistence-oracle
```
---
## Running

### Prerequisites

- Java 17+ installed
- Environment variable JAVA_HOME set accordingly
- Maven 3.9.6+ installed
- Docker and Docker Compose to run the required example infrastructure.

### Running as containers

First, build the example by running the following command in a terminal

```
mvn clean package -P<dbtype>
```
Current supported dbtypes in container mode are `postgresql`, `mssql` and `oracle`. So for e.g. to build the example using 
postgresql database configuration we can run the following command

```shell
mvn clean package -Ppostgresql
```
This will build this example's Quarkus application with the corresponding database configuration and create a Docker 
image that will be used in the `docker compose` template.

Finally, to start the example using `docker compose`, run

```
docker compose -f ./docker-compose/docker-compose-<dbtype>.yml up
```

For e.g. to start the example with postgresql run

```bash
docker compose -f ./docker-compose/docker-compose-postgresql.yml up
```

To stop and remove containers run

```
docker compose -f ./docker-compose/docker-compose-<dbtype>.yml down
```

### Running in Development mode

The development mode in this application uses `h2` database. The dev 
mode will embed all the needed Infrastructure Services (Database, Data-Index & Jobs Service) and won't require any 
extra step. To start this example's app in Development mode , just run the following command in a terminal
```shell
mvn clean package quarkus:dev
```

---

## Using

### Starting an instance of the Hiring Process

Once the service is up and running you can make use of the **Hiring** application by a sending request to
`http://localhost:8080/hiring`.

Sending the following valid `CandidateData` will start a process instance that will land into the _HR Interview_ task:

```json
{
  "candidateData": {
    "name": "Jon",
    "lastName": "Snow",
    "email": "jon@snow.org",
    "experience": 5,
    "skills": ["Java", "Kogito", "Fencing"]
  }
}
```

In a Terminal you can execute this curl command to start a **Hiring** process:

```bash
curl -H "Content-Type: application/json" -H "Accept: application/json" -X POST http://localhost:8080/hiring -d '{"candidateData": { "name": "Jon", "lastName": "Snow", "email": "jon@snow.org", "experience": 5, "skills": ["Java", "Kogito", "Fencing"]}}'
```

If everything went well you may get a response like:

```json
{
  "id": "628e679f-4deb-4abc-9f28-668914c64ef9",
  "offer": {
    "category": "Senior Software Engineer",
    "salary": 40450
  }
}
```

In the server logs you may find a trace like:

```
New Hiring has been created for candidate: Jon Snow
###################################
Generated offer for candidate: Jon Snow
Job Category: Senior Software Engineer
Base salary: 40450
###################################
```

Use the following `CandidateData` that don't match the minimal candidate requirements, to start a process that will
automatically end:

```json
{
  "candidateData": {
    "name": "Jon",
    "lastName": "Snow",
    "email": "jon@snow.org",
    "experience": 0,
    "skills": []
  }
}
```

In a Terminal you can execute this curl command to start a **Hiring** process:

```bash
curl -H "Content-Type: application/json" -H "Accept: application/json" -X POST http://localhost:8080/hiring -d '{"candidateData": { "name": "Jon", "lastName": "Snow", "email": "jon@snow.org", "experience": 0, "skills": []}}'
```

If everything went well you may get a response like:

```json
{
  "id": "3659601a-bb59-458d-859e-7892621ad5b7",
  "offer": null
}
```

In the server log You may find a trace like:

```
New Hiring has been created for candidate: Jon Snow
###################################
Candidate Jon Snow don't meet the requirements for the position but we'll keep it on records for the future!
###################################
```

### Completing the Hiring Process

- After starting a hiring process that meets the minimal candidate requirements, it starts an HR Interview Task. The task 
has a _Timer_ that will skip the task if it's not completed in a given amount of time (3 minutes in this example). We can
either wait 3 minutes to see the timer in action making the process instance skip the HR Interview task or complete the 
process by following the next steps.

- Inorder to complete the HR Interview task we can use the below curl command

```bash
curl -X POST "http://localhost:8080/usertasks/instance/{taskId}/transition?user=jdoe" -H "content-type: application/json" -d '{"transitionId": "complete","data": {"offer": {"category": "Senior Software Engineer","salary": 45000},"approve": true}}'
```
The taskId could be retrieved by running below command which returns all the usertasks assigned to the user. The id
field in the response is the required taskId.
```bash
curl -X GET "http://localhost:8080/usertasks/instance?user=jdoe"
```
- After the HR Interview Task is completed, we now have a new IT Interview Task that needs to be completed. Use the 
below command to complete the task
```bash
curl -X POST "http://localhost:8080/usertasks/instance/{taskId}/transition?user=jdoe" -H "content-type: application/json" -d '{"transitionId": "complete","data": {"approve": true}}'
```
As mentioned above the taskId for IT Interview Task also can be fetched using below query
```bash
curl -X GET "http://localhost:8080/usertasks/instance?user=jdoe"
```
- Once the IT Interview Task is successfully completed, in the server logs you may be able to see something like
```
###################################
To: jon@snow.org
Subject: Congratulations you made it!
Dear Jon Snow, we are happy to tell you that you've successfully went through the hiring process. You'll find the final Offer details in attached.
Job Category: Senior Software Engineer
Base salary: 45000
###################################
```
