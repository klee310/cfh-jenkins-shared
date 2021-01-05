def call() {
    echo "Push image to repo..."
    docker.withRegistry("${env.REPO_URL}", "${env.REPO_CRED}") {
        // sh "aws ecr create-repository --repository-name ${env.REPO_NAME} --image-scanning-configuration scanOnPush=true --region ${env.ECR_REGION} || true"
        sh "docker tag ${env.REPO}:latest ${env.REPO}:${env.BUILD_TAG} && \
            docker tag ${env.REPO}:latest ${env.REPO}:${env.BRANCH_NAME}-latest && \
            docker push ${env.REPO}:latest && \
            docker push ${env.REPO}:${env.BUILD_TAG} && \
            docker push ${env.REPO}:${env.BRANCH_NAME}-latest"
    }
    sh "docker rmi ${env.REPO}:${env.BUILD_TAG}"
}