package fr.redwoub.moderation.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerManager {

    public static void hidePlayer(Player player){
        for(Player players : Bukkit.getOnlinePlayers()){
            if(!players.hasPermission("moderation.view")){
                players.hidePlayer(player);
            }
        }
    }

    public static void showPlayer(Player player){
        for(Player players : Bukkit.getOnlinePlayers()){
            players.showPlayer(player);
        }
    }
}
