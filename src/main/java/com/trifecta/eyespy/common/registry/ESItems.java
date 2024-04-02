package com.trifecta.eyespy.common.registry;

import com.trifecta.eyespy.EyeSpy;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ESItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EyeSpy.MODID);

    public static final RegistryObject<Item> VOX_EYE = ITEMS.register("vox_eye", () -> new Item(new Item.Properties()));
}
