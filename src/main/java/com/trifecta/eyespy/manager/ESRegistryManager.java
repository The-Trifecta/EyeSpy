package com.trifecta.eyespy.manager;

import com.trifecta.eyespy.common.registry.ESBlocks;
import com.trifecta.eyespy.common.registry.ESCreativeModeTabs;
import com.trifecta.eyespy.common.registry.ESItems;
import com.trifecta.eyespy.common.registry.ESTags;
import net.minecraftforge.eventbus.api.IEventBus;

public final class ESRegistryManager {

    static void registerRegistries(IEventBus modBus) {
        ESTags.initialize();

        ESCreativeModeTabs.CREATIVE_MODE_TABS.register(modBus);
        ESBlocks.ITEM_BLOCKS.register(modBus);
        ESBlocks.BLOCKS.register(modBus);
        ESItems.ITEMS.register(modBus);
    }
}
