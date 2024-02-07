package com.songro.oneperm.role.fisher.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SetFishItem implements Listener {

    @EventHandler
    public void onFishSetItem(PlayerFishEvent e) {
        if(e.getCaught() instanceof Item) {
            Item caughtItem = (Item) e.getCaught();

            switch (caughtItem.getItemStack().getType()) {
                case COD:
                    ItemStack customCod = caughtItem.getItemStack();
                    ItemMeta codMeta = customCod.getItemMeta();

                    codMeta.setDisplayName(ChatColor.GRAY + "생 대구");
                    ArrayList<String> codLore = new ArrayList<>();
                    codLore.add(ChatColor.GRAY + "전혀 익히지 않은 생 대구이다.");
                    codLore.add("");
                    codLore.add(ChatColor.GRAY + "[ 팔시: 15000원 ]");
                    codLore.add(ChatColor.GRAY + "[ 등급: 일반 ]");
                    codMeta.setLore(codLore);

                    customCod.setItemMeta(codMeta);
                    break;

                case PUFFERFISH:
                    ItemStack pufferFIsh = caughtItem.getItemStack();
                    ItemMeta pufferMeta = pufferFIsh.getItemMeta();

                    pufferMeta.setDisplayName(ChatColor.YELLOW + "복어");
                    ArrayList<String> pufferLore = new ArrayList<>();
                    pufferLore.add(ChatColor.GRAY + "...*carrot*");
                    pufferLore.add("");
                    pufferLore.add(ChatColor.GRAY + "[ 팔시: 25000원 ]");
                    pufferLore.add(ChatColor.YELLOW + "[ 등급: 고급 ]");
                    pufferMeta.setLore(pufferLore);

                    pufferFIsh.setItemMeta(pufferMeta);
                    break;

                case SALMON:
                    ItemStack salmon = caughtItem.getItemStack();
                    ItemMeta salmonMeta = salmon.getItemMeta();

                    salmonMeta.setDisplayName(ChatColor.GREEN + "생 연어");
                    ArrayList<String> salmonLore = new ArrayList<>();
                    salmonLore.add(ChatColor.GRAY + "연어는 집에 돌아가고 싶데요");
                    salmonLore.add("");
                    salmonLore.add(ChatColor.GRAY + "[ 팔시: 20000원 ]");
                    salmonLore.add(ChatColor.GREEN + "[ 등급: 일반+ ]");
                    salmonMeta.setLore(salmonLore);

                    salmon.setItemMeta(salmonMeta);
                    break;

                case TROPICAL_FISH:
                    ItemStack tropical = caughtItem.getItemStack();
                    ItemMeta tropicalItemMeta = tropical.getItemMeta();

                    tropicalItemMeta.setDisplayName(ChatColor.AQUA + "열대어");
                    ArrayList<String> tropicalLore = new ArrayList<>();
                    tropicalLore.add(ChatColor.GRAY + "말이 열대어지 실제론 종류가 하나");
                    tropicalLore.add("");
                    tropicalLore.add(ChatColor.GRAY + "[ 팔시: 30000원 ]");
                    tropicalLore.add(ChatColor.AQUA + "[ 등급: 레어 ]");
                    tropicalItemMeta.setLore(tropicalLore);

                    tropical.setItemMeta(tropicalItemMeta);
                    break;
            }
        }
    }

}