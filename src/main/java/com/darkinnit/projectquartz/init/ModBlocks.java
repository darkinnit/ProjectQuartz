package com.darkinnit.projectquartz.init;

import com.darkinnit.projectquartz.block.BlockObserver;
import com.darkinnit.projectquartz.block.BlockPQ;
import com.darkinnit.projectquartz.block.BlockResponder;
import com.darkinnit.projectquartz.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by darkinnit on 12/08/14.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockPQ observer = new BlockObserver();
    public static final BlockPQ responder = new BlockResponder();

    public static void init() {
        GameRegistry.registerBlock(observer, "observer");
        GameRegistry.registerBlock(responder, "responder");
    }

}
