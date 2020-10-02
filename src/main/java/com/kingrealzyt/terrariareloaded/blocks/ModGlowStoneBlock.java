package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModGlowStoneBlock extends Block {

    public ModGlowStoneBlock() {
        super(Properties.create(Material.ROCK)
            .hardnessAndResistance(1.0F, 1.0F)
            .sound(SoundType.STONE)
            .harvestLevel(3)
            .lightValue(13)
            .harvestTool(ToolType.PICKAXE));
    }

}
