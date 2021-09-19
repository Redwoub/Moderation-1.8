package fr.redwoub.moderation.commands;

import fr.redwoub.moderation.Main;
import fr.redwoub.moderation.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.player")));
            return false;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            if(Main.getInstance().vanish.contains(player)){
                Main.getInstance().vanish.remove(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.vanish-off")));
                PlayerManager.showPlayer(player);
            }else {
                Main.getInstance().vanish.add(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.vanish-on")));
                PlayerManager.hidePlayer(player);
            }
            return false;
        }


        return false;
    }
}
