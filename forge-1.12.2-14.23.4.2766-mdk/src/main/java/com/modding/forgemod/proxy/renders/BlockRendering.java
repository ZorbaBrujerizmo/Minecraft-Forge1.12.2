package com.modding.forgemod.proxy.renders;

import com.modding.forgemod.init.ModBlocks;
import com.modding.forgemod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockRendering
{
	@SubscribeEvent
	public void onModelRegisterEvent(ModelRegistryEvent event)
	{
		register(ModBlocks.copper_block, "copper_block");
		register(ModBlocks.steel_block, "steel_block");
		register(ModBlocks.titanium_block, "titanium_block");
		register(ModBlocks.adamantium_block, "adamantium_block");
		
		register(ModBlocks.fusion_furnace, "fusion_furnace");
	}
	
	public static void register(Block block, String name)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
	}
}
