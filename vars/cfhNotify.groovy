def call() {
    withCredentials([string(credentialsId: 'acd8aa7c-57a3-47a1-997b-62ba4a7e1571', variable: 'LINE_TOKEN')]) {
        notifyLINE("${LINE_TOKEN}", currentBuild.currentResult == 'SUCCESS')
    }
}

def notifyLINE(token, isSuccess) {
    // backup...🎉 🎄 👻 🐂 🐀

    def url = 'https://notify-api.line.me/api/notify'
    def msg_prefix = isSuccess ? "🐂 *${currentBuild.currentResult}* 🐂" : "🐀 *${currentBuild.currentResult}* 🐀"
    // def message = "Build ```${env.REPO_NAME}:${env.BUILD_TAG}``` *${currentBuild.currentResult}*\n${env.BUILD_URL}"
    def message = msg_prefix + "\n```${env.REPO_NAME}:${env.BUILD_TAG}```\n${env.BUILD_URL}"
    // def stickerPackageId = '2'
    // def stickerId = isSuccess ? '28' : '23'

    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}' -F 'stickerPackageId=${stickerPackageId}' -F 'stickerId=${stickerId}'"
    sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
}