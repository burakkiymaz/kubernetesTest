def jekyllImage

def buildApp() {
    echo 'Jekyll image building'
    jekyllImage = docker.build("burakkiymaz/website-build:alpha", "-f website1P2C/dockerfiles/jekyll-cnt/Dockerfile website1P2C/dockerfiles/jekyll-cnt")
}

def testApp() {
    echo "Jekyll image testing"
    sh 'docker run -d -n website-build -p 4000:4000 burakkiymaz/website-build:alpha'
    sh 'docker exec -it website-build bash'
    sh 'curl localhost:4000;exit'
    sh 'docker stop website-build; docker rm website-build'
}

def deployApp() {
    echo "Jekyll application deploying"
}

return this