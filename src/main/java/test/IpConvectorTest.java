package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task1.IpConverter;

import static org.junit.jupiter.api.Assertions.*;


class IpConvectorTest {
    String testIp = "122.165.25.158";
    String testIp2 = "11.2.121.6";

    @DisplayName("Test IpConvection.ipToLong()")
    @Test
    void ipToLong() {
        assertEquals(longToIp(IpConverter.ipToLong(testIp)), testIp);
        assertEquals(longToIp(IpConverter.ipToLong(testIp2)), testIp2);
    }

    private String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {

            result.insert(0, (ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }

            ip = ip >> 8;
        }
        return result.toString();
    }
}