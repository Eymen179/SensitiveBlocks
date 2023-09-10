package org.eymen179.sensitiveblocks;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.eymen179.sensitiveblocks.ChainBreak.ChainBreakListener;
import org.eymen179.sensitiveblocks.GlassBreak.GlassBreakListener;
import org.eymen179.sensitiveblocks.PotBreak.PotBreakListener;
//My First Plugin
public final class SensitiveBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" +ChatColor.AQUA + "SensitiveBlocks" + ChatColor.GREEN+ "]" + ChatColor.WHITE + " The plugin has started.");

        getServer().getPluginManager().registerEvents(new GlassBreakListener(this), this);
        getServer().getPluginManager().registerEvents(new PotBreakListener(this), this);
        getServer().getPluginManager().registerEvents(new ChainBreakListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" +ChatColor.AQUA + "SensitiveBlocks" + ChatColor.GREEN+ "]" + ChatColor.WHITE + " The plugin has stopped.");
    }
}
