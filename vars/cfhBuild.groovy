def call(map config) {

}

def buildAngular(String tempName, String repo) {
    echo "REPO_NAME ~~ ${tempName}"
    echo "REPO ~~ ${repo}"
    // sh "docker build --rm --target BUILD -t ${tempName}:test . && \
    //     docker build --rm -t ${repo}:latest ."
    // $ docker build --rm --target BUILD -t channel/mobileweb:test . && docker build --rm -t channel/mobileweb .
}

def testAngular() {

}