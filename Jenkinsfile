pipeline {
    agent none
    stages {
        stage('Build') {
            agent { docker 'maven' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Run') {
            agent { docker 'openjdk:24-jdk-slim' }
            steps {
                echo 'Hello, JDK'
                sh 'java -jar target/web-app-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}