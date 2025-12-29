package com.dragn0007.deadlydinos.items;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.items.custom.*;
import com.dragn0007.deadlydinos.items.eggs.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadlyDinos.MODID);

    public static final RegistryObject<Item> ACROCANTHOSAURUS_SPAWN_EGG = ITEMS.register("acrocanthosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ACROCANTHOSAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_ACROCANTHOSAURUS_EGG = ITEMS.register("fertilized_acrocanthosaurus_egg",
            () -> new FertilizedAcrocanthosaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> ACROCANTHOSAURUS_EGG = ITEMS.register("acrocanthosaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));
    public static final RegistryObject<Item> ANOMALY_ACROCANTHOSAURUS_SPAWN_EGG = ITEMS.register("anomaly_acrocanthosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CERATOSAURUS_SPAWN_EGG = ITEMS.register("ceratosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CERATOSAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_CERATOSAURUS_EGG = ITEMS.register("fertilized_ceratosaurus_egg",
            () -> new FertilizedCeratosaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> CERATOSAURUS_EGG = ITEMS.register("ceratosaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> EOCARCHARIA_SPAWN_EGG = ITEMS.register("eocarcharia_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.EOCARCHARIA, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_EOCARCHARIA_EGG = ITEMS.register("fertilized_eocarcharia_egg",
            () -> new FertilizedEocarchariaEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> EOCARCHARIA_EGG = ITEMS.register("eocarcharia_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> MEGARAPTOR_SPAWN_EGG = ITEMS.register("megaraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MEGARAPTOR, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_MEGARAPTOR_EGG = ITEMS.register("fertilized_megaraptor_egg",
            () -> new FertilizedMegaraptorEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> MEGARAPTOR_EGG = ITEMS.register("megaraptor_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> MEI_LONG_SPAWN_EGG = ITEMS.register("mei_long_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MEI_LONG, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_MEI_LONG_EGG = ITEMS.register("fertilized_mei_long_egg",
            () -> new FertilizedMeiLongEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> MEI_LONG_EGG = ITEMS.register("mei_long_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> OVIRAPTOR_SPAWN_EGG = ITEMS.register("oviraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.OVIRAPTOR, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_OVIRAPTOR_EGG = ITEMS.register("fertilized_oviraptor_egg",
            () -> new FertilizedOviraptorEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> OVIRAPTOR_EGG = ITEMS.register("oviraptor_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> TARBOSAURUS_SPAWN_EGG = ITEMS.register("tarbosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.TARBOSAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_TARBOSAURUS_EGG = ITEMS.register("fertilized_tarbosaurus_egg",
            () -> new FertilizedTarbosaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> TARBOSAURUS_EGG = ITEMS.register("tarbosaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> UTAHRAPTOR_SPAWN_EGG = ITEMS.register("utahraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.UTAHRAPTOR, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_UTAHRAPTOR_EGG = ITEMS.register("fertilized_utahraptor_egg",
            () -> new FertilizedUtahraptorEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> UTAHRAPTOR_EGG = ITEMS.register("utahraptor_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> VELOCIRAPTOR_SPAWN_EGG = ITEMS.register("velociraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.VELOCIRAPTOR, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_VELOCIRAPTOR_EGG = ITEMS.register("fertilized_velociraptor_egg",
            () -> new FertilizedVelociraptorEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> VELOCIRAPTOR_EGG = ITEMS.register("velociraptor_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> YUTYRANNUS_SPAWN_EGG = ITEMS.register("yutyrannus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.YUTYRANNUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_YUTYRANNUS_EGG = ITEMS.register("fertilized_yutyrannus_egg",
            () -> new FertilizedYutyrannusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> YUTYRANNUS_EGG = ITEMS.register("yutyrannus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));


    public static final RegistryObject<Item> AMARGASAURUS_SPAWN_EGG = ITEMS.register("amargasaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.AMARGASAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_AMARGASAURUS_EGG = ITEMS.register("fertilized_amargasaurus_egg",
            () -> new FertilizedAmargasaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> AMARGASAURUS_EGG = ITEMS.register("amargasaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> DIPLODOCUS_SPAWN_EGG = ITEMS.register("diplodocus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.DIPLODOCUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_DIPLODOCUS_EGG = ITEMS.register("fertilized_diplodocus_egg",
            () -> new FertilizedDiplodocusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> DIPLODOCUS_EGG = ITEMS.register("diplodocus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> GRYPOSAURUS_SPAWN_EGG = ITEMS.register("gryposaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.GRYPOSAURUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_GRYPOSAURUS_EGG = ITEMS.register("fertilized_gryposaurus_egg",
            () -> new FertilizedGryposaurusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> GRYPOSAURUS_EGG = ITEMS.register("gryposaurus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> OLOROTITAN_SPAWN_EGG = ITEMS.register("olorotitan_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.OLOROTITAN, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_OLOROTITAN_EGG = ITEMS.register("fertilized_olorotitan_egg",
            () -> new FertilizedOlorotitanEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> OLOROTITAN_EGG = ITEMS.register("olorotitan_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> PARASAUROLOPHUS_SPAWN_EGG = ITEMS.register("parasaurolophus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.PARASAUROLOPHUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_PARASAUROLOPHUS_EGG = ITEMS.register("fertilized_parasaurolophus_egg",
            () -> new FertilizedParasaurolophusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> PARASAUROLOPHUS_EGG = ITEMS.register("parasaurolophus_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> TRICERATOPS_SPAWN_EGG = ITEMS.register("triceratops_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.TRICERATOPS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_TRICERATOPS_EGG = ITEMS.register("fertilized_triceratops_egg",
            () -> new FertilizedTriceratopsEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> TRICERATOPS_EGG = ITEMS.register("triceratops_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));


    public static final RegistryObject<Item> GIANT_CROP_SNAIL_SPAWN_EGG = ITEMS.register("giant_crop_snail_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CROP_SNAIL, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_GIANT_CROP_SNAIL_EGG = ITEMS.register("fertilized_giant_crop_snail_egg",
            () -> new FertilizedCropSnailEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> GIANT_CROP_SNAIL_EGG = ITEMS.register("giant_crop_snail_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> EUPHOBERIA_SPAWN_EGG = ITEMS.register("euphoberia_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.EUPHOBERIA, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_EUPHOBERIA_EGG = ITEMS.register("fertilized_euphoberia_egg",
            () -> new FertilizedEuphoberiaEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> EUPHOBERIA_EGG = ITEMS.register("euphoberia_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));

    public static final RegistryObject<Item> MEGANEURA_SPAWN_EGG = ITEMS.register("meganeura_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MEGANEURA, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_MEGANEURA_EGG = ITEMS.register("fertilized_meganeura_egg",
            () -> new FertilizedMeganeuraEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> MEGANEURA_EGG = ITEMS.register("meganeura_egg",
            () -> new Item((new Item.Properties()).stacksTo(64)));


    public static final RegistryObject<Item> ANUROGNATHUS_SPAWN_EGG = ITEMS.register("anurognathus_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANUROGNATHUS, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FERTILIZED_ANUROGNATHUS_EGG = ITEMS.register("fertilized_anurognathus_egg",
            () -> new FertilizedAnurognathusEggItem((new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> ANUROGNATHUS_EGG = ITEMS.register("anurognathus_egg",
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
    public static final RegistryObject<Item> DINO_NUGGET_1 = ITEMS.register("dino_nugget_1",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> DINO_NUGGET_2 = ITEMS.register("dino_nugget_2",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> DINO_NUGGET_3 = ITEMS.register("dino_nugget_3",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build())));
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

    public static final RegistryObject<Item> ESCARGOT = ITEMS.register("escargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 250, 4) ,0.75F).build())));
    public static final RegistryObject<Item> COOKED_ESCARGOT = ITEMS.register("cooked_escargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(1).meat().build())));
    public static final RegistryObject<Item> LIBANOCULEX = ITEMS.register("libanoculex",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> MEGANEURA = ITEMS.register("meganeura",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> EUPHOBERIA = ITEMS.register("euphoberia",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));

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


    //TACK
    public static final RegistryObject<Item> EOCARCHARIA_ARMOR = ITEMS.register("eocarcharia_armor",
            () -> new DinosaurArmorItem(12, "iron_eocarcharia", (new Item.Properties()).stacksTo(1)));


    //TROPHIES
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
    public static final RegistryObject<Item> CERATOSAURUS_TROPHY = ITEMS.register("ceratosaurus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false)
            ));
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
    public static final RegistryObject<Item> EOCARCHARIA_TROPHY = ITEMS.register("eocarcharia_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2, true, false)
            ));
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
    public static final RegistryObject<Item> MEGARAPTOR_TROPHY = ITEMS.register("megaraptor_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.INVISIBILITY, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 2880, 3, true, false)
            ));
    public static final RegistryObject<Item> MEI_LONG_TROPHY = ITEMS.register("mei_long_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false)
            ));
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
public static final RegistryObject<Item> OVIRAPTOR_TROPHY = ITEMS.register("oviraptor_trophy",
        () -> new TrophyItem(
                new MobEffectInstance(MobEffects.LUCK, 2880, 2,true, false)
        ));

    public static final RegistryObject<Item> TARBOSAURUS_TROPHY = ITEMS.register("tarbosaurus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
            ));

    public static final RegistryObject<Item> UTAHRAPTOR_TROPHY = ITEMS.register("utahraptor_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
            ));

    public static final RegistryObject<Item> VELOCIRAPTOR_TROPHY = ITEMS.register("velociraptor_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
            ));

    public static final RegistryObject<Item> YUTYRANNUS_TROPHY = ITEMS.register("yutyrannus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));

    public static final RegistryObject<Item> AMARGASAURUS_TROPHY = ITEMS.register("amargasaurus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
            ));
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
public static final RegistryObject<Item> DIPLODOCUS_TROPHY = ITEMS.register("diplodocus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
            ));
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
    public static final RegistryObject<Item> GRYPOSAURUS_TROPHY = ITEMS.register("gryposaurus_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.HEAL, 2880, 3, true, false)
            ));
public static final RegistryObject<Item> OLOROTITAN_TROPHY = ITEMS.register("olorotitan_trophy",
        () -> new TrophyItem(
                new MobEffectInstance(MobEffects.SATURATION, 2880, 2,true, false),
                new MobEffectInstance(MobEffects.LUCK, 2880, 3, true, false)
        ));
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
    public static final RegistryObject<Item> TRICERATOPS_TROPHY = ITEMS.register("triceratops_trophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
            ));
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

    //MEDICAL
    public static final RegistryObject<Item> GAUZE_WRAP = ITEMS.register("gauze_wrap",
            () -> new GauzeItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BUG_BITE_CREAM = ITEMS.register("bug_bite_cream",
            () -> new BugBiteCreamItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BIRD_FLU_SHOT = ITEMS.register("bird_flu_shot",
            () -> new BirdFluShotItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PARASITIC_ANTIBIOTIC = ITEMS.register("parasitic_antibiotic",
            () -> new ParasiticAntibioticItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BACTERIAL_ANTIBIOTIC = ITEMS.register("bacterial_antibiotic",
            () -> new BacterialAntibioticItem(new Item.Properties().stacksTo(16)));


    //EQUIPMENT
    public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword",
            () -> new SwordItem(DDDToolTiers.BONE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_PICKAXE = ITEMS.register("bone_pickaxe",
            () -> new PickaxeItem(DDDToolTiers.BONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_SHOVEL = ITEMS.register("bone_shovel",
            () -> new ShovelItem(DDDToolTiers.BONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_AXE = ITEMS.register("bone_axe",
            () -> new AxeItem(DDDToolTiers.BONE, 6, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_HOE = ITEMS.register("bone_hoe",
            () -> new HoeItem(DDDToolTiers.BONE, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_DAGGER = ITEMS.register("bone_dagger",
            () -> new SwordItem(DDDToolTiers.BONE, 1, -1.4F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_GREATSWORD = ITEMS.register("bone_greatsword",
            () -> new SwordItem(DDDToolTiers.BONE, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_BATTLEAXE = ITEMS.register("bone_battleaxe",
            () -> new AxeItem(DDDToolTiers.BONE, 7, -3.3F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_WARHAMMER = ITEMS.register("bone_warhammer",
            () -> new SwordItem(DDDToolTiers.BONE, 9, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> RIOT_HELMET = ITEMS.register("riot_helmet",
            () -> new ArmorItem(DDDArmorMaterials.RIOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RIOT_CHESTPLATE = ITEMS.register("riot_chestplate",
            () -> new ArmorItem(DDDArmorMaterials.RIOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RIOT_LEGGINGS = ITEMS.register("riot_leggings",
            () -> new ArmorItem(DDDArmorMaterials.RIOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RIOT_BOOTS = ITEMS.register("riot_boots",
            () -> new ArmorItem(DDDArmorMaterials.RIOT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ANOMALY_BONE_SWORD = ITEMS.register("anomaly_bone_sword",
            () -> new SwordItem(DDDToolTiers.ANOMALY_BONE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_PICKAXE = ITEMS.register("anomaly_bone_pickaxe",
            () -> new PickaxeItem(DDDToolTiers.ANOMALY_BONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_SHOVEL = ITEMS.register("anomaly_bone_shovel",
            () -> new ShovelItem(DDDToolTiers.ANOMALY_BONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_AXE = ITEMS.register("anomaly_bone_axe",
            () -> new AxeItem(DDDToolTiers.ANOMALY_BONE, 6, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_HOE = ITEMS.register("anomaly_bone_hoe",
            () -> new HoeItem(DDDToolTiers.ANOMALY_BONE, -2, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_DAGGER = ITEMS.register("anomaly_bone_dagger",
            () -> new SwordItem(DDDToolTiers.ANOMALY_BONE, 1, -1.4F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_GREATSWORD = ITEMS.register("anomaly_bone_greatsword",
            () -> new SwordItem(DDDToolTiers.ANOMALY_BONE, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_BATTLEAXE = ITEMS.register("anomaly_bone_battleaxe",
            () -> new AxeItem(DDDToolTiers.ANOMALY_BONE, 7, -3.3F, new Item.Properties()));
    public static final RegistryObject<Item> ANOMALY_BONE_WARHAMMER = ITEMS.register("anomaly_bone_warhammer",
            () -> new SwordItem(DDDToolTiers.ANOMALY_BONE, 9, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> HUNTING_KNIFE = ITEMS.register("hunting_knife",
            () -> new SwordItem(Tiers.IRON, 1, -1.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> TACTICAL_KNIFE = ITEMS.register("tactical_knife",
            () -> new SwordItem(Tiers.IRON, 2, -1.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> CROWBAR = ITEMS.register("crowbar",
            () -> new SwordItem(Tiers.IRON, 2, -2.4F,
                    new Item.Properties()));

//    public static final RegistryObject<Item> BONE_NETHERITE_HELMET = ITEMS.register("bone_netherite_helmet",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.HEAD,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_NETHERITE_CHESTPLATE = ITEMS.register("bone_netherite_chestplate",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.CHEST,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_NETHERITE_LEGGINGS = ITEMS.register("bone_netherite_leggings",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.LEGS,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_NETHERITE_BOOTS = ITEMS.register("bone_netherite_boots",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_NETHERITE, EquipmentSlot.FEET,
//                    new Item.Properties()));

//    public static final RegistryObject<Item> BONE_DIAMOND_HELMET = ITEMS.register("bone_diamond_helmet",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.HEAD,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_DIAMOND_CHESTPLATE = ITEMS.register("bone_diamond_chestplate",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.CHEST,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_DIAMOND_LEGGINGS = ITEMS.register("bone_diamond_leggings",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.LEGS,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_DIAMOND_BOOTS = ITEMS.register("bone_diamond_boots",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_DIAMOND, EquipmentSlot.FEET,
//                    new Item.Properties()));

//    public static final RegistryObject<Item> BONE_GOLD_HELMET = ITEMS.register("bone_gold_helmet",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.HEAD,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_GOLD_CHESTPLATE = ITEMS.register("bone_gold_chestplate",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.CHEST,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_GOLD_LEGGINGS = ITEMS.register("bone_gold_leggings",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.LEGS,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_GOLD_BOOTS = ITEMS.register("bone_gold_boots",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_GOLD, EquipmentSlot.FEET,
//                    new Item.Properties()));

//    public static final RegistryObject<Item> BONE_IRON_HELMET = ITEMS.register("bone_iron_helmet",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.HEAD,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_IRON_CHESTPLATE = ITEMS.register("bone_iron_chestplate",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.CHEST,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_IRON_LEGGINGS = ITEMS.register("bone_iron_leggings",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.LEGS,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> BONE_IRON_BOOTS = ITEMS.register("bone_iron_boots",
//            () -> new ArmorItem(DDDArmorMaterial.BONE_IRON, EquipmentSlot.FEET,
//                    new Item.Properties()));

//    public static final RegistryObject<Item> DUNKLEOSTEUS_HELMET = ITEMS.register("dunkleo_helmet",
//            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.HEAD,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> DUNKLEOSTEUS_CHESTPLATE = ITEMS.register("dunkleo_chestplate",
//            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.CHEST,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> DUNKLEOSTEUS_LEGGINGS = ITEMS.register("dunkleo_leggings",
//            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.LEGS,
//                    new Item.Properties()));
//    public static final RegistryObject<Item> DUNKLEOSTEUS_BOOTS = ITEMS.register("dunkleo_boots",
//            () -> new DunkleoArmorItem(DDDArmorMaterial.DUNKLEOSTEUS, EquipmentSlot.FEET,
//                    new Item.Properties()));


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
    public static final RegistryObject<Item> BLEEDING = ITEMS.register("bleeding",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}