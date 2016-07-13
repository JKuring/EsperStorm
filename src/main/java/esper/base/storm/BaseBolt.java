package esper.base.storm;

import com.espertech.esper.client.EPRuntime;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public interface BaseBolt<T> {

    public EPRuntime getEPRuntime(String eplName, String epl, String listenerName);

    public T analyzeTuple(String epl);

    public String getEplStatement();

    public void setEplStatement(String eplStatement);

    public String getBoltName();

    public void setBoltName(String boltName);

}
