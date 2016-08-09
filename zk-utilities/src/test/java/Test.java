import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

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

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        System.out.println("Start to Test.");
        String znode = "/multiop";
        Test test = new Test("10.11.58.89:2181", 1000);
        test.createSession();
        ZooKeeper zooKeeper = test.getZooKeeper();
        // Sync Method
        Stat stat = zooKeeper.exists(znode, false);
        Op op3 = Op.check(znode, stat.getVersion());
        Op op2 = Op.create(znode, "multiop1".getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Op op1 = Op.delete(znode, stat.getVersion());

        List<OpResult> results1 = zooKeeper.multi(Arrays.asList(op1, op2, op3));
        OpResult.CreateResult createResult1 = (OpResult.CreateResult) results1.get(1);
        OpResult.CheckResult checkResult1 = (OpResult.CheckResult) results1.get(2);
        System.out.println(createResult1.getPath());
        System.out.println(checkResult1.getType());

        // Async Method
        /*
        Transaction transaction = new Transaction();
        transaction.check("/multiop",1);
        transaction.create("/multiop","multiop1".getBytes(),null,null);
        transaction.delete("/multiop",1);
        List<OpResult> results2=transaction.commit();
        OpResult.CheckResult checkResult2 = (OpResult.CheckResult) results2.get(0);
        OpResult.CreateResult createResult2 = (OpResult.CreateResult) results2.get(1);
        */

    }

    public void createSession() throws IOException, InterruptedException {
        this.zooKeeper = new ZooKeeper(hostPort, timeout, this);
        Thread.sleep(300);
        //System.out.println("end");
        //zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
}
