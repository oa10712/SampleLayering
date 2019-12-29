package com.allenodden.minecraft.samplelayers.items;

import com.allenodden.minecraft.samplelayers.SampleLayers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class ItemLure extends Item {
    public ItemLure() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    // add a subitem for each item we want to appear in the creative tab
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (EnumType type : EnumType.values()) {
            ItemStack subItemStack = new ItemStack(this, 1, type.meta);
            subItems.add(subItemStack);
        }
    }

    /**
     * This way of setting names allows us to merge a bunch of similar entries in the lang file.
     * In this case, it nearly halves the number of entries, as there is 1 entry per type, and 1 each for gold and silver; instead of the usual 1 per combo
     */
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        int metadata = stack.getMetadata();

        EnumType type = EnumType.values()[metadata];

        return String.format(super.getItemStackDisplayName(stack), I18n.translateToLocal(SampleLayers.MOD_ID + ".type." + type.getName()));
    }

    /**
     * I only listed 3 here for ease of reading. All the types can easily be held.
     */
    public enum EnumType implements IStringSerializable {
        WATER(0, "water", Color.BLUE),
        FIRE(1, "fire", Color.RED),
        GRASS(2, "grass", Color.GREEN);

        public int getMetadata() {
            return this.meta;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Color getRenderColour() {
            return renderColour;
        }

        private final int meta;
        private final String name;
        private final Color renderColour;

        EnumType(int i_meta, String i_name, Color i_renderColour) {
            this.meta = i_meta;
            this.name = i_name;
            this.renderColour = i_renderColour;
        }
    }
}
