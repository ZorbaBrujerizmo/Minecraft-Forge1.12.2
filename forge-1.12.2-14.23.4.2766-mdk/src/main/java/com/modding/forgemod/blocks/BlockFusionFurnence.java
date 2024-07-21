package com.modding.forgemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFusionFurnence extends Block
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public BlockFusionFurnence()
	{
		super(Material.IRON);
		
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) 
	{
		world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, player)), 2);
	}
	
	public static EnumFacing getFacingFromEntity(BlockPos pos, EntityLivingBase player)
	{
		return EnumFacing.getFacingFromVector((float)player.posX - pos.getX(), (float)player.posY - pos.getY(), (float)player.posZ - pos.getZ());
	}
	
	@Override 
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).getIndex();
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FACING);
	}
}
