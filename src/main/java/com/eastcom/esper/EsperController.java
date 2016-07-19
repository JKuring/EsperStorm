package com.eastcom.esper;

import com.espertech.esper.client.ConfigurationOperations;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by linghang.kong on 2016/6/27.
 */
public interface EsperController {


    /**
     * Initialization
     */
    public void init();


    public void setEPLStatement(String index, String EPL);


    /**
     * clear all EPL statements.
     */
    public void clearEpl();

    /**
     * Gets the handle of EP statement.
     *
     * @return the statement handle.
     */
    public EPRuntime getEPRuntime();

    /**
     * Registers an update listener for the statement on EP.
     *
     * @param statement      EPL Statement
     * @param updateListener user-self define an update listener.
     */
    public void registListener(EPStatement statement, UpdateListener updateListener);

    /**
     * Creates an EPL statement, and return an EPStatement object.
     *
     * @return EPStatement Object.
     */
    public EPStatement createStatement();

    /**
     * In EPAdministrator, getting Configuration Operations to configure the event about defining and registering.
     *
     * @return ConfigurationOperations Object.
     */
    public ConfigurationOperations getOperations();

}
