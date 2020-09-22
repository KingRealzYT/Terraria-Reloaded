package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CobaltOre extends OreBlock {

    public CobaltOre() {
        super(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(6.0F, 20.0F)
            .sound(SoundType.METAL)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE));
    }
}
