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

def jg // jekyll groovy
pipeline {
    environment {
        registryCredential = 'pipeline-dockerhub'
    }
    agent any
    
    stages{
        stage("init") { 
            steps{
                script{
                    jg = load "website1P2C/dockerfiles/jekyll-cnt/jekyll.groovy"
                }    
            }
        }
        stage("build") {
            steps {
                echo "Building the application"
                script {
                    jg.buildApp()
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
