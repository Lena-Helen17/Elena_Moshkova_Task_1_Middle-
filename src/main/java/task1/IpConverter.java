package task1;

import org.apache.log4j.Logger;

/**
 * Convector IP address in a 32-bit binary form
 *
 * Created by e.moshkova on 20.05.22
 */

public class IpConverter {

    private static final Logger LOG = Logger.getLogger(IpConverter.class);

    public static long ipToLong(String ipAddress) {

        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {

            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);

        }

        return result;
    }
}
