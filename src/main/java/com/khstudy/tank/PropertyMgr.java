package main.java.com.khstudy.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {

    private PropertyMgr() {
    }

    private static Properties pros = new Properties();

    static {
        try {
            pros.load(PropertyMgr.class.getClassLoader().getResourceAsStream("main/java/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (pros == null) return null;
        return pros.get(key);
    }
}
