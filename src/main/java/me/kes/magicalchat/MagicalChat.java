package me.kes.magicalchat;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicalChat extends JavaPlugin {

    @Getter public ChatCooldown Chatcooldown;
    @Getter public ChatPingsClass chatPingsClass;
    String prefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "MGC" + ChatColor.GRAY + "] ";

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        Chatcooldown = new ChatCooldown(this);
        chatPingsClass = new ChatPingsClass(this);
        pm.registerEvents(Chatcooldown, this);
        pm.registerEvents(chatPingsClass, this);
        getLogger().info(this.prefix + ChatColor.GREEN + "Magical Chat Plugin has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(this.prefix + ChatColor.RED + "Magical Chat Plugin has been disabled");
    }
}
