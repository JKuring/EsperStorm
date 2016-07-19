package com.eastcom.esper;

import com.espertech.esper.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linghang.kong on 2016/6/23.
 * 抽象EPL语句的操作
 */
public abstract class EPControllerAbstract implements EsperController, EsperProcessing {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
    private EPAdministrator admin = epService.getEPAdministrator();


    private String statemnetName;
    private String eplStatement;
    private AtomicInteger eplIndex = new AtomicInteger();

    public EPControllerAbstract() {
    }


    public void init() {
        defineEvent();
        prepare();
    }


    public void setEPLStatement(String statemnetName, String eplStatement) {
        this.statemnetName = statemnetName;
        this.eplStatement = eplStatement;
    }


    public void clearEpl() {
        this.statemnetName = null;
        this.eplStatement = null;
    }

    public EPStatement createStatement() {
        try {
            String statemnetName = this.statemnetName;
            String eplStatement = this.eplStatement;
            if (eplStatement != null) {
                EPStatement statement = this.admin.createEPL(eplStatement, statemnetName);
                return statement;
            } else throw new Exception("Invalid EPL statement.");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }


    public abstract void createListener(String eplStatementName);

    /**
     * @param statement      EPL Statement
     * @param updateListener user-self define an update listener.
     */
    public void registListener(EPStatement statement, UpdateListener updateListener) {
        statement.addListener(updateListener);
    }

    public EPRuntime getEPRuntime() {
        // 初始化
        init();
        // 获取EP运行句柄
        return epService.getEPRuntime();
    }

    public ConfigurationOperations getOperations() {
        return admin.getConfiguration();
    }
}
