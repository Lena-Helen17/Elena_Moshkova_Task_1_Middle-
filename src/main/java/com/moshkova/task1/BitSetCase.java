package com.moshkova.task1;

import java.util.BitSet;

/**
 * Save for IP address as one bit in BitSet array
 * <p>
 * Created by e.moshkova on 21.05.22
 */
public class BitSetCase {

    private BitSet[] bitset;
    private final short CASE_SIZE = 2;

    public BitSetCase() {

        bitset = new BitSet[CASE_SIZE];
        for (int i = 0; i < CASE_SIZE; i++) {
            bitset[i] = new BitSet(Integer.MAX_VALUE);
        }
    }

    /**
     * Calculates chunk index and BitSet index for given
     * <br> IP address and storing them to collection
     *
     * @param ipDecimal IPv4 address in decimal format
     */
    void pushToSet(long ipDecimal) {

        bitset[getChunkIndex(ipDecimal)].set(getIpBitSetIndex(ipDecimal));
    }

    long getSize() {

        long total = 0;
        for (int i = 0; i < CASE_SIZE; i++) {
            total += bitset[i].cardinality();
        }
        return total;
    }

    /**
     * Calculates bit index in BitSet for IP address
     *
     * @param ipDecimal IPv4 address in decimal format
     * @return Position in BitSet with value 0 <= Integer.MAX_VALUE
     */
    private int getIpBitSetIndex(long ipDecimal) {
        int index = (int) ipDecimal;

        return index >= 0 ? index : index - Integer.MAX_VALUE - 1;
    }

    /**
     * @param ipDecimal IPv4 address in decimal format
     * @return BitSet[] chunk number for given IP address
     */
    private int getChunkIndex(long ipDecimal) {

        return ipDecimal <= Integer.MAX_VALUE ? 0 : 1;
    }
}

