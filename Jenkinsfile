//node {
//    def app
//
//    stage('Build Image') {
//        app = docker.build("burakkiymaz/website-build")
//    }
//
//    stage('Test Image') {
//        app.inside {
//            sh 'echo "Test Passed"'
//        }
//    }
//
//    stage('Push Image') {
//        docker.withRegistry('https://registry.hub.docker.com', 'burakkiymaz-dockerhub') {
//            app.push("alpha")
//            app.push("latest")
//        }
//    }
//}

//def jg // jekyll groovy
pipeline {
    environment {
        registryCredential = 'pipeline-dockerhub'
    }
    agent any
    
    stages{
        stage("build") { 
            steps{
                echo "Building the application"
                script {
                    jekyllImage = docker.build("burakkiymaz/website-build:alpha", "-f website1P2C/dockerfiles/jekyll-cnt/Dockerfile website1P2C/dockerfiles/jekyll-cnt")    
                }
            }
        }
        stage("test") {
            steps {
                echo "Image testing"
                script {
                    sh 'docker run -d --name website-build -p 4000:4000 burakkiymaz/website-build:alpha'
                    sh 'docker exec -it website-build bash'
                    sh 'curl localhost:4000;exit'
                    sh 'docker stop website-build; docker rm website-build'
                }
            }
        }
        stage("deploy") {
            steps {
                echo "Deploying the application"
                script {
                    jg.deployApp()
                }
            }
        }
    }
}
