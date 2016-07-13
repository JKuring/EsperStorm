package esper.ep;

/**
 * Created by linghang.kong on 2016/6/23.
 */

import com.espertech.esper.client.EPStatement;
import esper.base.esper.EPControllerAbstract;
import esper.listener.EsperListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EsperDataMap extends EPControllerAbstract {

    private EPStatement statement;
    private String[] eplListenerName;
    private String eventName;

    private List newEventsList;
    private List oldEventsList;

    public EsperDataMap(List newEventsList, List oldEventsList) {
        this.newEventsList = newEventsList;
        this.oldEventsList = oldEventsList;
    }

    public void prepare() {
        for (String name : eplListenerName
                ) {
            // 创建EPL语句
            statement = createAll().get(name);
            // 建立对该语句的监听
            // 目前默认：只使用一种监听，机理，根据监听的名称，在eplMap中去对应epl的名称，然后建立监听。
            // 需求，可以自定义多个不同种类的监听。
            // 实现方法，使用监听名称，建立一个listenerMap，key为监听名称，value为鉴定实例，然后再对应注册。
            registListener(statement, new EsperListener(this.newEventsList,this.oldEventsList));
        }
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
    public void createListener(String... eplStatementName) {
        this.eplListenerName = eplStatementName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}

