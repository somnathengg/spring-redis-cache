
********************command to run redis-cache server using docker *************************

docker run --name redis-cache -p 6379:6379 -d redis redis-server --requirepass yourpwd

*************************command to set password in redis server *************

redis-server --requirepass "Msdhon@7#redis88"


**********************command to connect redis cli******************************

docker exec -it redis-cache redis-cli

*********************command to show data in redis console key **************
get items::1

*********************command to get logs of redis cache in docker ***************

docker logs redis-cache
