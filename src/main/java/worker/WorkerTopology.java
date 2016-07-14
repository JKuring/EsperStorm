package worker;

import esper.base.storm.BaseTopology;
import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;

/**
 * Created by linghang.kong on 2016/7/7.
 */
public class WorkerTopology {
    //private static final Logger logger = LoggerFactory.getLogger(WorkerTopology.class.getClass());

    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        System.out.println("开启 topology!");
        Config config = new Config();
        System.out.println(config.keySet());
        BaseTopology topology = new BaseTopology();
        topology.setConfigurationFromYamlFile(config);

        // 提交到集群
        System.out.println("提交到集群!");
        StormSubmitter.submitTopology("esper-topology", config, topology.getEsperTopology());

        /*
        // 单机模式
        BaseTopology topology = new BaseTopology("WorkerSpout",null,1,1);
        WorkerSpout csfbSpout = new WorkerSpout("tcp://10.221.247.23:61616","Q_EVENT_PMCA_FILE2","ActiveMQ",2);
        WorkerBolt csfbBolt = new WorkerBolt();
        // 本地模式用于开发、测试，模拟一个完整的集群模式
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("esper-topology", config, topology.getEsperTopology(csfbSpout,csfbBolt));
        Utils.sleep(100);
        cluster.killTopology("esper-topology");
        cluster.shutdown();
        */
    }
}
