pipeline {
  agent none
  stages {
    stage("build & SonarQube analysis") {
      agent any
      steps {
        withSonarQubeEnv(installationName: 'Cinema SonarQubeScanner', credentialsId: 'SonarQubeToken') {
          sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}