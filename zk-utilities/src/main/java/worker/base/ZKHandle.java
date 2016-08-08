package worker.base;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/7/22.
 * Created a zookeeper handle, the object include all of controlled options
 * that can connect zk servers to send messages.
 */
public class ZKHandle {

    public static final Logger logger = LoggerFactory.getLogger(ZKHandle.class);

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

    /**
     * The function can get a zk handle, and singleton model.
     *
     * @return ZooKeeper handle.
     * @throws IOException
     */
    public ZooKeeper getZooKeeper() throws IOException {
        logger.debug("Get a Zookeeper handle.");
        if (zooKeeper == null) {
            synchronized (this.getClass()) {
                BaseWather baseWather = new BaseWather();
                // 这里没有指定会话id和密码，由客户端自行分配
                this.zooKeeper = new ZooKeeper(zkHostPorts, this.timeout, baseWather);
            }
        }
        return this.zooKeeper;
    }

}
