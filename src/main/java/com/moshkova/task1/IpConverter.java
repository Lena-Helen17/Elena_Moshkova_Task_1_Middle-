package com.moshkova.task1;

import org.apache.log4j.Logger;

/**
 * Convector IP address in a 32-bit binary form
 * <p>
 * Created by e.moshkova on 20.05.22
 */

public class IpConverter {

    private static final Logger LOG = Logger.getLogger(IpConverter.class);
    private static int COUNT_BYTE = 4;
    private static int PART_STRING = 3;

    public static long ipToLong(String ipAddress) {

        long result = 0;
        String[] octets = ipAddress.split("\\.");
        if (octets.length != COUNT_BYTE) {
            LOG.error("Ip V4 format not corrected");
            return 0;
        }

        for (int i = 0; i < octets.length; i++) {
            int power = PART_STRING - i;
            int ip;
            try {
                ip = Integer.parseInt(octets[i]);
            } catch (NumberFormatException e) {
                LOG.error("Ip V4 format not corrected " + e);
                return 0;
            }
            result += ip * Math.pow(256, power);
        }
        return result;
    }
}
