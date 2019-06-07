node{
    def prashanth = tool name:'maven3.6.1',type:'maven'
    stage('checkout code'){
        git credentialsId: '16f94abd-4040-4d99-9380-e460aad7ffef', url: 'https://github.com/pulluruprashanth/maven-web-application.git'
    }
    stage('build'){
        sh "$prashanth/bin/mvn clean package"
    }
    stage('nexus'){
        sh "$prashanth*/bin/mvn clean deploy"
    }
    stage('tomcat'){
        sshagent(['3e2846ac-531e-480b-8b58-715b5a15b56f']) {
    // some block

    sh "scp -o StrictHostKeyChecking=no target/maven-web-application.war ec2-user@13.233.245.21:/home/ec2-user/tomcat/apache-tomcat-9.0.20/webapps/"

}
    
    
}
}
