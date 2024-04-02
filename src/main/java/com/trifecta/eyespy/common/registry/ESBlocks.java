package com.trifecta.eyespy.common.registry;

import com.trifecta.eyespy.EyeSpy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ESBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EyeSpy.MODID);
    public static final DeferredRegister<Item> ITEM_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, EyeSpy.MODID);


    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        return registerBlock(name, supplier, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, boolean generateItem) {
        return registerBlock(name, supplier, 64, generateItem);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, int stackSize) {
        return registerBlock(name, supplier, stackSize, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, int stackSize, boolean generateItem) {
        RegistryObject<B> blockToRegister = BLOCKS.register(name, supplier);
        if (generateItem) ITEM_BLOCKS.register(name, () -> new BlockItem(blockToRegister.get(), new Item.Properties().stacksTo(stackSize)));
        return blockToRegister;
    }

    public static <B extends Block> RegistryObject<B> registerRareBlock(String name, Supplier<? extends B> supplier) {
        return registerRareBlock(name, supplier, true);
    }

    public static <B extends Block> RegistryObject<B> registerRareBlock(String name, Supplier<? extends B> supplier, boolean generateItem) {
        RegistryObject<B> blockToRegister = BLOCKS.register(name, supplier);
        if (generateItem) ITEM_BLOCKS.register(name, () -> new BlockItem(blockToRegister.get(), new Item.Properties().rarity(Rarity.RARE)));
        return blockToRegister;
    }

    public static <B extends Block> RegistryObject<B> registerEpicRareBlock(String name, Supplier<? extends B> supplier) {
        return registerEpicRareBlock(name, supplier, true);
    }

    public static <B extends Block> RegistryObject<B> registerEpicRareBlock(String name, Supplier<? extends B> supplier, boolean generateItem) {
        RegistryObject<B> blockToRegister = BLOCKS.register(name, supplier);
        if (generateItem) ITEM_BLOCKS.register(name, () -> new BlockItem(blockToRegister.get(), new Item.Properties().rarity(Rarity.EPIC)));
        return blockToRegister;
    }
}
