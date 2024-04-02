package com.trifecta.eyespy;

import com.mojang.logging.LogUtils;
import com.trifecta.eyespy.manager.ESModManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.Locale;

@Mod(EyeSpy.MODID)
public class EyeSpy {
    public static final String MODID = "eyespy";
    public static final String MOD_NAME = "Eye Spy";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static EyeSpy INSTANCE;

    public EyeSpy() {
        INSTANCE = this;

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        if (modBus != null && forgeBus != null) ESModManager.registerAll(modBus, forgeBus);
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(MODID, path.toLowerCase(Locale.ROOT));
    }

    @Nullable
    public static EyeSpy getInstance() {
        return INSTANCE;
    }

    public static boolean isLoaded() {
        return INSTANCE != null;
    }
}