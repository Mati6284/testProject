pipeline {

    agent any

    tools {
        jdk 'jdk21'
        maven 'maven3'
    }

    stages {

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'videos/**/*, screenshots/**/*', allowEmptyArchive: true
        }
    }
}