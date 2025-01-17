package com.trifecta.eyespy.manager;

import com.trifecta.eyespy.common.events.ESCommonMiscEvents;
import com.trifecta.eyespy.common.events.ESCommonSetupEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;

public final class ESEventManager {

    static void registerEvents(IEventBus modBus, IEventBus forgeBus) {
        registerCommonEvents(modBus, forgeBus);
        registerClientEvents(modBus, forgeBus);
        registerServerEvents(modBus, forgeBus);
    }

    private static void registerClientEvents(IEventBus modBus, IEventBus forgeBus) {
        if (FMLEnvironment.dist.isClient()) {
            modBus.register(ESCommonSetupEvents.ModEvents.class);

            forgeBus.register(ESCommonMiscEvents.class);
        }
    }

    private static void registerCommonEvents(IEventBus modBus, IEventBus forgeBus) {
        modBus.addListener(ESNetworkManager::registerPackets);
        modBus.register(ESCommonSetupEvents.ModEvents.class);

        forgeBus.register(ESCommonMiscEvents.class);
        forgeBus.register(ESCommonSetupEvents.ForgeEvents.class);
    }

    private static void registerServerEvents(IEventBus modBus, IEventBus forgeBus) {
        if (FMLEnvironment.dist.isDedicatedServer()) {

        }
    }
}
