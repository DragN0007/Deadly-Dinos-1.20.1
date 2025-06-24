package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.items.DDDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DDDItemModelProvider extends ItemModelProvider {
    public DDDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeadlyDinos.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        simpleItem(DDDItems.DDD_ENTITIES);
        simpleItem(DDDItems.DDD_ITEMS);
        simpleItem(DDDItems.DDD_FOOD);
        simpleItem(DDDItems.DDD_BLOCKS);
        simpleItem(DDDItems.DDD);

        handheldItem(DDDItems.ANOMALY_BONE_SWORD);
        handheldItem(DDDItems.ANOMALY_BONE_PICKAXE);
        handheldItem(DDDItems.ANOMALY_BONE_SHOVEL);
        handheldItem(DDDItems.ANOMALY_BONE_AXE);
        handheldItem(DDDItems.ANOMALY_BONE_HOE);
        handheldItem(DDDItems.ANOMALY_BONE_DAGGER);
        handheldItem(DDDItems.ANOMALY_BONE_GREATSWORD);
        handheldItem(DDDItems.ANOMALY_BONE_BATTLEAXE);
        handheldItem(DDDItems.ANOMALY_BONE_WARHAMMER);
        handheldItem(DDDItems.BONE_SWORD);
        handheldItem(DDDItems.BONE_PICKAXE);
        handheldItem(DDDItems.BONE_SHOVEL);
        handheldItem(DDDItems.BONE_AXE);
        handheldItem(DDDItems.BONE_HOE);
        handheldItem(DDDItems.BONE_DAGGER);
        simpleItem(DDDItems.RIOT_HELMET);
        simpleItem(DDDItems.RIOT_CHESTPLATE);
        simpleItem(DDDItems.RIOT_LEGGINGS);
        simpleItem(DDDItems.RIOT_BOOTS);

        advancedItem(DDDItems.ACROCANTHOSAURUS_SPAWN_EGG, "acrocanthosaurus_egg");
        advancedItem(DDDItems.FERTILIZED_ACROCANTHOSAURUS_EGG, "acrocanthosaurus_egg");
        simpleItem(DDDItems.ACROCANTHOSAURUS_EGG);
        simpleItem(DDDItems.ACROCANTHOSAURUS_TROPHY);

        advancedItem(DDDItems.UTAHRAPTOR_SPAWN_EGG, "utahraptor_egg");
        advancedItem(DDDItems.FERTILIZED_UTAHRAPTOR_EGG, "utahraptor_egg");
        simpleItem(DDDItems.UTAHRAPTOR_EGG);
        simpleItem(DDDItems.UTAHRAPTOR_TROPHY);

        advancedItem(DDDItems.YUTYRANNUS_SPAWN_EGG, "yutyrannus_egg");
        advancedItem(DDDItems.FERTILIZED_YUTYRANNUS_EGG, "yutyrannus_egg");
        simpleItem(DDDItems.YUTYRANNUS_EGG);
        simpleItem(DDDItems.YUTYRANNUS_TROPHY);

        advancedItem(DDDItems.PARASAUROLOPHUS_SPAWN_EGG, "parasaurolophus_egg");
        advancedItem(DDDItems.FERTILIZED_PARASAUROLOPHUS_EGG, "parasaurolophus_egg");
        simpleItem(DDDItems.PARASAUROLOPHUS_EGG);
        simpleItem(DDDItems.PARASAUROLOPHUS_TROPHY);

        advancedItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_SPAWN_EGG, "anomaly_acrocanthosaurus_egg");

        simpleItem(DDDItems.RAW_SMALL_MEAT);
        simpleItem(DDDItems.COOKED_SMALL_MEAT);
        simpleItem(DDDItems.RAW_MEDIUM_MEAT);
        simpleItem(DDDItems.COOKED_MEDIUM_MEAT);
        simpleItem(DDDItems.RAW_LARGE_MEAT);
        simpleItem(DDDItems.COOKED_LARGE_MEAT);

        simpleItem(DDDItems.LARGE_CARNIVORE_CLAW);
        simpleItem(DDDItems.LARGE_CARNIVORE_LEG);
        simpleItem(DDDItems.LARGE_CARNIVORE_RIBS);
        simpleItem(DDDItems.LARGE_CARNIVORE_SKULL);
        simpleItem(DDDItems.LARGE_CARNIVORE_SPINE);
        simpleItem(DDDItems.LARGE_CARNIVORE_TAIL);
        simpleItem(DDDItems.LARGE_CARNIVORE_TOOTH);

        simpleItem(DDDItems.MEDIUM_CARNIVORE_CLAW);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_LEG);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_RIBS);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_SKULL);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_SPINE);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_TAIL);
        simpleItem(DDDItems.MEDIUM_CARNIVORE_TOOTH);
        simpleItem(DDDItems.MEDIUM_RAPTOR_CLAW);

        simpleItem(DDDItems.SMALL_CARNIVORE_CLAW);
        simpleItem(DDDItems.SMALL_CARNIVORE_LEG);
        simpleItem(DDDItems.SMALL_CARNIVORE_RIBS);
        simpleItem(DDDItems.SMALL_CARNIVORE_SKULL);
        simpleItem(DDDItems.SMALL_CARNIVORE_SPINE);
        simpleItem(DDDItems.SMALL_CARNIVORE_TAIL);
        simpleItem(DDDItems.SMALL_CARNIVORE_TOOTH);
        simpleItem(DDDItems.SMALL_RAPTOR_CLAW);

        simpleItem(DDDItems.LARGE_HERBIVORE_CLAW);
        simpleItem(DDDItems.LARGE_HERBIVORE_LEG);
        simpleItem(DDDItems.LARGE_HERBIVORE_RIBS);
        simpleItem(DDDItems.LARGE_HERBIVORE_SKULL);
        simpleItem(DDDItems.LARGE_HERBIVORE_SPINE);
        simpleItem(DDDItems.LARGE_HERBIVORE_TAIL);
        simpleItem(DDDItems.LARGE_HERBIVORE_TOOTH);

        simpleItem(DDDItems.MEDIUM_HERBIVORE_CLAW);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_LEG);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_RIBS);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_SKULL);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_SPINE);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_TAIL);
        simpleItem(DDDItems.MEDIUM_HERBIVORE_TOOTH);

        simpleItem(DDDItems.SMALL_HERBIVORE_CLAW);
        simpleItem(DDDItems.SMALL_HERBIVORE_LEG);
        simpleItem(DDDItems.SMALL_HERBIVORE_RIBS);
        simpleItem(DDDItems.SMALL_HERBIVORE_SKULL);
        simpleItem(DDDItems.SMALL_HERBIVORE_SPINE);
        simpleItem(DDDItems.SMALL_HERBIVORE_TAIL);
        simpleItem(DDDItems.SMALL_HERBIVORE_TOOTH);

        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_CLAW);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_LEG);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_RIBS);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_SKULL);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_SPINE);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_TAIL);
        simpleItem(DDDItems.ANOMALY_ACROCANTHOSAURUS_TOOTH);

        simpleItem(DDDItems.CRACKER);
        simpleItem(DDDItems.DINO_SANDWICH);
        simpleItem(DDDItems.CANNED_VEGGIES);
        simpleItem(DDDItems.CANNED_MEAT);
        simpleItem(DDDItems.CANNED_STEW);
        simpleItem(DDDItems.MRE);
        simpleItem(DDDItems.SODA);
        simpleItem(DDDItems.TIGER_NUTS);
        simpleItem(DDDItems.YEW_PLUM);
        simpleItem(DDDItems.TIGER_NUT_BUTTER);
        simpleItem(DDDItems.YEW_PLUM_JAM);
        simpleItem(DDDItems.PBJ);
        simpleItem(DDDItems.GLAZED_RIBS);
        simpleItem(DDDItems.RAW_ESCARGOT);
        simpleItem(DDDItems.COOKED_ESCARGOT );
        simpleItem(DDDItems.DINO_NUGGET_1);
        simpleItem(DDDItems.DINO_NUGGET_2);
        simpleItem(DDDItems.DINO_NUGGET_3);
        simpleItem(DDDItems.HEARTY_SALAD);
        simpleItem(DDDItems.SMOOTHIE);
        simpleItem(DDDItems.DINO_DUMPLING);
        simpleItem(DDDItems.CHICKEN_NOODLE_SOUP);
        simpleItem(DDDItems.DINO_ROAST);
        simpleItem(DDDItems.BONE_MARROW);
        simpleItem(DDDItems.BROTH);
        simpleItem(DDDItems.DOUGH);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + item.getId().getPath()));
    }

    public ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + item.getId().getPath()));
    }

    public ItemModelBuilder advancedItem(RegistryObject<Item> item, String getTextureName) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + getTextureName));
    }
}