#!/usr/bin/env groovy

def call(String imageName, String dockerHubCredentialsID) {
    // Log in to DockerHub 
    withCredentials([usernamePassword(credentialsId: dockerHubCredentialsID, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
    }
    
    // Build and push Docker image
    echo "Building and Pushing Docker image..."
    sh "docker build -t ${imageName} ."
    sh "docker push ${imageName}"
}
