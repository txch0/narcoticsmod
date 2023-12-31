package com.txch.narcotics.datagen;

import com.txch.narcotics.Narcotics;
import com.txch.narcotics.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Narcotics.MODID, existingFileHelper);
        System.out.println("Generating item models.");
    }

    @Override
    protected void registerModels() {
        System.out.println("Generating item models.");
        simpleItem(ModItems.BAGGIE);
        simpleItem(ModItems.COCA_SEEDS);
        simpleItem(ModItems.COCA_LEAF);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        System.out.println("Generating item models.");
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Narcotics.MODID, "item/" + item.getId().getPath()));
    }
}
