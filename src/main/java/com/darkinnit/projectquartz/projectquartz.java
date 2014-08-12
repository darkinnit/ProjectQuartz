package com.darkinnit.projectquartz;

import com.darkinnit.projectquartz.handler.ConfigurationHandler;
import com.darkinnit.projectquartz.init.ModBlocks;
import com.darkinnit.projectquartz.init.ModItems;
import com.darkinnit.projectquartz.proxy.iProxy;
import com.darkinnit.projectquartz.reference.Reference;
import com.darkinnit.projectquartz.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by darkinnit on 11/08/14.
 */

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS)
public class projectquartz {
    @Mod.Instance(Reference.MOD_ID)
    public static projectquartz instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
            serverSide = Reference.SERVER_PROXY_CLASS)
    public static iProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();

        ModBlocks.init();

        LogHelper.debug("Pre Initialisation Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Recipes.init();
        LogHelper.debug("Initialisation Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        for (String oreName : OreDictionary.getOreNames())
        {
            LogHelper.info(oreName);
            // OreDictionary.getOres(oreName);
        }
        LogHelper.debug("Post Initialisation Complete!");
    }
}
