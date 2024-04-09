package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.EyeSpy;
import com.trifecta.eyespy.common.registry.ESBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ESBlockModelProvider extends BlockModelProvider {

    public ESBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EyeSpy.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return EyeSpy.MOD_NAME.concat(": Block Models");
    }

    @Override
    protected void registerModels() { //TODO Automate
        cubeAll(ESBlocks.SHARDED_PLATFORM_BLOCK.get());
    }

    protected void cubeAll(Block targetBlock) {
        cubeAll(ForgeRegistries.BLOCKS.getKey(targetBlock).getPath(), EyeSpy.prefix("block/" + ForgeRegistries.BLOCKS.getKey(targetBlock).getPath()));
    }

    protected void cubeTop(Block targetBlock) {
        cubeTop(ForgeRegistries.BLOCKS.getKey(targetBlock).getPath(), EyeSpy.prefix("block/" + ForgeRegistries.BLOCKS.getKey(targetBlock).getPath() + "_side"), EyeSpy.prefix("block/" + ForgeRegistries.BLOCKS.getKey(targetBlock).getPath() + "_top"));
    }
}
