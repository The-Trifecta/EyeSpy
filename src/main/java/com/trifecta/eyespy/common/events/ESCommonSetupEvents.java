package com.trifecta.eyespy.common.events;

import com.trifecta.eyespy.datagen.providers.*;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class ESCommonSetupEvents {

    public static class ModEvents {
        @SubscribeEvent
        public static void onFMLCommonSetupEvent(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void onGatherDataEvent(GatherDataEvent event) {
            DataGenerator dataGen = event.getGenerator();
            PackOutput dataGenPackOutput = dataGen.getPackOutput();
            final ExistingFileHelper curFileHelper = event.getExistingFileHelper();
            final CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

            dataGen.addProvider(event.includeClient(), new ESBlockModelProvider(dataGenPackOutput, curFileHelper));
            dataGen.addProvider(event.includeClient(), new ESBlockStateProvider(dataGenPackOutput, curFileHelper));
            dataGen.addProvider(event.includeClient(), new ESItemModelProvider(dataGenPackOutput, curFileHelper));
            dataGen.addProvider(event.includeClient(), new ESLanguageProvider(dataGenPackOutput));

            ESTagProvider.BlockTagProvider blockTagProvider = new ESTagProvider.BlockTagProvider(dataGenPackOutput, lookupProvider, curFileHelper);

            dataGen.addProvider(event.includeServer(), new LootTableProvider(dataGenPackOutput, Collections.emptySet(), ObjectArrayList.of(new LootTableProvider.SubProviderEntry(ESBlockLootTableProvider::new, LootContextParamSets.BLOCK))));
            dataGen.addProvider(event.includeServer(), blockTagProvider);
            dataGen.addProvider(event.includeServer(), new ESTagProvider.ItemTagProvider(dataGenPackOutput, lookupProvider, blockTagProvider.contentsGetter(), curFileHelper));
            dataGen.addProvider(event.includeServer(), new ESTagProvider.EntityTypeTagProvider(dataGenPackOutput, lookupProvider, curFileHelper));
            dataGen.addProvider(event.includeServer(), new ESRecipeProvider(dataGenPackOutput));
        }
    }

    public static class ForgeEvents {

    }
}
