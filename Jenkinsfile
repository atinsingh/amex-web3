pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        sh 'checkout scm'
      }
    }

    stage('compile') {
      steps {
        sh 'mvn compile'
      }
    }

  }
}