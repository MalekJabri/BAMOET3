#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-bamoe-canvas.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE applications
oc project $BAMOE_PROJECT

# Installation
echo -e "\nSetting up IBM BAMOE Canvas Extended Services..."
oc apply -f ../deployments/deployment-bamoe-canvas-extended-services.yaml
oc apply -f ../services/service-bamoe-canvas-extended-services.yaml
oc apply -f ../routes/route-bamoe-canvas-extended-services.yaml
oc label services/$BAMOE_CANVAS_EXTENDED_SERVICES app.kubernetes.io/part-of=${BAMOE_GROUP}
oc label routes/$BAMOE_CANVAS_EXTENDED_SERVICES app.kubernetes.io/part-of=${BAMOE_GROUP}
oc label deployments/$BAMOE_CANVAS_EXTENDED_SERVICES app.kubernetes.io/part-of=$BAMOE_GROUP
oc label deployments/$BAMOE_CANVAS_EXTENDED_SERVICES app.openshift.io/runtime=golang

echo -e "\nSetting up IBM BAMOE Canvas Cors Proxy..."
oc apply -f ../deployments/deployment-bamoe-canvas-cors-proxy.yaml
oc apply -f ../services/service-bamoe-canvas-cors-proxy.yaml
oc apply -f ../routes/route-bamoe-canvas-cors-proxy.yaml
oc label services/$BAMOE_CANVAS_CORS_PROXY app.kubernetes.io/part-of=$BAMOE_GROUP
oc label routes/$BAMOE_CANVAS_CORS_PROXY app.kubernetes.io/part-of=$BAMOE_GROUP
oc label deployments/$BAMOE_CANVAS_CORS_PROXY app.kubernetes.io/part-of=$BAMOE_GROUP
oc label deployments/$BAMOE_CANVAS_CORS_PROXY app.openshift.io/runtime=nodejs

echo -e "\nSetting up IBM BAMOE Canvas UI..."
oc apply -f ../deployments/deployment-bamoe-canvas-ui.yaml
oc apply -f ../services/service-bamoe-canvas-ui.yaml
oc apply -f ../routes/route-bamoe-canvas-ui.yaml
oc label services/$BAMOE_CANVAS_UI app.kubernetes.io/part-of=$BAMOE_GROUP
oc label routes/$BAMOE_CANVAS_UI app.kubernetes.io/part-of=$BAMOE_GROUP
oc label deployments/$BAMOE_CANVAS_UI app.kubernetes.io/part-of=$BAMOE_GROUP
oc label deployments/$BAMOE_CANVAS_UI app.openshift.io/runtime=js

