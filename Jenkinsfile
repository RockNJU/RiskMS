node {
    stage('SCM') {
        git 'https://github.com/RockNJU/RiskMS.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop mynewd || true"
        sh "docker rm mynewd || true"
        sh "docker run --name mynewd -p 11113:8080 -d tomcat"
        sh "docker cp target/maven-web-demo-0.0.1-SNAPSHOT.war mynewd:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
