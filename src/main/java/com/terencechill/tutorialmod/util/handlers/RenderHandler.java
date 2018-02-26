package com.terencechill.tutorialmod.util.handlers;

import com.terencechill.tutorialmod.entities.EntityCentaur;
import com.terencechill.tutorialmod.entities.EntityMammoth;
import com.terencechill.tutorialmod.entities.EntityPlayerGreeting;
import com.terencechill.tutorialmod.entities.render.RenderCentaur;
import com.terencechill.tutorialmod.entities.render.RenderMammoth;
import com.terencechill.tutorialmod.entities.render.RenderPlayerGreeting;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by Raphi on 12.02.2018.
 */
public class RenderHandler {

    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
            @Override
            public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
                return new RenderCentaur(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new IRenderFactory<EntityMammoth>() {
            @Override
            public Render<? super EntityMammoth> createRenderFor(RenderManager manager) {
                return new RenderMammoth(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityPlayerGreeting.class, new IRenderFactory<EntityPlayerGreeting>() {
            @Override
            public Render<? super EntityPlayerGreeting> createRenderFor(RenderManager manager) {
                return new RenderPlayerGreeting(manager);
            }
        });

    }
}
