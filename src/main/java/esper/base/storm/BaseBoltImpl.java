package esper.base.storm;

import com.espertech.esper.client.EPRuntime;
import esper.ep.EsperDataMap;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public abstract class BaseBoltImpl<T> extends BaseRichBolt implements BaseBolt  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String eplStatement;
    private String eplName;
    private String listenerName;
    private String boltName;
    private EPRuntime epRuntime;

    private String spoutTupleName;
    private String boltTupleName;

    private String eventName;

    private OutputCollector collector;

    private List newEventsList;
    private List oldEventsList;


    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        logger.info("Start Bolt ID: "+ context.getThisComponentId());
        this.collector = collector;

        this.spoutTupleName = (String) stormConf.get("project.spout.tuple.name");
        this.boltTupleName = (String) stormConf.get("project.bolt.tuple.name");

        this.eventName = (String) stormConf.get("project.esper.map.name");
        this.eplName = (String) stormConf.get("project.esper.eplStatement.name");
        this.eplStatement = (String) stormConf.get("project.esper.eplStatement.statement");

        this.epRuntime = getEPRuntime(this.eplName, this.eplStatement,this.listenerName);

    }

    @Override
    public void execute(Tuple input) {
        Map spoutTuple= (Map) input.getValueByField(spoutTupleName);
        if (spoutTuple != null) {
            epRuntime.sendEvent(spoutTuple,this.eventName);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //if (!this.boltTupleName.isEmpty())
        //declarer.declare(new Fields(this.boltTupleName));

    }


    /**
     * Esper init
     * @param epl EPL
     * @param listenerName listener name
     * @return EPRuntime
     */
    public EPRuntime getEPRuntime(String eplName, String epl, String eventName,
                                  String listenerName,List newEventsList,List oldEventsList){
        EsperDataMap esperDataMap = new EsperDataMap(newEventsList,oldEventsList);
        esperDataMap.setEpl(eplName,epl);
        esperDataMap.setEventName(eventName);
        esperDataMap.createListener(listenerName);
        return esperDataMap.getEPRuntime();
    }

    abstract public T analyzeTuple(String epl);

    public String getEplStatement() {
        return eplStatement;
    }

    public void setEplStatement(String eplStatement) {
        this.eplStatement = eplStatement;
    }

    public String getBoltName() {
        return boltName;
    }

    public void setBoltName(String boltName) {
        this.boltName = boltName;
    }
}
