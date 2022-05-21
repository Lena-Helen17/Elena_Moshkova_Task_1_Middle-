package task1;


import org.apache.log4j.*;

import java.io.*;


public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Utils.loadProperties();
        final String txtPath = Context.txtPath;

        long timeStart = System.currentTimeMillis();

        BitSetSave bitset = new BitSetSave();

        try (BufferedReader br = new BufferedReader(new FileReader(txtPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                bitset.pushToSet(IpConverter.ipToLong(line));
            }
        } catch (FileNotFoundException e) {
            LOG.error("File don't found" + e);

        } catch (IOException e) {
            LOG.error("Error read file" + e);
        }

        long count = bitset.getResult();

        System.out.println("Time for counting " + (System.currentTimeMillis() - timeStart) + " mc");
        System.out.println("Count is " + count);
    }
}
