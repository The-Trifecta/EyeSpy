package com.trifecta.eyespy;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(EyeSpy.MODID)
public class EyeSpy {
    public static final String MODID = "eyespy";
    public static final String MOD_NAME = "Eye Spy";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EyeSpy() {
    }
}
