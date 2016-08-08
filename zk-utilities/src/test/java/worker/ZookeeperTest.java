package worker;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import worker.base.ZKHandle;
import worker.bean.ControlledTrigger;

import java.io.IOException;

/**
 * Created by linghang.kong on 2016/7/22.
 */
public class ZookeeperTest {
    @Test
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String host = "10.11.58.89";
        String port = "2181";
        // 节点名称
        String znode = "/mytest";

        ZooKeeper zooKeeper = new ZKHandle(host, port, 10000).getZooKeeper();
        AsynchController asynchController = new AsynchController(zooKeeper);
        ControlledTrigger controlledTrigger = new ControlledTrigger();
        System.out.println(controlledTrigger.isChangedBit());
        asynchController.getDataFromZk(znode, controlledTrigger);

        //while (true) {
        Thread.sleep(5000);
        if (controlledTrigger.isChangedBit()) {
            System.out.println(new String((byte[]) controlledTrigger.getData()));
            System.out.println(controlledTrigger.getStat().toString());
            controlledTrigger.setChangedBit(false);
        } else
            System.out.println("no change.");
        //}
    }
}
