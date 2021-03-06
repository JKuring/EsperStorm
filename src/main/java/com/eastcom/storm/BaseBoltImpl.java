package com.eastcom.storm;

import com.eastcom.data.EsperDataMap;
import com.espertech.esper.client.EPRuntime;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public abstract class BaseBoltImpl<T> extends BaseRichBolt implements BaseBolt {

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
        logger.info("Start Bolt ID: " + context.getThisComponentId());
        this.collector = collector;

        // read configuration from local yaml file
        this.spoutTupleName = (String) stormConf.get("project.spout.tuple.name");
        this.boltTupleName = (String) stormConf.get("project.bolt.tuple.name");

        this.eplName = (String) stormConf.get("project.esper.eplStatement.name");
        this.eplStatement = (String) stormConf.get("project.esper.eplStatement.statement");
        this.eventName = (String) stormConf.get("project.esper.map.name");

        this.epRuntime = getEPRuntime(this.eplName, this.eplStatement, this.eventName,
                this.listenerName, this.newEventsList, this.oldEventsList);

    }

    @Override
    public void execute(Tuple input) {
        if (this.newEventsList != null) {
            collector.emit(new Values(this.newEventsList));
            this.newEventsList.clear();
        }
        Map spoutTuple = (Map) input.getValueByField(spoutTupleName);
        if (spoutTuple != null) {
            epRuntime.sendEvent(spoutTuple, this.eventName);
        }
        // 担心线程处理没有事件发送快
        if (this.newEventsList != null) {
            collector.emit(new Values(this.newEventsList));
            this.newEventsList.clear();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //if (!this.boltTupleName.isEmpty())
        //declarer.declare(new Fields(this.boltTupleName));

    }


    /**
     * Esper init
     *
     * @param eplStatement EPL
     * @param listenerName listener name
     * @return EPRuntime
     */
    public EPRuntime getEPRuntime(String eplName, String eplStatement, String eventName,
                                  String listenerName, List newEventsList, List oldEventsList) {
        EsperDataMap esperDataMap = new EsperDataMap();
        // add a EPL statement
        esperDataMap.setEPLStatement(eplName, eplStatement);
        // register an event
        esperDataMap.setEventName(eventName);
        // add event result
        esperDataMap.addEventResultContainer(newEventsList, oldEventsList);
        // create a listener
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
