def gv

pipeline {

    agent any

    stages{
        stage("init") { 
            steps{
                script{
                    gv = load "tests.groovy"
                }    
            }
        }
        stage("build") {
            steps {
                echo "Building the application"
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            steps {
                echo "Testing the application"
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                echo "Deploying the application"
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
