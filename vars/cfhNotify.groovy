def call() {
    withCredentials([string(credentialsId: 'acd8aa7c-57a3-47a1-997b-62ba4a7e1571', variable: 'LINE_TOKEN')]) {
        notifyLINE("${LINE_TOKEN}", currentBuild.currentResult == 'SUCCESS')
    }
}

/* 
    backup emoji: 🎉 🎄 👻 🐂 🐀
    backup - to use default stickers available with API - check this sample:

    // def stickerPackageId = '2'
    // def stickerId = isSuccess ? '28' : '23'
    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}' -F 'stickerPackageId=${stickerPackageId}' -F 'stickerId=${stickerId}'"

    // def message = "Build ```${env.REPO_NAME}:${env.BUILD_TAG}``` *${currentBuild.currentResult}*\n${env.BUILD_URL}"
*/

def notifyLINE(String token, Boolean isSuccess) {
    // def url = 'https://notify-api.line.me/api/notify'
    // def msg_prefix = isSuccess ? "🐂 *${currentBuild.currentResult}* 🐂" : "🐀 *${currentBuild.currentResult}* 🐀"
    // def message = msg_prefix + "\n```${env.REPO_NAME}:${env.BUILD_TAG}```\n${env.BUILD_URL}"
    
    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
    if (env.AUTO_REDEPLOY == 'YES') {
        notifyLINE(token, isSuccess, "(BUILD & DEPLOYED)");
    }
    else {
        notifyLINE(token, isSuccess, "(BUILD)");
    }
}

def notifyLINE(String token, Boolean isSuccess, String headerSuffix) {
    def url = 'https://notify-api.line.me/api/notify';
    def msg_prefix = isSuccess ? "🐂 *${currentBuild.currentResult}* 🐂" : "🐀 *${currentBuild.currentResult}* 🐀";

    if (headerSuffix) {
        msg_prefix = msg_prefix + " " + headerSuffix;
    }
    def message = msg_prefix + "\n```${env.REPO_NAME}:${env.BUILD_TAG}```\n${env.BUILD_URL}";
    
    sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'";
}