package com.darkinnit.projectquartz.block;

import net.minecraft.block.material.Material;

/**
 * Created by darkinnit on 12/08/14.
 */
public class BlockObserver extends BlockPQ {
    public BlockObserver() {
        super(Material.rock);
        this.setBlockName("observer");
        this.setBlockTextureName("observer");
        this.setStepSound(soundTypeStone);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
    }
}
