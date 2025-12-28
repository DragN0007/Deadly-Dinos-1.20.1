package com.dragn0007.deadlydinos.entities;

import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly.AnomalyAcrocanthosaurus;
import com.dragn0007.deadlydinos.entities.amargasaurus.Amargasaurus;
import com.dragn0007.deadlydinos.entities.anurognathus.Anurognathus;
import com.dragn0007.deadlydinos.entities.ceratosaurus.Ceratosaurus;
import com.dragn0007.deadlydinos.entities.diplodocus.Diplodocus;
import com.dragn0007.deadlydinos.entities.eocarcharia.Eocarcharia;
import com.dragn0007.deadlydinos.entities.giant_crop_snail.CropSnail;
import com.dragn0007.deadlydinos.entities.gryposaurus.Gryposaurus;
import com.dragn0007.deadlydinos.entities.megaraptor.Megaraptor;
import com.dragn0007.deadlydinos.entities.mei_long.MeiLong;
import com.dragn0007.deadlydinos.entities.olorotitan.Olorotitan;
import com.dragn0007.deadlydinos.entities.oviraptor.Oviraptor;
import com.dragn0007.deadlydinos.entities.parasaurolophus.Parasaurolophus;
import com.dragn0007.deadlydinos.entities.tarbosaurus.Tarbosaurus;
import com.dragn0007.deadlydinos.entities.triceratops.Triceratops;
import com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor;
import com.dragn0007.deadlydinos.entities.velociraptor.Velociraptor;
import com.dragn0007.deadlydinos.entities.yutyrannus.Yutyrannus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dragn0007.deadlydinos.DeadlyDinos.MODID;

public class EntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    //Carnivores
    public static final RegistryObject<EntityType<Acrocanthosaurus>> ACROCANTHOSAURUS = ENTITY_TYPES.register("acrocanthosaurus",
            () -> EntityType.Builder.of(Acrocanthosaurus::new,
                    MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"acrocanthosaurus").toString()));

    public static final RegistryObject<EntityType<AnomalyAcrocanthosaurus>> ANOMALOUS_ACROCANTHOSAURUS = ENTITY_TYPES.register("anomaly_acrocanthosaurus",
            () -> EntityType.Builder.of(AnomalyAcrocanthosaurus::new,
                            MobCategory.CREATURE)
                    .sized(4f,4f)
                    .build(new ResourceLocation(MODID,"anomaly_acrocanthosaurus").toString()));

    public static final RegistryObject<EntityType<Ceratosaurus>> CERATOSAURUS = ENTITY_TYPES.register("ceratosaurus",
            () -> EntityType.Builder.of(Ceratosaurus::new,
                            MobCategory.CREATURE)
                    .sized(2.2f,2.2f)
                    .build(new ResourceLocation(MODID,"ceratosaurus").toString()));

    public static final RegistryObject<EntityType<Eocarcharia>> EOCARCHARIA = ENTITY_TYPES.register("eocarcharia",
            () -> EntityType.Builder.of(Eocarcharia::new,
                            MobCategory.CREATURE)
                    .sized(2.5f,2.5f)
                    .build(new ResourceLocation(MODID,"eocarcharia").toString()));

    public static final RegistryObject<EntityType<Megaraptor>> MEGARAPTOR = ENTITY_TYPES.register("megaraptor",
            () -> EntityType.Builder.of(Megaraptor::new,
                            MobCategory.CREATURE)
                    .sized(1.0f,2.0f)
                    .build(new ResourceLocation(MODID,"megaraptor").toString()));

    public static final RegistryObject<EntityType<MeiLong>> MEI_LONG = ENTITY_TYPES.register("mei_long",
            () -> EntityType.Builder.of(MeiLong::new,
                            MobCategory.CREATURE)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MODID,"mei_long").toString()));

    public static final RegistryObject<EntityType<Oviraptor>> OVIRAPTOR = ENTITY_TYPES.register("oviraptor",
            () -> EntityType.Builder.of(Oviraptor::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"oviraptor").toString()));

    public static final RegistryObject<EntityType<Tarbosaurus>> TARBOSAURUS = ENTITY_TYPES.register("tarbosaurus",
            () -> EntityType.Builder.of(Tarbosaurus::new,
                            MobCategory.CREATURE)
                    .sized(3f,4f)
                    .build(new ResourceLocation(MODID,"tarbosaurus").toString()));

    public static final RegistryObject<EntityType<Utahraptor>> UTAHRAPTOR = ENTITY_TYPES.register("utahraptor",
            () -> EntityType.Builder.of(Utahraptor::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,1.8f)
                    .build(new ResourceLocation(MODID,"utahraptor").toString()));

    public static final RegistryObject<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor",
            () -> EntityType.Builder.of(Velociraptor::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"velociraptor").toString()));

    public static final RegistryObject<EntityType<Yutyrannus>> YUTYRANNUS = ENTITY_TYPES.register("yutyrannus",
            () -> EntityType.Builder.of(Yutyrannus::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"yutyrannus").toString()));


    //Herbivores
    public static final RegistryObject<EntityType<Amargasaurus>> AMARGASAURUS = ENTITY_TYPES.register("amargasaurus",
            () -> EntityType.Builder.of(Amargasaurus::new,
                            MobCategory.CREATURE)
                    .sized(3F,4.5f)
                    .build(new ResourceLocation(MODID,"amargasaurus").toString()));

    public static final RegistryObject<EntityType<Diplodocus>> DIPLODOCUS = ENTITY_TYPES.register("diplodocus",
            () -> EntityType.Builder.of(Diplodocus::new,
                            MobCategory.CREATURE)
                    .sized(3F,4.5f)
                    .build(new ResourceLocation(MODID,"diplodocus").toString()));

    public static final RegistryObject<EntityType<Gryposaurus>> GRYPOSAURUS = ENTITY_TYPES.register("gryposaurus",
            () -> EntityType.Builder.of(Gryposaurus::new,
                            MobCategory.CREATURE)
                    .sized(2f,3.5f)
                    .build(new ResourceLocation(MODID,"gryposaurus").toString()));

    public static final RegistryObject<EntityType<Olorotitan>> OLOROTITAN = ENTITY_TYPES.register("olorotitan",
            () -> EntityType.Builder.of(Olorotitan::new,
                            MobCategory.CREATURE)
                    .sized(2f,3.5f)
                    .build(new ResourceLocation(MODID,"olorotitan").toString()));

    public static final RegistryObject<EntityType<Parasaurolophus>> PARASAUROLOPHUS = ENTITY_TYPES.register("parasaurolophus",
            () -> EntityType.Builder.of(Parasaurolophus::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"parasaurolophus").toString()));

    public static final RegistryObject<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops",
            () -> EntityType.Builder.of(Triceratops::new,
                            MobCategory.CREATURE)
                    .sized(3f,4.5f)
                    .build(new ResourceLocation(MODID,"triceratops").toString()));


    //Insects
    public static final RegistryObject<EntityType<CropSnail>> CROP_SNAIL = ENTITY_TYPES.register("giant_crop_snail",
            () -> EntityType.Builder.of(CropSnail::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"giant_crop_snail").toString()));


    //Other
    public static final RegistryObject<EntityType<Anurognathus>> ANUROGNATHUS = ENTITY_TYPES.register("anurognathus",
            () -> EntityType.Builder.of(Anurognathus::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(MODID,"anurognathus").toString()));
}

