package worker;

import worker.bean.ControlledTrigger;

/**
 * Created by linghang.kong on 2016/8/2.
 */
public interface ZookeeperController {
    /**
     * @param znode             Zookeeper path.
     * @param controlledTrigger Controlled trigger object.
     */
    public void getDataFromZK(String znode, ControlledTrigger controlledTrigger, Object ctx);

}
