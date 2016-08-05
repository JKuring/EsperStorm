package worker.WatcherAndCallback;

import org.apache.zookeeper.AsyncCallback.DataCallback;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import worker.bean.ControlledTrigger;

/**
 * Created by linghang.kong on 2016/7/22.
 */
public class ZookeeperDataCallback implements Watcher, DataCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ZooKeeper zooKeeper;
    private String znode;
    private ControlledTrigger controlledTrigger;
    private Object ctx;

    public void setDataCallback(ZooKeeper zooKeeper, String znode, ControlledTrigger controlledTrigger) {
        this.zooKeeper = zooKeeper;
        this.znode = znode;
        this.controlledTrigger = controlledTrigger;
    }

    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        this.ctx = ctx;
        if (this.znode != path) {
            logger.error("Can't find znode. znode: " + this.znode + ", path:" + path);
        } else {
            boolean exists = false;
            switch (rc) {
                case Code.Ok:
                    exists = true;
                    break;
                case Code.NoNode:
                    break;
                case Code.SessionExpired:
                    break;
                case Code.NoAuth:
                    break;
                default:
                    return;
            }
            if (exists) {
                logger.debug("fetch the Data from callback.");
                controlledTrigger.setData(data);
                controlledTrigger.setStat(stat);
                controlledTrigger.setChangedBit(true);
            } else {
                controlledTrigger.setChangedBit(false);
                logger.debug("Data is null.");
            }
        }
    }


    @Override
    public void process(WatchedEvent event) {
        Event.EventType eventType = event.getType();
        Event.KeeperState keeperState = event.getState();
        if (eventType == Event.EventType.NodeDataChanged) {
            // We are are being told that the state of the
            // connection has changed
            switch (keeperState) {
                case SyncConnected:
                    this.zooKeeper.getData(znode, this, this, this.ctx);
                    break;
                case Disconnected:
                    logger.error("unsuccessful created znode.");
                case Expired:
                    break;
            }
        }
    }
}
