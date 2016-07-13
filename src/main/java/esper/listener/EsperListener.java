package esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linghang.kong on 2016/6/23.
 *
 */
public class EsperListener implements UpdateListener {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List newEventsList;
    private List oldEventsList;

    public EsperListener(List newEventsList, List oldEventsList) {
        this.newEventsList = newEventsList;
        this.oldEventsList = oldEventsList;
    }

    // 对每个事件的进入，都会通知监听，启动update
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        try {
            if (newEvents != null) {
                this.newEventsList =Arrays.asList(newEvents);
                /*
                for (int i = 0; i < newEvents.length; i++) {
                    String name = (String) newEvents[i].get("name");
                    Integer age = (Integer) newEvents[i].get("age");
                    System.out.println("Person`s name: " + name + ", Person`s age: " + age);
                }
                */
            }
            if (oldEvents != null) {
                this.oldEventsList =Arrays.asList(oldEvents);
                /*
                System.out.println("oldEvents");
                for (int i = 0; i < oldEvents.length; i++) {
                    String name = (String) oldEvents[i].get("name");
                    Integer age = (Integer) oldEvents[i].get("age");
                    System.out.println("Person`s name: " + name + ", Person`s age: " + age);
                }
                */
            }
        } catch (Exception e) {
            logger.error("get error: " + e.getMessage());
        }
    }
}
