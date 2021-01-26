pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'javac src/jenkins_test/Jenkins_Test.java'
            }
        }
        stage('Run') {
            steps {
                sh 'cd src && java jenkins_test.Jenkins_Test'
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                git branch: 'test', url: 'https://github.com/Fullcodex/Jenkins_Test.git'
                sh 'git commit -am "push test - master" && git push origin test:master'
            }
        }
    }
}
