package com.songro.oneperm.util;

import org.bukkit.entity.Item;

import java.lang.reflect.Field;

public class maxStack {
    public void modifyMaxStack(Item item, int amount) {
        try {
            Field f = Item.class.getDeclaredField("maxStackSize");
            f.setAccessible(true);
            f.setInt(item, amount);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
