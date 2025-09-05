#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-pgweb.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE infrastrudture applications
oc project $BAMOE_INFRASTRUCTURE_PROJECT

# Installation 
echo -e "\nInstalling PostgreSQL admin console..."
oc apply -f ../deployments/deployment-pgweb.yaml
oc apply -f ../services/service-pgweb.yaml
oc apply -f ../routes/route-pgweb.yaml

