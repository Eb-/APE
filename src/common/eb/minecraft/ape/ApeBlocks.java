package eb.minecraft.ape;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;
import eb.minecraft.ape.blocks.*;

public class ApeBlocks
{
	// blocks
	public static Item Barrel;
	public static Item CauldronApe;
	
	// ID's
	public static int barrelID;
	public static int cauldronID;
	
	public static void getBlockIDs(FMLPreInitializationEvent event)
	{
		// Creating our Configuration Object
					Configuration config =  new Configuration(event.getSuggestedConfigurationFile());
					// Loading Configuration
					config.load();
					
					// Getting ID's or setting if none defined / already occupied.
					barrelID = config.getItem("Barrel", 500).getInt();
					cauldronID= config.getItem("CauldronApe", 501).getInt();
					
					// Saving Configuration
					config.save();
	}
	
	public static void initBlocks()
	{
		
	}
	
	
}
