package eb.minecraft.ape;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
// forge imports
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;


@Mod(modid="APE", name="Alcohol, Potions, and Enchantments", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)

public class Ape 
{
	// The instance of your mod that Forge uses.
		@Instance("APE")
		public static Ape instance;
		
		// Says where the client and server 'proxy' code is loaded.
		@SidedProxy(clientSide="eb.minecraft.ape.client.ClientProxy", serverSide="eb.minecraft.ape.CommonProxy")
		public static CommonProxy proxy;
		
		@PreInit
		public void preInit(FMLPreInitializationEvent event) 
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
		
		@Init
		public void load(FMLInitializationEvent event) 
		{
			// Initializing Blocks
			
			// Initializing Items, for dusts we set their sprite index here
			mortarAndPestle = (new ItemMortarAndPestle(mortarAndPestleID));
			gemDust = (new ItemGemDust(gemDustID));
			
			// Adding to the Language Registry
			LanguageRegistry.addName(new ItemStack(mortarAndPestle), "Mortar and Pestle");
			LanguageRegistry.addName(new ItemStack(gemDust), "Gem Dust");
			
			// Multi-Item Initialization
			
			final String[] dustNames = 
				{
					"Agate", "Amethyst",  "Beryl", "Diamond", "Emerald", "Garnet",
					"Jade", "Jasper", "Opal", "Ruby", "Sapphire", "Topaz", "Tourmaline"
				};
			
			for (int ix = 0; ix < 12; ix++)
			{
				ItemStack gemDustIS = new ItemStack(gemDust, 1, ix);
				LanguageRegistry.addName(gemDustIS, dustNames[gemDustIS.getItemDamage()] + " Dust");
			}
			
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
				
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),0)), new ItemStack(Ape.mortarAndPestle,1,-1), gemAgateIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),1)), new ItemStack(Ape.mortarAndPestle,1,-1), gemAmethystIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),2)), new ItemStack(Ape.mortarAndPestle,1,-1), gemBerylIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),3)), new ItemStack(Ape.mortarAndPestle,1,-1), gemDiamondIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),4)), new ItemStack(Ape.mortarAndPestle,1,-1), gemEmeraldIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),5)), new ItemStack(Ape.mortarAndPestle,1,-1), gemGarnetIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),6)), new ItemStack(Ape.mortarAndPestle,1,-1), gemJadeIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),7)), new ItemStack(Ape.mortarAndPestle,1,-1), gemJasperIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),8)), new ItemStack(Ape.mortarAndPestle,1,-1), gemOpalIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),9)), new ItemStack(Ape.mortarAndPestle,1,-1), gemRubyIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),10)), new ItemStack(Ape.mortarAndPestle,1,-1), gemSapphireIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),11)), new ItemStack(Ape.mortarAndPestle,1,-1), gemTopazIS);
				GameRegistry.addShapelessRecipe((new ItemStack(gemDust,(int)Math.pow(2, ix),12)), new ItemStack(Ape.mortarAndPestle,1,-1), gemTourmalineIS);
			}
			
			proxy.registerRenderers();
		}
		
		@PostInit
		public void postInit(FMLPostInitializationEvent event) 
		{
			// Stub Method	
		}
		
		// ID's
		public static int mortarAndPestleID;
		public static int gemDustID;
		
		// Blocks
		
		// Items
		public static Item mortarAndPestle;
		public static Item gemDust;
		
		
		// Misc
		
}