package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.common.registry.ESBlocks;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.stream.Collectors;

public class ESBlockLootTableProvider extends BlockLootSubProvider {

    public ESBlockLootTableProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() { //TODO Automate
        dropSelf(ESBlocks.SHARDED_PLATFORM_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ESBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toCollection(ObjectArrayList::new));
    }
}
