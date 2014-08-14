package com.darkinnit.projectquartz.block;

import com.darkinnit.projectquartz.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by darkinnit on 14/08/14.
 */
public class BlockResponder extends BlockPQ {

    @SideOnly(Side.CLIENT)
    private static class Icons {
        public static IIcon top;
        public static IIcon bottom;
        public static IIcon side;
    }

    public BlockResponder() {
        super(Material.rock);
        this.setBlockName("responder");
        this.setStepSound(soundTypeStone);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registry) {
        Icons.top = registry.registerIcon(Textures.RESPONDER_TOP);
        Icons.bottom = registry.registerIcon(Textures.RESPONDER_BOTTOM);
        Icons.side = registry.registerIcon(Textures.RESPONDER_SIDE);

        setTexture(ForgeDirection.UP, Icons.top);
        setTexture(ForgeDirection.DOWN, Icons.bottom);
        setTexture(ForgeDirection.EAST, Icons.side);
        setTexture(ForgeDirection.NORTH, Icons.side);
        setTexture(ForgeDirection.SOUTH, Icons.side);
        setTexture(ForgeDirection.WEST, Icons.side);
        setDefaultTexture(Icons.side);
    }
}
