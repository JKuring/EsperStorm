package esper.base.storm;

import org.apache.storm.Config;
import org.apache.storm.generated.StormTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public class BaseTopology {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String spoutName;
    private List<String> boltName;
    private int spoutParallelism = 10;
    private int boltParallelism = 10;
    private String mqURL;
    private String mqName;
    private String queueName;
    private int spoutFileThread;
    private String spoutTupleName;

    /**
     * Used yaml file to set storm configuration, them will over
     *
     * @param config
     */
    public void setConfigurationFromYamlFile(Config config) {
        spoutName = (String) config.get("project.spout.name");
        boltName = (List<String>) config.get("project.bolt.name");
        spoutParallelism = (int) config.get("project.spout.parallelism");
        boltParallelism = (int) config.get("project.bolt.parallelism");

        mqURL = (String) config.get("project.activemq.broker.url");
        mqName = (String) config.get("project.activemq.name");
        queueName = (String) config.get("project.activemq.queue.name");
        spoutFileThread = (int) config.get("project.spout.threads.file");
        spoutTupleName = (String) config.get("project.spout.tupleName");
    }


    public StormTopology getEsperTopology() {
        /*
        TopologyBuilder builder = new TopologyBuilder();

        WorkerSpout csfbSpout = new WorkerSpout();
        WorkerBolt csfbBolt = new WorkerBolt();
        builder.setSpout(spoutName, csfbSpout, spoutParallelism).setNumTasks(2);
        // bolt需要定制，但是如何定制呢？比如stream groupings,这个等测试完spout再说
        for (int i = 0; i < baseBoltImpl.length; i++) {
            for (String boltName : this.boltName
                    ) {
                if (boltName == baseBoltImpl[i].getBoltName())
                    logger.error("Bolt Name is "+boltName);
                    builder.setBolt(boltName, baseBoltImpl[i], boltParallelism).fieldsGrouping(spoutName, new Fields(spoutTupleName));
                break;
            }
        }
        //builder.setBolt(boltName.get(1),csfbBolt,boltParallelism).fieldsGrouping(spoutName,new Fields(spoutTupleName));
        return builder.createTopology();
        */
        return null;

    }
}
