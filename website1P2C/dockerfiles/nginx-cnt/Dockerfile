FROM ubuntu:latest

RUN apt-get update -y && apt-get upgrade -y
RUN apt-get install -y net-tools curl nginx vim cron 

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

