package com.eastcom.data;

/**
 * Created by linghang.kong on 2016/6/23.
 */

import com.eastcom.esper.EPControllerAbstract;
import com.eastcom.listener.EsperListenerFactory;
import com.espertech.esper.client.EPStatement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EsperDataMap extends EPControllerAbstract {

    private EPStatement statement;
    private String eplListenerName;
    private String eventName;

    private List newEventsList;
    private List oldEventsList;

    public void addEventResultContainer(List newEventsList, List oldEventsList) {
        this.newEventsList = newEventsList;
        this.oldEventsList = oldEventsList;
    }

    public void prepare() {
        // 创建EPL语句
        statement = createStatement();
        // 注册监听
        registListener(statement, EsperListenerFactory.getListener(eplListenerName, newEventsList, oldEventsList));
    }

    public void defineEvent() {

        // Address的Map定义

        Map<String, Object> address = new HashMap<String, Object>();
        address.put("road", String.class);
        address.put("street", String.class);
        address.put("houseNo", int.class);

        // Person的Map定义
        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", String.class);
        person.put("age", int.class);
        person.put("children", List.class);
        person.put("phones", Map.class);
        person.put("address", "Address");

        // 注册Address到Esper
        getOperations().addEventType("Address", address);
        // 注册Person到Esper
        getOperations().addEventType(this.eventName, person);

    }

    @Override
    public void createListener(String eplStatementName) {
        this.eplListenerName = eplStatementName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}

