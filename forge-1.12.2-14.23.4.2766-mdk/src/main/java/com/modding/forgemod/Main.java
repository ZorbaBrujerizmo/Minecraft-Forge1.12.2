package com.modding.forgemod;

import com.modding.forgemod.init.ModBlocks;
import com.modding.forgemod.proxy.CommonProxy;
import com.modding.forgemod.registry.RegisterEvent;
import com.modding.forgemod.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.NAME)
public class Main
{	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.initialization();
		CommonProxy.registerEvent(new RegisterEvent());
		
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
}
