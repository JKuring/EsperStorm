package esper.utility.mq;

/**
 * Created by linghang.kong on 2016/7/7.
 */
public class MQFactory {

    public MQConsumer getMqConsumer(String url, String queueName, String mqServiceName) throws Exception {
        switch (mqServiceName) {
            case "ActiveMQ":
                return new ActiveMQConsumer(url, queueName);
            case "Kafka":
                return new KafkaMQConsumer(url, queueName);
            default:
                throw new Exception("Can1t find MQ service!");
        }
    }
}
