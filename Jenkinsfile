pipeline {
    agent any
    stages {
        stage('jdk-17 확인') {
            steps {
                sh 'java -version'  // JAVA_HOME 설정 확인
                sh 'echo $JAVA_HOME'
                sh 'echo $PATH'
            }
        }
        stage("Permission") {
            steps {
                sh "chmod +x ./gradlew"
            }
        }
        stage('gradle 이 사용하는 JAVA 버전 확인') {
            steps {
                sh './gradlew -version'
            }
        }
        stage("Compile") {
            steps {
                sh './gradlew compileJava'
            }
        }
        stage("Test") {
            steps {
                sh './gradlew test'
            }
        }
        stage("Gradle Build") {
            steps {
                sh './gradlew clean build'
            }
        }
    }
}