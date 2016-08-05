package worker.bean;

import org.apache.zookeeper.data.Stat;

/**
 * Created by linghang.kong on 2016/8/2.
 */
public class ControlledTrigger<T> {
    private boolean changedBit = false;
    private Stat stat;
    private T data;

    public boolean isChangedBit() {
        return changedBit;
    }

    public void setChangedBit(boolean changedBit) {
        this.changedBit = changedBit;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
