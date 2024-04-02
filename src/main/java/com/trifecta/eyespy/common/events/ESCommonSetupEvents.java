package com.trifecta.eyespy.common.events;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ESCommonSetupEvents {

    public static class ModEvents {
        @SubscribeEvent
        public static void onFMLCommonSetupEvent(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void onGatherDataEvent(GatherDataEvent event) {

        }
    }

    public static class ForgeEvents {

    }
}
