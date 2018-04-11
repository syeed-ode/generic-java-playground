package com.syeedode.blockchain;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static java.security.MessageDigest.getInstance;

/**
 * Author: syeedode
 * Date: 4/5/18
 */
public class Block {

    private final int index;
    private final long timestamp;
    private String hash;
    private final String previousHash;
    private String   data;
    private int nonce;

    public Block(int index, long timestamp, String previousHash, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        nonce = 0;
        hash = Block.calculateHash(this);
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    protected int getNonce() {
        return nonce;
    }

    public String str() {
        return getIndex() + getTimestamp() + getPreviousHash() + getData() + getNonce();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Block #")
                .append(getIndex())
                .append(" [previousHash : ").append(getPreviousHash()).append(",")
                .append(" timestamp : ").append(getTimestamp()).append(",")
                .append(" data : ").append(getData()).append(",")
                .append(" hash : ").append(getHash()).append("]");
        return builder.toString();
    }

    public static String calculateHash(Block block) {

        return Optional.of(block)
                .map(block1 -> {
                    try {
                        MessageDigest digest = getInstance("SHA-256");
                        String txt = block1.str();
                        final byte bytes[] = digest.digest(txt.getBytes());
                        final StringBuilder builder = new StringBuilder();

                        for (final byte b : bytes) {
                            String hex = Integer.toHexString(0xff & b);
                            if(hex.length() == 1) {
                                builder.append("0");
                            }
                            builder.append(hex);
                        }
                        return builder.toString();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .filter(s -> !StringUtils.isEmpty(s))
                .orElse(null);
    }

    public void mineBlock(int difficulty) {
        nonce = 0;
        while(!getHash().substring(0, difficulty).endsWith(BlockChainUtils.zeros(difficulty))) {
            nonce ++;
            hash = Block.calculateHash(this);
        }
    }
}
