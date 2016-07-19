package com.eastcom.listener;

import com.espertech.esper.client.UpdateListener;

import java.util.List;

/**
 * Created by linghang.kong on 2016/7/18.
 */
public class EsperListenerFactory {

    public static UpdateListener getListener(String listenerName, List newEventsList, List oldEventsList) {
        switch (listenerName) {
            case "UserDefinedListener":
                return new UserDefinedListener();
            case "EsperListener":
                return new EsperListener(listenerName, newEventsList, oldEventsList);
        }
        return null;
    }
}
