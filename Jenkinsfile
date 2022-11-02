def gv

pipeline {

    agent any

    stages{
        stage("init") { 
            script{
                gv = load "tests.groovy"
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
            }
        }
        stage("deploy") {
            steps {
                echo "Deploy the application"
            }
        }
    }
}
