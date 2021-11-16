pipeline {
    agent { node { label 'jenkins-slave'}}

    stages {
        stage('pull stage') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '537ac0c6-d2aa-48db-a4f9-9f6b5508f0b6', url: 'http://gitlab.betterlife.xin:8080/center/tg-demo.git']]])
            }
        }
        stage('build stage') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
    post {
        always {
            emailext(
                subject: '项目名称：${PROJECT_NAME} - 构建次数：${BUILD_NUMBER} - 构建结果：${BUILD_STATUS}',
                body: '${FILE,path="email.html"}',
                to: 'zhangyufeng@betterlife.xin'
            )
        }
    }
}





// node('jenkins-slave') {
//     stage('pull stage') {
//         checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '537ac0c6-d2aa-48db-a4f9-9f6b5508f0b6', url: 'http://gitlab.betterlife.xin:8080/center/tg-demo.git']]])
//     }
//     stage('build stage') {
//         sh 'mvn clean package'
//     }
// post {
//     always {
//         emailext
//             subject: '项目名称：${PROJECT_NAME} - 构建次数：${BUILD_NUMBER} - 构建结果：${BUILD_STATUS}',
//             body: '${FILE,path="email"}',
//             to: 'zhangyufeng@betterlife.xin'
//     }
// }
// }

















