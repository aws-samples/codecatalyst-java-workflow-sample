# CodeCatalyst CI Workflows for Java-SpringBoot Application
* This is a simple example of two Continuous Integration workflows created in CodeCatalyst for a Java & Spring-Boot based backend application. The application exposes one API to perform a sum between integers Calculation
* The repository includes, inside the `.codecatalyst/workloads` folder, the definition of two CodeCatalyst workflows:
  * `build.yaml`: the workflow builds the jar, performs a CodeGuru Reviewer full-repository scan, uploads it to CodeArtifact, builds the Docker images, uploads it to ECR
  * `test.yaml`: the workflow perform unit and coverage tests on code


## Usage
* The purpose of this repository is to show how to create CI workflows on CodeCatalyst to perform actions for a SpringBoot Java based application


## Getting Started / Prerequisites
* The example project is built with Java 17 and Maven 3. Please be aware that you'll need those to run the project locally.  
* You'll need to create a CodeCatalyst space, a new Project with a new Code Repository
* You'll need to connect the CodeCatalyst space to an AWS Account. This account will be used to store Docker images (ECR) and Java Artifacts (CodeArtifact)
  * **PLEASE NOTE**: During the creation of the CodeCatalyst connection, you'll need to create a proper IAM Role that will be assumed by CodeCatalyst. For this example we've used the policy you can find in the file `CodeCatalystRolePolicyExample.json`. This IAM policy is very permissive so please **don't use it for production purposes!!**
* For this particular example we're assuming:
  * AWS Account ID: 123456789012
  * CodeCatalyst Environment (linked to the account above) named "TestEnvironment" referencing the "CodeCatalystTestEnvironmentRole" IAM role 

### Creating ECR and CodeArtifact repositories     
* You'll need to create an ECR repository and a CodeArtifact repository and properly substitute values inside `./codecatalyst/workflows/build.yaml`
* Instructions to create ECR repository via CLI:
    ```
  aws ecr create-repository \
  --repository-name rest-calculator \
  --region us-east-1 
    ```
* Instructions to create a CodeArtifact repository via CLI
    ```
  # Creating a domain
  aws codeartifact create-domain --domain artifact-store-demo --region us-east-1
  
  # Creating repository 
  aws codeartifact create-repository --domain artifact-store-demo --domain-owner 123456789012 --repository artifact-store-demo --description "My new repository" --region us-east-1
    ```

### Replace values inside Build pipeline
* The files `./codecatalyst/workflows/build.yaml` contains a fake account ID (123456789012). Please replace it with your correct AWS Account ID


## CI Workflows
The project contains two CodeCatalyst workflows:
* Test Workflow (`.codecatalyst/workloads/test.yaml`)
* Build & Release Workflow (`.codecatalyst/workloads/build.yaml`)

### Test Workflow
The main goal of this workflow is to run unit and coverage tests. The workflow is triggered by Pull Requests.
Proper Success Criterias are defined for unit and coverage tests and unit and coverage reports are autodiscovered and will be available for every run.

The application project is fully based on Maven 3, and, for that reason, we use Maven commands to run those test. More specifically we're using a single Maven Wrapper (https://github.com/apache/maven-wrapper) command `mvn -ntp verify`. 
For unit testing we leverage JUnit 5, and for coverage test we leverage Jacoco Code Coverage Library (https://github.com/jacoco/jacoco)

### Build & Release Workflow
This workflow performs several steps, more specifically:
* Listing files
* Maven Cleaning
* Performs a CodeGuru Reviewer full-repository scan (the report that will be produced will be available for each run)
* Building the jar & uploading it to CodeArtifact repository 
* Building the Docker image and uploading it to ECR 

![](images/build_workflow.png?raw=true)

## Resources
* [Setting up CodeCatalyst](https://docs.aws.amazon.com/codecatalyst/latest/userguide/setting-up-topnode.html)  
* [Getting Started with CodeGuru Reviewer](https://docs.aws.amazon.com/codeguru/latest/reviewer-ug/getting-started-with-guru.html)  
* [CodeGuru Reviewer Wrapper CLI](https://github.com/aws/aws-codeguru-cli)
* [Getting started with CodeArtifact](https://docs.aws.amazon.com/codeartifact/latest/ug/getting-started.html) 
* [Amazon ECR User Guide](https://docs.aws.amazon.com/AmazonECR/latest/userguide/what-is-ecr.html)  

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This library is licensed under the MIT-0 License. See the LICENSE file.