package com.darkinnit.projectquartz.creativetab;

import com.darkinnit.projectquartz.init.ModItems;
import com.darkinnit.projectquartz.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by darkinnit on 11/08/14.
 */
public class CreativeTabPQ {
    public static final CreativeTabs PQ_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.tempThing;
        }

    };
}
