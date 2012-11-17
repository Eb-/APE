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

// temp imports


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
			mortarAndPestle = (new MortarAndPestle(mortarAndPestleID));
			gemDust = (new GemDust(gemDustID));
			
			// Adding to the Language Registry
			LanguageRegistry.addName(new ItemStack(mortarAndPestle), "Mortar and Pestle");
			LanguageRegistry.addName(new ItemStack(gemDust), "Gem Dust");
			
			
			// Adding Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(Ape.gemDust, 3, 3), new ItemStack(Ape.mortarAndPestle, 1, -1), Item.diamond);
			
			// Multi-Item Initialization
			
			final String[] dustNames = 
				{
					"Agate", "Amethyst",  "Beryl", "Diamond", "Emerald", "Garnet",
					"Jade", "Jasper", "Opal", "Ruby", "Sapphire", "Topaz", "Tourmaline"
				};
			
			for (int ix = 0; ix < 12; ix++)
			{
				ItemStack gemDustIS = new ItemStack(gemDust, 1, ix);
				
				// Disabled until I get some dummy items made.
				//GameRegistry.addShapelessRecipe(gemDustIS, Ape.mortarAndPestle, ("gem" + dustNames[gemDustIS.getItemDamage()].toLowerCase() ));
				LanguageRegistry.addName(gemDustIS, dustNames[gemDustIS.getItemDamage()] + " Dust");
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