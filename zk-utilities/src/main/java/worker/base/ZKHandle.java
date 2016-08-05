package worker.base;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/7/22.
 */
public class ZKHandle {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String zkHostPorts;
    private ZooKeeper zooKeeper;
    private int timeout;

    public ZKHandle(String zkHost, String zkPort, int timeout) {
        this.zkHostPorts = zkHost + ':' + zkPort;
        this.timeout = timeout;
    }

    public ZKHandle(String zkHostPorts, int timeout) {
        this.zkHostPorts = zkHostPorts;
        this.timeout = timeout;
    }

    public ZooKeeper getZooKeeper() throws IOException {
        logger.info("Get a Zookeeper handle.");
        BaseWather baseWather = new BaseWather();
        this.zooKeeper = new ZooKeeper(zkHostPorts, this.timeout, baseWather);
        return this.zooKeeper;
    }

}
