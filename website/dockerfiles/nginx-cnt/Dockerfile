FROM ubuntu:latest

RUN apt-get update -y && apt-get upgrade -y
RUN apt-get install -y net-tools
RUN apt-get install -y curl 
RUN apt-get install -y nginx
RUN apt-get install -y vim
RUN apt-get install -y cron

# Creating publishing folder
RUN mkdir -p /var/www/burakkiymaz

COPY default /etc/nginx/sites-available/

WORKDIR /var/www/burakkiymaz

EXPOSE 4000 80 

CMD ["nginx", "-g", "daemon off;"]

