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
        sh "docker stop my || true"
        sh "docker rm my || true"
        sh "docker run --name my -p 11118:8080 -d dordoka/tomcat"
        sh "docker cp target/RiskMS.war my:/opt/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
