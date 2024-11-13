pipeline {
    agent any
//     tools {
//         jdk 'openjdk-17'  // Jenkins의 Global Tool Configuration에서 설정한 JDK 이름
//     }
//     environment {
//         // 'openjdk-17' JDK의 경로를 자동으로 설정
//         JAVA_HOME = "tool openjdk-17"
//         PATH = "${JAVA_HOME}/bin:${env.PATH}"  // JAVA_HOME에 맞춰 PATH 설정
//     }
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