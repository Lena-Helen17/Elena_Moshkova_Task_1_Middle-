package com.moshkova.task1;

import org.apache.log4j.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static final Logger LOG = Logger.getLogger(ReadProperties.class);

    public static void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            Properties properties = new java.util.Properties();
            properties.load(fis);
            Context.filePath = properties.getProperty("filePath");
        } catch (IOException e) {
            LOG.error("Failed to load properties " + e);
        }
    }
}
