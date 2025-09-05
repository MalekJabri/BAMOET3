#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-postgres.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE infrastrudture applications
oc project $BAMOE_INFRASTRUCTURE_PROJECT

# Installation 
echo -e "\nInstalling PostgreSQL databaase..."
oc apply -f ../config-maps/config-map-postgres.yaml
oc apply -f ../deployments/deployment-postgres.yaml
oc apply -f ../services/service-postgres.yaml
