package dev.qv7_.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class Author implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.BOLD + "----------------------------");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Plugin Name: KotHub");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Plugin Version: 1.0.0");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Author: 7qv_");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Discord: 7qv_#0001");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.BOLD + "----------------------------");
        return false;
    }
}
