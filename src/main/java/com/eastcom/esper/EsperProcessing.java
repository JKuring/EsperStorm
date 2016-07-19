package com.eastcom.esper;

/**
 * Created by linghang.kong on 2016/6/27.
 * Defines an interface to processed EP events.
 */
public interface EsperProcessing {
    /**
     * Defines prepared work ,and create epl statements.
     */
    public void prepare();

    /**
     * Defines event type ,and add configuration operations.
     * eg: addEventType, etc.
     */
    public void defineEvent();
}
