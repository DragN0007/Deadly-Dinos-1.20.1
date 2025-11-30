package com.dragn0007.deadlydinos.items.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class DinosaurArmorItem extends Item {
   private static final String TEX_FOLDER = "textures/entity/horse/";
   private final int protection;
   private final ResourceLocation texture;

   public DinosaurArmorItem(int prot, String p_41365_, Properties p_41366_) {
      this(prot, new ResourceLocation("textures/entity/horse/armor/horse_armor_" + p_41365_ + ".png"), p_41366_);
   }

   public DinosaurArmorItem(int prot, ResourceLocation p_41365_, Properties p_41366_) {
      super(p_41366_);
      this.protection = prot;
      this.texture = p_41365_;
   }

   public ResourceLocation getTexture() {
      return texture;
   }

   public int getProtection() {
      return this.protection;
   }
}
