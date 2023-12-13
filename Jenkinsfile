pipeline {
    environment {
        DOCKERHUB_CRED = credentials("DockerHubCred")
    }
    
    agent any

    stages {
        stage('Stage 1: Git Clone') {
            steps {
                git 'https://github.com/anshul-iiitb16/SPE_Major_Project.git'
            }
        }

        stage('Stage 2: Build Spring Boot backend') {
            steps {
                sh '/usr/share/maven/bin/mvn clean install'
            }
        }
        
        stage('Stage 3: Build backend Docker Image') {
            steps {
                sh "docker build -t anshul1601/backend_image:latest ."
            }
        }

        stage('Stage 4: Build frontend Docker image') {
            steps {
                echo 'Building frontend Docker image'
                dir('react-hooks-frontend') {
                    sh "docker build -t anshul1601/frontend_image:latest ."
                }
            }
        }

        stage('Stage 5: Push backend Docker image to DockerHub') {
            steps {
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push anshul1601/backend_image:latest"
            }
        }
        
        stage('Stage 6: Push frontend Docker image to DockerHub') {
            steps {
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push anshul1601/frontend_image:latest"
            }
        }

        stage('Stage 7: Clean docker images') {
            steps {
                script {
                    sh 'docker container prune -f'
                    sh 'docker image prune -a -f'
                }
            }
        }
        stage('Stage 8: Ansible Deployment') {
            steps {
                dir('Deployment'){
                    sh 'ansible-playbook -i inventory deploy.yml'
                }
            }
        }
    }
}
