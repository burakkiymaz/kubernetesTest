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
        stage("test") {
            agent {
                docker { 
                    image 'burakkiymaz/website-build:alpha' 
                }
            }
            steps {
                sh 'curl localhost:4000'
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
