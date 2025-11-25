package com.dragn0007.deadlydinos.entities;

import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly.AnomalyAcrocanthosaurus;
import com.dragn0007.deadlydinos.entities.megaraptor.Megaraptor;
import com.dragn0007.deadlydinos.entities.parasaurolophus.Parasaurolophus;
import com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor;
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
    public static final RegistryObject<EntityType<Acrocanthosaurus>> ACROCANTHOSAURUS_ENTITY = ENTITY_TYPES.register("acrocanthosaurus",
            () -> EntityType.Builder.of(Acrocanthosaurus::new,
                    MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"acrocanthosaurus").toString()));

    public static final RegistryObject<EntityType<AnomalyAcrocanthosaurus>> ANOMALOUS_ACROCANTHOSAURUS_ENTITY = ENTITY_TYPES.register("anomaly_acrocanthosaurus",
            () -> EntityType.Builder.of(AnomalyAcrocanthosaurus::new,
                            MobCategory.CREATURE)
                    .sized(4f,4f)
                    .build(new ResourceLocation(MODID,"anomaly_acrocanthosaurus").toString()));

    public static final RegistryObject<EntityType<Megaraptor>> MEGARAPTOR_ENTITY = ENTITY_TYPES.register("megaraptor",
            () -> EntityType.Builder.of(Megaraptor::new,
                            MobCategory.CREATURE)
                    .sized(1.0f,2.0f)
                    .build(new ResourceLocation(MODID,"megaraptor").toString()));

    public static final RegistryObject<EntityType<Utahraptor>> UTAHRAPTOR_ENTITY = ENTITY_TYPES.register("utahraptor",
            () -> EntityType.Builder.of(Utahraptor::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,1.8f)
                    .build(new ResourceLocation(MODID,"utahraptor").toString()));

    public static final RegistryObject<EntityType<Yutyrannus>> YUTYRANNUS_ENTITY = ENTITY_TYPES.register("yutyrannus",
            () -> EntityType.Builder.of(Yutyrannus::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"yutyrannus").toString()));


    //Herbivores
    public static final RegistryObject<EntityType<Parasaurolophus>> PARASAUROLOPHUS_ENTITY = ENTITY_TYPES.register("parasaurolophus",
            () -> EntityType.Builder.of(Parasaurolophus::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"parasaurolophus").toString()));
}

