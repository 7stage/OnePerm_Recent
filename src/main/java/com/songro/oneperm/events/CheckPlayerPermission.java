package com.songro.oneperm.events;

import com.songro.oneperm.OnePerm;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CheckPlayerPermission implements Listener {

    @EventHandler
    public void playerPermission(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        OnePerm.plugin.getServer().getScheduler().runTaskTimer(OnePerm.plugin, () -> checkPlayerPerm(player), 0, 10);
    }

    public void checkPlayerPerm(Player player) {
        if(player.hasPermission("role.op")) {
            player.setDisplayName(ChatColor.RED + "[ 관리자 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.RED + "[ 관리자 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.cop")) {
            if(player.hasPermission("role.cop.cheif")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰총감 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰총감 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.superintendent")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 치안총감 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 치안총감 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.intendent")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 총경 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 총경 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.alleviation")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 경감 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 경감 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.inspector")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 경위 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 경위 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.lightsuit")) {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 경장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 경장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.cop.cop")) {
                player.setDisplayName(ChatColor.AQUA + "[ 순경 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 순경 ] " + ChatColor.WHITE + player.getName());
            } else {
                player.setDisplayName(ChatColor.AQUA + "[ 경찰 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.AQUA + "[ 경찰 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.default")) {
            player.setDisplayName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.guide")) {
            player.setDisplayName(ChatColor.DARK_PURPLE + "[ 가이드 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 가이드 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.mafia")) {
            if(player.hasPermission("role.mafia.boss")) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 보스 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 보스 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.mafia.deputyboss")) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 부보스 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 부보스 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.mafia.cadre")) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 간부 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 간부 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.mafia.maifa")) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.maifa.mafiasibo")) {
                player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 시보 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 시보 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.fire")) {
            if(player.hasPermission("role.fire.cheif")) {
                player.setDisplayName(ChatColor.RED + "[ 소방청장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.RED + "[ 소방청장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.fire.leader")) {
                player.setDisplayName(ChatColor.RED + "[ 소방팀장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.RED + "[ 소방팀장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.fire.fighter")) {
                player.setDisplayName(ChatColor.RED + "[ 소방관 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.RED + "[ 소방관 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.broadcast")) {
            if(player.hasPermission("role.broadcast.leader")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 원장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 원장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.deputyleader")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 부원장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 부원장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.director")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 부장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 부장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.conductor")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 차장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 차장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.headsection")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 과장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 과장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.surrogate")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 대리 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 대리 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.cheif")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 주임 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 주임 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.broadcast.employee")) {
                player.setDisplayName(ChatColor.GOLD + "[ 방송관 사원 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.GOLD + "[ 방송관 사원 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.law")) {
            if(player.hasPermission("role.law.chiefjustice")) {
                player.setDisplayName(ChatColor.DARK_PURPLE + "[ 판사 대법원장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 판사 대법원장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.law.chancellor")) {
                player.setDisplayName(ChatColor.DARK_PURPLE + "[ 판사 대법관 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 판사 대법관 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.law.cheifjudge")) {
                player.setDisplayName(ChatColor.DARK_PURPLE + "[ 부장판사 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 부장판사 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.law.reputable")) {
                player.setDisplayName(ChatColor.DARK_PURPLE + "[ 평판사 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 평판사 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.law.judgepoetry")) {
                player.setDisplayName(ChatColor.DARK_PURPLE + "[ 판사 시보 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 판사 시보 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.student")) { // student
            player.setDisplayName(ChatColor.DARK_GREEN + "[ 학생 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.DARK_GREEN + "[ 학생 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.prosector")) {
            if(player.hasPermission("role.prosector.general")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 총장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 총장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.prosector.cheifinspection")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 검사장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 검사장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.prosector.chief")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 부장검사 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 부장검사 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.prosector.deputychief")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 부부장검사 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 부부장검사 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.prosector.audit")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 검사 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 검사 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.prosector.inspection")) {
                player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 검사시보 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 검사시보 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.cityhall")) {
            player.setDisplayName(ChatColor.DARK_AQUA + "[ 시청 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.DARK_AQUA + "[ 시청 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.execution")) {
            if(player.hasPermission("role.execution.committee")) {
                player.setDisplayName(ChatColor.DARK_RED + "[ 집행위원회 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_RED + "[ 집행위원회 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.execution.chairmen")) {
                player.setDisplayName(ChatColor.DARK_RED + "[ 집행위원장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.DARK_RED + "[ 집행위원장 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.election")) {
            player.setDisplayName(ChatColor.LIGHT_PURPLE + "[ 선거위원회 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.LIGHT_PURPLE + "[ 선거위원회 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.colleage")) {
            if(player.hasPermission("role.colleage.leader")) {
                player.setDisplayName(ChatColor.BLUE + "[ 대학교장 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.BLUE + "[ 대학교장 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.colleage.student")) {
                player.setDisplayName(ChatColor.BLUE + "[ 대학교원 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.BLUE + "[ 대학교원 ] " + ChatColor.WHITE + player.getName());
            }
        } else if (player.hasPermission("role.bank")) {
            if(player.hasPermission("role.bank.president")) {
                player.setDisplayName(ChatColor.YELLOW + "[ 은행 총재 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.YELLOW + "[ 은행 총재 ] " + ChatColor.WHITE + player.getName());
            } else if(player.hasPermission("role.bank.plan")) {
                player.setDisplayName(ChatColor.YELLOW + "[ 은행 부총재 ] " + ChatColor.WHITE + player.getName());
                player.setPlayerListName(ChatColor.YELLOW + "[ 은행 부총재 ] " + ChatColor.WHITE + player.getName());
            }
        }
    }
}
