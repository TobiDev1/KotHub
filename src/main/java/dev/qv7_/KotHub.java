package dev.qv7_;

import dev.qv7_.commands.Author;
import dev.qv7_.commands.social.*;
import dev.qv7_.file.ConfigHandler;
import dev.qv7_.listeners.DeveloperListener;
import dev.qv7_.listeners.EnderButtListener;
import dev.qv7_.listeners.PlayerListener;
import dev.qv7_.listeners.WorldListener;
import dev.qv7_.scoreboard.ScoreBoardProvider;
import dev.qv7_.scoreboard.assamble.Assemble;
import dev.qv7_.scoreboard.assamble.AssembleStyle;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class KotHub extends JavaPlugin {

    public static KotHub inst;
    private ConfigHandler ScoreBoardYML;
    private ConfigHandler ConfigYML;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        // LISTENERS

        registerListeners();
        registerCommands();
        registerScoreboard();
        registerFiles();

        // CONSOLE MESSAGE

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Loading plugin...");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD + "=========================");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Plugin Name: KotPlugin");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Version: 1.0-SNAPSHOT");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Author: 7qv_#0001");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD + "=========================");
    }

    @Override
    public void onDisable() {
       
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new DeveloperListener(), this);
        getServer().getPluginManager().registerEvents(new EnderButtListener(), this);
        getServer().getPluginManager().registerEvents(new WorldListener(), this);
    }

    public void registerCommands() {
        getCommand("author").setExecutor(new Author());
        getCommand("website").setExecutor(new WebSite());
        getCommand("twitter").setExecutor(new Twitter());
        getCommand("teamspeak").setExecutor(new TeamSpeak());
        getCommand("store").setExecutor(new Store());
        getCommand("discord").setExecutor(new Discord());
    }

    public void registerScoreboard() {
        // Start Instance.
        Assemble assemble = new Assemble(this, new ScoreBoardProvider());

        // Set Interval (Tip: 20 ticks = 1 second).
        assemble.setTicks(2);

        // Set Style (Tip: Viper Style starts at -1 and goes down).
        assemble.setAssembleStyle(AssembleStyle.VIPER);
    }

    public void registerFiles() {
        this.ScoreBoardYML = new ConfigHandler(this, "scoreboard", getDataFolder().getAbsolutePath());
        this.ConfigYML = new ConfigHandler(this, "config", getDataFolder().getAbsolutePath());
    }

    public static KotHub getInst() {
        return inst;
    }

}
