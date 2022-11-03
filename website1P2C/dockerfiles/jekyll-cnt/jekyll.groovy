def buildApp() {
    echo 'Jekyll image building'
    def jekyllImage = docker.build("burakkiymaz/website-build:alpha")
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