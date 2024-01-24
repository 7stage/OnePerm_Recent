package com.songro.oneperm.cmd.debug;

import com.songro.oneperm.OnePerm;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetGroupFromPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player)commandSender;
        LuckPerms api = OnePerm.plugin.api;
        User usrAPI = api.getUserManager().getUser(p.getName());

        assert usrAPI != null;
        p.sendMessage("usr prim group" + usrAPI.getPrimaryGroup());

        return true;
    }
}
