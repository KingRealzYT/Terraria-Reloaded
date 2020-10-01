package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ModLeavesBlock extends Block {

    public ModLeavesBlock() {
        super(Properties.create(Material.ORGANIC)
            .hardnessAndResistance(0.5F, 1.0F)
            .sound(SoundType.PLANT)
                .variableOpacity()
                .notSolid()
            .harvestLevel(0)
            .harvestTool(ToolType.AXE));
    }

}
