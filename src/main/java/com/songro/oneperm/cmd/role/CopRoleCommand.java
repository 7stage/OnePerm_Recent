package com.songro.oneperm.cmd.role;

/*
INFO: just testing
 */

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CopRoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        if(strings.length != 0) {
            if (strings[0].equalsIgnoreCase("채용")) {
                Player t = Bukkit.getPlayer(strings[1]);

                if (t != null) {
                    try {
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".cop", true);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().set(t.getName() + ".bank", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        p.sendMessage(ChatColor.GREEN + "[ONEPERM] " + t.getName() + " 님을 " + " 채용하였습니다.");
                        p.sendMessage(ChatColor.YELLOW + "[ONEPERM] " + t.getName() + "님은 현재 부서가 지정되지 않았습니다! '/(police/경찰) 부서 추가' 명령어를 이용해 부서를 추가하세요.");
                    } catch (IOException e) {
                        p.sendMessage(ChatColor.RED + "[ONEPERM] 에러가 발생했습니다\n[ONEPERM] " + e.getMessage());
                    }
                } else {
                    p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어가 존재하지 않거나, 서버에 들어온적이 없습니다.");
                }
            } else if(strings[0].equalsIgnoreCase("부서")) {
                Player t = Bukkit.getPlayer(strings[1]);

                if(strings[1].length() != 0) {
                    if(strings[1].equalsIgnoreCase("추가")) {
                        if(strings[2].length() != 0) {
                            assert t != null;

                            switch(strings[2]) {
                                // im in danger
                                case "치안총감":
                                    t.addAttachment(OnePerm.plugin, "role.cop.superintendent", true);
                                    OnePerm.plugin.getCustomConfig().set(t.getName() + ".data.department", "치안총감");
                                    try {
                                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                                    } catch (IOException e) {
                                        p.sendMessage(ChatColor.RED + "CRITICAL: COULDN'T SAVE FILE CAUSE OF: IOEXCEPTION OCCURRED\nCRITICAL: CAUSED PLUGIN: OnePerm\nCRITICAL: " + e.getLocalizedMessage());
                                    }

                                case "치안정감":
                                    t.addAttachment(OnePerm.plugin, "role.cop.sensesecurity", true);
                                    OnePerm.plugin.getCustomConfig().set(t.getName() + ".data.department", "치안정감");
                                    try {
                                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                                    } catch (IOException e) {
                                        p.sendMessage(ChatColor.RED + "CRITICAL: COULDN'T SAVE FILE CAUSE OF: IOEXCEPTION OCCURRED\nCRITICAL: CAUSED PLUGIN: OnePerm\nCRITICAL: " + e.getLocalizedMessage());
                                    }

                                default:
                                    t.addAttachment(OnePerm.plugin, "role.cop.cop", true);
                                    OnePerm.plugin.getCustomConfig().set(t.getName() + ".data.department", "순경");
                                    try {
                                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                                    } catch (IOException e) {
                                        p.sendMessage(ChatColor.RED + "CRITICAL: COULDN'T SAVE FILE CAUSE OF: IOEXCEPTION OCCURRED\nCRITICAL: CAUSED PLUGIN: OnePerm\nCRITICAL: " + e.getLocalizedMessage());
                                    }
                            }
                        } else {
                            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 추가 명령어가 없습니다.");
                            return false;
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 추가 명령어가 없습니다.");
                    return false;
                }
            } else if(strings[0].equalsIgnoreCase("확성기")) {
                if(strings[1].length() != 0) {
                    String line = strings[1];

                    Bukkit.broadcast(ChatColor.AQUA + "[ 확성기 : 경찰 ]" + line, "role.cop");
                } else {
                    p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 추가 명령어가 없습니다.");
                    return false;
                }
            } else {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 추가 명령어가 없습니다.");
                return false;
            }
        } else {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 추가 명령어가 없습니다.");
            return false;
        }

        return true;
    }
}
