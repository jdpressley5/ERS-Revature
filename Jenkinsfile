pipeline {
    options {
        timeout(time: 5, unit: 'MINUTES', activity: false) 
    }
    agent any
    stages {
        stage('Build') {    
            steps {
                dir('./ERS') {
                    sh 'echo $USER'
                    sh 'mvn clean'
                    sh 'mvn install -e'
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
                dir('./ERS') {
                    sh 'echo $CATALINA_HOME'
                    sh 'cp target/*.war $CATALINA_HOME/webapps/'
                    sh 'cp -r target/ERS1 $CATALINA_HOME/webapps/'
                }
            }
        }
    }     
}
