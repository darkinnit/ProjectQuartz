package com.darkinnit.projectquartz.init;

import com.darkinnit.projectquartz.item.ItemPQ;
import com.darkinnit.projectquartz.item.ItemTempThing;
import com.darkinnit.projectquartz.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by darkinnit on 11/08/14.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemPQ tempThing = new ItemTempThing();

    public static void init()
    {
        GameRegistry.registerItem(tempThing, "tempThing");
    }
}
