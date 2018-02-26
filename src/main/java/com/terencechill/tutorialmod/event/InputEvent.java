package com.terencechill.tutorialmod.event;

import com.terencechill.tutorialmod.guis.GesturesGui;
import com.terencechill.tutorialmod.init.ModKeys;
import com.terencechill.tutorialmod.network.PacketHandler;
import com.terencechill.tutorialmod.network.message.MessageGreeting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by Raphi on 16.02.2018.
 */
public class InputEvent {

    public static int greetingTicks = 0;
    public static final int MAX_GREETING_TICKS = 120;

    public static boolean greeting = false;
    public static boolean printed = false;

    public static final int MAX_GREETING_HELD = 8;
    public static int greetingHeld = 0;
    public static int prevGreetingHeld = 0;

    public static float firstPersonPartialTicks;

    public String connectionType;

    @SubscribeEvent
    public void onKeyInput(net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event)
    {

        if (ModKeys.gesturesGui.isKeyDown()){
            Minecraft.getMinecraft().displayGuiScreen(new GesturesGui());
        }


        if(ModKeys.greet.isKeyDown())
        {
            if(!greeting)
            {
                if("MODDED".equals(connectionType))
                    PacketHandler.INSTANCE.sendToServer(new MessageGreeting(true));
                greeting = true;
            }
        }
        else
        {
            if("MODDED".equals(connectionType))
                PacketHandler.INSTANCE.sendToServer(new MessageGreeting(false));
            greeting = false;
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        prevGreetingHeld = greetingHeld;

        if(greeting && greetingHeld < MAX_GREETING_HELD)
        {
            greetingHeld++;
        }
        else if(!greeting && greetingHeld > 0)
        {
            greetingHeld--;
        }


        if (greetingTicks < MAX_GREETING_TICKS)
        {
            greetingTicks++;
        }
        else
        {
            greetingTicks = 0;
        }
    }

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent event)
    {
        if(!printed)
        {
            event.player.sendMessage(new TextComponentString(TextFormatting.GOLD.toString() + TextFormatting.BOLD.toString() + "Press " + Keyboard.getKeyName(ModKeys.greet.getKeyCode()) + " to Greet!"));
            printed = true;
        }
    }

    @SubscribeEvent
    public void onRender(RenderHandEvent event)
    {
        firstPersonPartialTicks = event.getPartialTicks();
    }

    @SubscribeEvent
    public void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent event)
    {
        this.connectionType = event.getConnectionType();
    }
}
