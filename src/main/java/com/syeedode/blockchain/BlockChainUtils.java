package com.syeedode.blockchain;

import java.util.Objects;

/**
 * Author: syeedode
 * Date: 4/5/18
 */
public class BlockChainUtils {

    public static class HashCalculation {
        private final String storedHash;
        private final Block comparativeBlock;

        public HashCalculation(Block comparativeBlock, String storedHash) {
            this.storedHash = storedHash;
            this.comparativeBlock = comparativeBlock;
        }

        public String getStoredHash() {
            return storedHash;
        }

        public Block getComparativeBlock() {
            return comparativeBlock;
        }
    }

    public static String zeros(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

    public static boolean blockHasIndexOfZero(Block b) {
        boolean valid = b.getIndex() == 0;
        if(!valid) {
            System.out.println("Initial index validity check failed: "
                    + b);
        }
        return valid;
    }

    public static boolean storedHashEquatesToCalculatedHash(Block b, String storedHash) {
        String calculatedHash = Block.calculateHash(b);
        if(Objects.nonNull(storedHash)) {
            return storedHash.equals(calculatedHash);
        } else {
            return null == calculatedHash;
        }

    }

}
