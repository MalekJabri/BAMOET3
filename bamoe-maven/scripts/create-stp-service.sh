#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nUsage: create-stp-service.sh <project-name> [-DpropertyName=propertyValue -DpropertyName=propertyValue] ..."
    echo -e "  where <project-name> is required and -DpropertyName=propertyValue -DpropertyName=propertyValue are optional].\n"
    exit 1
fi

# Remove the project directory if it exists
if [ -d "$1" ]; then rm -rf $1; fi

# Run the archetype and generate the project structure
mvn archetype:generate -B "-DarchetypeGroupId=com.ibm.edu.bamoe.maven.archetypes" "-DarchetypeArtifactId=stp-orchestration-service-archetype" "-DarchetypeVersion=9.2.1" \
  "-DprojectName=$1" \
  "-DartifactId=$1" $2