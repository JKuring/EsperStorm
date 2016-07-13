package esper.base.storm;

import java.util.Queue;

/**
 * Created by linghang.kong on 2016/7/6.
 */
public interface BaseSpout<T, E> {
    /**
     * Fetched data from resource db or data stream etc.
     * Storm will open multi threads to process it.
     * The "dataQueue" param has a consumed queue, and need to add data object in it.
     *
     * @param dataQueue the queue of data source object.
     */
    public void fetchTuple(Queue<E> dataQueue) throws Exception;
}
