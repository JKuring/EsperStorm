package esper.base.esper;

import com.espertech.esper.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linghang.kong on 2016/6/23.
 * 抽象EPL语句的操作
 */
public abstract class EPControllerAbstract implements EsperController, EsperProcessing {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
    private EPAdministrator admin = epService.getEPAdministrator();


    private HashMap<Object, String> eplMap = new HashMap<Object, String>();
    private AtomicInteger eplIndex = new AtomicInteger();

    public EPControllerAbstract() {
    }

    public EPControllerAbstract(String epl) {
        this.eplMap.put(eplIndex.incrementAndGet(), epl);
    }


    public void init() {
        defineEvent();
        prepare();
    }

    public String getEpl(Object index) {
        return eplMap.get(index);
    }

    public void setEpl(String epl) {
        this.eplMap.put(eplIndex.incrementAndGet(), epl);
    }

    public void setEpl(Object index, String epl) {
        this.eplMap.put(index, epl);
    }

    public void clearEpl() {
        this.eplMap.clear();
    }

    public EPStatement createEPL(Object epl) {
        try {
            String eplStatement = this.eplMap.get(epl);
            if (epl != null) {
                EPStatement statement = this.admin.createEPL(eplStatement);
                return statement;
            } else throw new Exception("Invalid EPL statement.");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * key: EPL name, value: EPL
     * @return HashMap
     */
    public HashMap<Object, EPStatement> createAll() {
        HashMap<Object, EPStatement> statementMap = new HashMap<>();
        for (Object key : this.eplMap.keySet()
                ) {
            statementMap.put(key, this.admin.createEPL(this.eplMap.get(key)));
        }
        return statementMap;
    }

    public abstract void createListener(String... eplStatementName);

    /**
     *
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
