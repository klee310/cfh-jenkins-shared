// def call(map config) {
// }

def buildAngular() {
    echo "Build Docker Image..."
    sh "docker build --rm --target BUILD -t tempimage:test . && \
        docker build --rm -t ${env.REPO}:latest ."
    // $ docker build --rm --target BUILD -t channel/mobileweb:test . && docker build --rm -t channel/mobileweb .
}

def testAngular() {
    // echo "execute tests using docker container..."
    // // sh 'docker run -t ${env.REPO_NAME}:test npm run testCI'
    // sh 'mkdir -p coverage && \
    //     docker run -t --mount type=bind,source=$PWD/coverage,target=/usr/src/app/coverage \
    //     ${env.REPO_NAME}:test npm run testCI'
    // cobertura coberturaReportFile: 'coverage/cobertura-coverage.xml'
    echo "KL-10/15: tests disabled until Matthew/TP fixes their test-cases"
    sh "docker rmi tempimage:test"
}

def buildSpring() {
    echo "Build Docker Image..."
    sh "docker build --rm --build-arg BUILD_TAG=${env.BUILD_TAG} -t ${env.REPO}:latest ."
}