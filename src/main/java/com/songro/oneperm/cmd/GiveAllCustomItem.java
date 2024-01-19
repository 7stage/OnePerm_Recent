package com.songro.oneperm.cmd;

import com.songro.oneperm.item.CopBulletProof;
import com.songro.oneperm.item.CopCustomItem;
import com.songro.oneperm.item.FirefighterCustomItem;
import com.songro.oneperm.item.MarriageRing;
import com.songro.oneperm.item.weapon.Grenade;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveAllCustomItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player)commandSender;

        if(player.isOp()) {
            CopCustomItem.giveCopItem(player);
            FirefighterCustomItem.giveFireItem(player);
            CopBulletProof.giveItem(player);
            Grenade.giveItem(player);
            //Glock.giveCstWeapon(player);
            MarriageRing.giveItem(player);
        }

        return true;
    }
}
