package com.eastcom.storm;

import com.espertech.esper.client.EPRuntime;

import java.util.List;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public interface BaseBolt<T> {

    public EPRuntime getEPRuntime(String eplName, String eplStatement, String eventName,
                                  String listenerName, List newEventsList, List oldEventsList);

    public T analyzeTuple(String epl);

    public String getEplStatement();

    public void setEplStatement(String eplStatement);

    public String getBoltName();

    public void setBoltName(String boltName);

}
