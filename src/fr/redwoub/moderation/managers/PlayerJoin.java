package fr.redwoub.moderation.managers;

import fr.redwoub.moderation.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class PlayerJoin implements Listener {

    @EventHandler
    public void joinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("moderation.view")) return;
        for(Player players : Main.getInstance().vanish){
            player.hidePlayer(players);
        }
    }
}
