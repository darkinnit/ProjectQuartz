package com.darkinnit.projectquartz.block;

import com.darkinnit.projectquartz.creativetab.CreativeTabPQ;
import com.darkinnit.projectquartz.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by darkinnit on 11/08/14.
 */
public class BlockPQ extends Block {
    public BlockPQ(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabPQ.PQ_TAB);
        setRotationMode(BlockRotationMode.NONE);
    }

    public enum BlockRotationMode {
        NONE(),
        FOUR_DIRECTIONS(ForgeDirection.UP, ForgeDirection.DOWN),
        SIX_DIRECTIONS(ForgeDirection.VALID_DIRECTIONS),
        TWENTYFOUR_DIRECTIONS(ForgeDirection.VALID_DIRECTIONS);

        private BlockRotationMode(ForgeDirection... rotations)
        {
            this.rotations = rotations;
        }

        private final ForgeDirection[] rotations;
    }

    public BlockPQ()
    {
        this(Material.rock);
    }

    public IIcon[] textures = new IIcon[6];
    protected BlockRotationMode blockRotationMode;
    protected ForgeDirection inventoryRenderRotation = ForgeDirection.WEST;


    public BlockRotationMode getRotationMode() {
        return this.blockRotationMode;
    }

    protected void setRotationMode(BlockRotationMode mode) {
        this.blockRotationMode = mode;
    }

    protected void setInventoryRenderRotation(ForgeDirection rotation) {
        inventoryRenderRotation = rotation;
    }

    @SideOnly(Side.CLIENT)
    public ForgeDirection getInventoryRenderRotation() {
        return inventoryRenderRotation;
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


    public void setTexture(ForgeDirection direction, IIcon icon) {
        textures[direction.ordinal()] = icon;
    }

    public void setDefaultTexture(IIcon icon) {
        this.blockIcon = icon;
    }

    protected IIcon getUnrotatedTexture(ForgeDirection direction)
    {
        if (direction != ForgeDirection.UNKNOWN)
        {
            final int directionid = direction.ordinal();
            if (textures[directionid] != null)
            {
                return textures[directionid];
            }
        }
        return blockIcon;
    }

    public IIcon getUnrotatedTexture(ForgeDirection direction, IBlockAccess world, int x, int y, int z)
    {
        return getUnrotatedTexture(direction);
    }

    public ForgeDirection rotateSideByMetadata(int side, int metadata) {
        ForgeDirection rotation = ForgeDirection.getOrientation(metadata);
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        switch (getRotationMode()) {
            case FOUR_DIRECTIONS:
            case NONE:
                switch (rotation) {
                    case EAST:
                        dir = dir.getRotation(ForgeDirection.DOWN);
                        break;
                    case SOUTH:
                        dir = dir.getRotation(ForgeDirection.UP);
                        //dir = dir.getRotation(ForgeDirection.UP);
                        break;
                    case WEST:
                        dir = dir.getRotation(ForgeDirection.UP);
                        break;
                    default:
                        break;
                }
                return dir;
            default:
                switch (rotation) {
                    case DOWN:
                        dir = dir.getRotation(ForgeDirection.SOUTH);
                        //dir = dir.getRotation(ForgeDirection.SOUTH);
                        break;
                    case EAST:
                        dir = dir.getRotation(ForgeDirection.NORTH);
                        break;
                    case NORTH:
                        dir = dir.getRotation(ForgeDirection.WEST);
                        break;
                    case SOUTH:
                        dir = dir.getRotation(ForgeDirection.EAST);
                        break;
                    case WEST:
                        dir = dir.getRotation(ForgeDirection.SOUTH);
                        break;
                    default:
                        break;

                }
        }
        return dir;
    }

    @SuppressWarnings("unchecked")
    public static <U> U getTileEntity(IBlockAccess world, int x, int y, int z, Class<U> T)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te != null && T.isAssignableFrom(te.getClass()))
        {
            return (U)te;
        }
        return null;
    }

    /**
     * Get the texture, but rotate the block around the metadata rotation first
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        ForgeDirection direction = rotateSideByMetadata(side, world.getBlockMetadata(x, y, z));
        IIconProvider provider = getTileEntity(world, x, y, z, IIconProvider.class);
        IIcon teIcon = null;
        if (provider!=null)
        {
            teIcon = provider.getIcon(direction);
        }
        return teIcon!=null? teIcon : getUnrotatedTexture(direction, world, x, y, z);
    }

    /***
     * This is called by the blockrenderer when rendering an item into the
     * inventory.
     * We'll return the block, rotated as we wish, but without any additional
     * texture changes that are caused by the blocks current state
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        ForgeDirection newRotation = rotateSideByMetadata(side, metadata);
        return getUnrotatedTexture(newRotation);
    }
}
