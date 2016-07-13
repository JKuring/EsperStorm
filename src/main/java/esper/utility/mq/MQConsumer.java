package esper.utility.mq;

/**
 * Created by linghang.kong on 2016/7/7.
 */
public interface MQConsumer<T> {
    /**
     * Get a MQ consumer service object.
     *
     * @return T
     */
    public T getConsumer();
}
