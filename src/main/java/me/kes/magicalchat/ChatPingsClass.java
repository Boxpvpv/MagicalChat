package me.kes.magicalchat;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@RequiredArgsConstructor
public class ChatPingsClass implements Listener {
    public final MagicalChat mainplugin;

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player sender = event.getPlayer();
        String senderName = sender.getName();

        for (Player recipient : Bukkit.getOnlinePlayers()) {
            String recipientName = recipient.getName();
            if (message.toLowerCase().contains(recipientName.toLowerCase())) {
                message = message.replaceAll("(?i)" + recipientName, ChatColor.ITALIC + " " + ChatColor.AQUA + "@" +  recipientName + ChatColor.WHITE);
                recipient.playSound(recipient.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
            }
        }

        event.setMessage(message);
        Bukkit.getServer().getConsoleSender().sendMessage(senderName + message);
    }
}