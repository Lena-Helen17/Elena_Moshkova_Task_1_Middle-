package com.moshkova.task1;


import org.apache.log4j.*;

import java.io.*;


public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ReadProperties.loadProperties();
        final String txtPath = Context.filePath;

        long timeStart = System.currentTimeMillis();

        BitSetCase bitset = new BitSetCase();

        try (BufferedReader br = new BufferedReader(new FileReader(txtPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                long longLine = IpConverter.ipToLong(line);
                if (longLine != 0) {
                    bitset.pushToSet(longLine);
                }
            }
        } catch (FileNotFoundException e) {
            LOG.error("File don't found" + e);

        } catch (IOException e) {
            LOG.error("Error read file" + e);
        }

        long count = bitset.getSize();

        System.out.println("Time for counting " + (System.currentTimeMillis() - timeStart) + " mc");
        System.out.println("Count is " + count);
    }
}
