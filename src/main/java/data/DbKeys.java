package data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DbKeys {

    public final static String uptime = "uptime";
    public final static String md5 = "md5";
    public static final String unknown = "unknown";

    public static final String SITE_INFO = "site:info";

    /**
     * 检查常量字段是否有重复
     *
     * @param args
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        DbKeys dbKeys = new DbKeys();
        Field[] fields = dbKeys.getClass().getDeclaredFields();
        Map<String, String> map = new HashMap<>();
        for (Field field : fields) {
            String name = field.getName();
            String value = String.valueOf(field.get(dbKeys));
            if (map.containsKey(value)) {
                System.err.println("发现重复项: " + name + "--" + map.get(value));
            } else {
                map.put(value, name);
            }
        }
        System.out.println("----finish----");
    }

}
