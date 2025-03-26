package com.dragn0007.deadlydinos.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

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

        public static TagKey<EntityType<?>> forgeTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", name));
        }
    }

}
