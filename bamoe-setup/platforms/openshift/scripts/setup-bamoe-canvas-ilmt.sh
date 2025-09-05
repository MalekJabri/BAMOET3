#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-bamoe-canvas-ilmt.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE applications
oc project $BAMOE_PROJECT

# Patch the current deployment if not installed with updated deployment YAML script
kubectl patch deployment bamoe-canvas-ui -p \
  '{"spec": {"template":{"metadata":{"annotations":{"productID":"72984f114b54496a8a44be139154a988", "productName": "IBM Process Automation Manager Open Edition", "productMetric": "VIRTUAL_PROCESSOR_CORE", "productChargedContainers": "All"}}}} }'
