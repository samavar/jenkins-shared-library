def label = "mypod-${UUID.randomUUID().toString()}"
podTemplate(label: label, containers: [
    containerTemplate(name: 'docker', image: 'docker:dind', privileged: true),
    containerTemplate(name: 'helm', image: "dtzar/helm-kubectl:2.12.0", command: 'cat', ttyEnabled: true)
    ]) {
    node(label) {
        stage('shellzzz') {
            container('helm'){
                sh 'echo hello world from Kubzzzzz'
                sh 'kubectl get pods'
            }
        }
    }
}