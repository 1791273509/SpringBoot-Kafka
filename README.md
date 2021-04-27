[环境搭建链接](https://blog.csdn.net/qq_34446716/article/details/111880354)
看消息消费控制台打印出来了并且可以登录到容器里面查看
docker 进入 
docker exec -it kafka bash
cd /opt/kafka/bin
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic payTopic  --from-beginning

当ip发生变化之后，docker中的命令要重新启动


两处换成自己的ip地址即可
```shell script
docker run -d --restart=always --log-driver json-file --log-opt max-size=100m --log-opt max-file=2 --name kafka   -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=172.23.248.141:2181/kafka   -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://172.23.248.141:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092  -v /etc/localtime:/etc/localtime wurstmeister/kafka
```