package com.dragn0007.deadlydinos.items;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.items.custom.SodaItem;
import com.dragn0007.deadlydinos.items.custom.TrophyItem;
import com.dragn0007.deadlydinos.items.eggs.FertilizedAcrocanthosaurusEggItem;
import com.dragn0007.deadlydinos.items.eggs.FertilizedParasaurolophusEggItem;
import com.dragn0007.deadlydinos.items.eggs.FertilizedUtahraptorEggItem;
import com.dragn0007.deadlydinos.items.eggs.FertilizedYutyrannusEggItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadlyDinos.MODID);

    public static final RegistryObject<Item> ACROCANTHOSAURUS_SPAWN_EGG = ITEMS.register("acrocanthosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ACROCANTHOSAURUS_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_ACROCANTHOSAURUS_EGG = ITEMS.register("fertilized_acrocanthosaurus_egg",
            () -> new FertilizedAcrocanthosaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> ACROCANTHOSAURUS_EGG = ITEMS.register("acrocanthosaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_SPAWN_EGG = ITEMS.register("anomaly_acrocanthosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));


    public static final RegistryObject<Item> UTAHRAPTOR_SPAWN_EGG = ITEMS.register("utahraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.UTAHRAPTOR_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_UTAHRAPTOR_EGG = ITEMS.register("fertilized_utahraptor_egg",
            () -> new FertilizedUtahraptorEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> UTAHRAPTOR_EGG = ITEMS.register("utahraptor_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> YUTYRANNUS_SPAWN_EGG = ITEMS.register("yutyrannus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.YUTYRANNUS_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_YUTYRANNUS_EGG = ITEMS.register("fertilized_yutyrannus_egg",
            () -> new FertilizedYutyrannusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> YUTYRANNUS_EGG = ITEMS.register("yutyrannus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> PARASAUROLOPHUS_SPAWN_EGG = ITEMS.register("parasaurolophus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.PARASAUROLOPHUS_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_PARASAUROLOPHUS_EGG = ITEMS.register("fertilized_parasaurolophus_egg",
            () -> new FertilizedParasaurolophusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> PARASAUROLOPHUS_EGG = ITEMS.register("parasaurolophus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));


    //FOOD ITEMS
    public static final RegistryObject<Item> RAW_SMALL_MEAT = ITEMS.register("raw_small_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 250, 4) ,0.75F).build())));
    public static final RegistryObject<Item> COOKED_SMALL_MEAT = ITEMS.register("cooked_small_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> RAW_MEDIUM_MEAT = ITEMS.register("raw_medium_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 5) ,0.85F).build())));
    public static final RegistryObject<Item> COOKED_MEDIUM_MEAT = ITEMS.register("cooked_medium_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> RAW_LARGE_MEAT = ITEMS.register("raw_large_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 5) ,0.85F).build())));
    public static final RegistryObject<Item> COOKED_LARGE_MEAT = ITEMS.register("cooked_large_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> CRACKER = ITEMS.register("cracker",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build())));
    public static final RegistryObject<Item> DINO_SANDWICH = ITEMS.register("dino_sandwich",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(18).saturationMod(1).build())));
    public static final RegistryObject<Item> CANNED_VEGGIES = ITEMS.register("canned_veggies",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build())));
    public static final RegistryObject<Item> CANNED_MEAT = ITEMS.register("canned_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build())));
    public static final RegistryObject<Item> CANNED_STEW = ITEMS.register("canned_stew",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build())));
    public static final RegistryObject<Item> MRE = ITEMS.register("mre",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build())));
    public static final RegistryObject<Item> SODA = ITEMS.register("soda",
        () -> new SodaItem(
                new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 1, true, false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 1, true, false)
        ));
    public static final RegistryObject<Item> TIGER_NUTS = ITEMS.register("tiger_nuts",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build())));
    public static final RegistryObject<Item> YEW_PLUM = ITEMS.register("yew_plum",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(1).build())));
    public static final RegistryObject<Item> TIGER_NUT_BUTTER = ITEMS.register("tiger_nut_butter",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build())));
    public static final RegistryObject<Item> YEW_PLUM_JAM = ITEMS.register("yew_plum_jam",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(1).build())));
    public static final RegistryObject<Item> PBJ = ITEMS.register("pbj",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(14).saturationMod(1).build())));
    public static final RegistryObject<Item> GLAZED_RIBS = ITEMS.register("glazed_ribs",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).build())));
    public static final RegistryObject<Item> RAW_ESCARGOT = ITEMS.register("raw_escargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 250, 4) ,0.75F).build())));
    public static final RegistryObject<Item> COOKED_ESCARGOT = ITEMS.register("cooked_escargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> DINO_NUGGET_1 = ITEMS.register("dino_nugget_1",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> DINO_NUGGET_2 = ITEMS.register("dino_nugget_2",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> DINO_NUGGET_3 = ITEMS.register("dino_nugget_3",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build())));
    public static final RegistryObject<Item> SMOOTHIE = ITEMS.register("smoothie",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build())));
    public static final RegistryObject<Item> DINO_DUMPLING = ITEMS.register("dino_dumpling",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build())));
    public static final RegistryObject<Item> CHICKEN_NOODLE_SOUP = ITEMS.register("chicken_noodle_soup",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build())));
    public static final RegistryObject<Item> DINO_ROAST = ITEMS.register("dino_roast",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(16).saturationMod(1).build())));
    public static final RegistryObject<Item> BONE_MARROW = ITEMS.register("bone_marrow",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> BROTH = ITEMS.register("broth",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build())));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(1).build())));

//    public static final RegistryObject<Item> GAR = ITEMS.register("gar",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build())));
//    public static final RegistryObject<Item> COOKED_GAR = ITEMS.register("cooked_gar",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).meat().build())));
//    public static final RegistryObject<Item> SHARK = ITEMS.register("shark",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0).meat().build())));
//    public static final RegistryObject<Item> COOKED_SHARK = ITEMS.register("cooked_shark",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).meat().build())));
//    public static final RegistryObject<Item> LARGE_FISH = ITEMS.register("large_fish",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build())));
//    public static final RegistryObject<Item> COOKED_LARGE_FISH = ITEMS.register("cooked_large_fish",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).meat().build())));
//    public static final RegistryObject<Item> ARGANODUS = ITEMS.register("arganodus",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build())));
//    public static final RegistryObject<Item> COOKED_ARGANODUS = ITEMS.register("cooked_arganodus",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).meat().build())));
//    public static final RegistryObject<Item> HYNERIA = ITEMS.register("hyneria",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build())));
//    public static final RegistryObject<Item> COOKED_HYNERIA = ITEMS.register("cooked_hyneria",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).meat().build())));
//
//    public static final RegistryObject<Item> BLUBBER = ITEMS.register("blubber",
//            () -> new BlubberItem(new Item.Properties()));
//
//
    //SMALL CARNI BONES
    public static final RegistryObject<Item> SMALL_CARNIVORE_TOOTH = ITEMS.register("small_carnivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_SKULL = ITEMS.register("small_carnivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_RIBS = ITEMS.register("small_carnivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_CLAW = ITEMS.register("small_carnivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_TAIL = ITEMS.register("small_carnivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_RAPTOR_CLAW = ITEMS.register("small_raptor_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_SPINE = ITEMS.register("small_carnivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CARNIVORE_LEG = ITEMS.register("small_carnivore_leg",
            () -> new Item(new Item.Properties()));


    //MEDIUM CARNI BONES
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_TOOTH = ITEMS.register("medium_carnivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_SKULL = ITEMS.register("medium_carnivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_RIBS= ITEMS.register("medium_carnivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_CLAW = ITEMS.register("medium_carnivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_TAIL = ITEMS.register("medium_carnivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_RAPTOR_CLAW = ITEMS.register("medium_raptor_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_SPINE = ITEMS.register("medium_carnivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CARNIVORE_LEG = ITEMS.register("medium_carnivore_leg",
            () -> new Item(new Item.Properties()));


    //LARGE CARNI BONES
    public static final RegistryObject<Item> LARGE_CARNIVORE_TOOTH = ITEMS.register("large_carnivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_SKULL = ITEMS.register("large_carnivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_RIBS= ITEMS.register("large_carnivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_CLAW = ITEMS.register("large_carnivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_TAIL = ITEMS.register("large_carnivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_SPINE = ITEMS.register("large_carnivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CARNIVORE_LEG = ITEMS.register("large_carnivore_leg",
            () -> new Item(new Item.Properties()));


    //SMALL HERBI BONES
    public static final RegistryObject<Item> SMALL_HERBIVORE_TOOTH = ITEMS.register("small_herbivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_SKULL = ITEMS.register("small_herbivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_RIBS = ITEMS.register("small_herbivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_CLAW = ITEMS.register("small_herbivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_TAIL = ITEMS.register("small_herbivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_SPINE = ITEMS.register("small_herbivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_HERBIVORE_LEG = ITEMS.register("small_herbivore_leg",
            () -> new Item(new Item.Properties()));


    //MEDIUM HERBI BONES
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_TOOTH = ITEMS.register("medium_herbivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_SKULL = ITEMS.register("medium_herbivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_RIBS= ITEMS.register("medium_herbivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_CLAW = ITEMS.register("medium_herbivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_TAIL = ITEMS.register("medium_herbivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_SPINE = ITEMS.register("medium_herbivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_HERBIVORE_LEG = ITEMS.register("medium_herbivore_leg",
            () -> new Item(new Item.Properties()));


    //LARGE HERBI BONES
    public static final RegistryObject<Item> LARGE_HERBIVORE_TOOTH = ITEMS.register("large_herbivore_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_SKULL = ITEMS.register("large_herbivore_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_RIBS= ITEMS.register("large_herbivore_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_CLAW = ITEMS.register("large_herbivore_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_TAIL = ITEMS.register("large_herbivore_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_SPINE = ITEMS.register("large_herbivore_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_HERBIVORE_LEG = ITEMS.register("large_herbivore_leg",
            () -> new Item(new Item.Properties()));

    //ANOMALY BONES
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_TOOTH = ITEMS.register("anomaly_acrocanthosaurus_tooth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_SKULL = ITEMS.register("anomaly_acrocanthosaurus_skull",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_RIBS= ITEMS.register("anomaly_acrocanthosaurus_ribs",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_CLAW = ITEMS.register("anomaly_acrocanthosaurus_claw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_TAIL = ITEMS.register("anomaly_acrocanthosaurus_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_SPINE = ITEMS.register("anomaly_acrocanthosaurus_spine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_LEG = ITEMS.register("anomaly_acrocanthosaurus_leg",
            () -> new Item(new Item.Properties()));
//
//
////    //TOOLS
////    public static final RegistryObject<Item> SMALL_BONE_SWORD = ITEMS.register("small_bone_sword",
////            () -> new SwordItem(DDDItemTier.SMALL_BONE, 3, -2f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> SMALL_BONE_PICKAXE = ITEMS.register("small_bone_pickaxe",
////            () -> new PickaxeItem(DDDItemTier.SMALL_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> SMALL_BONE_AXE = ITEMS.register("small_bone_axe",
////            () -> new AxeItem(DDDItemTier.SMALL_BONE, 4, -2.5f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> SMALL_BONE_SHOVEL = ITEMS.register("small_bone_shovel",
////            () -> new ShovelItem(DDDItemTier.SMALL_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> SMALL_BONE_HOE = ITEMS.register("small_bone_hoe",
////            () -> new HoeItem(DDDItemTier.SMALL_BONE, 1, 1f,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> MEDIUM_BONE_SWORD = ITEMS.register("medium_bone_sword",
////            () -> new SwordItem(DDDItemTier.MEDIUM_BONE_, 3, -2f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> MEDIUM_BONE_PICKAXE = ITEMS.register("medium_bone_pickaxe",
////            () -> new PickaxeItem(DDDItemTier.MEDIUM_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> MEDIUM_BONE_AXE = ITEMS.register("medium_bone_axe",
////            () -> new AxeItem(DDDItemTier.MEDIUM_BONE, 4, -2.5f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> MEDIUM_BONE__SHOVEL = ITEMS.register("medium_bone_shovel",
////            () -> new ShovelItem(DDDItemTier.MEDIUM_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> MEDIUM_BONE__HOE = ITEMS.register("medium_bone_hoe",
////            () -> new HoeItem(DDDItemTier.MEDIUM_BONE, 1, 1f,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> LARGE_BONE_SWORD = ITEMS.register("large_bone_sword",
////            () -> new SwordItem(DDDItemTier.LARGE_BONE, 3, -1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> LARGE_BONE_PICKAXE = ITEMS.register("large_bone_pickaxe",
////            () -> new PickaxeItem(DDDItemTier.LARGE_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> LARGE_BONE_AXE = ITEMS.register("large_bone_axe",
////            () -> new AxeItem(DDDItemTier.LARGE_BONE, 4, -2.5f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> LARGE_BONE_SHOVEL = ITEMS.register("large_bone_shovel",
////            () -> new ShovelItem(DDDItemTier.LARGE_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> LARGE_BONE_HOE = ITEMS.register("large_bone_hoe",
////            () -> new HoeItem(DDDItemTier.LARGE_BONE, 1, 1f,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> LARGE_BONE_CLUB = ITEMS.register("large_bone_club",
////            () -> new SwordItem(DDDItemTier.LARGE_BONE, 5, -3f,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> BOWIE_KNIFE = ITEMS.register("bowie_knife",
////            () -> new SwordItem(Tiers.IRON, 2, -1.4F,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> CROWBAR = ITEMS.register("crowbar",
////            () -> new SwordItem(Tiers.IRON, 2, -2.4F,
////                    new Item.Properties()));
////
////
////
////    //ARMOR
////    public static final RegistryObject<Item> BONE_NETHERITE_HELMET = ITEMS.register("bone_netherite_helmet",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.HEAD,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_NETHERITE_CHESTPLATE = ITEMS.register("bone_netherite_chestplate",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.CHEST,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_NETHERITE_LEGGINGS = ITEMS.register("bone_netherite_leggings",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.LEGS,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_NETHERITE_BOOTS = ITEMS.register("bone_netherite_boots",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.FEET,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> BONE_DIAMOND_HELMET = ITEMS.register("bone_diamond_helmet",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.HEAD,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_DIAMOND_CHESTPLATE = ITEMS.register("bone_diamond_chestplate",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.CHEST,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_DIAMOND_LEGGINGS = ITEMS.register("bone_diamond_leggings",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.LEGS,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_DIAMOND_BOOTS = ITEMS.register("bone_diamond_boots",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.FEET,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> BONE_GOLD_HELMET = ITEMS.register("bone_gold_helmet",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.HEAD,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_GOLD_CHESTPLATE = ITEMS.register("bone_gold_chestplate",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.CHEST,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_GOLD_LEGGINGS = ITEMS.register("bone_gold_leggings",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.LEGS,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_GOLD_BOOTS = ITEMS.register("bone_gold_boots",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.FEET,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> BONE_IRON_HELMET = ITEMS.register("bone_iron_helmet",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.HEAD,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_IRON_CHESTPLATE = ITEMS.register("bone_iron_chestplate",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.CHEST,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_IRON_LEGGINGS = ITEMS.register("bone_iron_leggings",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.LEGS,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> BONE_IRON_BOOTS = ITEMS.register("bone_iron_boots",
////            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.FEET,
////                    new Item.Properties()));
////
////
////    public static final RegistryObject<Item> DUNKLEOSTEUS_HELMET = ITEMS.register("dunkleo_helmet",
////            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.HEAD,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> DUNKLEOSTEUS_CHESTPLATE = ITEMS.register("dunkleo_chestplate",
////            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.CHEST,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> DUNKLEOSTEUS_LEGGINGS = ITEMS.register("dunkleo_leggings",
////            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.LEGS,
////                    new Item.Properties()));
////    public static final RegistryObject<Item> DUNKLEOSTEUS_BOOTS = ITEMS.register("dunkleo_boots",
////            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.FEET,
////                    new Item.Properties()));
//
//
//
//
//
//
//    //TODO;
////    public static final RegistryObject<Item> ARCHAEOPTERYX_HARNESS = ITEMS.register("archaeopteryx_harness",
////            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> EOCARCHARIA_ARMOR = ITEMS.register("eocarcharia_armor",
//            () -> new Item(new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> DUNKLEOSTEUS_SKELETON = ITEMS.register("dunkleo_skeleton",
//            () -> new Item(new Item.Properties().stacksTo(1)));
//
//
//    //TROPHIES
    public static final RegistryObject<Item> ACROCANTHOSAURUS_TROPHY = ITEMS.register("acrocanthosaurus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 3,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
            ));

//    public static final RegistryObject<Item> ALBERTOTROPHY = ITEMS.register("albertotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 3,true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 5, true, false)
//            ));
//    public static final RegistryObject<Item> ALLOTROPHY = ITEMS.register("allotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> ANDALTROPHY = ITEMS.register("andaltrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> ARCHAETROPHY = ITEMS.register("archaetrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> ATROCITROPHY = ITEMS.register("atrocitrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> AUSTRALOTROPHY = ITEMS.register("australotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> AUSTROTROPHY = ITEMS.register("austrotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> BARYTROPHY = ITEMS.register("barytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> CARCHARTROPHY = ITEMS.register("carchartrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> CARNOTROPHY = ITEMS.register("carnotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> CERATOTROPHY = ITEMS.register("ceratotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> COMPYTROPHY = ITEMS.register("compytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.SATURATION, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> CRYOTROPHY = ITEMS.register("cryotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> DEINONTROPHY = ITEMS.register("deinontrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> DILOTROPHY = ITEMS.register("dilotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.INVISIBILITY, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.LUCK, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> EOCARCHARTROPHY = ITEMS.register("eocarchartrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> GIGATROPHY = ITEMS.register("gigatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> ICHTHYTROPHY = ITEMS.register("ichthytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> IGUATROPHY = ITEMS.register("iguatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> MAHAKALATROPHY = ITEMS.register("mahakalatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)
//            ));
//    public static final RegistryObject<Item> MAJUNGATROPHY = ITEMS.register("majungatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> MEGARAPTROPHY = ITEMS.register("megaraptrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.INVISIBILITY, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.NIGHT_VISION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> REXTROPHY = ITEMS.register("rextrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5, true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> SPINOTROPHY = ITEMS.register("spinotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> TARBOTROPHY = ITEMS.register("tarbotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 1,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> TROODONTROPHY = ITEMS.register("troodontrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
//            ));
    public static final RegistryObject<Item> UTAHRAPTOR_TROPHY = ITEMS.register("utahraptor_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
            ));

    public static final RegistryObject<Item> YUTYRANNUS_TROPHY = ITEMS.register("yutyrannus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));

//    public static final RegistryObject<Item> AMARGATROPHY = ITEMS.register("amargatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> AMPELOTROPHY = ITEMS.register("ampelotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.HEAL, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> ANKYTROPHY = ITEMS.register("ankytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> AVATROPHY = ITEMS.register("avatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 2880, 2,true, false)
//            ));
//    public static final RegistryObject<Item> DEINOCHTROPHY = ITEMS.register("deinochtrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> EDMONTOTROPHY = ITEMS.register("edmontotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> GALLITROPHY = ITEMS.register("gallitrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.JUMP, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> GRYPOTROPHY = ITEMS.register("grypotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.SATURATION, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.HEAL, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> PACHYRTROPHY = ITEMS.register("pachyrtrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.HEAL, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
//            ));
    public static final RegistryObject<Item> PARASAUROLOPHUS_TROPHY = ITEMS.register("parasaurolophus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
            ));
//    public static final RegistryObject<Item> SAUROTROPHY = ITEMS.register("saurotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false),
//                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> SHANTTROPHY = ITEMS.register("shanttrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> STEGOTROPHY = ITEMS.register("stegotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> THERITROPHY = ITEMS.register("theritrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> TRIKETROPHY = ITEMS.register("triketrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> PACHYTROPHY = ITEMS.register("pachytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
//            ));
//
//
//    public static final RegistryObject<Item> MOSATROPHY = ITEMS.register("mosatrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false),
//                    new MobEffectInstance(MobEffects.CONDUIT_POWER, 2880, 2,true, false)
//            ));
//    public static final RegistryObject<Item> HELITROPHY = ITEMS.register("helitrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false)
//            ));
//    public static final RegistryObject<Item> DUNKLEOTROPHY = ITEMS.register("dunkleotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 2, true, false)
//            ));
//
//    public static final RegistryObject<Item> ICHTHYOTROPHY = ITEMS.register("ichthyotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 2, true, false)
//            ));
//
//    public static final RegistryObject<Item> LEEDTROPHY = ITEMS.register("leedtrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.CONDUIT_POWER, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
//            ));
//
//    public static final RegistryObject<Item> BASILOTROPHY = ITEMS.register("basilotrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.CONDUIT_POWER, 2880, 3, true, false)
//            ));
//
//    public static final RegistryObject<Item> MEGTROPHY = ITEMS.register("megtrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false)
//            ));
//
//    public static final RegistryObject<Item> LIVYTROPHY = ITEMS.register("livytrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false),
//                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
//            ));
//
//    public static final RegistryObject<Item> STETHTROPHY = ITEMS.register("stethtrophy",
//            () -> new TrophyItem(
//                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 2,true, false),
//                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 3, true, false)
//            ));




    //MOD ITEM TABS (UNOBTAINABLE)
    public static final RegistryObject<Item> DDD_ITEMS = ITEMS.register("ddd_items",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDD_ENTITIES = ITEMS.register("ddd_entities",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDD_FOOD = ITEMS.register("ddd_food",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDD_BLOCKS = ITEMS.register("ddd_blocks",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDD = ITEMS.register("ddd",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}