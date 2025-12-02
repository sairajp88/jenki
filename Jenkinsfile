pipeline {
    agent any

    tools {
        maven 'Maven-3.9.0'   // Must match the name in Global Tool Config
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/sairajp88/jenki.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
