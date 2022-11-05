def jekyllImage

def buildApp() {
    echo 'Jekyll image building'
    jekyllImage = docker.build("burakkiymaz/website-build:alpha", "-f website1P2C/dockerfiles/jekyll-cnt/Dockerfile .")
}

def testApp() {
    echo "Jekyll application testing"
    jekyllImage.inside {
        sh 'jekyll serve; curl localhost:4000'
    }
}

def deployApp() {
    echo "Jekyll application deploying"
}

return this