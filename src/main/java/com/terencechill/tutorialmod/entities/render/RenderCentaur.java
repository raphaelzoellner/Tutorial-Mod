package com.terencechill.tutorialmod.entities.render;

import com.terencechill.tutorialmod.TutorialMod;
import com.terencechill.tutorialmod.entities.EntityCentaur;
import com.terencechill.tutorialmod.entities.model.ModelCentaur;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;

import javax.annotation.Nullable;

/**
 * Created by Raphi on 12.02.2018.
 */
public class RenderCentaur extends RenderLiving<EntityCentaur>{

    public static final ResourceLocation TEXTURES = new ResourceLocation(TutorialMod.MODID + ":textures/entities/centaur.png");

    public RenderCentaur(RenderManager manager)
    {
        super(manager, new ModelCentaur(),0.5F );
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCentaur entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCentaur entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
