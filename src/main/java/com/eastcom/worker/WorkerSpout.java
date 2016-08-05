package com.eastcom.worker;

import com.eastcom.reader.Readable;
import com.eastcom.reader.ReaderController;
import com.eastcom.storm.BaseSpoutImpl;
import com.eastcom.utility.mq.MQFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import java.io.BufferedReader;
import java.util.Queue;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public class WorkerSpout<E> extends BaseSpoutImpl {

    private static final long WAITING_TIME = 100;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 构建获取配置文件中信息，url、queue name, 场景为MQ队列式场景，最好写一个工厂来生成对应的MQ句柄，ActiveMQ、Kafka
    @Override
    public void fetchTuple(Queue dataQueue) throws Exception {
        try {
            if (dataQueue == null) {
                throw new Exception("Failed to get the Queue.");
            }
            Readable readable = new ReaderController();

            String url = super.getMqURL();
            String queueName = super.getQueueName();
            String mqName = super.getMqName();

            logger.info("MQ info: " + url + " " + mqName + " " + queueName);
            MessageConsumer consumer = (MessageConsumer) (new MQFactory().getMqConsumer(url, queueName, mqName)).getConsumer();
            String message;
            while (true) {
                message = getMessage(consumer);
                if (message != null) {
                    // 此处为处理ftp文件，但是需要做到通用性，需优化
                    BufferedReader bufferedReader = readable.read(message);
                    while (bufferedReader.ready()) {
                        dataQueue.add(bufferedReader.readLine());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("fetchTuple() :" + e.toString());
            throw e;
        }
    }


    /**
     * Get a MQ message form ActiveMQ system.
     *
     * @return A message.
     * @throws JMSException
     * @throws InterruptedException
     */
    private String getMessage(MessageConsumer consumer) {
        try {

            ObjectMessage message = (ObjectMessage) consumer.receive();
            if (message != null) {
                return (String) message.getObject();
            } else Thread.sleep(WAITING_TIME);
        } catch (Exception e) {
            logger.error("getMessage: " + e.toString());
        }
        return null;
    }


    @Override
    public String instanceObject(Object data) {
        return (String) data;
    }

}
