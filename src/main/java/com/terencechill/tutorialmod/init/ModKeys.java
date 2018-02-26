package com.terencechill.tutorialmod.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

/**
 * Created by Raphi on 16.02.2018.
 */
public class ModKeys {

    public static KeyBinding greet;
    public static KeyBinding gesturesGui;

    public static void init()
    {
                greet = new KeyBinding("key.greet", Keyboard.KEY_R, "key.categories.Greet");
                gesturesGui = new KeyBinding("key.gestures", Keyboard.KEY_Z,  "key.categories.Gestures");
    }

    public static void register()
    {
        ClientRegistry.registerKeyBinding(greet);
        ClientRegistry.registerKeyBinding(gesturesGui);
    }
}
