package com.modding.forgemod.registry;

import com.modding.forgemod.init.ModBlocks;
import com.modding.forgemod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisterEvent
{
	@SubscribeEvent
	public void onRegisterBlockEvent(RegistryEvent.Register<Block> event)
	{
		ModBlocks.registerBlock(event.getRegistry());
	}
	
	@SubscribeEvent
	public void onRegisterItemEvent(RegistryEvent.Register<Item> event)
	{
		ModBlocks.registerItemblock(event.getRegistry());
		ModItems.register = event.getRegistry();
		
		ModItems.initialization();
	}
}
