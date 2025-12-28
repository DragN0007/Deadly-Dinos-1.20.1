package com.dragn0007.deadlydinos.datagen.biglooter;

import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import com.dragn0007.deadlydinos.items.DDDItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class DDDBlockLoot extends BlockLootSubProvider {

    public DDDBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        dropSelf(DDDBlocks.REINFORCED_COBBLESTONE.get());
        dropSelf(DDDBlocks.REINFORCED_GLASS.get());
        dropSelf(DDDBlocks.REINFORCED_STONE_BRICKS.get());
        dropSelf(DDDBlocks.CHAIN_LINK_FENCE.get());
        dropSelf(DDDBlocks.HORIZONTAL_BAR_FENCE.get());
        dropSelf(DDDBlocks.WIDE_BAR_FENCE.get());
        dropSelf(DDDBlocks.WIRE_FENCE.get());
        dropSelf(DDDBlocks.ELECTRIC_WIRE_FENCE.get());

        LootItemCondition.Builder supply_box = LootItemBlockStatePropertyCondition.hasBlockStateProperties(DDDBlocks.FOOD_SUPPLY_STASH.get());
        this.add(DDDBlocks.FOOD_SUPPLY_STASH.get(), this.createMultiDrops(DDDBlocks.FOOD_SUPPLY_STASH.get(), DDDItems.CRACKER.get(), DDDItems.CRACKER.get(), DDDItems.SODA.get(), DDDItems.MRE.get(), supply_box));

        LootItemCondition.Builder med_supply_box = LootItemBlockStatePropertyCondition.hasBlockStateProperties(DDDBlocks.MEDICAL_SUPPLY_STASH.get());
        this.add(DDDBlocks.MEDICAL_SUPPLY_STASH.get(), this.createMedicalDrops(DDDBlocks.MEDICAL_SUPPLY_STASH.get(), DDDItems.GAUZE_WRAP.get(), DDDItems.BUG_BITE_CREAM.get(), DDDItems.BIRD_FLU_SHOT.get(), DDDItems.PARASITIC_ANTIBIOTIC.get(), DDDItems.BACTERIAL_ANTIBIOTIC.get(), med_supply_box));

        LootItemCondition.Builder eq_supply_box = LootItemBlockStatePropertyCondition.hasBlockStateProperties(DDDBlocks.EQUIPMENT_SUPPLY_STASH.get());
        this.add(DDDBlocks.EQUIPMENT_SUPPLY_STASH.get(), this.createEquipmentDrops(DDDBlocks.EQUIPMENT_SUPPLY_STASH.get(), DDDItems.RIOT_HELMET.get(), DDDItems.HUNTING_KNIFE.get(), DDDItems.TACTICAL_KNIFE.get(), DDDItems.CROWBAR.get(), eq_supply_box));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createMultiDrops(Block block, Item item, Item item1, Item item2, Item item3, LootItemCondition.Builder builder) {
        return this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(item).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 2)))
                .add(LootItem.lootTableItem(item1).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 2)))
                .add(LootItem.lootTableItem(item2).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 2)))
                .add(LootItem.lootTableItem(item3).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 2)))
        ));
    }

    protected LootTable.Builder createEquipmentDrops(Block block, Item item, Item item1, Item item2, Item item3, LootItemCondition.Builder builder) {
        return this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(item).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item1).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item2).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item3).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
        ));
    }

    protected LootTable.Builder createMedicalDrops(Block block, Item item, Item item1, Item item2, Item item3, Item item4, LootItemCondition.Builder builder) {
        return this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(item).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item1).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item2).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item3).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
                .add(LootItem.lootTableItem(item4).when(builder).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 0)))
        ));
    }
}
