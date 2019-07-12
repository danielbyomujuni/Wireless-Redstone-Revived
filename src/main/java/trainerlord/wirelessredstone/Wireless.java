package trainerlord.wirelessredstone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import trainerlord.wirelessredstone.lists.BlockList;
import trainerlord.wirelessredstone.lists.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.state.*;

@Mod("wirelessredstone")
public class Wireless {
	
	public static Wireless instance;
	public static final String modid = "wirelessredstone";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public Wireless()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered.");
	}
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegistries method registered.");
	}
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegisteryEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					ItemList.wirelessReciverBlock = new BlockItem(BlockList.wirelessReciver, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(BlockList.wirelessReciver.getRegistryName()),
					ItemList.wirelessTransmitterBlock = new BlockItem(BlockList.wirelessTransmitter, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(BlockList.wirelessTransmitter.getRegistryName())

			);
			logger.info("Items Registered");
		}
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					BlockList.wirelessReciver = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f)).setRegistryName(location("wirelessreciver")),
					BlockList.wirelessTransmitter = new TranmitterHandler()
					);
			logger.info("Blocks Registered");
		}
		
		
		
		
	}
	
	private static ResourceLocation location(String name) {
		return new ResourceLocation(modid, name);
	}
	

	
	
}
