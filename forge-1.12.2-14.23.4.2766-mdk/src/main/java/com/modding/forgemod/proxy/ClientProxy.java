package com.modding.forgemod.proxy;

import com.modding.forgemod.proxy.renders.BlockRendering;
import com.modding.forgemod.proxy.renders.ItemRendering;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		registerEvent(new BlockRendering());
		registerEvent(new ItemRendering());
	}
	
	@Override
	public void init()
	{
		
	}
	
	@Override
	public void postInit()
	{
		
	}
}
