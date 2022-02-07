package dev.qv7_.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class DeveloperListener implements Listener {

    @EventHandler
    public void onJoinDev(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        if (p.getName().equals("7qv_")) {
            p.sendMessage(ChatColor.LIGHT_PURPLE + "This server is using KotHub");
            p.sendMessage(ChatColor.BOLD + "----------------------------");
            p.sendMessage("");
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Plugin Name: KotHub");
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Plugin Version: 1.0.0");
            p.sendMessage("");
            p.sendMessage(ChatColor.BOLD + "----------------------------");
        }

    }

}
