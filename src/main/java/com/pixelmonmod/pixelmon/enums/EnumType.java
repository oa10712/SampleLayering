package com.pixelmonmod.pixelmon.enums;


import java.util.ArrayList;
import java.util.Collections;


public enum EnumType {
    Normal(0, "Normal", 14540253, 0.0F, 297.0F),
    Fire(1, "Fire", 16746496, 198.0F, 99.0F),
    Water(2, "Water", 5727743, 396.0F, 99.0F),
    Electric(3, "Electric", 16118348, 297.0F, 0.0F),
    Grass(4, "Grass", 54304, 99.0F, 198.0F),
    Ice(5, "Ice", 11599871, 297.0F, 198.0F),
    Fighting(6, "Fighting", 12189752, 99.0F, 99.0F),
    Poison(7, "Poison", 13174256, 99.0F, 297.0F),
    Ground(8, "Ground", 10053184, 198.0F, 198.0F),
    Flying(9, "Flying", 13424127, 297.0F, 99.0F),
    Psychic(10, "Psychic", 16733419, 198.0F, 297.0F),
    Bug(11, "Bug", 11067475, 0.0F, 0.0F),
    Rock(12, "Rock", 10712917, 297.0F, 297.0F),
    Ghost(13, "Ghost", 7089034, 0.0F, 198.0F),
    Dragon(14, "Dragon", 2830540, 198.0F, 0.0F),
    Dark(15, "Dark", 4210752, 99.0F, 0.0F),
    Steel(16, "Steel", 12369090, 396.0F, 0.0F),
    Mystery(17, "???", 3184256, 0.0F, 297.0F),
    Fairy(18, "Fairy", 16614535, 0.0F, 99.0F);


    private int index;


    private String name;


    private int color;


    public float textureX;


    public float textureY;


    EnumType(int i, String s, int c, float texX, float texY) {
        this.index = i;
        this.name = s;
        this.color = c;
        this.textureX = texX;
        this.textureY = texY;
    }


    public int getColor() {
        return this.color;
    }


    public String getName() {
        return this.name;
    }


    public static EnumType parseType(int index) {
        try {
            return values()[index];
        } catch (IndexOutOfBoundsException e) {
            return Normal;
        }
    }


    public static EnumType parseType(String name) {
        try {
            return valueOf(name);
        } catch (Exception e) {
            return Normal;
        }
    }

    public static EnumType parseOrNull(int index) {
        try {
            return values()[index];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public static ArrayList<EnumType> getAllTypes() {
        ArrayList<EnumType> list = new ArrayList<>();
        EnumType[] t = values();
        Collections.addAll(list, t);
        return list;
    }


    public int getIndex() {
        return this.index;
    }


}
