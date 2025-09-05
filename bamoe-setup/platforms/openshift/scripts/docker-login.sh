#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: ./docker-login.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Login to Docker using OCP token
echo -e "\nLogging into Docker using OCP token..."
OCP_HOST=$(oc get route default-route -n openshift-image-registry --template='{{ .spec.host }}')
podman login --tls-verify=false -u $(oc whoami) -p $(oc whoami -t) $OCP_HOST
