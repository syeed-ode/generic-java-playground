package com.syeedode.blockchain;

/**
 * Author: syeedode
 * Date: 4/11/18
 */
public class BlockChainMain {

    public static void main(String [] args) {
        int difficulty = 4;
        BlockChain blockChain = new BlockChain(difficulty);
        blockChain.addBlock(blockChain.newBlock("All of your bitcoins"));
        blockChain.addBlock(blockChain.newBlock("Syeed Ode"));
        blockChain.addBlock(blockChain.newBlock("https://www.allofyourbitcoins.com"));

        System.out.println("Is blockchain valid: " + blockChain.isBlockChainValid());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(blockChain);

    }
}
