# Decision Table Listener, with Kogito and Quarkus

An extension of the example `dmn-listener-quarkus`, focusing on semantic asynchronous evaluation of `AfterEvaluateDecisionTableEvent`(s) using Quarkus capabilities.
The `dmn-listener-dtable` demonstrates what events can we listen to during a decision table evaluation.

## Installing and Running

### Prerequisites

You will need:
  - Java 17+ installed
  - Environment variable JAVA_HOME set accordingly
  - Maven 3.9.6+ installed

When using native image compilation, you will also need:
  - [GraalVM 21.0.2](https://github.com/graalvm/graalvm-ce-builds/releases/tag/jdk-21.0.2) installed
  - Environment variable GRAALVM_HOME set accordingly
  - Note that GraalVM native image compilation typically requires other packages (glibc-devel, zlib-devel and gcc) to be installed too.  You also need 'native-image' installed in GraalVM (using 'gu install native-image'). Please refer to [GraalVM installation documentation](https://www.graalvm.org/docs/reference-manual/aot-compilation/#prerequisites) for more details.

### Compile and Run in Local Dev Mode

```
mvn clean compile quarkus:dev
```

### Package and Run in JVM mode

```
mvn clean package
java -jar target/quarkus-app/quarkus-run.jar
```

or on Windows

```
mvn clean package
java -jar target\quarkus-app\quarkus-run.jar
```

### Package and Run using Local Native Image
Note that this requires GRAALVM_HOME to point to a valid GraalVM installation

```
mvn clean package -Pnative
```

To run the generated native executable, generated in `target/`, execute

```
./target/dmn-listener-dtable-runner
```

Note: This does not yet work on Windows, GraalVM and Quarkus should be rolling out support for Windows soon.

## OpenAPI (Swagger) documentation
[Specification at swagger.io](https://swagger.io/docs/specification/about/)

You can take a look at the [OpenAPI definition](http://localhost:8080/q/openapi?format=json) - automatically generated and included in this service - to determine all available operations exposed by this service. For easy readability you can visualize the OpenAPI definition file using a UI tool like for example available [Swagger UI](https://editor.swagger.io).

In addition, various clients to interact with this service can be easily generated using this OpenAPI definition.

When running in either Quarkus Development or Native mode, we also leverage the [Quarkus OpenAPI extension](https://quarkus.io/guides/openapi-swaggerui#use-swagger-ui-for-development) that exposes [Swagger UI](http://localhost:8080/q/swagger-ui/) that you can use to look at available REST endpoints and send test requests.

## Decision Table Listener
Please check `ExampleDMNRuntimeEventListener.java` to see the listener implementation and `PeriodicJobBean.java` to see the listener instantiation.


## Example Usage

Once the service is up and running, you can use the following example to interact with the service.

### POST /dtevent

It accepts two inputs `a` and `b`, both are numbers.

Example curl command:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"a": 10, "b": 20}' http://localhost:8080/dtevent
```
or on Windows:

```sh
curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d "{\"a\":10,\"b\":20}" http://localhost:8080/dtevent
```

```

To check `ExampleDMNRuntimeEventListener` is working, search for logs like below in your terminal:

```
2025-06-18 11:37:45,001 INFO  [org.kie.kog.dmn.qua.exa.dtl.PeriodicJobBean] (vert.x-worker-thread-16) Decision Table ...
```