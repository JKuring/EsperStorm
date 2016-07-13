import esper.utility.ImpalaConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by linghang.kong on 2016/7/1.
 */
public class sqltest {
    private static final String SQL_STATEMENT = "select * from o_se_ur_csfb_session \n" +
            "where\n" +
            "hour_partition >= 201607030000 and hour_partition <= 201607030100\n" +
            "limit 1000;";
    private static Statement stmt;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Configuration config = new Configuration();
        //config.configure("");
        ImpalaConnector impalaConnector = new ImpalaConnector();
        stmt= impalaConnector.getStatement();
        ResultSet rs = stmt.executeQuery(SQL_STATEMENT);
        System.out.println("\n== Begin Query Results ======================");
        // print the results to the console
        while (rs.next()) {
            System.out.println(rs.getLong("start_time")+" "+rs.getString(2));
        }

        System.out.println("== End Query Results =======================\n\n");
    }

}
