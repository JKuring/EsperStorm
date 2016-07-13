package esper.base.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public abstract class BaseBoltImpl extends BaseRichBolt implements BaseBolt  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String epl;
    private String boltName;


    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {


    }

    @Override
    public void execute(Tuple input) {
        if( input.getValueByField("esperspoutdata") !=null);
        //epRuntime.sendEvent((Map) input.getValueByField(""),this.eventName);

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }


    //abstract public T analyzeTuple(String epl);

    public String getEpl() {
        return epl;
    }

    public void setEpl(String epl) {
        this.epl = epl;
    }

    public String getBoltName() {
        return boltName;
    }

    public void setBoltName(String boltName) {
        this.boltName = boltName;
    }
}
