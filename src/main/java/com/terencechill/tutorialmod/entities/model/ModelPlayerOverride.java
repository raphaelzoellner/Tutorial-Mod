package com.terencechill.tutorialmod.entities.model;

import com.terencechill.tutorialmod.event.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Raphi on 16.02.2018.
 */
public class ModelPlayerOverride extends ModelPlayer{

    private ModelBase oldModel;
    private float thirdPersonPartialTicks;
    //public ModelRenderer bipedHead2;

    public ModelPlayerOverride(ModelBase oldModel, float modelSize, boolean smallArmsIn)
    {
        super(modelSize, smallArmsIn);
        this.oldModel = oldModel;
        //this.bipedHead2 = new ModelRenderer(this, 0, 0);
        //this.bipedHead2.addBox(-12.0F, -8.0F, -4.0F, 8, 8, 8, modelSize);
        //this.bipedHead2.setRotationPoint(0.0F, 0.0F + 0.0F, 0.0F);
    }


    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.pushMatrix();

        if (this.isChild)
        {
            float f = 2.0F;
            GlStateManager.scale(0.75F, 0.75F, 0.75F);
            GlStateManager.translate(0.0F, 16.0F * scale, 0.0F);
            //this.bipedHead2.render(scale);
        }
        else
        {
            if (entityIn.isSneaking()) {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }

            //this.bipedHead2.render(scale);
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
        thirdPersonPartialTicks = partialTickTime;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        oldModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        boolean isOurPlayer = entityIn.getEntityId() == Minecraft.getMinecraft().player.getEntityId();

        if(entityIn.getEntityData().getBoolean("greeting") || (isOurPlayer && InputEvent.prevGreetingHeld > 0))
        {
            float heldPercent = (InputEvent.prevGreetingHeld + (InputEvent.greetingHeld - InputEvent.prevGreetingHeld) * thirdPersonPartialTicks) / InputEvent.MAX_GREETING_HELD;

            if(!isOurPlayer) heldPercent = 1.0F;

            this.bipedRightArm.rotateAngleX = (float) Math.toRadians(-90F * heldPercent);
            this.bipedRightArm.rotateAngleY = (float) Math.toRadians(-35F * heldPercent);

            this.bipedRightArmwear.rotateAngleX = (float) Math.toRadians(-90F * heldPercent);
            this.bipedRightArmwear.rotateAngleY = (float) Math.toRadians(-35F * heldPercent);

            this.bipedLeftArm.rotateAngleX = (float) Math.toRadians(15F * heldPercent);
            this.bipedLeftArm.rotateAngleY = (float) Math.toRadians(15F * heldPercent);
            this.bipedLeftArm.rotateAngleZ = (float) Math.toRadians(-110F * heldPercent);

            this.bipedLeftArmwear.rotateAngleX = (float) Math.toRadians(15F * heldPercent);
            this.bipedLeftArmwear.rotateAngleY = (float) Math.toRadians(15F * heldPercent);
            this.bipedLeftArmwear.rotateAngleZ = (float) Math.toRadians(-110F * heldPercent);

            float rotationX = entityIn.rotationPitch;
            this.bipedHead.rotateAngleX = (float) Math.toRadians(-rotationX * heldPercent) + (float) Math.toRadians(45F * heldPercent + rotationX);

            float rotationY = (((EntityPlayer) entityIn).renderYawOffset - entityIn.rotationYaw);
            this.bipedHead.rotateAngleY = (float) Math.toRadians(rotationY * heldPercent) + (float) Math.toRadians(35F * heldPercent - rotationY);

            copyModelAngles(this.bipedHead, this.bipedHeadwear);

            if(isOurPlayer)
            {
                if(Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)
                {
                    heldPercent = (InputEvent.prevGreetingHeld + (InputEvent.greetingHeld - InputEvent.prevGreetingHeld) * InputEvent.firstPersonPartialTicks) / InputEvent.MAX_GREETING_HELD;

                    GlStateManager.rotate(-50F * heldPercent, 1, 0, 0);
                    GlStateManager.rotate(30F * heldPercent, 0, 1, 0);
                    GlStateManager.rotate(-30F * heldPercent, 0, 0, 1);
                    GlStateManager.translate(-0.3 * heldPercent, -0.2 * heldPercent, -0.5 * heldPercent);
                }
            }
        }
    }
}
