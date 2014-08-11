package com.darkinnit.projectquartz.client.gui;

import com.darkinnit.projectquartz.handler.ConfigurationHandler;
import com.darkinnit.projectquartz.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by darkinnit on 11/08/14.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(
                        ConfigurationHandler.configuration.getCategory(
                                Configuration.CATEGORY_GENERAL
                        )
                ).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}

