package com.syeedode.blockchain;


import com.syeedode.blockchain.BlockChainUtils.HashCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.syeedode.blockchain.BlockChainUtils.storedHashEquatesToCalculatedHash;
import static java.util.Objects.nonNull;

/**
 * Author: syeedode
 * Date: 4/10/18
 */
public class BlockChain {

    private final int difficulty;
    private List<Block> blockList;


    public BlockChain(int difficulty) {
        this.difficulty = difficulty;
        this.blockList = new ArrayList<>();
        Block block = new Block(0, System.currentTimeMillis(), null, "Genesis Block");
        block.mineBlock(difficulty);
        blockList.add(block);
    }

    public Block getLatestBlock() {
        return blockList.get(blockList.size() - 1);
    }

    public Block newBlock(String data) {
        Block latestBlcok = this.getLatestBlock();
        int newIndex = latestBlcok.getIndex() + 1;
        return new Block(
                  newIndex
                , System.currentTimeMillis()
                , latestBlcok.getHash()
                , data);
    }

    public void addBlock(Block block) {
        if(nonNull(block)) {
            block.mineBlock(this.getDifficulty());
            blockList.add(block);
        }
    }

    public boolean isFirstBlockValid() {
        return blockList.stream()
                .filter(Objects::nonNull)
                .findFirst()
                .filter(BlockChainUtils::blockHasIndexOfZero)
                .map(block -> new HashCalculation(block, block.getHash()))
                .filter(hc -> storedHashEquatesToCalculatedHash(hc.getComparativeBlock(), hc.getStoredHash()))
                .isPresent();
    }

    public boolean isValidNewBlock(Block newBlock, Block lastBlock) {
        if(Objects.nonNull(newBlock) && Objects.nonNull(lastBlock)) {

            if(lastBlock.getIndex() + 1 != newBlock.getIndex()){
                System.out.println("Block index mismatch for new block: "
                        + newBlock
                        + " and latestBlock: "
                        + lastBlock);
                return false;
            }

            String nBPreviousHash = newBlock.getPreviousHash();
            if(Objects.isNull(nBPreviousHash) || nBPreviousHash.equals(lastBlock.getHash())) {
                System.out.println("Block hash mismatch between new block: "
                        + newBlock
                        + " and latestBlock: "
                        + lastBlock);
                return false;
            }

            String newBlocksHash = newBlock.getHash();
            if(Objects.isNull(newBlocksHash) || !Block.calculateHash(newBlock).equals(newBlocksHash)) {
                System.out.println("Block hash calculation between new block: "
                        + newBlock
                        + " and latestBlock: "
                        + lastBlock);
                return false;
            }

            return true;
        }
        return false;
    }

    public boolean isBlockChainValid() {
        if(!isFirstBlockValid()) {
            return false;
        }

        for(int i = 1; i < blockList.size(); i++) {
            Block currentBlock = blockList.get(i);
            Block previousBlock = blockList.get(i-1);

            if(!isValidNewBlock(currentBlock, previousBlock)) {
                return false;
            }
        }

        return true;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        blockList.stream()
                .forEach(b -> stringBuilder.append(b).append("\n\t"));
        return stringBuilder.toString();
    }
}
