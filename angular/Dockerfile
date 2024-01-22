FROM nginx:1.23.3

LABEL org.opencontainers.image.title="angular"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.authors="khasar"

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/drg

EXPOSE 80

ADD dist/angular /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
