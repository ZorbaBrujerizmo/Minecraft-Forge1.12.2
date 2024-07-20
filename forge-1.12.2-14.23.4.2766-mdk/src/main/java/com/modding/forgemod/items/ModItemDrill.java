package com.modding.forgemod.items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModItemDrill extends Item
{
	public float speedDestroy;
	
	public static final Set<Block> LIST_BLOCKS = Sets.newHashSet
			(
			Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE,
			Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE,
			Blocks.DOUBLE_STONE_SLAB, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE,
			Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK,
			Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE,
			Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE,
			Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE,
			
			Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, 
			Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE,
			
			Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, 
			Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.CONCRETE_POWDER
			);
	
	public static final Set<Material> LIST_MATERIAL = Sets.newHashSet
			(
			Material.IRON, Material.ANVIL, Material.ROCK,
			Material.WOOD, Material.PLANTS, Material.VINE,
			Material.GROUND, Material.SAND, Material.SNOW, 
			Material.CRAFTED_SNOW, Material.CLAY, Material.GRASS
			);
	
	public ModItemDrill(float speed, int maxUse)
	{
		this.speedDestroy = speed;
		
		this.setMaxDamage(maxUse);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
	{
		return LIST_MATERIAL.contains(state.getMaterial()) ? speedDestroy : 1.0F;
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState state) 
	{	
		return LIST_BLOCKS.contains(state.getBlock());
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		stack.damageItem(2, attacker);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase player) 
	{
		if((double)state.getBlockHardness(world, pos) != 0.0D) 
		{
			stack.damageItem(1, player);
		}
		return true;
	}
}
