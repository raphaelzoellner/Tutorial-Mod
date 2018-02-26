package com.terencechill.tutorialmod.entities.render;

import com.terencechill.tutorialmod.TutorialMod;
import com.terencechill.tutorialmod.entities.EntityMammoth;
import com.terencechill.tutorialmod.entities.model.ModelMammoth;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Raphi on 13.02.2018.
 */
public class RenderMammoth extends RenderLiving<EntityMammoth> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID + ":textures/entities/mammoth.png");

    public RenderMammoth(RenderManager manager)
    {
        super(manager, new ModelMammoth(),0.5F );
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMammoth entity)
    {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(EntityMammoth entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

    }
