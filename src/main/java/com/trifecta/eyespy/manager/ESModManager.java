package com.trifecta.eyespy.manager;

import net.minecraftforge.eventbus.api.IEventBus;

public final class ESModManager {

    public static void registerAll(IEventBus modBus, IEventBus forgeBus) {
        ESEventManager.registerEvents(modBus, forgeBus);
        ESRegistryManager.registerRegistries(modBus);
    }
}
