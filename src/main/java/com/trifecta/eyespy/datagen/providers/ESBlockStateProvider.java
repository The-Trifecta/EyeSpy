package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.EyeSpy;
import com.trifecta.eyespy.common.registry.ESBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ESBlockStateProvider extends BlockStateProvider {

    public ESBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EyeSpy.MODID, exFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return EyeSpy.MOD_NAME.concat(": BlockState Provider");
    }

    @Override
    protected void registerStatesAndModels() {//TODO Automate
        simpleBlock(ESBlocks.SHARDED_PLATFORM_BLOCK.get());
        simpleBlock(ESBlocks.VOX_BRICKS.get());
        simpleBlock(ESBlocks.VOX_RACK.get());
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

