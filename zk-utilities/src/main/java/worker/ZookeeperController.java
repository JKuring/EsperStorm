package worker;

import worker.bean.ControlledTrigger;

/**
 * Created by linghang.kong on 2016/8/2.
 */
public interface ZookeeperController {
    /**
     * The operation can send a context to a watcher by registered a watcher in it..
     *
     * @param znode             Zookeeper path.
     * @param controlledTrigger Controlled trigger object.
     * @param ctx               It is context that
     */
    public void getDataFromZK(String znode, ControlledTrigger controlledTrigger, Object ctx);

}
