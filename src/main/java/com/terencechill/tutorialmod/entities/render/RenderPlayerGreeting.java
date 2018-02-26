package com.terencechill.tutorialmod.entities.render;

import com.terencechill.tutorialmod.entities.EntityPlayerGreeting;
import com.terencechill.tutorialmod.entities.model.ModelPlayerGreeting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

/**
 * Created by Raphi on 21.02.2018.
 */
public class RenderPlayerGreeting extends RenderLivingBase<EntityPlayerGreeting> {

    public RenderPlayerGreeting(RenderManager manager){

        // modelsize??? smallArmsIn???
        super(manager, new ModelPlayerGreeting(1F, true), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPlayerGreeting entity) {
        return Minecraft.getMinecraft().player.getLocationSkin();
    }

    @Override
    protected void applyRotations(EntityPlayerGreeting entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
