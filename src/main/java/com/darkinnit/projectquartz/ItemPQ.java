package com.darkinnit.projectquartz;

import com.darkinnit.projectquartz.creativetab.CreativeTabPQ;
import com.darkinnit.projectquartz.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by darkinnit on 11/08/14.
 */
public class ItemPQ extends Item {
    public ItemPQ()
    {
        super();
        this.setCreativeTab(CreativeTabPQ.PQ_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s",
                Textures.RESOURCE_PREFIX,
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s",
                Textures.RESOURCE_PREFIX,
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(
                this.getUnlocalizedName().substring(
                        this.getUnlocalizedName().indexOf(".") + 1
                )
        );
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
