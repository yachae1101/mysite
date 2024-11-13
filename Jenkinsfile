pipeline {
    agent any
    tools {
        jdk 'openjdk-17'  // 설정한 JDK 이름
    }
    environment {
        JAVA_HOME = "tool openjdk-17"
    }
    stages {
        stage('jdk-17 확인') {
            steps {
                sh '${JAVA_HOME}/bin/java -version'
                sh '${JAVA_HOME}/bin/javac -version'
            }
        }
        stage("Permission") {
            steps {
                sh "chmod +x ./gradlew"
            }
        }
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Gradle Build"){
            steps{
                sh "./gradlew clean build"
            }
        }
    }
}