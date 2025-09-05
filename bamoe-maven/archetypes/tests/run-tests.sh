#!/bin/bash

echo Generating test projects via archetypes...
../../scripts/create-fact-model.sh test-fact-model
../../scripts/create-classic-decision-service.sh test-classic-decision-service "-DuseFactModel=true -DfactModelGroupId=com.ibm.edu.bamoe.workshop.student -DfactModelArtifactId=test-fact-model -DfactModelVersion=1.0.0-SNAPSHOT"
../../scripts/create-decision-service.sh test-decision-service 
../../scripts/create-stp-service.sh test-stp-service "-DuseFactModel=true -DfactModelGroupId=com.ibm.edu.bamoe.workshop.student -DfactModelArtifactId=test-fact-model -DfactModelVersion=1.0.0-SNAPSHOT"
../../scripts/create-process-service.sh test-process-service "-DuseFactModel=true -DfactModelGroupId=com.ibm.edu.bamoe.workshop.student -DfactModelArtifactId=test-fact-model -DfactModelVersion=1.0.0-SNAPSHOT"

echo Buiding test projects generated from archetypes...

cd test-fact-model
mvn clean install
cd ..

cd test-classic-decision-service
mvn clean install
cd ..

cd test-decision-service
mvn clean install
cd ..

cd test-stp-service
mvn clean install
cd ..

cd test-process-service
mvn clean install
cd ..

echo Be sure to remove the compiled test projects from your local Maven repository cache, the files are located in ~/.m2/repository/com/ibm/edu/bamoe/workshop/student/**...

