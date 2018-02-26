package com.terencechill.tutorialmod.entities;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Raphi on 20.02.2018.
 */
public class EntityPlayerGreeting extends EntityPlayer {


    public EntityPlayerGreeting(World worldIn){

        super(worldIn, Minecraft.getMinecraft().player.getGameProfile());

    }

    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }
}
