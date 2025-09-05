#!/bin/bash

if [ "$1" == "" ]; then
    echo -e "\nPlease specify a pod status to cleanup..."
    echo -e "  Example usage: oc-cleanup.sh Evicted\n"
    exit 1
fi

# Cleanup Evicted Pods
echo -e "\nCleaning up all pods in all namespaces with $1 status..."
oc delete pod -A --field-selector="status.phase==$1"