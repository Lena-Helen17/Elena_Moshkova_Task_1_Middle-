package com.moshkova.task1.test;

import com.moshkova.task1.IpConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class IpConvectorTest {

    @Test
    void ipToLong_true() {
        assertEquals(IpConverter.ipToLong("122.165.25.158"), 2057640350);
        assertEquals(IpConverter.ipToLong("11.2.121.6"), 184711430);
    }

 // @DisplayName("Test IpConvection.ipToLong()")
    @Test
    void ipToLong_Exception() {
        assertEquals(IpConverter.ipToLong("11.2.121"), 0);
        assertEquals(IpConverter.ipToLong("11.2.121.6t"), 0);
    }
}