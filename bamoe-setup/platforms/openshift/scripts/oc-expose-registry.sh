#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a property file name..."
    echo -e "  Example usage: ./oc-expose-registry.sh ../default-ocp.properties\n"
    exit 1
fi

# Load the property file
source $1

# Login to OCP 
source ./oc-login.sh $1

# Expose the container image registry
echo -e "\nExposing the container image registry..."
oc patch configs.imageregistry.operator.openshift.io/cluster --patch '{"spec":{"defaultRoute":true}}' --type=merge
HOST=$(oc get route default-route -n openshift-image-registry --template='{{ .spec.host }}')
oc extract secret/$(oc get ingresscontroller -n openshift-ingress-operator default -o json | jq '.spec.defaultCertificate.name // "router-certs-default"' -r) -n openshift-ingress --confirm

# sudo mv tls.crt /etc/pki/ca-trust/source/anchors/
#sudo update-ca-trust enable
#sudo docker login -u kubeadmin -p $(oc whoami -t) $HOST
