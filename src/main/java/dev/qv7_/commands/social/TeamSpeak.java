package dev.qv7_.commands.social;

import dev.qv7_.KotHub;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class TeamSpeak implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "ts.praxi.com");
        return false;
    }
}
