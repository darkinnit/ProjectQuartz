package com.darkinnit.projectquartz.block;

import com.darkinnit.projectquartz.creativetab.CreativeTabPQ;
import com.darkinnit.projectquartz.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by darkinnit on 11/08/14.
 */
public class BlockPQ extends Block {
    public BlockPQ(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabPQ.PQ_TAB);
    }

    public BlockPQ()
    {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s",
                Textures.RESOURCE_PREFIX,
                getUnwrappedUnlocalizedName(
                        super.getUnlocalizedName())
        );
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(
                String.format(
                        "%s",
                        getUnwrappedUnlocalizedName(
                                this.getUnlocalizedName()
                        )
                )
        );
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(
                unlocalizedName.indexOf(".") + 1
        );
    }
}