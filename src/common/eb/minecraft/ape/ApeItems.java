package eb.minecraft.ape;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import eb.minecraft.ape.items.*;

public class ApeItems
{
	// Items
	public static Item MortarAndPestle;
	public static Item GemDust;
	
	// ID's
	public static int mortarAndPestleID;
	public static int gemDustID;
	
	public static void getItemIDs(FMLPreInitializationEvent event)
	{
		// Creating our Configuration Object
					Configuration config =  new Configuration(event.getSuggestedConfigurationFile());
					// Loading Configuration
					config.load();
					
					// Getting ID's or setting if none defined / already occupied.
					mortarAndPestleID = config.getItem("MortarAndPestle", 30000).getInt();
					gemDustID= config.getItem("gemDust", 30001).getInt();
					
					/*//just a test comment
					Property comments = config.get(Configuration.CATEGORY_GENERAL, "?", "?");
					comments.comment = "This is a comment.";
					
					String lalaString = comments.value;
					*/
					
					// Saving Configuration
					config.save();
	}
	
	public static void initItems()
	{
		// Initializing Items
		MortarAndPestle = (new ItemMortarAndPestle(mortarAndPestleID));
		GemDust = (new ItemGemDust(gemDustID));
		
		// Adding to the Language Registry
		LanguageRegistry.addName(new ItemStack(MortarAndPestle), "Mortar and Pestle");
		LanguageRegistry.addName(new ItemStack(GemDust), "Gem Dust");
		
		// Gem Dust Initialization
		
		final String[] dustNames = 
			{
				"Agate", "Amethyst",  "Beryl", "Diamond", "Emerald", "Garnet",
				"Jade", "Jasper", "Opal", "Ruby", "Sapphire", "Topaz", "Tourmaline"
			};
		
		// Adding different types of gem dust into the language registry
		for (int ix = 0; ix < 12; ix++)
		{
			ItemStack gemDustIS = new ItemStack(GemDust, 1, ix);
			LanguageRegistry.addName(gemDustIS, dustNames[gemDustIS.getItemDamage()] + " Dust");
		}
		// Gems into Gem dust recipes
		for (int ix=0; ix < 5; ix++)
		{
			ItemStack gemAgateIS = new ItemStack(TFC.TFCItems.GemAgate, 1, ix);
			ItemStack gemAmethystIS = new ItemStack(TFC.TFCItems.GemAmethyst, 1, ix);
			ItemStack gemBerylIS = new ItemStack(TFC.TFCItems.GemBeryl, 1, ix);
			ItemStack gemDiamondIS = new ItemStack(TFC.TFCItems.GemDiamond, 1, ix);
			ItemStack gemEmeraldIS = new ItemStack(TFC.TFCItems.GemEmerald, 1, ix);
			ItemStack gemGarnetIS = new ItemStack(TFC.TFCItems.GemGarnet, 1, ix);
			ItemStack gemJadeIS = new ItemStack(TFC.TFCItems.GemJade, 1, ix);
			ItemStack gemJasperIS = new ItemStack(TFC.TFCItems.GemJasper, 1, ix);
			ItemStack gemOpalIS = new ItemStack(TFC.TFCItems.GemOpal, 1, ix);
			ItemStack gemRubyIS = new ItemStack(TFC.TFCItems.GemRuby, 1, ix);
			ItemStack gemSapphireIS = new ItemStack(TFC.TFCItems.GemSapphire, 1, ix);
			ItemStack gemTopazIS = new ItemStack(TFC.TFCItems.GemTopaz, 1, ix);
			ItemStack gemTourmalineIS = new ItemStack(TFC.TFCItems.GemTourmaline, 1, ix);
			
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 0)), new ItemStack(MortarAndPestle,1,-1), gemAgateIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 1)), new ItemStack(MortarAndPestle,1,-1), gemAmethystIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 2)), new ItemStack(MortarAndPestle,1,-1), gemBerylIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 3)), new ItemStack(MortarAndPestle,1,-1), gemDiamondIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 4)), new ItemStack(MortarAndPestle,1,-1), gemEmeraldIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 5)), new ItemStack(MortarAndPestle,1,-1), gemGarnetIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 6)), new ItemStack(MortarAndPestle,1,-1), gemJadeIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 7)), new ItemStack(MortarAndPestle,1,-1), gemJasperIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 8)), new ItemStack(MortarAndPestle,1,-1), gemOpalIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix), 9)), new ItemStack(MortarAndPestle,1,-1), gemRubyIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix),10)), new ItemStack(MortarAndPestle,1,-1), gemSapphireIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix),11)), new ItemStack(MortarAndPestle,1,-1), gemTopazIS);
			GameRegistry.addShapelessRecipe((new ItemStack(GemDust,(int)Math.pow(2, ix),12)), new ItemStack(MortarAndPestle,1,-1), gemTourmalineIS);
		}
	}
	
}
