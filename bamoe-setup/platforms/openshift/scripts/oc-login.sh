#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: oc-login.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OpenShift cluster
echo -e "\nLogging into the cluster and setting the default project..."
oc login --username=${OCP_USER} --password=${OCP_PASS} ${OCP_URL}
oc project ${OCP_DEFAULT_PROJECT}
