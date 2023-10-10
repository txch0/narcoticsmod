package com.txch.narcotics.datagen;

import com.txch.narcotics.Narcotics;
import com.txch.narcotics.block.ModBlocks;
import com.txch.narcotics.block.custom.CocaCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Narcotics.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeCocaCrop((CropBlock)ModBlocks.COCA_CROP.get(), "coca_crop", "coca_crop");
        blockWithItem(ModBlocks.FILLER);
    }

    public void makeCocaCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cocaState(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] cocaState(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((CocaCropBlock) block).getAgeProperty()),
                new ResourceLocation(Narcotics.MODID, "block/" + textureName + state.getValue(((CocaCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
