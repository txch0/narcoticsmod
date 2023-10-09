package com.txch.narcotics.item;

import com.txch.narcotics.Narcotics;
import com.txch.narcotics.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Narcotics.MODID);

    public static final RegistryObject<Item> BAGGIE = ITEMS.register("baggie", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> COCA_SEEDS  = ITEMS.register("coca_seeds", () -> new ItemNameBlockItem(ModBlocks.COCA_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
