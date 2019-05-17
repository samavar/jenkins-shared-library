#!groovy
def call(Closure body) {
    def label = "mypod-${UUID.randomUUID().toString()}"
    podTemplate(label: label, containers: [
        containerTemplate(name: 'docker', image: 'docker:dind', privileged: true),
        containerTemplate(name: 'helm', image: "dtzar/helm-kubectl:2.12.0", command: 'cat', ttyEnabled: true)
        ]) {
        node(label) {
            body()
        }
    }
}