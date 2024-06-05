#!/usr/bin/env groovy

def call(String OPENSHIFT_CREDENTIALS_ID, String OPENSHIFT_PROJECT, String CLUSTER_URL) {

    
    // Login to OpenShift using the service account token
    withCredentials([string(credentialsId: OPENSHIFT_CREDENTIALS_ID, variable: 'OC_TOKEN')]) {
        sh "oc login --token=${OC_TOKEN} --server=$CLUSTER_URL --insecure-skip-tls-verify"
    }

    // Apply the updated deployment.yaml to the OpenShift cluster
    sh "oc apply -f . --namespace=${OPENSHIFT_OPROJECT}"
}
