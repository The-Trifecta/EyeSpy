package com.trifecta.eyespy.common.registry;

import com.trifecta.eyespy.EyeSpy;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class ESCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EyeSpy.MODID);

    public static final RegistryObject<CreativeModeTab> EYESPY_ITEMS = CREATIVE_MODE_TABS.register("eyespy_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.es.eyespy_items"))
            .icon(() -> ESItems.VOX_EYE.get().getDefaultInstance())
            .displayItems((displayParams, curOutput) -> curOutput.acceptAll(ESItems.ITEMS.getEntries().stream().map(RegistryObject::get).filter(itemEntry -> !(itemEntry instanceof TieredItem) && !(itemEntry instanceof ArmorItem)).map(Item::getDefaultInstance).collect(Collectors.toCollection(ObjectArrayList::new)), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY))
            .build());

    public static final RegistryObject<CreativeModeTab> EYESPY_BLOCKS = CREATIVE_MODE_TABS.register("eyespy_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.es.eyespy_blocks"))
            .icon(() -> ESBlocks.SHARDED_PLATFORM_BLOCK.get().asItem().getDefaultInstance())
            .displayItems((displayParams, curOutput) -> curOutput.acceptAll(ESBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).map(Block::asItem).map(Item::getDefaultInstance).collect(Collectors.toCollection(ObjectArrayList::new)), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY))
            .build());
}
