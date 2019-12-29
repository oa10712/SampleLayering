package com.allenodden.minecraft.samplelayers.proxy;

import com.allenodden.minecraft.samplelayers.LureItemColor;
import com.allenodden.minecraft.samplelayers.SampleLayers;
import com.allenodden.minecraft.samplelayers.items.ItemLure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class ClientProxy extends BaseProxy {
    public void postInit(FMLPostInitializationEvent event) {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(LureItemColor.INSTANCE, SampleLayers.Items.gold_lure);
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(LureItemColor.INSTANCE, SampleLayers.Items.silver_lure);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (ItemLure.EnumType type : ItemLure.EnumType.values()) {
            ModelLoader.setCustomModelResourceLocation(SampleLayers.Items.gold_lure,
                    type.getMetadata(),
                    new ModelResourceLocation(SampleLayers.MOD_ID + ":gold_lure", "inventory"));
            ModelLoader.setCustomModelResourceLocation(SampleLayers.Items.silver_lure,
                    type.getMetadata(),
                    new ModelResourceLocation(SampleLayers.MOD_ID + ":silver_lure", "inventory"));
        }
    }
}
