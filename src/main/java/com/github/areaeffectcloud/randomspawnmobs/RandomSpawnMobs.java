package com.github.areaeffectcloud.randomspawnmobs;

import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.util.List;
import java.util.Random;

public class RandomSpawnMobs implements Listener {

    @EventHandler
    public void RandomBlock(BlockBreakEvent e) {

        File entitiesYml = new File(Main.plugin.getDataFolder() + File.separator + "entities.yml");
        FileConfiguration entitiesConfig = YamlConfiguration.loadConfiguration(entitiesYml);
        List<String> list = entitiesConfig.getStringList("entities");

        Player player = e.getPlayer();
        Block block = e.getBlock();
        Random random = new Random();
        String toSpawn = list.get(random.nextInt(list.size()));

        player.getWorld().spawnEntity(block.getLocation(), EntityType.valueOf(toSpawn));
    }
}
