package com.terencechill.tutorialmod.blocks;

import com.terencechill.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FirstBlock extends Block {
    public FirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(TutorialMod.MODID + ".firstblock");     // Used for localization (en_US.lang)
        setRegistryName("firstblock");        // The unique name (within your mod) that identifies this block
    }
}