package com.txch.narcotics.villager;

import com.google.common.collect.ImmutableSet;
import com.txch.narcotics.Narcotics;
import com.txch.narcotics.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Narcotics.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Narcotics.MODID);

    public static final RegistryObject<PoiType> DEALER_POI = POI_TYPES.register("dealer_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FILLER.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> DEALER_PROFESSION = VILLAGER_PROFESSIONS.register("dealer_prof", () -> new VillagerProfession("dealer_prof",
            holder -> holder.get() == DEALER_POI.get(), holder -> holder.get() == DEALER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
