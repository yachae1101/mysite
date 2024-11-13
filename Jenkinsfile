pipeline {
    agent any
    environment{
       DOCKERHUB_CREDENTIALS = credentials("dockerhub-username-password")
    }
    stages {
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
       stage("Docker Image Build"){
         steps{
             sh "docker build -t yachae1101/mysite:${env.BUILD_NUMBER} ."
             sh "docker tag yachae1101/mysite:${env.BUILD_NUMBER} yachae1101/mysite:latest"
         }
       }
       stage('Docker Hub Login'){
         steps{
             sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
         }
       }
       stage('Docker Hub Push'){
         steps{
             sh "docker push yachae1101/mysite:${env.BUILD_NUMBER}"
             sh "docker push yachae1101/mysite:latest"
         }
       }
       stage('Deploy'){
          steps{
              sh "docker run -d --rm -p 8765:8080 --name mysite yachae1101/mysite:${env.BUILD_NUMBER}"
          }
       }
        stage('Clean Up Docker Images') {
            steps {
                script {
                    def imageTag = "${env.BUILD_NUMBER}"
                    def previousTag = (imageTag.toInteger() - 1).toString()

                    // Delete older images locally, keeping only the current and previous build images
                    sh """
                        docker images --filter=reference='yachae1101/mysite:*' --format '{{.Tag}}' | \
                        grep -Ev '^(${imageTag}|${previousTag}|latest)\$' | \
                        xargs -I {} docker rmi -f yachae1101/mysite:{}
                    """

                    // 환경 변수로 Docker Hub 사용자 이름과 API 토큰 설정
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-username-password', usernameVariable: 'DOCKERHUB_USR', passwordVariable: 'DOCKERHUB_TOKEN')]) {
                        // Clean up old images on Docker Hub using Docker Hub API with token
                        sh """
                            # Get the list of tags from Docker Hub and delete older images except the current and previous ones
                            curl -s -H "Authorization: JWT \$DOCKERHUB_TOKEN" \
                            "https://hub.docker.com/v2/repositories/yachae1101/mysite/tags/" | \
                            jq -r '.results[].name' | \
                            grep -Ev '^(${imageTag}|${previousTag}|latest)\$' | \
                            xargs -I {} curl -X DELETE -H "Authorization: JWT \$DOCKERHUB_TOKEN" \
                            "https://hub.docker.com/v2/repositories/yachae1101/mysite/tags/{}"
                        """
                    }
                }
            }
        }
    }
    post{
       always{
           sh 'docker stop mysite'
       }
    }

}