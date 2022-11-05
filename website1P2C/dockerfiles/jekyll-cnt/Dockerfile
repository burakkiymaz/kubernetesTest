FROM ubuntu:latest

RUN apt-get update -y && apt-get upgrade -y
RUN apt-get install -y net-tools
RUN apt-get install -y curl 
RUN apt-get install -y vim

#JEKYLL install
RUN apt-get install -y ruby-full build-essential zlib1g-dev

RUN echo '# Install Ruby Gems to ~/gems' >> ~/.profile
RUN echo 'export GEM_HOME="$HOME/gems"' >> ~/.profile
RUN echo 'export PATH="$HOME/gems/bin:$PATH"' >> ~/.profile
ENV GEM_HOME="/usr/local/bundle"
ENV PATH $GEM_HOME/bin:$GEM_HOME/gems/bin:$PATH

RUN yes | gem install jekyll bundler

# Creating publishing folder
RUN mkdir -p /var/www/burakkiymaz
RUN mkdir -p /opt/websiteTest
COPY files/ /var/www/burakkiymaz
COPY tests/ /opt/websiteTest
RUN chmod 755 /opt/websiteTest/*
EXPOSE 4000 4000

WORKDIR /var/www/burakkiymaz
CMD ["jekyll", "serve"]

