package task1;

import org.apache.log4j.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static final Logger  LOG = Logger.getLogger(Utils.class);

    public static void loadProperties() {
        try {
            FileInputStream fis;
            fis = new FileInputStream("context.properties");
            Properties properties = new Properties();
            properties.load(fis);
            Context.txtPath = properties.getProperty("txtPath");
        } catch (IOException e) {
            LOG.error("Failed to load properties " + e);
        }
    }
}
