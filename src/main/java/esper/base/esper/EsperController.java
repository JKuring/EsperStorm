package esper.base.esper;

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

    public <T> String getEpl(T index);

    public void setEpl(String EPL);

    public <T> void setEpl(T index, String epl);

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
     * @param epl EPL Statement
     * @param <T>
     * @return EPStatement Object.
     */
    public <T> EPStatement createEPL(T epl);

    /**
     * In EPAdministrator, getting Configuration Operations to configure the event about defining and registering.
     *
     * @return ConfigurationOperations Object.
     */
    public ConfigurationOperations getOperations();

}
