package worker;


import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import worker.bean.ControlledTrigger;
import worker.watchercallback.ZookeeperDataCallback;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/2.
 * This class is controller of asynchronous operation. it include
 * most of all common zk operations, getDataFromZK and so on, and
 * this methods create an result in a ControlledTrigger object.
 */
public class AsynchController implements ZookeeperController {

    private static final Logger logger = LoggerFactory.getLogger(AsynchController.class);

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

    /**
     * The operation can send a context to a watcher by registered a watcher in it..
     *
     * @param znode             Zookeeper path.
     * @param controlledTrigger Controlled trigger object.
     * @param ctx               It is context that
     */
    @Override
    public void getDataFromZK(String znode, ControlledTrigger controlledTrigger, Object ctx) {

        logger.debug("getDataFromZK: " + znode + " data: " + controlledTrigger.getData() + " context: " + ctx);
        this.zookeeperDataCallback.setDataCallback(this.zooKeeper, znode, controlledTrigger);
        this.zooKeeper.getData(znode, zookeeperDataCallback, zookeeperDataCallback, ctx);
    }

    /**
     * @see AsynchController#getDataFromZK(String, ControlledTrigger, Object)
     * @param znode             Zookeeper path.
     * @param controlledTrigger Controlled trigger object.
     */
    public void getDataFromZk(String znode, ControlledTrigger controlledTrigger) {
        this.getDataFromZK(znode, controlledTrigger, null);
    }
}
