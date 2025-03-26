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
    protected void registerModels() {
        simpleItem(DDDItems.DDD_ENTITIES);

        advancedItem(DDDItems.ACROCANTHOSAURUS_SPAWN_EGG, "acrocanthosaurus_egg");
        advancedItem(DDDItems.FERTILIZED_ACROCANTHOSAURUS_EGG, "acrocanthosaurus_egg");
        simpleItem(DDDItems.ACROCANTHOSAURUS_EGG);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder advancedItem(RegistryObject<Item> item, String getTextureName) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + getTextureName));
    }
}