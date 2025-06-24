package com.dragn0007.deadlydinos.items;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class DDDToolTiers {

    public static final Tier BONE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 600, 7.0F, 4.5F, 10,
                    DDDTags.Blocks.NEEDS_BONE_TOOL, () -> Ingredient.of(DDDTags.Items.BONES)),
            new ResourceLocation(DeadlyDinos.MODID, "bone"), List.of(Tiers.IRON), List.of());

}