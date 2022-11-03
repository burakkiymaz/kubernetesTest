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


def gv
def jg // jekyll groovy
pipeline {

    agent any
    tools {
        docker "latest"
    }
    stages{
        stage("init") { 
            steps{
                script{
                    gv = load "tests.groovy"
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
            steps {
                echo "Testing the application"
                script {
                    jg.testApp()
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
