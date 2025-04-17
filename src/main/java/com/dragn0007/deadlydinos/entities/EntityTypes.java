package com.dragn0007.deadlydinos.entities;

import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.anomaly.AnomalyAcrocanthosaurus;
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

    public static final RegistryObject<EntityType<AnomalyAcrocanthosaurus>> ANOMALOUS_ACROCANTHOSAURUS_ENTITY = ENTITY_TYPES.register("anomalous_acrocanthosaurus",
            () -> EntityType.Builder.of(AnomalyAcrocanthosaurus::new,
                            MobCategory.CREATURE)
                    .sized(4f,4f)
                    .build(new ResourceLocation(MODID,"acrocanthosaurus").toString()));

    public static final RegistryObject<EntityType<Utahraptor>> UTAHRAPTOR_ENTITY = ENTITY_TYPES.register("utahraptor",
            () -> EntityType.Builder.of(Utahraptor::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.8f)
                    .build(new ResourceLocation(MODID,"utahraptor").toString()));
//
//    public static final RegistryObject<EntityType<Carno>> CARNO_ENTITY = ENTITY_TYPES.register("carno",
//            () -> EntityType.Builder.of(Carno::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,3f)
//                    .build(new ResourceLocation(MODID,"carno").toString()));
//
//    public static final RegistryObject<EntityType<Cerato>> CERATO_ENTITY = ENTITY_TYPES.register("cerato",
//            () -> EntityType.Builder.of(Cerato::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,2.8f)
//                    .build(new ResourceLocation(MODID,"cerato").toString()));
//
//    public static final RegistryObject<EntityType<Giga>> GIGA_ENTITY = ENTITY_TYPES.register("giga",
//            () -> EntityType.Builder.of(Giga::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"giga").toString()));
//
//    public static final RegistryObject<EntityType<Rex>> REX_ENTITY = ENTITY_TYPES.register("rex",
//            () -> EntityType.Builder.of(Rex::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"rex").toString()));
//
//    public static final RegistryObject<EntityType<Spino>> SPINO_ENTITY = ENTITY_TYPES.register("spino",
//            () -> EntityType.Builder.of(Spino::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,5f)
//                    .build(new ResourceLocation(MODID,"spino").toString()));
//    public static final RegistryObject<EntityType<Compy>> COMPY_ENTITY = ENTITY_TYPES.register("compy",
//            () -> EntityType.Builder.of(Compy::new,
//                            MobCategory.CREATURE)
//                    .sized(0.5f,0.5f)
//                    .build(new ResourceLocation(MODID,"compy").toString()));
//
//    public static final RegistryObject<EntityType<Mahakala>> MAHAKALA_ENTITY = ENTITY_TYPES.register("mahakala",
//            () -> EntityType.Builder.of(Mahakala::new,
//                            MobCategory.CREATURE)
//                    .sized(0.4f,0.4f)
//                    .build(new ResourceLocation(MODID,"mahakala").toString()));
//
//    public static final RegistryObject<EntityType<Austro>> AUSTRO_ENTITY = ENTITY_TYPES.register("austro",
//            () -> EntityType.Builder.of(Austro::new,
//                            MobCategory.CREATURE)
//                    .sized(0.8f,1.5f)
//                    .build(new ResourceLocation(MODID,"austro").toString()));
//
//    public static final RegistryObject<EntityType<Deinon>> DEINON_ENTITY = ENTITY_TYPES.register("deinon",
//            () -> EntityType.Builder.of(Deinon::new,
//                            MobCategory.CREATURE)
//                    .sized(0.6f,1.3f)
//                    .build(new ResourceLocation(MODID,"deinon").toString()));
//
//    public static final RegistryObject<EntityType<Alberto>> ALBERTO_ENTITY = ENTITY_TYPES.register("alberto",
//            () -> EntityType.Builder.of(Alberto::new,
//                            MobCategory.CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"alberto").toString()));
//
//    public static final RegistryObject<EntityType<Majunga>> MAJUNGA_ENTITY = ENTITY_TYPES.register("majunga",
//            () -> EntityType.Builder.of(Majunga::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,3f)
//                    .build(new ResourceLocation(MODID,"majunga").toString()));
//
//    public static final RegistryObject<EntityType<Troodon>> TROODON_ENTITY = ENTITY_TYPES.register("troodon",
//            () -> EntityType.Builder.of(Troodon::new,
//                            MobCategory.CREATURE)
//                    .sized(0.5f,1f)
//                    .build(new ResourceLocation(MODID,"troodon").toString()));
//
//    public static final RegistryObject<EntityType<Archae>> ARCHAE_ENTITY = ENTITY_TYPES.register("archae",
//            () -> EntityType.Builder.of(Archae::new,
//                            MobCategory.CREATURE)
//                    .sized(0.5f,1f)
//                    .build(new ResourceLocation(MODID,"archae").toString()));
//
//    public static final RegistryObject<EntityType<Tarbo>> TARBO_ENTITY = ENTITY_TYPES.register("tarbo",
//            () -> EntityType.Builder.of(Tarbo::new,
//                            MobCategory.CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"tarbo").toString()));
//
//    public static final RegistryObject<EntityType<Andal>> ANDAL_ENTITY = ENTITY_TYPES.register("andal",
//            () -> EntityType.Builder.of(Andal::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,1f)
//                    .build(new ResourceLocation(MODID,"andal").toString()));
//
//    public static final RegistryObject<EntityType<Carchar>> CARCHAR_ENTITY = ENTITY_TYPES.register("carchar",
//            () -> EntityType.Builder.of(Carchar::new,
//                            MobCategory.CREATURE)
//                    .sized(2.5f,5f)
//                    .build(new ResourceLocation(MODID,"carchar").toString()));
//
//    public static final RegistryObject<EntityType<Allo>> ALLO_ENTITY = ENTITY_TYPES.register("allo",
//            () -> EntityType.Builder.of(Allo::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,3f)
//                    .build(new ResourceLocation(MODID,"allo").toString()));
//
//    public static final RegistryObject<EntityType<Dilo>> DILO_ENTITY = ENTITY_TYPES.register("dilo",
//            () -> EntityType.Builder.of(Dilo::new,
//                            MobCategory.CREATURE)
//                    .sized(0.8f,1.8f)
//                    .build(new ResourceLocation(MODID,"dilo").toString()));
//
    public static final RegistryObject<EntityType<Yutyrannus>> YUTYRANNUS_ENTITY = ENTITY_TYPES.register("yutyrannus",
            () -> EntityType.Builder.of(Yutyrannus::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"yutyrannus").toString()));
//
//    public static final RegistryObject<EntityType<Cryo>> CRYO_ENTITY = ENTITY_TYPES.register("cryo",
//            () -> EntityType.Builder.of(Cryo::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"cryo").toString()));
//
//    public static final RegistryObject<EntityType<Australo>> AUSTRALO_ENTITY = ENTITY_TYPES.register("australo",
//            () -> EntityType.Builder.of(Australo::new,
//                            MobCategory.CREATURE)
//                    .sized(0.8f,1.8f)
//                    .build(new ResourceLocation(MODID,"australo").toString()));
//
//    public static final RegistryObject<EntityType<Atroci>> ATROCI_ENTITY = ENTITY_TYPES.register("atroci",
//            () -> EntityType.Builder.of(Atroci::new,
//                            MobCategory.CREATURE)
//                    .sized(0.5f,1f)
//                    .build(new ResourceLocation(MODID,"atroci").toString()));
//
//    public static final RegistryObject<EntityType<Ichthy>> ICHTHY_ENTITY = ENTITY_TYPES.register("ichthy",
//            () -> EntityType.Builder.of(Ichthy::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,2.5f)
//                    .build(new ResourceLocation(MODID,"ichthy").toString()));
//
//    public static final RegistryObject<EntityType<Megarap>> MEGARAP_ENTITY = ENTITY_TYPES.register("megarap",
//            () -> EntityType.Builder.of(Megarap::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,2.5f)
//                    .build(new ResourceLocation(MODID,"megarap").toString()));
//
//    public static final RegistryObject<EntityType<Eocarchar>> EOCARCHAR_ENTITY = ENTITY_TYPES.register("eocarchar",
//            () -> EntityType.Builder.of(Eocarchar::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,2.5f)
//                    .build(new ResourceLocation(MODID,"eocarchar").toString()));
//
//    public static final RegistryObject<EntityType<Bary>> BARY_ENTITY = ENTITY_TYPES.register("bary",
//            () -> EntityType.Builder.of(Bary::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,2.5f)
//                    .build(new ResourceLocation(MODID,"bary").toString()));
//
//
//
//
//
//    //Herbivores
//
//    public static final RegistryObject<EntityType<CropSnail>> CROPSNAIL_ENTITY = ENTITY_TYPES.register("cropsnail",
//            () -> EntityType.Builder.of(CropSnail::new,
//                            MobCategory.CREATURE)
//                    .sized(1f,1f)
//                    .build(new ResourceLocation(MODID,"cropsnail").toString()));
//
//    public static final RegistryObject<EntityType<Amarga>> AMARGA_ENTITY = ENTITY_TYPES.register("amarga",
//            () -> EntityType.Builder.of(Amarga::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"amarga").toString()));
//
//    public static final RegistryObject<EntityType<Para>> PARA_ENTITY = ENTITY_TYPES.register("para",
//            () -> EntityType.Builder.of(Para::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"para").toString()));
//    public static final RegistryObject<EntityType<Theri>> THERI_ENTITY = ENTITY_TYPES.register("theri",
//            () -> EntityType.Builder.of(Theri::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,5f)
//                    .build(new ResourceLocation(MODID,"theri").toString()));
//    public static final RegistryObject<EntityType<Deinoch>> DEINOCH_ENTITY = ENTITY_TYPES.register("deinoch",
//            () -> EntityType.Builder.of(Deinoch::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,5f)
//                    .build(new ResourceLocation(MODID,"deinoch").toString()));
//    public static final RegistryObject<EntityType<Stego>> STEGO_ENTITY = ENTITY_TYPES.register("stego",
//            () -> EntityType.Builder.of(Stego::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4f)
//                    .build(new ResourceLocation(MODID,"stego").toString()));
//    public static final RegistryObject<EntityType<Shant>> SHANT_ENTITY = ENTITY_TYPES.register("shant",
//            () -> EntityType.Builder.of(Shant::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"shant").toString()));
//    public static final RegistryObject<EntityType<Galli>> GALLI_ENTITY = ENTITY_TYPES.register("galli",
//            () -> EntityType.Builder.of(Galli::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,2.5f)
//                    .build(new ResourceLocation(MODID,"galli").toString()));
//    public static final RegistryObject<EntityType<Sauro>> SAURO_ENTITY = ENTITY_TYPES.register("sauro",
//            () -> EntityType.Builder.of(Sauro::new,
//                            MobCategory.CREATURE)
//                    .sized(5f,8f)
//                    .build(new ResourceLocation(MODID,"sauro").toString()));
//    public static final RegistryObject<EntityType<Anky>> ANKY_ENTITY = ENTITY_TYPES.register("anky",
//            () -> EntityType.Builder.of(Anky::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,2.5f)
//                    .build(new ResourceLocation(MODID,"anky").toString()));
//
//    public static final RegistryObject<EntityType<Ava>> AVA_ENTITY = ENTITY_TYPES.register("ava",
//            () -> EntityType.Builder.of(Ava::new,
//                            MobCategory.CREATURE)
//                    .sized(1.5f,1.5f)
//                    .build(new ResourceLocation(MODID,"ava").toString()));
//
//    public static final RegistryObject<EntityType<Grypo>> GRYPO_ENTITY = ENTITY_TYPES.register("grypo",
//            () -> EntityType.Builder.of(Grypo::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"grypo").toString()));
//
//    public static final RegistryObject<EntityType<Ampelo>> AMPELO_ENTITY = ENTITY_TYPES.register("ampelo",
//            () -> EntityType.Builder.of(Ampelo::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"ampelo").toString()));
//
//    public static final RegistryObject<EntityType<Pachyr>> PACHYR_ENTITY = ENTITY_TYPES.register("pachyr",
//            () -> EntityType.Builder.of(Pachyr::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,2.5f)
//                    .build(new ResourceLocation(MODID,"pachyr").toString()));
//
//    public static final RegistryObject<EntityType<Edmonto>> EDMONTO_ENTITY = ENTITY_TYPES.register("edmonto",
//            () -> EntityType.Builder.of(Edmonto::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4.5f)
//                    .build(new ResourceLocation(MODID,"edmonto").toString()));
//
//    public static final RegistryObject<EntityType<Igua>> IGUA_ENTITY = ENTITY_TYPES.register("igua",
//            () -> EntityType.Builder.of(Igua::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4f)
//                    .build(new ResourceLocation(MODID,"igua").toString()));
//
//    public static final RegistryObject<EntityType<Trike>> TRIKE_ENTITY = ENTITY_TYPES.register("trike",
//            () -> EntityType.Builder.of(Trike::new,
//                            MobCategory.CREATURE)
//                    .sized(2f,4f)
//                    .build(new ResourceLocation(MODID,"trike").toString()));
//
//    public static final RegistryObject<EntityType<Pachy>> PACHY_ENTITY = ENTITY_TYPES.register("pachy",
//            () -> EntityType.Builder.of(Pachy::new,
//                            MobCategory.CREATURE)
//                    .sized(1f,2f)
//                    .build(new ResourceLocation(MODID,"pachy").toString()));
//
//
//
//
//    public static final RegistryObject<EntityType<Mosa>> MOSA_ENTITY = ENTITY_TYPES.register("mosa",
//            () -> EntityType.Builder.of(Mosa::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"mosa").toString()));
//
//    public static final RegistryObject<EntityType<Heli>> HELI_ENTITY = ENTITY_TYPES.register("heli",
//            () -> EntityType.Builder.of(Heli::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"heli").toString()));
//
//    public static final RegistryObject<EntityType<Gar>> GAR_ENTITY = ENTITY_TYPES.register("gar",
//            () -> EntityType.Builder.of(Gar::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(1f,2f)
//                    .build(new ResourceLocation(MODID,"gar").toString()));
//
//    public static final RegistryObject<EntityType<Dunkleo>> DUNKLEO_ENTITY = ENTITY_TYPES.register("dunkleo",
//            () -> EntityType.Builder.of(Dunkleo::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"dunkleo").toString()));
//
//    public static final RegistryObject<EntityType<Ichthyo>> ICHTHYO_ENTITY = ENTITY_TYPES.register("ichthyo",
//            () -> EntityType.Builder.of(Ichthyo::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"ichthyo").toString()));
//
//    public static final RegistryObject<EntityType<Leed>> LEED_ENTITY = ENTITY_TYPES.register("leed",
//            () -> EntityType.Builder.of(Leed::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(5f,5f)
//                    .build(new ResourceLocation(MODID,"leed").toString()));
//
//    public static final RegistryObject<EntityType<Basilo>> BASILO_ENTITY = ENTITY_TYPES.register("basilo",
//            () -> EntityType.Builder.of(Basilo::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"basilo").toString()));
//
//    public static final RegistryObject<EntityType<Meg>> MEG_ENTITY = ENTITY_TYPES.register("meg",
//            () -> EntityType.Builder.of(Meg::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(2f,2f)
//                    .build(new ResourceLocation(MODID,"meg").toString()));
//
//    public static final RegistryObject<EntityType<Livy>> LIVY_ENTITY = ENTITY_TYPES.register("livy",
//            () -> EntityType.Builder.of(Livy::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(5f,5f)
//                    .build(new ResourceLocation(MODID,"livy").toString()));
//
//    public static final RegistryObject<EntityType<Steth>> STETH_ENTITY = ENTITY_TYPES.register("steth",
//            () -> EntityType.Builder.of(Steth::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(1f,2f)
//                    .build(new ResourceLocation(MODID,"steth").toString()));
//
//    public static final RegistryObject<EntityType<Hyneria>> HYNERIA_ENTITY = ENTITY_TYPES.register("hyneria",
//            () -> EntityType.Builder.of(Hyneria::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(1f,1f)
//                    .build(new ResourceLocation(MODID,"hyneria").toString()));
//
//    public static final RegistryObject<EntityType<Argan>> ARGAN_ENTITY = ENTITY_TYPES.register("argan",
//            () -> EntityType.Builder.of(Argan::new,
//                            MobCategory.WATER_CREATURE)
//                    .sized(1f,1f)
//                    .build(new ResourceLocation(MODID,"argan").toString()));
//
//
//
//
//    //Cars
//
//    public static final RegistryObject<EntityType<Car>> CAR_ENTITY = ENTITY_TYPES.register("car",
//            () -> EntityType.Builder.of(Car::new,
//                            MobCategory.CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"car").toString()));
//
//    public static final RegistryObject<EntityType<CarSide>> CARSIDE_ENTITY = ENTITY_TYPES.register("carside",
//            () -> EntityType.Builder.of(CarSide::new,
//                            MobCategory.CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"carside").toString()));
//
//    public static final RegistryObject<EntityType<CarFlipped>> CARFLIPPED_ENTITY = ENTITY_TYPES.register("carflipped",
//            () -> EntityType.Builder.of(CarFlipped::new,
//                            MobCategory.CREATURE)
//                    .sized(3f,3f)
//                    .build(new ResourceLocation(MODID,"carflipped").toString()));

}

