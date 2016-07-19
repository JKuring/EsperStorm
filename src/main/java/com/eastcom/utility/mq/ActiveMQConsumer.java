package com.eastcom.utility.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created by linghang.kong on 2016/7/6.
 */
public class ActiveMQConsumer implements MQConsumer {
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer consumer;
    private String url;
    private String queueName;

    public ActiveMQConsumer(String url, String queueName) throws JMSException {
        this.url = url;
        this.queueName = queueName;
        init();
    }

    private void init() throws JMSException {
        factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, url);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue(queueName);
        consumer = session.createConsumer(destination);
    }

    public MessageConsumer getConsumer() {
        return consumer;
    }
}
