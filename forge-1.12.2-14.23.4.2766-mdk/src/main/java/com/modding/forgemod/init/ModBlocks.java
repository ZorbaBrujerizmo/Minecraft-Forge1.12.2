package com.modding.forgemod.init;

import com.modding.forgemod.blocks.BlockFusionFurnence;
import com.modding.forgemod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
	public static Block copper_block, steel_block, titanium_block, adamantium_block;
	
	public static Block fusion_furnace;
	
	public static Block[] listBlock = new Block[5];
	public static Item[] listItemblock = new Item[5];
	
	public static int id;
	
	public static void registerBlock(IForgeRegistry<Block> register)
	{
		register.registerAll(listBlock);
	}
	
	public static void registerItemblock(IForgeRegistry<Item> register)
	{
		register.registerAll(listItemblock);
	}
	
	public static void initialization()
	{
		copper_block = register("copper_block", new Block(Material.IRON).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		steel_block = register("steel_block", new Block(Material.IRON).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		titanium_block = register("titanium_block", new Block(Material.IRON).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		adamantium_block = register("adamantium_block", new Block(Material.IRON).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		
		fusion_furnace = register("fusion_furnace", new BlockFusionFurnence());
	}
	
	public static Block register(String name, Block block)
	{
		block.setUnlocalizedName(name);
		
		listBlock[id] = block.setRegistryName(Reference.MOD_ID, name);
		listItemblock[id] = new ItemBlock(block).setRegistryName(Reference.MOD_ID, name);
		id++;
		
		return block;
	}
}
