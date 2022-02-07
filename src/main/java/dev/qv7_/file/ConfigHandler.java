package dev.qv7_.file;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class ConfigHandler extends YamlConfiguration {

    /* File */
    private File file;
    /* Strings */
    @SuppressWarnings("unused")
    private String name, directory;

    /**
     * Bukkit Configuration Class
     *
     * @param name - Is the identifier for the configuration file and object.
     * @param directory - Directory.
     */
    public ConfigHandler(JavaPlugin plugin, String name, String directory){
        /* Set the Name */
        setName(name);
        /* Set the Directory */
        setDirectory(directory);
        /* Set File */
        file = new File(directory, name + ".yml");
        /* If file does not already exist, then grab it internally from the resources folder */
        if (!file.exists()) {
            plugin.saveResource(name + ".yml", false);
        }
        load();
        save();
        // OLD YamlConfiguration.loadConfiguration(this.getFile());
    }

    public void load() {
        /* Load the files configuration */
        try {
            this.load(this.file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the configuration file from memory to storage
     */
    public void save() {
        try {
            this.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Configuration getConfiguration() {
        return this;
    }

    public void setFile(final File file) {
        this.file = file;
    }
    public void setDirectory(final String directory) {
        this.directory = directory;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void reloadConfiguration(){
        YamlConfiguration.loadConfiguration(file);
    }
}