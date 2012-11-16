package eb.minecraft.ape;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class GemDust extends Item 
{
	// Dust names
	private final static String[] dustNames = 
	{
		"Agate Dust", "Amethyst Dust",  "Beryl Dust", "Diamond Dust", "Emerald Dust", "Garnet Dust",
		"Jade Dust", "Jasper Dust", "Opal Dust", "Ruby Dust", "Sapphire Dust", "Topaz Dust", "Tourmaline Dust"
	};
	
	public GemDust(int id, int spriteIndex)
	{
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setIconIndex(spriteIndex);
		setHasSubtypes(true);
		setItemName("Gem Dust");
	}

	public String getTextureFile () {
		return CommonProxy.ITEMS_PNG;
	}
	
	@Override
	public String getItemNameIS(ItemStack itemstack)
	{
		return getItemName() + "." + dustNames[itemstack.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int unknown, CreativeTabs tab, List subItems)
	{
		for (int ix = 0; ix < 12; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
	
}