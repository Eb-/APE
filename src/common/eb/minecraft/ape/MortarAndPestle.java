package eb.minecraft.ape;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class MortarAndPestle extends Item
{
	public MortarAndPestle(int id)
	{
		super(id);
		
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabTools);
		setIconIndex(0);
		setItemName("Mortar and Pestle");
		setMaxDamage(15 - 1);
		setContainerItem(this);
		setNoRepair();
	}

	
	@Override 
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
	{ 
		return false;
	}
	  
	  
	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack)
	{
		itemStack.setItemDamage(itemStack.getItemDamage() + 1);
		return itemStack;
	}

	public String getTextureFile () {
		return CommonProxy.ITEMS_PNG;
	}
}
