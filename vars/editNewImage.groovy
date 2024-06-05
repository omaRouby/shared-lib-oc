#!/usr/bin/env groovy

def call(String imageName) {
    // Edit deployment.yaml with new Docker Hub image
    sh "sed -i 's|image:.*|image: ${imageName}|g' deployment.yml"
}
