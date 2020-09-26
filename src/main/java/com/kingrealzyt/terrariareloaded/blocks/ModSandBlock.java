package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModSandBlock extends SandBlock {

    public ModSandBlock(int dust_color) {
        super( dust_color,
                Properties.create(Material.SAND)
            .hardnessAndResistance(1.0F, 1.0F)
            .sound(SoundType.SAND)
            .harvestLevel(0)
            .harvestTool(ToolType.SHOVEL));
    }

}
