package com.eastcom.esperobjecttest;

/**
 * Created by linghang.kong on 2016/6/23.
 * <p>
 * Created by linghang.kong on 2016/6/22.
 * <p>
 * Created by linghang.kong on 2016/6/22.
 * <p>
 * Created by linghang.kong on 2016/6/22.
 * <p>
 * Created by linghang.kong on 2016/6/22.
 */
/**
 * Created by linghang.kong on 2016/6/22.
 */

import com.espertech.esper.client.*;

/**
 *
 * @author luonanqin
 *
 */
class Apple {
    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class AppleListener implements UpdateListener {

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents != null) {
            Double avg = (Double) newEvents[0].get("avg(price)");
            System.out.println("Apple's average price is " + avg);
        }
    }
}

public class Test {

    public static void main(String[] args) throws InterruptedException {

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

        EPAdministrator admin = epService.getEPAdministrator();

        String product = Apple.class.getName();
        // EPL
        String epl = "select avg(price) from " + product + ".win:length_batch(3)";
        System.out.println(epl);
        EPStatement state = admin.createEPL(epl);
        state.addListener(new AppleListener());

        EPRuntime runtime = epService.getEPRuntime();

        Apple apple1 = new Apple();
        apple1.setId(1);
        apple1.setPrice(5);
        runtime.sendEvent(apple1);

        Apple apple2 = new Apple();
        apple2.setId(2);
        apple2.setPrice(2);
        runtime.sendEvent(apple2);

        Apple apple3 = new Apple();
        apple3.setId(3);
        apple3.setPrice(5);
        runtime.sendEvent(apple3);

    }
}
