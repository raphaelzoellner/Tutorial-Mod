package com.terencechill.tutorialmod;

import com.terencechill.tutorialmod.init.EntityInit;
import com.terencechill.tutorialmod.network.PacketHandler;
import com.terencechill.tutorialmod.proxy.CommonProxy;
import com.terencechill.tutorialmod.util.handlers.RenderHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TutorialMod.MODID, name=TutorialMod.MODNAME, version = TutorialMod.VERSION)
public class TutorialMod
{
    public static final String MODID = "tutmod";
    public static final String MODNAME = "Tutorial Mod";
    public static final String VERSION = "0.0.1";

    public static final int ID_ENTITY_CENTAUR = 120;
    public static final int ID_ENTITY_MAMMOTH = 121;
    public static final int ID_ENTITY_PLAYERGREETING = 122;

    @SidedProxy(clientSide = "com.terencechill.tutorialmod.proxy.ClientProxy", serverSide = "com.terencechill.tutorialmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static TutorialMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

        PacketHandler.init();
        //not sure if to put in extra method in RegistryHandler?
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
