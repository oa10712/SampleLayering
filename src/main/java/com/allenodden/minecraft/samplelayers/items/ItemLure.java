package com.allenodden.minecraft.samplelayers.items;

import com.pixelmonmod.pixelmon.enums.EnumType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLure extends Item {
    EnumType type;

    public ItemLure(Properties properties, EnumType type) {
        super(properties);
        this.type = type;
    }

    public EnumType getType() {
        return type;
    }

    public int getColor(ItemStack stack) {
        return type.getColor();
    }
}
