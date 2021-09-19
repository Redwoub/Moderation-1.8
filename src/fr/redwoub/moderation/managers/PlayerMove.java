package fr.redwoub.moderation.managers;

import fr.redwoub.moderation.Main;
import fr.redwoub.moderation.utils.Freeze;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(Freeze.isFreeze(player) && event.getFrom().distance(event.getTo()) > 0){
            player.teleport(player.getLocation());
            player.sendMessage(Main.getInstance().prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.target-move")));
        }
    }
}
