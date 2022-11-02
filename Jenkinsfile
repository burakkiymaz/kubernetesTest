pipeline {
    agent { docker { image 'maven:3.3.3' } }
      stages {
        stage('log version info') {
      steps {
        sh 'mvn --version'
        sh 'mvn clean install'
      }
    }
  }
}

//def gv
//
//pipeline {
//
//    agent any
//
//    stages{
//        stage("init") {
//            script{
//                gv = load "tests.groovy"
//            }
//        }
//        stage("build") {
//            steps {
//                echo "Building the application"
//                script {
//                    gv.buildApp()
//                }
//            }
//        }
//        stage("test") {
//            steps {
//                echo "Testing the application"
//            }
//        }
//        stage("deploy") {
//            steps {
//                echo "Deploy the application"
//            }
//        }
//    }
//}
