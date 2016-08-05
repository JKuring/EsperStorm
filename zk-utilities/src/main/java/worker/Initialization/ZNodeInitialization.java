package worker.Initialization;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/5.
 */
public interface ZNodeInitialization {


    public void init(ZooKeeper zooKeeper) throws IOException;
}
