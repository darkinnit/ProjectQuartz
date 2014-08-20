package com.darkinnit.projectquartz.block;

import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by darkinnit on 20/08/14.
 */
public interface IIconProvider {
    public IIcon getIcon(ForgeDirection rotatedDir);
}
