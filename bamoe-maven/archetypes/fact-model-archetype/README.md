# IBM Business Automation Manager Open Editions (IBM BAMOE) - Sharable Fact Model Archetype
This repository contains a custom [**Maven Archetype**](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html) used for creating reusable fact model _(aka data model)_ for used with rules, decisions, processes, and client appliations.

# Using the Archetype
This custom Maven archetype can be run from the developer workstation, build server, or any other environment where a command line tool can be used, assuming that environment has access to the enterprise Maven repository for which the archetype has been installed or deployed. Once installed into Maven, the archetype can be run either via the command line or directly in Business Central.

## Using the Archetype from the Command Line
Once the archetype has been built and installed into the enterprise artifact repository, navigate to the project folder for which you would like to create the new project, and run the following command (replacing the properties with the appropriate project value):

```shell
mvn archetype:generate -B "-DarchetypeGroupId=com.ibm.edu.bamoe.maven.archetypes" "-DarchetypeArtifactId=fact-model-archetype" "-DarchetypeVersion=1.0.0" \
  "-DprojectName=$1" \
  "-DartifactId=$1" $2
```

As an alternative to the Maven command listed above, you can also use the supplied script file `create-classic-decision-service.sh`, located in the `scripts` folder of this repository.  Typical syntax for the script would be as follows:

```shell
./bamoe-maven/scripts/create-fact-model.sh my-fact-model
./bamoe-maven/scripts/create-fact-model.sh my-fact-model "-DjavaVersion=17"
```

where the first parameter to the script is the name of the project.  You can optionally also include additional properties, as in the second example shown above.

# Archetype Parameters
The command above represents the minimal set of properties for the archetype. The `-B command line option` essentially tells the archetype to run in batch mode, rather than interactive mode, which prompts for each archetype property. Each archetype property has a specific default value, set in the archetype descriptor, in the event the property is not provided on the command line. The remainder of the parameters are listed in the following table. All parameters can be added to the call to the archetype by specifying `-DparameterName=parameterValue` on the command line. Please note that most parameters have default values and are not required.

**Classic Decision Service Archetype - Required and Optional Parameters.**
| Parameter Name | Type   | Description | Default Value | Required ? |
| :---           | :----: | :---        | :-----------: | :--------: |
| archetypeGroupId | String | Group ID for the archetype | None | Yes |
| archetypeArtifactId | String | Artifact ID for the archetype | None | Yes |
| archetypeVersion | String | Version number for the archetype | None | Yes |
| projectName | String | Project name (becomes decision service name) | untitled | No |
| projectDescription | String | Project description | Sharable Fact Model | No |
| groupId | String | Maven groupId for generated project | com.ibm.edu.bamoe.workshop.student | No |
| artifactId | String | Maven artifactId for generated project | untitled | No |
| version | String | Maven version for generated project | 1.0.0-SNAPSHOT | No |
| packaging | String | Maven build package target | jar | No |
| skipTests | Boolean | Determines if unit tests are automatically run | true| No |
| javaVersion | String | Version of Java JDK | 17 | No |
| mavenCompilerPluginVersion | String | Maven compiler plugin version | 3.10.1 | No |
| mavenCompilerParameters | Boolean | Maven compiler parameters | true | No |
| mavenResourcesPluginVersion | String | Maven resources plugin version | 3.2.0 | No |
| mavenSurefirePluginVersion | String | Maven sure-fire plugin version | 3.0.0-M7 | No |
| sourceEncoding | String | Source encoding scheme | UTF-8 | No |
| outputEncoding | String | Output encoding scheme | UTF-8 | No |
| loggingEnabled | Boolean | Enable logging | false | No |
| loggingLevel | String | Logging Output Level | WARN | No |
| sampleClassName | String | Name of sample class to auto generate | Sample | No |
|

**Note:** *The parameters of this archetype are meant to be extended as the organization adds more sharable dependencies, so please be sure to update these properties, the archetype, and this documentation!*
