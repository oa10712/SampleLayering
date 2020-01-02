package com.allenodden.minecraft.samplelayers;

import com.allenodden.minecraft.samplelayers.items.GoldLure;
import com.allenodden.minecraft.samplelayers.items.ItemLure;
import com.allenodden.minecraft.samplelayers.items.SilverLure;
import com.pixelmonmod.pixelmon.enums.EnumType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        SampleLayers.MOD_ID
)
public class SampleLayers {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "samplelayers";
    public static final String MOD_NAME = "SampleLayers";
    public static final String VERSION = "2019.2-1.3.1";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    public static SampleLayers INSTANCE;

    public SampleLayers() {

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        INSTANCE = this;
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // register all of the Lures to use a custom color for all layers other than 0. We get this color via the getColor method in ItemLure
        Minecraft.getInstance().getItemColors().register((stack, layer) -> {
                    return layer > 0 ? -1 : ((ItemLure) stack.getItem()).getColor(stack);
                }, Items.silver_lure_normal, Items.silver_lure_fire, Items.silver_lure_water, Items.silver_lure_electric,
                Items.silver_lure_grass, Items.silver_lure_ice, Items.silver_lure_fighting, Items.silver_lure_poison,
                Items.silver_lure_flying, Items.silver_lure_ground, Items.silver_lure_psychic, Items.silver_lure_bug,
                Items.silver_lure_rock, Items.silver_lure_ghost, Items.silver_lure_dragon, Items.silver_lure_dark,
                Items.silver_lure_steel, Items.silver_lure_fairy, Items.silver_lure_xxx,
                Items.gold_lure_normal, Items.gold_lure_fire, Items.gold_lure_water, Items.gold_lure_electric,
                Items.gold_lure_grass, Items.gold_lure_ice, Items.gold_lure_fighting, Items.gold_lure_poison,
                Items.gold_lure_flying, Items.gold_lure_ground, Items.gold_lure_psychic, Items.gold_lure_bug,
                Items.gold_lure_rock, Items.gold_lure_ghost, Items.gold_lure_dragon, Items.gold_lure_dark,
                Items.gold_lure_steel, Items.gold_lure_fairy, Items.gold_lure_xxx);
    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @ObjectHolder(MOD_ID)
    public static class Blocks {
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name. You may want to store these in a List rather than all 38 individually.
     */
    @ObjectHolder(MOD_ID)
    public static class Items {
        public static final GoldLure gold_lure_normal = null;
        public static final GoldLure gold_lure_fire = null;
        public static final GoldLure gold_lure_water = null;
        public static final GoldLure gold_lure_electric = null;
        public static final GoldLure gold_lure_grass = null;
        public static final GoldLure gold_lure_ice = null;
        public static final GoldLure gold_lure_fighting = null;
        public static final GoldLure gold_lure_poison = null;
        public static final GoldLure gold_lure_flying = null;
        public static final GoldLure gold_lure_ground = null;
        public static final GoldLure gold_lure_psychic = null;
        public static final GoldLure gold_lure_bug = null;
        public static final GoldLure gold_lure_rock = null;
        public static final GoldLure gold_lure_ghost = null;
        public static final GoldLure gold_lure_dragon = null;
        public static final GoldLure gold_lure_dark = null;
        public static final GoldLure gold_lure_steel = null;
        public static final GoldLure gold_lure_fairy = null;
        public static final GoldLure gold_lure_xxx = null;

        public static final SilverLure silver_lure_normal = null;
        public static final SilverLure silver_lure_fire = null;
        public static final SilverLure silver_lure_water = null;
        public static final SilverLure silver_lure_electric = null;
        public static final SilverLure silver_lure_grass = null;
        public static final SilverLure silver_lure_ice = null;
        public static final SilverLure silver_lure_fighting = null;
        public static final SilverLure silver_lure_poison = null;
        public static final SilverLure silver_lure_flying = null;
        public static final SilverLure silver_lure_ground = null;
        public static final SilverLure silver_lure_psychic = null;
        public static final SilverLure silver_lure_bug = null;
        public static final SilverLure silver_lure_rock = null;
        public static final SilverLure silver_lure_ghost = null;
        public static final SilverLure silver_lure_dragon = null;
        public static final SilverLure silver_lure_dark = null;
        public static final SilverLure silver_lure_steel = null;
        public static final SilverLure silver_lure_fairy = null;
        public static final SilverLure silver_lure_xxx = null;
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            for (EnumType type : EnumType.getAllTypes()) {
                event.getRegistry().register(new GoldLure(new Item.Properties().group(ItemGroup.MISC), type)
                        .setRegistryName(MOD_ID, "gold_lure_" + type.getName().toLowerCase().replace('?', 'x')));
                event.getRegistry().register(new SilverLure(new Item.Properties().group(ItemGroup.MISC), type)
                        .setRegistryName(MOD_ID, "silver_lure_" + type.getName().toLowerCase().replace('?', 'x')));
            }
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
        }
    }
}
