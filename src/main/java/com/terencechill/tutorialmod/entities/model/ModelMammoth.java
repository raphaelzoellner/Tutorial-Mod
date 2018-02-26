// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by Reicheltp with Cubik Studio - https://cubik.studio
package com.terencechill.tutorialmod.entities.model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMammoth extends ModelBase {

    //fields
    public ModelRenderer e1;
    public ModelRenderer e2;

    public ModelMammoth()
    {
        textureWidth = 64;
        textureHeight = 64;

        e1 = new ModelRenderer(this, 0, 32);
        e1.setRotationPoint(-8F, 24F, -8F);
        e1.addBox(0F, -16F, 0F, 16, 16, 16);
        e1.setTextureSize(64, 64);
        e1.mirror = false;
        setRotation(e1, 0F, 0F, 0F);
        e2 = new ModelRenderer(this, 0, 16);
        e2.setRotationPoint(-2.5F, 40F, -3.5F);
        e2.addBox(0F, -7.5F, 0F, 6, 8, 8);
        e2.setTextureSize(64, 64);
        e2.mirror = false;
        setRotation(e2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        e1.render(f5);
        e2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
     
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
 
}