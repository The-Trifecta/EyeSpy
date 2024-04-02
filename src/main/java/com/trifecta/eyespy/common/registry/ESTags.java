package com.trifecta.eyespy.common.registry;

import com.trifecta.eyespy.EyeSpy;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.levelgen.structure.Structure;

public class ESTags {
    public static class EntityTypeTags {

        private static TagKey<EntityType<?>> createEntityTag(String tagName) {
            return TagKey.create(Registries.ENTITY_TYPE, EyeSpy.prefix(tagName));
        }
    }

    public static class BlockTags {

        private static TagKey<Block> createBlockTag(String tagName) {
            return TagKey.create(Registries.BLOCK, EyeSpy.prefix(tagName));
        }
    }

    public static class EffectTags {

        private static TagKey<MobEffect> createMobEffectTag(String tagName) {
            return TagKey.create(Registries.MOB_EFFECT, EyeSpy.prefix(tagName));
        }
    }

    public static class ItemTags {

        private static TagKey<Item> createItemTag(String tagName) {
            return TagKey.create(Registries.ITEM, EyeSpy.prefix(tagName));
        }
    }

    public static class BiomeTags {

        private static TagKey<Biome> createBiomeTag(String tagName) {
            return TagKey.create(Registries.BIOME, EyeSpy.prefix(tagName));
        }
    }

    public static class StructureTags {

        private static TagKey<Structure> createBiomeTag(String tagName) {
            return TagKey.create(Registries.STRUCTURE, EyeSpy.prefix(tagName));
        }
    }

    public static class BannerPatternTags {

        private static TagKey<BannerPattern> tag(String tagName) {
            return TagKey.create(Registries.BANNER_PATTERN, EyeSpy.prefix(tagName));
        }
    }

    public static void initialize() {}
}