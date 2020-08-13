package com.gonggongjohn.eok.entity;

import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityNat extends EntityNPCBase {
    public EntityNat(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        ItemStack egg = new ItemStack(Items.SPAWN_EGG, 1);
        ItemMonsterPlacer.applyEntityIdToItemStack(egg, new ResourceLocation("eok:entity.nat"));
        this.entityDropItem(egg, 0.0F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

}