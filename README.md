[环境搭建链接](https://blog.csdn.net/qq_34446716/article/details/111880354)
看消息消费控制台打印出来了并且可以登录到容器里面查看
docker 进入 
docker exec -it kafka bash
cd /opt/kafka/bin
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic payTopic  --from-beginning