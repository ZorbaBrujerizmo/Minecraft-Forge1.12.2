package com.modding.forgemod.proxy.renders;

import com.modding.forgemod.init.ModItems;
import com.modding.forgemod.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemRendering
{
	@SubscribeEvent
	public void onModelRengisterEvent(ModelRegistryEvent event)
	{
		register(ModItems.copper_ingot, "copper_ingot");
		register(ModItems.steel_ingot, "steel_ingot");
		register(ModItems.titanium_ingot, "titanium_ingot");
		register(ModItems.adamantium_ingot, "adamantium_ingot");
		
		register(ModItems.copper_sword, "copper_sword");
		register(ModItems.steel_sword, "steel_sword");
		register(ModItems.titanium_sword, "titanium_sword");
		register(ModItems.adamantium_sword, "adamantium_sword");
		
		register(ModItems.copper_drill, "copper_drill");
		register(ModItems.steel_drill, "steel_drill");
		register(ModItems.titanium_drill, "titanium_drill");
		register(ModItems.adamantium_drill, "adamantium_drill");
	}
	
	public void register(Item item, String name)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
	}
}
