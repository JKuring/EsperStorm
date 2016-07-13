package esper.base.storm;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.apache.commons.collections4.MapUtils.getIntValue;

/**
 * Created by linghang.kong on 2016/7/5.
 * Base Storm Spout Class.
 * Don`t include any applied context, and just for some base spout functions,
 * but there are multi read threads to fetch data to spout queue.
 * One emitted thread consume the queue at the same time.
 */
public abstract class BaseSpoutImpl<T, E> extends BaseRichSpout implements BaseSpout {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private int Thread_NUM = 10;
    private SpoutOutputCollector spoutOutputCollector;
    private Queue<E> dataQueue;
    private String spoutTupleName;

    private String mqURL;
    private String queueName;
    private String mqName;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        logger.info(" Start Spout ID: "+ context.getThisComponentId());

        Thread_NUM = getIntValue(conf, "project.spout.threads.file");
        spoutTupleName = (String) conf.get("project.spout.tuple.name");
        mqURL = (String) conf.get("project.activemq.broker.mqURL");
        queueName = (String) conf.get("project.activemq.queue.name");
        mqName = (String) conf.get("project.activemq.name");


        this.spoutOutputCollector = collector;
        this.dataQueue = new ConcurrentLinkedQueue<E>();

        for (int i = 0; i < Thread_NUM; i++) {
            new DataThread(String.valueOf(i)).start();
        }
    }


    @Override
    public void nextTuple() {
        if (!dataQueue.isEmpty()) {
            T data = instanceObject(dataQueue.poll());
            spoutOutputCollector.emit(new Values(data));
        } else try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        logger.info("project.spout.tuple.name: "+ this.spoutTupleName);
        declarer.declare(new Fields(spoutTupleName));
    }

    abstract public void fetchTuple(Queue dataQueue) throws Exception;

    /**
     * Instanced the data to be an object.
     *
     * @param data E
     * @return T
     */
    abstract public T instanceObject(E data);

    public String getMqURL() {
        return mqURL;
    }

    public void setMqURL(String mqURL) {
        this.mqURL = mqURL;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMqName() {
        return mqName;
    }

    public void setMqName(String mqName) {
        this.mqName = mqName;
    }

    private class DataThread extends Thread {
        public DataThread(String s) {
            super.setName(s);
        }

        @Override
        public void run() {
            try {
                logger.info("The thread ID of Fetch tuple function: " + Thread.currentThread().getName());
                fetchTuple(dataQueue);
            } catch (Exception e) {
                String sOut = "";
                sOut = sOut+"Thread run error: " + e.toString();
                StackTraceElement[] trace = e.getStackTrace();
                for (StackTraceElement s : trace) {
                    sOut += "\tat " + s.toString() + "\r\n";
                }
                logger.error(sOut);
            }
        }
    }
}
