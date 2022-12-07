pipeline {
  agent none
  stages {
    stage("build & SonarQube analysis") {
      agent any
      steps {
        withSonarQubeEnv(installationName: 'sonar_server', credentialsId: 'SonarQubeToken') {
          sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}