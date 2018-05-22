# docker-gitlab-spring-boot-boilerplate

### Assumed that readers have preliminary knowledge of docker, docker-compose, gitlab, CI/CD and network.
- Network along with docker is very important.
- Should know how docker network works.
- It uses many container images from docker hub to achieve the goal that spring boot app can be deployed in docker container and be secured.
- Maybe a lot of things were skipped such as port-forwarding, setting ssh, etc..

## Steps

#### First, install docker and docker-compose on your server
- Skipped.

#### Second, put docker-compose.yml from this repository on your preferred location.
- I used `~/docker-compose` as the location.
- `cd ~`
- `mkdir docker-compose`
- `cd docker-compose`
- `vim docker-compose.yml`

#### Third, create docker network for `explicitly` internal usage.
- `docker network create nginx-net`

#### 4th, Start docker containers along with predefined docker-compose.yml
- `docker-compose up -d`
- Or using zsh with docker-compose plugin, `dco up -d`

#### 5th, Set up docker registry embedded in gitlab-ce container.
- Maybe already settled in `docker-compose.yml`

#### 6th, register gitlab-runner for gitlab-CI
- `docker exec -it gitlab-runner bash`
- Execute `gitlab-runner register` and complete following prompts.
- Press `Ctrl + p + q` in order to exit from container shell safely.

#### 7th, Develop spring-boot app and set up gitlab-CI
- Put `Dockerfile` and `.gitlab-ci.yml` on the root directory of spring boot project.

#### Finally, gitlab-CI may be triggered on push to the repository.