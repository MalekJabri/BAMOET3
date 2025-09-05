#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: setup-kafka.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Select the default project for BAMOE infrastrudture applications
oc project $BAMOE_INFRASTRUCTURE_PROJECT

# Installation 
echo -e "\nInstalling Apache Kafka..."
oc apply -f ../operator/strimzi-kafka-operator.yaml
oc apply -f ../deployments/deployment-kafka-single-node.yaml -n "$BAMOE_INFRASTRUCTURE_PROJECT"

# Wait for things to come up
echo -e "\nWaiting for cluster to start..."
oc wait --for=condition=Ready kafka/kafka-cluster -n "$BAMOE_INFRASTRUCTURE_PROJECT" --timeout=500s

# Grab certs
echo -e "\nObtaining certs for clients..."

# Remove a previous cert if it exists
if [ -f "$HOME/.bamoe/ocp-kafka-ca.crt" ]; then
    rm $HOME/.bamoe/ocp-kafka-ca.crt
fi

oc extract secret/kafka-cluster-cluster-ca-cert -n "$BAMOE_INFRASTRUCTURE_PROJECT" --keys=ca.crt --to=- > $HOME/.bamoe/ocp-kafka-ca.crt
