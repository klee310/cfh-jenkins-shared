def call(map config) {

}

def buildAngular(String testRepoName, String repo) {
    echo "REPO_NAME ~~ ${testRepoName}"
    echo "REPO ~~ ${repo}"
    // sh "docker build --rm --target BUILD -t ${testRepoName}:test . && \
    //     docker build --rm -t ${repo}:latest ."
    // $ docker build --rm --target BUILD -t channel/mobileweb:test . && docker build --rm -t channel/mobileweb .
}

def testAngular(String testRepoName) {
    // echo "execute tests using docker container..."
    // // sh 'docker run -t ${env.REPO_NAME}:test npm run testCI'
    // sh 'mkdir -p coverage && \
    //     docker run -t --mount type=bind,source=$PWD/coverage,target=/usr/src/app/coverage \
    //     ${env.REPO_NAME}:test npm run testCI'
    // cobertura coberturaReportFile: 'coverage/cobertura-coverage.xml'
    echo "KL-10/15: tests disabled until Matthew/TP fixes their test-cases"
    sh "docker rmi ${testRepoName}:test"
}