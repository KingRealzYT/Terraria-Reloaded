package com.kingrealzyt.terrariareloaded.data;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ILootFunction;
import net.minecraftforge.fml.RegistryObject;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LootTableDataGenerator extends LootTableProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator generator;
    private final Map<Block, LootTable.Builder> tablemap = new HashMap<>();

    public LootTableDataGenerator(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }

    @Override
    public void act(DirectoryCache cache) {
        System.out.println("Generating Block loot tables");

        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(b -> {
            System.out.println("BLOCK: " + b);
            LootTable.Builder table;
            if (b instanceof ILootTableData) {
                table = tablemap.getOrDefault(b, multipleDrops(b));
            } else {
                table = tablemap.getOrDefault(b, selfDrop(b));
            }
            tablemap.put(b, table);
        });

        Path output = this.generator.getOutputFolder();
        for (Map.Entry<Block, LootTable.Builder> e : this.tablemap.entrySet()) {
            Path path = output.resolve("data/" + TerrariaReloaded.MOD_ID + "/loot_tables/blocks/" + e.getKey().getRegistryName().getPath() + ".json");
            TerrariaReloaded.LOGGER.debug("Generated loot table for block: {}", e.getKey().getRegistryName().getPath());
            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(e.getValue().setParameterSet(LootParameterSets.BLOCK).build()), path);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private Path getPath(Path root, Block block) {
        return root.resolve("data/" + TerrariaReloaded.MOD_ID + "/loot_tables/blocks/" + block.getRegistryName().getPath() + ".json");
    }

    public LootTable.Builder selfDrop(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        LootPool.Builder pool = LootPool.builder().name("selfdrop").rolls(ConstantRange.of(1)).addEntry(entry)
                .acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(pool);
    }

    public LootTable.Builder multipleDrops(Block dataBlock) {
        ILootTableData data = (ILootTableData) dataBlock;
        List<LootEntry.Builder<?>> entries = Lists.newArrayList();
        if (data.getDrops() == null)
            return this.selfDrop(dataBlock);
        data.getDrops().forEach(item -> entries.add(ItemLootEntry.builder(item)));
        if (entries.isEmpty())
            return this.selfDrop(dataBlock);

        List<LootPool.Builder> pools = Lists.newArrayList();
        int i = 0;
        for (LootEntry.Builder<?> entry : entries) {
            LootPool.Builder pool = LootPool.builder().name(dataBlock.getRegistryName().getPath() + i++).rolls(ConstantRange.of(i++));
            pool.addEntry(entry);
            if (data.lootFunctions() != null && !data.lootFunctions().isEmpty())
                for (ILootCondition.IBuilder condition : data.lootConditions())
                    pool.acceptCondition(condition);
            if (data.lootFunctions() != null && !data.lootFunctions().isEmpty())
                for (ILootFunction.IBuilder func : data.lootFunctions())
                    pool.acceptFunction(func);
            pools.add(pool);
        }
        LootTable.Builder table = LootTable.builder();
        pools.forEach(table::addLootPool);//
        return table;
    }


}
