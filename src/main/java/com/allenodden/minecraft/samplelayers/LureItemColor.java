package com.allenodden.minecraft.samplelayers;

import com.allenodden.minecraft.samplelayers.items.ItemLure;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import java.awt.*;

/**
 * This is what actually applies the tint to the items
 */
public class LureItemColor implements IItemColor {
    public static final LureItemColor INSTANCE = new LureItemColor();

    /**
     * In this case, we are pulling the specific color from the TypeEnum in ItemLure
     */
    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        //switch based on the layer in the model file. Layer 0 is handled by the default case
        switch (tintIndex) {
            default:
                return Color.WHITE.getRGB();
            case 1:
                return ItemLure.EnumType.values()[stack.getMetadata()].getRenderColour().getRGB();
        }
    }
}
