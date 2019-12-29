package com.allenodden.minecraft.samplelayers;

import com.allenodden.minecraft.samplelayers.items.GoldLure;
import com.allenodden.minecraft.samplelayers.items.SilverLure;
import com.allenodden.minecraft.samplelayers.proxy.BaseProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = SampleLayers.MOD_ID,
        name = SampleLayers.MOD_NAME,
        version = SampleLayers.VERSION
)
public class SampleLayers {

    public static final String MOD_ID = "samplelayers";
    public static final String MOD_NAME = "SampleLayers";
    public static final String VERSION = "2019.2-1.3.1";

    @SidedProxy(serverSide = "com.allenodden.minecraft.samplelayers.proxy.BaseProxy", clientSide = "com.allenodden.minecraft.samplelayers.proxy.ClientProxy")
    public static BaseProxy proxy;

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static SampleLayers INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
        public static final GoldLure gold_lure = null;
        public static final SilverLure silver_lure = null;
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new GoldLure().setRegistryName(MOD_ID, "gold_lure").setUnlocalizedName("gold_lure"));
            event.getRegistry().register(new SilverLure().setRegistryName(MOD_ID, "silver_lure").setUnlocalizedName("silver_lure"));
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
        }
    }
}
