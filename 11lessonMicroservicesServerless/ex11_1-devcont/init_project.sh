#!/bin/bash

# Install Serverless Framework
curl -o- -L https://slss.io/install | bash

# Create project subfolder (if needed)
mkdir -p serverless-functions

# Initialize Quarkus project
cd serverless-functions
mvn io.quarkus.platform:quarkus-maven-plugin:3.9.3:create -DprojectGroupId=via.doc1 -DprojectArtifactId=serverless-example -Dextensions="funqy-http" -DclassName="via.doc1.serverless.MyFunctions"
