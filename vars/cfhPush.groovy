def call() {
    docker.withRegistry("${env.REPO_URL}", "${env.REPO_CRED}") {
        // sh "aws ecr create-repository --repository-name ${env.REPO_NAME} --image-scanning-configuration scanOnPush=true --region ${env.ECR_REGION} || true"
        sh "docker tag ${env.REPO}:latest ${env.REPO}:${env.BUILD_TAG} && \
            docker push ${env.REPO}:latest && \
            docker push ${env.REPO}:${env.BUILD_TAG}"
    }
    sh "docker rmi ${env.REPO}:${env.BUILD_TAG}"
}