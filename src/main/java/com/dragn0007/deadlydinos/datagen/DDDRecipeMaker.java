package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class DDDRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public DDDRecipeMaker(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.REINFORCED_COBBLESTONE.get())
                .define('A', Items.IRON_NUGGET)
                .define('B', Items.COBBLESTONE)
                .pattern("ABA")
                .unlockedBy("has_iron_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_NUGGET)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.REINFORCED_GLASS.get())
                .define('A', Items.IRON_NUGGET)
                .define('B', Items.GLASS)
                .pattern("ABA")
                .unlockedBy("has_iron_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_NUGGET)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.REINFORCED_STONE_BRICKS.get())
                .define('A', Items.IRON_NUGGET)
                .define('B', Items.STONE_BRICKS)
                .pattern("ABA")
                .unlockedBy("has_iron_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_NUGGET)
                        .build())).save(pFinishedRecipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.EOCARCHARIA_ARMOR.get())
                .define('A', Items.IRON_BLOCK)
                .define('B', Items.IRON_INGOT)
                .define('C', Items.LEATHER)
                .pattern("  B")
                .pattern("BBA")
                .pattern("CCC")
                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_INGOT)
                        .build())).save(pFinishedRecipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_SWORD.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_PICKAXE.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_SHOVEL.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_AXE.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_HOE.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern("AA ")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_DAGGER.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_GREATSWORD.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern("AAA")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_BATTLEAXE.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern("ACA")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.ANOMALY_BONE_WARHAMMER.get())
                .define('A', DDDTags.Items.ANOMALY_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern("AC ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_SWORD.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_PICKAXE.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_SHOVEL.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_AXE.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_HOE.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern("AA ")
                .pattern(" C ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_DAGGER.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_GREATSWORD.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern(" A ")
                .pattern("AAA")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_BATTLEAXE.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern("ACA")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.BONE_WARHAMMER.get())
                .define('A', DDDTags.Items.LARGE_BONES)
                .define('C', Items.STICK)
                .pattern("AAA")
                .pattern("AC ")
                .pattern(" C ")
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK)
                        .build())).save(pFinishedRecipeConsumer);
        


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.RIOT_HELMET.get())
                .define('A', Items.IRON_INGOT)
                .define('B', Items.BLACK_WOOL)
                .pattern("ABA")
                .pattern("B B")
                .unlockedBy("", inventoryTrigger(ItemPredicate.Builder.item()
                        .of()
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.RIOT_CHESTPLATE.get())
                .define('A', Items.IRON_INGOT)
                .define('B', Items.BLACK_WOOL)
                .pattern("A A")
                .pattern("AAA")
                .pattern("BBB")
                .unlockedBy("", inventoryTrigger(ItemPredicate.Builder.item()
                        .of()
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.RIOT_LEGGINGS.get())
                .define('A', Items.IRON_INGOT)
                .define('B', Items.BLACK_WOOL)
                .pattern("ABA")
                .pattern("B B")
                .pattern("A A")
                .unlockedBy("", inventoryTrigger(ItemPredicate.Builder.item()
                        .of()
                        .build())).save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.RIOT_BOOTS.get())
                .define('A', Items.IRON_INGOT)
                .define('B', Items.BLACK_WOOL)
                .pattern("A A")
                .pattern("B B")
                .unlockedBy("", inventoryTrigger(ItemPredicate.Builder.item()
                        .of()
                        .build())).save(pFinishedRecipeConsumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 2)
                .requires(DDDTags.Items.SMALL_BONES)
                .unlockedBy("has_bones", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "bonemeal_small_bones"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 4)
                .requires(DDDTags.Items.MEDIUM_BONES)
                .unlockedBy("has_bones", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "bonemeal_medium_bones"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 6)
                .requires(DDDTags.Items.LARGE_BONES)
                .unlockedBy("has_bones", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "bonemeal_large_bones"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 10)
                .requires(DDDTags.Items.ANOMALY_BONES)
                .unlockedBy("has_bones", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "bonemeal_anomalous_bones"));
        
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

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.RAW_ESCARGOT.get()), RecipeCategory.MISC, DDDItems.COOKED_ESCARGOT.get(), 0.35F, 100)
                .unlockedBy("has_escargot", has(DDDItems.RAW_ESCARGOT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_escargot_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.RAW_ESCARGOT.get()), RecipeCategory.MISC, DDDItems.COOKED_ESCARGOT.get(), 0.35F, 200)
                .unlockedBy("has_escargot", has(DDDItems.RAW_ESCARGOT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_escargot_smelting"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.RAW_ESCARGOT.get()), RecipeCategory.MISC, DDDItems.COOKED_ESCARGOT.get(), 0.35F, 600)
                .unlockedBy("has_escargot", has(DDDItems.RAW_ESCARGOT.get())).save(pFinishedRecipeConsumer, new ResourceLocation(DeadlyDinos.MODID, "cooked_escargot_campfire_cooking"));


//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.WIRE_FENCE_1.get())
//                .define('A', Items.IRON_NUGGET)
//                .define('B', Items.IRON_INGOT)
//                .pattern("BAB")
//                .pattern("BBB")
//                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(Items.IRON_INGOT).build()))
//                .save(pFinishedRecipeConsumer);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.WIRE_FENCE_2.get())
//                .define('A', Items.IRON_NUGGET)
//                .define('B', Items.IRON_INGOT)
//                .pattern("BAB")
//                .pattern("BAB")
//                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(Items.IRON_INGOT).build()))
//                .save(pFinishedRecipeConsumer);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.WIRE_FENCE_3.get())
//                .define('A', Items.IRON_NUGGET)
//                .define('B', Items.IRON_INGOT)
//                .pattern("AAA")
//                .pattern("BAB")
//                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(Items.IRON_INGOT).build()))
//                .save(pFinishedRecipeConsumer);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.WIRE_FENCE_4.get())
//                .define('A', Items.IRON_NUGGET)
//                .pattern("AAA")
//                .pattern("AAA")
//                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(Items.IRON_INGOT).build()))
//                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.DINO_ROAST.get())
                .requires(DDDTags.Items.MEATS)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(ItemTags.LEAVES)
                .requires(DDDItems.BONE_MARROW.get())
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.CHICKEN_NOODLE_SOUP.get())
                .requires(DDDTags.Items.RAW_CHICKEN)
                .requires(DDDItems.BROTH.get())
                .requires(DDDTags.Items.DOUGH)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DOUGH.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.DINO_DUMPLING.get())
                .requires(DDDTags.Items.RAW_DINO_MEATS)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.DOUGH)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DOUGH.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.HEARTY_SALAD.get())
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(ItemTags.LEAVES)
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.DOUGH.get())
                .requires(Items.WHEAT)
                .requires(DDDTags.Items.WATER)
                .unlockedBy("has_wheat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.WHEAT)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.CRACKER.get())
                .requires(DDDTags.Items.WHEAT)
                .requires(DDDTags.Items.WHEAT)
                .unlockedBy("has_wheat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.WHEAT)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DDDItems.BROTH.get())
                .requires(DDDItems.BONE_MARROW.get())
                .unlockedBy("has_bone_marrow", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.BONE_MARROW.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDTags.Items.BONES), RecipeCategory.MISC, DDDItems.BONE_MARROW.get(), 0.35F, 200)
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES).build()))
                .save(pFinishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.DOUGH.get()), RecipeCategory.MISC, Items.BREAD, 0.35F, 200)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.DOUGH).build()))
                .save(pFinishedRecipeConsumer);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDBlocks.DINO_NUGGETS_BOX.get())
//                .define('A', DDDTags.Items.RAW_CHICKEN)
//                .define('B', Items.PAPER)
//                .define('C', Items.BREAD)
//                .pattern("BBB")
//                .pattern("AAA")
//                .pattern("CCC")
//                .unlockedBy("has_chicken", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(DDDTags.Items.RAW_CHICKEN).build()))
//                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.SODA.get())
                .define('A', Items.SUGAR)
                .define('B', Items.IRON_NUGGET)
                .define('C', DDDTags.Items.WATER)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_sugar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.SUGAR).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.MRE.get())
                .define('A', DDDTags.Items.MEATS)
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', DDDItems.CRACKER.get())
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.DINO_SANDWICH.get())
                .define('A', DDDItems.COOKED_MEDIUM_MEAT.get())
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', Items.BREAD)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.CANNED_VEGGIES.get())
                .define('A', DDDTags.Items.VEGETABLES)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AA")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.CANNED_STEW.get())
                .define('A', DDDTags.Items.MEATS)
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DDDItems.CANNED_MEAT.get())
                .define('A', DDDTags.Items.MEATS)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AA")
                .pattern(" B ")
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS).build()))
                .save(pFinishedRecipeConsumer);
    }
}