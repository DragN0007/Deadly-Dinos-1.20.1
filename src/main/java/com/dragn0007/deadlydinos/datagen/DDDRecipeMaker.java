package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.items.DDDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class DDDRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public DDDRecipeMaker(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.RAW_SMALL_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_SMALL_MEAT.get(), 0.35F, 100)
                .unlockedBy("has_small_meat", has(DDDItems.RAW_SMALL_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_small_meat_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.RAW_SMALL_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_SMALL_MEAT.get(), 0.35F, 200)
                .unlockedBy("has_small_meat", has(DDDItems.RAW_SMALL_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_small_meat_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.RAW_SMALL_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_SMALL_MEAT.get(), 0.35F, 600)
                .unlockedBy("has_small_meat", has(DDDItems.RAW_SMALL_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_small_meat_campfire_cooking"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.RAW_MEDIUM_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_MEDIUM_MEAT.get(), 0.35F, 100)
                .unlockedBy("has_medium_meat", has(DDDItems.RAW_MEDIUM_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_medium_meat_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.RAW_MEDIUM_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_MEDIUM_MEAT.get(), 0.35F, 200)
                .unlockedBy("has_medium_meat", has(DDDItems.RAW_MEDIUM_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_medium_meat_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.RAW_MEDIUM_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_MEDIUM_MEAT.get(), 0.35F, 600)
                .unlockedBy("has_medium_meat", has(DDDItems.RAW_MEDIUM_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_medium_meat_campfire_cooking"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.RAW_LARGE_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_LARGE_MEAT.get(), 0.35F, 100)
                .unlockedBy("has_large_meat", has(DDDItems.RAW_LARGE_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_large_meat_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.RAW_LARGE_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_LARGE_MEAT.get(), 0.35F, 200)
                .unlockedBy("has_large_meat", has(DDDItems.RAW_LARGE_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_large_meat_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.RAW_LARGE_MEAT.get()), RecipeCategory.MISC, DDDItems.COOKED_LARGE_MEAT.get(), 0.35F, 600)
                .unlockedBy("has_large_meat", has(DDDItems.RAW_LARGE_MEAT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_large_meat_campfire_cooking"));

    }
}