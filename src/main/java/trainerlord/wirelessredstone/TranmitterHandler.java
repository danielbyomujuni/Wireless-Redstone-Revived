package trainerlord.wirelessredstone;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.block.state.*;
import net.minecraft.block.BlockState;
public class TranmitterHandler extends Block {

	public TranmitterHandler() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(2.0f,3.0f)
				
				);
		setRegistryName("wirelesstransmitter");
		
	}

	
	
}
