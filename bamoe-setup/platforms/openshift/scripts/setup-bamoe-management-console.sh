#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-bamoe-management-console.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE applications
oc project $BAMOE_PROJECT

# Installation
echo -e "\nInstalling IBM BAMOE Management Console..."
oc apply -f ../deployments/deployment-bamoe-management-console.yaml
oc apply -f ../services/service-bamoe-management-console.yaml
oc apply -f ../routes/route-bamoe-management-console.yaml
oc label services/${BAMOE_MGMT_CONSOLE} app.kubernetes.io/part-of=${BAMOE_GROUP}
oc label routes/${BAMOE_MGMT_CONSOLE} app.kubernetes.io/part-of=${BAMOE_GROUP}
oc label deployments/${BAMOE_MGMT_CONSOLE} app.kubernetes.io/part-of=${BAMOE_GROUP}



