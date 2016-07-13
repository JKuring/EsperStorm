package esper.utility.mq;

/**
 * Created by linghang.kong on 2016/7/7.
 */
public class KafkaMQConsumer implements MQConsumer {
    private String url;
    private String queueName;

    public KafkaMQConsumer(String url, String queueName) {
        this.url = url;
        this.queueName = queueName;
    }

    @Override
    public Object getConsumer() {
        return null;
    }
}
