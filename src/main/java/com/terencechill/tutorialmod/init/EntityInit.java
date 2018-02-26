package com.terencechill.tutorialmod.init;

import com.terencechill.tutorialmod.TutorialMod;
import com.terencechill.tutorialmod.entities.EntityCentaur;
import com.terencechill.tutorialmod.entities.EntityMammoth;
import com.terencechill.tutorialmod.entities.EntityPlayerGreeting;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by Raphi on 11.02.2018.
 */
public class EntityInit {

    public static void registerEntities(){
        registerEntity("centaur", EntityCentaur.class, TutorialMod.ID_ENTITY_CENTAUR, 50, 11437146, 000000);
        registerEntity("mammoth", EntityMammoth.class, TutorialMod.ID_ENTITY_MAMMOTH, 50, 11437146, 000000);
        registerEntity("greeting", EntityPlayerGreeting.class, TutorialMod.ID_ENTITY_PLAYERGREETING, 50, 11437146, 000000);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int eggcolor1, int eggcolor2){
        EntityRegistry.registerModEntity(new ResourceLocation(TutorialMod.MODID + ":" + name), entity, name, id, TutorialMod.instance, range, 1, true, eggcolor1, eggcolor2);
    }

}
