import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/7/26.
 */
public class Test implements Watcher {
    private String hostPort;
    private int timeout;
    private ZooKeeper zooKeeper;

    public Test(String hostPort, int timeout) {
        this.hostPort = hostPort;
        this.timeout = timeout;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Start to Test.");
        Test test = new Test("10.11.58.86:2181", 1000);
        test.createSession();
    }

    public void createSession() throws IOException, InterruptedException {
        this.zooKeeper = new ZooKeeper(hostPort, timeout, this);
        Thread.sleep(200);
        //System.out.println("end");
        //zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }
}
