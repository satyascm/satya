pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                checkout scm
                sh 'ant run'
               sh './mail.sh'
               }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
       /*  stage('Deploy - DEV') {
            steps {
                 echo 'Deploying....to Dev'
            }
             steps {
                input "Does the DEV environment look ok?"
            }
        }
       stage('Deploy - QA') {
            steps {
                 echo 'Deploying....to QA'
            } 
           steps {
                input "Does the QA environment look ok?"
            }
        }*/

       stage('Deploy - Staging') {
            steps {
                 echo 'Deploying....to Staging'
            }
        }
        stage('Sanity check'){
            steps {
                input "Does the staging environment look ok?"
            }
        }
        stage('Deploy - Production'){
            steps {
              echo 'Deploying....to Production'
            }
        }
    }
    post {
        /*Sanitycheck{
         echo 'Are we ready to proceed for prod deployment:please provide your approval'
         mail to: "satyapriya.das@cognizant.com", subject:"Need your approval: Running ${env.BUILD_ID} on ${env.JENKINS_URL}", body: "Dear Sir,Please login to the build and give your approval,if want to proceed with prod Deployment  ${env.JENKINS_URL}/${env.BUILD_ID}"    
        }*/
       always {
                echo 'This will always run..'
        }
       success {
                echo 'This will run only if successful..'
                mail to: "satyapriya.das@cognizant.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
       }
       failure {
                echo 'This will run only if failed..'
                mail to: "satyapriya.das@cognizant.com", subject:"Failed Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
           
       }
       unstable {
                echo 'This will run only if the run was marked as unstable..'
       }
       changed {
                echo 'This will run only if the state of the Pipeline has changed..'
                echo 'For example, if the Pipeline was previously failing but is now successful..'
       }
    }
}
