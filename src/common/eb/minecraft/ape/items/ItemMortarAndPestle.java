package eb.minecraft.ape.items;

import eb.minecraft.ape.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemMortarAndPestle extends Item
{
	public ItemMortarAndPestle(int id)
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
