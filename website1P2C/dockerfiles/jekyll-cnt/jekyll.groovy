def jekyllImage

def buildApp() {
    echo 'Jekyll image building'
    jekyllImage = docker.build("burakkiymaz/website-build:alpha", "-f website1P2C/dockerfiles/jekyll-cnt/Dockerfile website1P2C/dockerfiles/jekyll-cnt")
}

def deployApp() {
    echo "Jekyll application deploying"
    docker.withRegistry('', registryCredential) {
        jekyllImage.push('alpha')
    }
}

return this