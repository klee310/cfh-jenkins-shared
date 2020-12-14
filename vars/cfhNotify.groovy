def call(map config) {
    // notifyLINE("IYinezD7zpHt3DbtIKw67n1XCCgskFcVilzGE3nddhW", currentBuild.currentResult == 'SUCCESS')
    // curl https://notify-api.line.me/api/notify -H 'Authorization: Bearer IYinezD7zpHt3DbtIKw67n1XCCgskFcVilzGE3nddhW' -F 'message=test 🎄 👻' -F 'stickerPackageId=2' -F 'stickerId=28'"

    def url = 'https://notify-api.line.me/api/notify'
    def message = "Build ```${env.REPO_NAME}:${env.BUILD_TAG}``` *${currentBuild.currentResult}*\n${env.BUILD_URL}"
    // def stickerPackageId = '2'
    // def stickerId = isSuccess ? '28' : '23'

    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}' -F 'stickerPackageId=${stickerPackageId}' -F 'stickerId=${stickerId}'"
    sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
}
