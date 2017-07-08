#!/usr/bin/env groovy

 stage('Checkout source') {
            /*
            * For a standalone workflow script, we would use the `git` step
            *
            *
            * git url: 'git://github.com/jenkinsci/jenkins.io',
            *     branch: 'master'
            */

            /*
            * Represents the SCM configuration in a "Workflow from SCM" project build. Use checkout
            * scm to check out sources matching Jenkinsfile with the SCM details from
            * the build that is executing this Jenkinsfile.
            *
            * when not in multibranch: https://issues.jenkins-ci.org/browse/JENKINS-31386
            */
            checkout scm
        }
        
    stage('Build') {
            steps {
                echo 'Building..'
                 echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                sh 'ant run'
            }
        }
     stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
    stage('Deploy - Staging') {
            steps {
                 echo 'Deploying....to Staging'
            }
        }
        stage('Sanity check'){
            steps {
              // echo "Need your approval:Running ${env.BUILD_ID} on ${env.BUILD_URL}"| mailx -s "Need your approval on ${env.BUILD_URL}" @ "satyapriya.das@cognizant.com"
                input "Does the staging environment look ok?"
                //sh 'echo "Dear Sir,Please login to the build and give your approval,if want to proceed with prod Deployment  ${env.JENKINS_URL}/${env.BUILD_ID}" | mailx -r "dipuliki@gmail.com" -s "Need your approval: Running ${env.BUILD_ID} on ${env.JENKINS_URL}" "satyapriya.das@cognizant.com"'
            }
        }
        stage('Deploy - Production'){
            steps {
              echo 'Deploying....to Production'
            }
        }
        
    catch (exc) {
    echo "Caught: ${exc}"

    String recipient = 'infra@lists.jenkins-ci.org'

    mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) failed",
            body: "It appears that ${env.BUILD_URL} is failing, somebody should do something about that",
              to: satyapriya.das@cognizant.com
         replyTo: recipient,
            from: 'noreply@ci.jenkins.io'
        }
        
