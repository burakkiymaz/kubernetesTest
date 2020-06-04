FROM ubuntu:latest

RUN apt-get update -y && apt-get upgrade -y
RUN apt-get install -y net-tools
RUN apt-get install -y curl 
RUN apt-get install -y nginx
RUN apt-get install -y vim
RUN apt-get install -y cron

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

COPY default /etc/nginx/sites-available/

WORKDIR /var/www/burakkiymaz

# Setting cronjob for rebuild website content
COPY jekyll-build /etc/cron.d/jekyll-build
RUN chmod 0644 /etc/cron.d/jekyll-build
RUN crontab /etc/cron.d/jekyll-build
RUN touch /var/log/cron.log

EXPOSE 4000 80 

CMD ["nginx", "-g", "daemon off;"]

