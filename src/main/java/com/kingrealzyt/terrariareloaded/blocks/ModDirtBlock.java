package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModDirtBlock extends Block {

    public ModDirtBlock() {
        super(Properties.create(Material.EARTH)
            .hardnessAndResistance(1.0F, 1.0F)
            .sound(SoundType.GROUND)
            .harvestLevel(0)
            .harvestTool(ToolType.SHOVEL));
    }

}
