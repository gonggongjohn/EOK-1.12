package com.gonggongjohn.eok.items;

import com.gonggongjohn.eok.EOK;
import com.gonggongjohn.eok.handlers.ItemHandler;
import com.gonggongjohn.eok.utils.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

//当前，左右手持起火棍（fire stick），长按右键点火

public class ItemFireStick extends Item implements IHasModel {

    final ArrayList<Long> timeList = new ArrayList<>();
    private final Random rand = new Random();
    private int cpt = 0;
    private boolean fire = false;
    private int useTime = 0;

    public ItemFireStick() {

        this.maxStackSize = 1;

        String name = "fire_stick";
        this.setUnlocalizedName("eok." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOK.tabEOK);

        ItemHandler.ITEM_REGISTRY.add(this);
    }

    @Override
    public void registerModel() {

        EOK.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public BlockPos getFirePos(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing) {

        pos = pos.add(0.0D, 1.0D, 0.0D);

        return pos;
    }

    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand handIn, EnumFacing facing, float hitX, float hitY, float fitZ) {

        ItemStack itemStack = playerIn.getHeldItem(handIn);

        if (!playerIn.canPlayerEdit(pos, facing, itemStack) || fire == true) {

            fire = false;

            return EnumActionResult.FAIL;
        } else {

            if (cpt < 20) {

                timeList.add(worldIn.getWorldTime());

                if (timeList.size() >= 2 && (timeList.get(timeList.size() - 1) - timeList.get(timeList.size() - 2)) > 10) {

                    timeList.clear();
                    cpt = 0;
                }

                if (cpt > 0) {

                    //Smoke_normal
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
			        /*
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 1.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 1.0D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() - 0.0D, 0.0D, 0.0D, 0.0D);
					*/
                }

                if (cpt > 10) {

                    //Smoke_Large
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
					/*
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 1.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 1.0D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() - 0.0D, 0.0D, 0.0D, 0.0D);
					*/
                }

                if (cpt > 15) {

                    //Flame
                    worldIn.playSound(getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + rand.nextDouble() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + rand.nextDouble() + 0.0D, 0.0D, 0.0D, 0.0D);
			        /*
					worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() - 0.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 1.0D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() + 1.0D, 0.0D, 0.0D, 0.0D);
			        worldIn.spawnParticle(EnumParticleTypes.FLAME, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getX() + 0.5D, getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getY(), getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()).getZ() - 0.0D, 0.0D, 0.0D, 0.0D);
					*/
                }
            } else {

                if (timeList.size() != 0) {

                    //System.out.println("Total time: " + (timeList.get(timeList.size() - 1) - timeList.get(0)));
                    //cpt = 20时，连击最短用时37
                    if ((timeList.get(timeList.size() - 1) - timeList.get(0)) <= 37) {

                        fire = true;
                    }
                }

                timeList.clear();
                cpt = 0;
            }

            playerIn.swingArm(EnumHand.MAIN_HAND);
            playerIn.swingArm(EnumHand.OFF_HAND);

            if (playerIn.getHeldItemOffhand().getItem() == this && playerIn.getHeldItemMainhand().getItem() == this) {

                cpt++;

                if (fire) {

                    useTime++;

                    if (useTime > 1) {

                        playerIn.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
                        playerIn.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);

                        useTime = 0;
                    }

                    worldIn.setBlockState(getFirePos(playerIn, worldIn, pos, handIn, playerIn.getHorizontalFacing()), Blocks.FIRE.getDefaultState(), 11);
                }
            } else {

                cpt = 0;
            }

            return EnumActionResult.SUCCESS;
        }
    }
}