def jekyllImage

def buildApp() {
    echo 'Jekyll image building'
    jekyllImage = docker.build("burakkiymaz/website-build:alpha", "-f website1P2C/dockerfiles/jekyll-cnt/Dockerfile website1P2C/dockerfiles/jekyll-cnt")
}

def testApp() {
    echo "Jekyll application testing"
    agent {
        docker { image 'burakkiymaz/website-build:alpha'}
    }
    steps {
        sh 'curl localhost:4000'
    }
}

def deployApp() {
    echo "Jekyll application deploying"
}

return this