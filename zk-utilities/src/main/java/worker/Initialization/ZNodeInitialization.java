package worker.initialization;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/5.
 * This class is initialization of Zk tree about esper.
 * you implement this class and call init method, if you need initialize a ZK tree.
 */
public interface ZNodeInitialization {

    /**
     * Initialization Operation
     *
     * @param zooKeeper ZK handle
     * @throws IOException
     */
    public void initZnodes(ZooKeeper zooKeeper) throws IOException;

    public void cleanZnodes(ZooKeeper zooKeeper);
}
