pipeline {
  agent none
  stages {
    stage("build & SonarQube analysis") {
      steps {
        withSonarQubeEnv(installationName: 'sonar_server', credentialsId: 'SonarQubeToken') {
          sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}