import com.espertech.esper.client.EPRuntime;
import com.eastcom.data.bean.Person;
import com.eastcom.data.EsperDataMap;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Created by linghang.kong on 2016/6/23.
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        String from = Person.class.getName();
        // 为什么第二次结果为零呢
        String where = "name !=\"\"";
        String select = "name, age";

        EsperDataMap esperDataMap = new EsperDataMap();
        esperDataMap.setEPLStatement("select", "select irstream name, age from Person.win:time(1 sec) where name !=\"\"");
        esperDataMap.createListener("select");
        EPRuntime epRuntime = esperDataMap.getEPRuntime();

        // POJO
        /*
        Person person1 = new Person();
        person1.setName("kong");
        person1.setAge(1);
        epRuntime.sendEvent(person1);

        sleep(2000);
        Person person2 = new Person();
        person2.setName("ling");
        person2.setAge(2);
        epRuntime.sendEvent(person2);

        sleep(2000);
        Person person3 = new Person();
        person3.setName("hang");
        person3.setAge(3);
        epRuntime.sendEvent(person3);

        sleep(2000);
        */

        // Map 热切换
        Map persons1 = new HashMap();
        persons1.put("name", "kong");
        persons1.put("age", 1);
        epRuntime.sendEvent(persons1, "Person");
        sleep(2000);

        Map persons2 = new HashMap();
        persons2.put("name", "ling");
        persons2.put("age", 2);
        epRuntime.sendEvent(persons2, "Person");

        sleep(2000);


        System.exit(0);
    }
}
