rm ./volume/banco-jorge-api.log
docker rm $(docker ps -a -q) -f
docker rmi banco-jorge-api -f
docker rmi mvn-build-stage -f
docker rmi banco-jorge -f
docker compose up