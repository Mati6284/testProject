pipeline {

    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Playwright') {
            steps {
                sh '''
                npm install
                npx playwright install
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

    }

}