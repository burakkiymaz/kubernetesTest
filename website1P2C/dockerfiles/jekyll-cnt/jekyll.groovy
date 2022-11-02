def buildApp() {
    echo 'Jekyll image building'
    def jekyllImage = docker.build("website1P2C/dockerfiles/jekyll-cnt")
}

def testApp() {
    echo "Jekyll application testing"
    jekyllImage.inside {
        sh 'curl localhost:4000'
    }
}

def deployApp() {
    echo "Jekyll application deploying"
}

return this