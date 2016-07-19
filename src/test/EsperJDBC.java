package worker;

import java.util.Properties;

/**
 * Created by linghang.kong on 2016/7/7.
 */
public class EsperJDBC {
    private static EPServiceProvider epService;

    public static void main(String[] args) throws Exception {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EsperJDBC esperJDBC = new EsperJDBC();
        esperJDBC.setEpService(epService);
        esperJDBC.setUpBeforeClass();
        esperJDBC.testTimeIsolation();
        esperJDBC.tearDownAfterClass();
    }

    public void setUpBeforeClass() throws Exception {
        System.out.println("call before all tests...");
        //配置数据库链接
        Properties props = new Properties();

        props.put("username", "ipms");
        props.put("password", "");
        props.put("driverClassName", org.apache.hive.jdbc.HiveDriver.class.getName());
        props.put("url", "jdbc:hive2://10.11.58.22:21050/xdr_data;auth=noSasl");
        props.put("initialSize", 20);
        props.put("maxActive", 20);
        props.put("validationQuery", "select 1 from o_se_ur_csfb_session limit 1;");

        //ConfigurationDBRef configDB = new ConfigurationDBRef();
        //configDB.setDataSourceFactory(props, BasicDataSourceFactory.class.getName());
        //configDB.setConnectionLifecycleEnum(ConfigurationDBRef.ConnectionLifecycleEnum.POOLED);

        Configuration config = new Configuration();
        config.configure("conf/esper-jdbc.xml");
        //定义event
        config.addEventType("TransferAccount", TransferAccount.class);
        //config.addDatabaseReference("xdr_data", configDB);
        //初始化Esper引擎
        //定义数据库查询语句
        String sql = "select 1 from o_se_ur_csfb_session limit 1";
        //定义statment  EPL语句
        String statmentSQL = "select nameDest,beforeTime " +
                "from TransferAccount(transferMoney/nameSrcMoney>=0.9).win:time(3 sec) as ta, " +
                "sql:xdr_data [\"" + sql + "\"] ";
        //+
        //"as ld " +
        //"where ld.one>1 ";

        System.out.println("EPStatement");
        epService = EPServiceProviderManager.getProvider("engineURI", config);
        EPStatement st = epService.getEPAdministrator().createEPL(statmentSQL);

        //添加监听器
        System.out.println("添加监听器");
        st.addListener(new UpdateListener() {
            //得到符合EPL条件的事件（EPL处理的结果）
            public void update(EventBean[] newEvents, EventBean[] oldEvents) {
                long endTime = System.currentTimeMillis();
                if (newEvents != null) {
                    System.out.println("----new----end------->" + endTime + "------term:----->" + (endTime - Long.parseLong(newEvents[0].get("beforeTime").toString())) + "ms");
                } else if (oldEvents != null) {
                    System.out.println("----old----end------->" + endTime + "------term:----->" + (endTime - Long.parseLong(oldEvents[0].get("beforeTime").toString())) + "ms");
                    System.out.println("the old event is null.");
                } else {
                    System.out.println("-------end--------->" + endTime);
                }
            }
        });
    }

    public void testTimeIsolation() throws Exception {
//      发送事件
        for (int i = 0; i < 10000; i++) {
            long beforeTime = System.currentTimeMillis();
            epService.getEPRuntime().sendEvent(new TransferAccount("100@aa.com", "1000@aa.com", 100d, 90d, beforeTime));
        }
    }

    public void tearDownAfterClass() throws Exception {
        epService.destroy();
    }

    public EPServiceProvider getEpService() {
        return epService;
    }

    public void setEpService(EPServiceProvider epService) {
        this.epService = epService;
    }

    //要发送的事件
    public static class TransferAccount {
        Long beforeTime;

        String nameSrc;

        String nameDest;

        Double nameSrcMoney;

        Double transferMoney;

        TransferAccount(String nameSrc, String nameDest, Double nameSrcMoney, Double transferMoney, Long beforeTime) {
            this.nameSrc = nameSrc;
            this.nameDest = nameDest;
            this.nameSrcMoney = nameSrcMoney;
            this.transferMoney = transferMoney;
            this.beforeTime = beforeTime;
        }


        public String getNameSrc() {
            return nameSrc;
        }

        public void setNameSrc(String nameSrc) {
            this.nameSrc = nameSrc;
        }

        public String getNameDest() {
            return nameDest;
        }

        public void setNameDest(String nameDest) {
            this.nameDest = nameDest;
        }

        public Double getNameSrcMoney() {
            return nameSrcMoney;
        }

        public void setNameSrcMoney(Double nameSrcMoney) {
            this.nameSrcMoney = nameSrcMoney;
        }

        public Double getTransferMoney() {
            return transferMoney;
        }

        public void setTransferMoney(Double transferMoney) {
            this.transferMoney = transferMoney;
        }

        public Long getBeforeTime() {
            return beforeTime;
        }

        public void setBeforeTime(Long beforeTime) {
            this.beforeTime = beforeTime;
        }

    }
}
