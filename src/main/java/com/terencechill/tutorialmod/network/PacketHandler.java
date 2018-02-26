package com.terencechill.tutorialmod.network;

import com.terencechill.tutorialmod.TutorialMod;
import com.terencechill.tutorialmod.network.message.MessageGreeting;
import com.terencechill.tutorialmod.network.message.MessageUpdate;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Raphi on 16.02.2018.
 */
public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(TutorialMod.MODID);

    public static void init()
    {
        INSTANCE.registerMessage(MessageGreeting.class, MessageGreeting.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageUpdate.class, MessageUpdate.class, 1, Side.CLIENT);
    }

}
