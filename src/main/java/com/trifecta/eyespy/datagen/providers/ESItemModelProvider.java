package com.trifecta.eyespy.datagen.providers;

import com.trifecta.eyespy.EyeSpy;
import com.trifecta.eyespy.common.registry.ESBlocks;
import com.trifecta.eyespy.common.registry.ESItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ESItemModelProvider extends ItemModelProvider {
    private static final ResourceLocation ITEM_GENERATED = new ResourceLocation("item/generated");

    public ESItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EyeSpy.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return EyeSpy.MOD_NAME.concat(": Item Models");
    }

    @Override
    protected void registerModels() {
        registerBlockItemModels();
        registerItemModels();
    }

    private void registerItemModels() {
        final ModelFile parentGenerated = getExistingFile(mcLoc("item/generated"));
        final ModelFile.ExistingModelFile parentHandheld = getExistingFile(mcLoc("item/handheld"));

        ESItems.ITEMS.getEntries().forEach(itemEntry -> {
            String itemRegName = itemEntry.getId().getPath();

            EyeSpy.LOGGER.debug("[Generating Item Model]: " + itemRegName);

            if (itemEntry.getId().getPath().contains("_spawn_egg")) {
                getBuilder(itemEntry.getId().getPath()).parent(parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/spawn_eggs/" + itemRegName.replaceAll("_spawn_egg", ""));
            } else if (itemEntry.getId().getPath().contains("boat")) {
                getBuilder(itemEntry.getId().getPath()).parent(parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/boats/" + itemRegName.replaceAll("_boat", ""));
            } else {
                if (existingFileHelper.exists(getItemResourceLocation(itemRegName), TEXTURE) || existingFileHelper.exists(getItemResourceLocation(itemRegName), MODEL)) getBuilder(itemEntry.getId().getPath()).parent(itemEntry.get().getMaxDamage(ItemStack.EMPTY) > 0 && !(itemEntry.get() instanceof ArmorItem) ? parentHandheld : parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/" + itemRegName);;
            }
        });
    }

    private void registerBlockItemModels() {
        ESBlocks.ITEM_BLOCKS.getEntries().forEach(blockItemRegEntry -> {
            String blockItemRegName = blockItemRegEntry.getId().getPath();
            BlockItem blockItemEntry = (BlockItem) blockItemRegEntry.get();
            Block blockEntry = blockItemEntry.getBlock();

            EyeSpy.LOGGER.debug("[Generating BlockItem Model]: " + blockItemRegName);

            if (blockItemRegName.contains("_wall")) {
                withExistingParent(blockItemRegName, getBlockResourceLocation(blockItemRegName + "_inventory"));
            } else if (blockItemRegName.contains("_trapdoor")) {
                withExistingParent(blockItemRegName, getBlockResourceLocation(blockItemRegName + "_bottom"));
            } else if (blockItemRegName.contains("_door")) {
                singleTextureLayer0(blockItemRegName, ITEM_GENERATED, getItemResourceLocation(blockItemRegName));
            } else if (blockEntry instanceof SaplingBlock || blockEntry instanceof FlowerBlock) {
                singleTextureLayer0(blockItemRegName, ITEM_GENERATED, getBlockResourceLocation(blockItemRegName));
            } else if (blockEntry instanceof FenceBlock || blockEntry instanceof ButtonBlock) {
                withExistingParent(blockItemRegName, getBlockResourceLocation(blockItemRegName + "_inventory"));
            } else {
                if (existingFileHelper.exists(getBlockResourceLocation(blockItemRegName), MODEL) || existingFileHelper.exists(getItemResourceLocation(blockItemRegName), MODEL)) withExistingParent(blockItemRegName, getBlockResourceLocation(blockItemRegName));
            }
        });
    }

    protected static ResourceLocation getBlockResourceLocation(String name) {
        return getResourceLocation("block/" + name);
    }

    protected static ResourceLocation getItemResourceLocation(String name) {
        return getResourceLocation("item/" + name);
    }

    protected static ResourceLocation getResourceLocation(String path) {
        return EyeSpy.prefix(path);
    }

    protected ItemModelBuilder singleTextureLayer0(String name, ResourceLocation parent, ResourceLocation texture) {
        return singleTexture(name, parent, "layer0", texture);
    }
}