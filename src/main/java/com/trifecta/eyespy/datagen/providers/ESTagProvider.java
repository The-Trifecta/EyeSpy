package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.EyeSpy;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ESTagProvider {
    public static class BlockTagProvider extends BlockTagsProvider {

        public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, EyeSpy.MODID, existingFileHelper);
        }

        @Override
        public String getName() {
            return EyeSpy.MOD_NAME.concat(": Block Tags");
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
        }
    }

    public static class ItemTagProvider extends ItemTagsProvider {

        public ItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(pOutput, pLookupProvider, pBlockTags, EyeSpy.MODID, existingFileHelper);
        }

        @Override
        public String getName() {
            return EyeSpy.MOD_NAME.concat(": Item Tags");
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
        }
    }

    public static class EntityTypeTagProvider extends EntityTypeTagsProvider {

        public EntityTypeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(pOutput, pLookupProvider, EyeSpy.MODID, existingFileHelper);
        }

        @Override
        public String getName() {
            return EyeSpy.MOD_NAME.concat(": EntityType Tags");
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
        }
    }

}
