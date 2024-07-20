package com.modding.forgemod.init;

import com.modding.forgemod.items.ModItemDrill;
import com.modding.forgemod.items.ModItemSword;
import com.modding.forgemod.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
	public static Item copper_ingot, steel_ingot, titanium_ingot, adamantium_ingot;
	public static Item copper_sword, steel_sword, titanium_sword, adamantium_sword;
	public static Item copper_drill, steel_drill, titanium_drill, adamantium_drill;
	
	public static IForgeRegistry<Item> register;
	
	public static void initialization()
	{
		copper_ingot = register("coppet_ingot", new Item().setCreativeTab(CreativeTabs.MATERIALS));
		steel_ingot = register("steel_ingot", new Item().setCreativeTab(CreativeTabs.MATERIALS));
		titanium_ingot = register("titanium_ingot", new Item().setCreativeTab(CreativeTabs.MATERIALS));
		adamantium_ingot = register("adamantium_ingot", new Item().setCreativeTab(CreativeTabs.MATERIALS));
		
		copper_sword = register("copper_sword", new ModItemSword(ToolMaterial.STONE, 250, 3.0F));
		steel_sword = register("steel_sword", new ModItemSword(ToolMaterial.IRON, 1561, 3.0F));
		titanium_sword = register("titanium_sword", new ModItemSword(ToolMaterial.DIAMOND, 2089, 3.0F));
		adamantium_sword = register("adamantium_sword", new ModItemSword(ToolMaterial.DIAMOND, 2561, 4.0F));
		
		copper_drill = register("copper_drill", new ModItemDrill(4.0F, 250));
		steel_drill = register("steel_drill", new ModItemDrill(6.0F, 1561));
		titanium_drill = register("titanium_drill", new ModItemDrill(8.0F, 2089));
		adamantium_drill = register("adamantium_drill", new ModItemDrill(10.0F, 2561));
	}
	
	public static Item register(String name, Item item)
	{	
		item.setUnlocalizedName(name);
		register.register(item.setRegistryName(Reference.MOD_ID, name));
		
		return item;
	}
}
