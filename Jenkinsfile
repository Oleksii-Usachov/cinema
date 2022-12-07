pipeline {
  agent none
  stages {
    stage("build & SonarQube analysis") {
      agent any
      steps {
        withSonarQubeEnv(installationName: 'Cinema SonarQubeScanner', credentialsId: 'test-token') {
          sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}