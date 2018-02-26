package com.terencechill.tutorialmod.entities.model;

import com.terencechill.tutorialmod.event.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by Raphi on 21.02.2018.
 */
public class ModelPlayerGreeting extends ModelPlayer {

    private static final int ARM_RISE_TICKS = 12;
    private static final int ARM_WAVE_TICKS = 13;

    // TODO: Hier Model anpassen zum greet selbst schreiben? Sonst wird echtes Playermodel genommen
    public ModelPlayerGreeting(float modelSize, boolean smallArmsIn)
    {
        super(modelSize, smallArmsIn);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {

    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        float animPercent;
        if (InputEvent.greetingTicks < ARM_RISE_TICKS)
        {
            animPercent = (float)InputEvent.greetingTicks / ARM_RISE_TICKS;
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F * animPercent);
        }
        else if (InputEvent.greetingTicks < ARM_RISE_TICKS + ARM_WAVE_TICKS)
        {
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F);
            animPercent = (float)(InputEvent.greetingTicks - ARM_RISE_TICKS) / ARM_WAVE_TICKS;
            this.bipedRightArm.rotateAngleZ = (float) Math.toRadians(-45F * animPercent);
        }
        else if (InputEvent.greetingTicks < ARM_RISE_TICKS + 2 * ARM_WAVE_TICKS)
        {
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F);
            animPercent = (float)(InputEvent.greetingTicks - (ARM_RISE_TICKS + ARM_WAVE_TICKS)) / ARM_WAVE_TICKS;
            this.bipedRightArm.rotateAngleZ = (float) Math.toRadians(-45F + 45F * animPercent);
        }
        else if (InputEvent.greetingTicks < ARM_RISE_TICKS + 3 * ARM_WAVE_TICKS)
        {
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F);
            animPercent = (float)(InputEvent.greetingTicks - (ARM_RISE_TICKS + 2 * ARM_WAVE_TICKS)) / ARM_WAVE_TICKS;
            this.bipedRightArm.rotateAngleZ = (float) Math.toRadians(-45F * animPercent);
        }
        else if (InputEvent.greetingTicks < ARM_RISE_TICKS + 4 * ARM_WAVE_TICKS)
        {
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F);
            animPercent = (float)(InputEvent.greetingTicks - (ARM_RISE_TICKS + 3 * ARM_WAVE_TICKS)) / ARM_WAVE_TICKS;
            this.bipedRightArm.rotateAngleZ = (float) Math.toRadians(-45F + 45F * animPercent);
        }
        else if (InputEvent.greetingTicks < 2 * ARM_RISE_TICKS + 4 * ARM_WAVE_TICKS)
        {
            animPercent = (float)(InputEvent.greetingTicks - (ARM_RISE_TICKS + 4 * ARM_WAVE_TICKS)) / ARM_RISE_TICKS;
            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-180F + 180F * animPercent);
        }
    }


}

