#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-keycloak.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE infrastrudture applications
oc project $BAMOE_INFRASTRUCTURE_PROJECT

# Installation 
echo -e "\nInstalling Keycloak..."
oc apply -f ../deployments/deployment-keycloak.yaml
oc apply -f ../routes/route-keycloak.yaml


