# IBM Business Automation Manager Open Editions - Maven Configuration
This document contains the instructions on how to configure IBM BAMOE Maven.

# Maven Repository
With `IBM Business Automation Manager Open Editions v9.2.x` aligning with its previous version BAMOE v8 in the downstream build model, the artifacts are no longer available in Maven Central. The artifacts are shipped as part of the product as a Container Image and Maven Repository inside the compressed file in a consumable format.

If you have a Maven Repository Manager tool like Artifactory or Nexus, you can import the compressed BAMOE Maven repository content into Maven Repository Manager. For companies without such infrastructure, it is highly recommended to use the container image and make it available within the company for all developers and the continuous integration (CI) system. For companies that already use a Maven Repository Manager tool, developers and the CI system are typically configured to connect with it. If you are using the container image, ensure that it is made available and provide the URL that developers and the CI system need to specify in their `settings.xml` file.

## Configuring a local Maven Repository 
If you prefer not to use containers, you can download and configure the BAMOE Maven repository from the compressed file. The BAMOE Maven repository contains the libraries that Java developers need to build BAMOE applications.  The following approach can also be used in order to make Maven depencencies available from an enterprise Maven repository, such as `Artifactory`.  To configure the BAMOE Maven repository locally follow these steps:

1.  Download the BAMOE v9.2.1 Maven Repository (`.offline/bamoe-9.2.1.GA-maven-repository`).
2.  Extract the downloaded archive in your local `~/.m2/` directory and open the Maven `settings.xml` file in a text editor or IDE.
3.  Update your local `settings.xml` file, adding profiles from the snippet below:

```xml
<settings xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/SETTINGS/1.0.0" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository>${user.home}/.m2/repository</localRepository>
    <profiles>
        <!-- BAMOE 9.2.1 via Offline -->
        <profile>
            <id>ibm-bamoe-offline-maven-repository</id>
            <repositories>
                <repository>
                    <id>ibm-bamoe-offline-maven-repository</id>
                    <url>file://${user.home}/.m2/bamoe-9.2.1.GA-maven-repository</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                </repository>
            </repositories>

            <pluginRepositories>
                <pluginRepository>
                    <id>ibm-bamoe-offline-maven-repository</id>
                    <url>file://${user.home}/.m2/bamoe-9.2.1.GA-maven-repository</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    </pluginRepository>
            </pluginRepositories>
        </profile>
    </profiles>

    <activeProfiles>
        <activeProfile>ibm-bamoe-offline-maven-repository</activeProfile>
    </activeProfiles>
</settings>
```

If your Maven repository contains outdated artifacts, you might encounter Maven error messages when you build or deploy the project, such as:

-  Missing artifact <PROJECT_NAME>
- [ERROR] Failed to execute goal on project <ARTIFACT_NAME>; Could not resolve dependencies for <PROJECT_NAME>

To resolve these issues, delete the cached version of your local repository that is located in the ~/.m2/repository directory to force a download of the latest Maven artifacts.

Your Maven repository is now properly configured and ready to build BAMOE based projects using a standard Maven workflow.



