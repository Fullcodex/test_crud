pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'javac src/main/java/accessingdatamysql/AccessingDataMysqlApplication.java'
            }
        }
        stage('Run') {
            steps {
                sh 'cd src/main/java/accessingdatamysql && java accessingdatamysql.AccessingDataMysqlApplication'
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                //git branch: 'test', url: 'https://github.com/Fullcodex/Jenkins_Test.git'
                //sh 'git commit -am "push test - master" && git push origin test:master'
            }
        }
    }
}
