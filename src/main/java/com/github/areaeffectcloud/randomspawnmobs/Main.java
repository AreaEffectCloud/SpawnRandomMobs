package com.github.areaeffectcloud.randomspawnmobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main mainclass;
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new RandomSpawnMobs(), this);

        mainclass = this;
        plugin = this;

        saveResource("entities.yml", false);
        File entitiesYml = new File(plugin.getDataFolder() + File.separator + "entities.yml");
        FileConfiguration entitiesConfig = YamlConfiguration.loadConfiguration(entitiesYml);

        try {
            entitiesConfig.save(entitiesYml);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
