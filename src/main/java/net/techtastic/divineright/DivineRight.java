package net.techtastic.divineright;

import net.fabricmc.api.ModInitializer;
import net.techtastic.divineright.block.ModBlocks;
import net.techtastic.divineright.block.entity.ModBlockEntities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivineRight implements ModInitializer {
	public static final String MOD_ID = "divineright";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

	}
}
