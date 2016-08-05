package worker;


import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import worker.WatcherAndCallback.ZookeeperDataCallback;
import worker.bean.ControlledTrigger;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/2.
 */
public class AsynchController implements ZookeeperController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ZooKeeper zooKeeper;
    private String zkHost;
    private String zkPort;
    private String zkHostPorts;
    private Object ctx;
    private int sessionTimeout = 10000;

    private ZookeeperDataCallback zookeeperDataCallback;

    public AsynchController(ZooKeeper zooKeeper) throws IOException {
        this.zkHostPorts = zkHost + ':' + zkPort;
        this.zooKeeper = zooKeeper;
        this.zookeeperDataCallback = new ZookeeperDataCallback();
    }

    @Override
    public void getDataFromZK(String znode, ControlledTrigger controlledTrigger, Object ctx) {

        logger.debug("getDataFromZK: " + znode + " data: " + controlledTrigger.getData() + " context: " + ctx);

        this.zookeeperDataCallback.setDataCallback(this.zooKeeper, znode, controlledTrigger);
        this.zooKeeper.getData(znode, zookeeperDataCallback, zookeeperDataCallback, ctx);
    }

    public void getDataFromZk(String znode, ControlledTrigger controlledTrigger) {
        this.getDataFromZK(znode, controlledTrigger, null);
    }
}
