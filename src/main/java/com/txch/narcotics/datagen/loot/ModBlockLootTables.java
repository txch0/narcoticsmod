package com.txch.narcotics.datagen.loot;

import com.txch.narcotics.block.ModBlocks;
import com.txch.narcotics.block.custom.CocaCropBlock;
import com.txch.narcotics.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Coca Leaves
        LootItemCondition.Builder coca_lootitemconditionbuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COCA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CocaCropBlock.AGE, 5));
        this.add(ModBlocks.COCA_CROP.get(), createCropDrops(ModBlocks.COCA_CROP.get(), ModItems.COCA_LEAF.get(), ModItems.COCA_SEEDS.get(), coca_lootitemconditionbuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
