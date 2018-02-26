package com.terencechill.tutorialmod.guis;

import com.terencechill.tutorialmod.TutorialMod;
import com.terencechill.tutorialmod.entities.EntityCentaur;
import com.terencechill.tutorialmod.entities.EntityPlayerGreeting;
import com.terencechill.tutorialmod.entities.model.ModelPlayerGreeting;
import com.terencechill.tutorialmod.entities.model.ModelPlayerOverride;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Raphi on 19.02.2018.
 */
public class GesturesGui extends GuiScreen {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID, "textures/guis/radialmenu.png");

    /** The old x position of the mouse pointer */
    private float oldMouseX;
    /** The old y position of the mouse pointer */
    private float oldMouseY;

    EntityPlayerGreeting playerGreeting = new EntityPlayerGreeting(Minecraft.getMinecraft().world);

    private static int textureWidth = 1000;
    private static int textureHeight = 1000;
    private static int guiWidth = 100;
    private static int guiHeight = 100;
    private static float guiScaleWidth = (float)guiWidth/textureWidth;
    private static float guiScaleHeight = (float)guiHeight/textureHeight;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

        GlStateManager.pushMatrix();
            GlStateManager.translate((width-guiWidth)/2,(height-guiHeight)/2,0);
            GlStateManager.scale(guiScaleWidth,guiScaleHeight,1);
            drawModalRectWithCustomSizedTexture(0,0,0,0,1000,1000,1000,1000);
        GlStateManager.popMatrix();
        //TODO: drawEntityOnScreen();
        super.drawScreen(mouseX, mouseY, partialTicks);
        drawGreetingPlayer(50 + 51, 50 + 75, 30, playerGreeting);
        this.oldMouseX = (float)mouseX;
        this.oldMouseY = (float)mouseY;
    }


    public static void drawGreetingPlayer(int posX, int posY, int scale, EntityLivingBase player)
    {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();

            GlStateManager.translate((float)posX, (float)posY, 50.0F);
            GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);

            float f = player.renderYawOffset;
            float f1 = player.rotationYaw;
            float f2 = player.rotationPitch;
            float f3 = player.prevRotationYawHead;
            float f4 = player.rotationYawHead;

            GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
            RenderHelper.enableStandardItemLighting();
            GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);

            //TODO: Animation
            player.renderYawOffset = 0;
            player.rotationYaw = 0;
            player.rotationPitch = 0;
            player.rotationYawHead = player.rotationYaw;
            player.prevRotationYawHead = player.rotationYaw;

            //TODO: Animation Ende

            RenderHelper.enableStandardItemLighting();

            RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
            rendermanager.setPlayerViewY(180.0F);
            rendermanager.setRenderShadow(false);
            rendermanager.renderEntity(player, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
            rendermanager.setRenderShadow(true);

            player.renderYawOffset = f;
            player.rotationYaw = f1;
            player.rotationPitch = f2;
            player.prevRotationYawHead = f3;
            player.rotationYawHead = f4;

        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
