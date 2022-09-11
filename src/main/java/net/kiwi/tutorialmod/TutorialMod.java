package net.kiwi.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.kiwi.tutorialmod.block.ModBlocks;
import net.kiwi.tutorialmod.item.ModItems;
import net.kiwi.tutorialmod.painting.ModPaintings;
import net.kiwi.tutorialmod.util.ModLootTableModifiers;
import net.kiwi.tutorialmod.villager.ModVillagers;
import net.kiwi.tutorialmod.world.feature.ModConfiguredFeatures;
import net.kiwi.tutorialmod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();

		ModOreGeneration.generateOres();

		ModLootTableModifiers.modifyLootTables();
	}
}
