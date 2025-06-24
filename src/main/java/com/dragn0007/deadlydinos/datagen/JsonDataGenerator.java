package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.datagen.biglooter.DDDLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JsonDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), DDDLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new DDDRecipeMaker(packOutput));
        generator.addProvider(event.includeClient(), new DDDBlockstateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new DDDItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new DDDWorldGenerator(packOutput, lookupProvider));
    }
}
