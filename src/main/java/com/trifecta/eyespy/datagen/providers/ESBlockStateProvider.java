package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.EyeSpy;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ESBlockStateProvider extends BlockStateProvider {

    public ESBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EyeSpy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {//TODO Automate
    }

    protected void farmland(FarmBlock farmBlock) {
        ModelFile normalModel = models().getExistingFile(blockTexture(farmBlock));
        ModelFile moistModel = models().getExistingFile(EyeSpy.prefix(blockTexture(farmBlock).getPath() + "_moist"));

        getVariantBuilder(farmBlock).forAllStatesExcept(targetState -> ConfiguredModel.builder().modelFile(targetState.getValue(FarmBlock.MOISTURE) == 7 ? moistModel : normalModel).build());
    }

    protected void topBlock(Block targetBlock) {
        simpleBlock(targetBlock, new ConfiguredModel(models().cubeTop(ForgeRegistries.BLOCKS.getKey(targetBlock).getPath(), EyeSpy.prefix("block/" + ForgeRegistries.BLOCKS.getKey(targetBlock).getPath() + "_side"), EyeSpy.prefix("block/" + ForgeRegistries.BLOCKS.getKey(targetBlock).getPath() + "_top"))));
    }
}
