package com.terencechill.tutorialmod.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

/**
 * Created by Raphi on 13.02.2018.
 */
public class EntityMammoth extends EntityCow {

    public EntityMammoth(World worldIn){
        super(worldIn);
    }

    @Override
    public EntityCow createChild(EntityAgeable ageable)
    {
        return new EntityCentaur(world);
    }
}
