package eb.minecraft.ape.client;

import net.minecraftforge.client.MinecraftForgeClient;
import eb.minecraft.ape.CommonProxy;

public class ClientProxy extends CommonProxy 
{
	
	@Override
	public void registerRenderers() 
	{
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		//MinecraftForgeClient.preloadTexture(BLOCK_PNG);
	}
}