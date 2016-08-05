package worker.base;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * Created by linghang.kong on 2016/7/22.
 */
public class BaseWather implements Watcher {

    public final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void process(WatchedEvent watchedEvent) {
        EventType eventType = watchedEvent.getType();
        KeeperState keeperState = watchedEvent.getState();
        if (eventType == EventType.NodeCreated) {
            // We are are being told that the state of the
            // connection has changed
            switch (keeperState) {
                case SyncConnected:
                    logger.info("successful created znode.");
                    break;
                case Disconnected:
                    logger.error("unsuccessful created znode.");
                case Expired:
                    break;
            }
        } else if (eventType == EventType.NodeDeleted) {
            switch (keeperState) {
                case SyncConnected:
                    logger.info("unsuccessful delete znode.");
                    break;
                case Disconnected:
                    logger.error("successful delete znode.");
                case Expired:
                    break;
            }
        }
    }
}
