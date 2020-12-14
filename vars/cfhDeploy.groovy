def call() {
    withCredentials([usernamePassword(credentialsId: '1d7ee753-e50a-45ba-9d20-c5544ae18319', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
        sh "git clone https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/klee310/cfh-vnins-devops.git && \
            cd cfh-vnins-devops; docker build --rm -t awskube:latest -f Dockerfile.awskube ."
    }
    withCredentials([usernamePassword(credentialsId: 'cce3c97d-537b-4fa9-b2c4-d616d10ff5cc', passwordVariable: 'AWS_SECRET', usernameVariable: 'AWS_KEY')]) {
        sh "docker run -e AWS_ACCESS_KEY_ID=${AWS_KEY} -e AWS_SECRET_ACCESS_KEY=${AWS_SECRET} -e AWS_DEFAULT_REGION=ap-southeast-1 -e SERVICE_TO_RESTART=${env.POD_NAME} -e EKS_NAMESPACE=${env.EKS_NAMESPACE} awskube:latest"
    }
}