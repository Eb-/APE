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
// APE Imports
import eb.minecraft.ape.ApeItems;

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
			// Getting Block and Item ID's from config
			ApeBlocks.getBlockIDs(event);
			ApeItems.getItemIDs(event);
		}
		
		@Init
		public void load(FMLInitializationEvent event) 
		{
			// Initializing Blocks and Items
			ApeBlocks.initBlocks();
			ApeItems.initItems();
			
			proxy.registerRenderers();
		}
		
		@PostInit
		public void postInit(FMLPostInitializationEvent event) 
		{
			// Stub Method	
		}

		
		// Misc
		
}