package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModFleshBlock extends Block {

    public ModFleshBlock() {
        super(Properties.create(Material.CORAL)
            .hardnessAndResistance(5.0F, 5.0F)
            .sound(SoundType.CORAL)
            .harvestLevel(1)
            .harvestTool(ToolType.PICKAXE));
    }

}
