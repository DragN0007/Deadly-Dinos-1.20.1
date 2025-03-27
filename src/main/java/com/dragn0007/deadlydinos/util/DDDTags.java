package com.dragn0007.deadlydinos.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDDTags {

    public static class Items {

        public static final TagKey<Item> CARNIVORE_EATS = tag("carnivore_eats");
        public static final TagKey<Item> HERBIVORE_EATS = tag("herbivore_eats");

        public static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
        public static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(DeadlyDinos.MODID, name));
        }
    }

    public static class Entity_Types {

        public static final TagKey<EntityType<?>> LARGE_PREDATOR_PREY = forgeTag("large_predator_prey");
        public static final TagKey<EntityType<?>> MEDIUM_PREDATOR_PREY = forgeTag("medium_predator_prey");
        public static final TagKey<EntityType<?>> SMALL_PREDATOR_PREY = forgeTag("small_predator_prey");

        public static final TagKey<EntityType<?>> MEDIUM_DINOS_RUN_FROM = forgeTag("medium_dinos_run_from");
        public static final TagKey<EntityType<?>> SMALL_DINOS_RUN_FROM = forgeTag("small_dinos_run_from");

        public static final TagKey<EntityType<?>> RAPTORS = forgeTag("raptors");
        public static final TagKey<EntityType<?>> LARGE_PREDATORS = forgeTag("large_predators");
        public static final TagKey<EntityType<?>> MEDIUM_PREDATORS = forgeTag("medium_predators");
        public static final TagKey<EntityType<?>> SMALL_PREDATORS = forgeTag("small_predators");
        public static final TagKey<EntityType<?>> PREDATORS = forgeTag("predators");
        public static final TagKey<EntityType<?>> LARGE_HERBIVORES = forgeTag("large_herbivores");
        public static final TagKey<EntityType<?>> MEDIUM_HERBIVORES = forgeTag("medium_herbivores");
        public static final TagKey<EntityType<?>> SMALL_HERBIVORES = forgeTag("small_herbivores");
        public static final TagKey<EntityType<?>> HERBIVORES = forgeTag("herbivores");

        public static TagKey<EntityType<?>> forgeTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> TROODON_SEEKS = forgeTag("troodon_seeks");
        public static final TagKey<Block> LARGE_DINO_DESTROYS = forgeTag("large_dino_destroys");
        public static final TagKey<Block> MEDIUM_DINO_DESTROYS = forgeTag("medium_dino_destroys");
        public static final TagKey<Block> SMALL_DINO_DESTROYS = forgeTag("small_dino_destroys");

        public static TagKey<net.minecraft.world.level.block.Block> forgeTag (String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

}
