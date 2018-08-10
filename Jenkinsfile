pipeline {
    options {
        timeout(time: 5, unit: 'MINUTES', activity: false) 
    }
    agent any
    stages {
        stage('Build') {    
            steps {
                dir('./ERS1') {
                    sh 'sudo su ec2-user'
                    sh 'echo $USER'
                    sh 'mvn clean'
                    sh 'mvn install'
                }
            }
        }
        stage('Test') {
            steps {
                echo '(>^_^)> (^_^) <(^_^<) '
            }
        }
        stage('Deliver') {
            steps {
                dir('./ERS1') {
                    sh 'echo $CATALINA_HOME'
                    sh 'cp target/*.war $CATALINA_HOME/webapps/'
                    sh 'cp -r target/ERS1 $CATALINA_HOME/webapps/'
                }
            }
        }
    }     
}
