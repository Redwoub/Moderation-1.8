package fr.redwoub.moderation.commands;

import fr.redwoub.moderation.Main;
import fr.redwoub.moderation.utils.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        String prefix = Main.getInstance().prefix;

        if(cmd.getName().equalsIgnoreCase("freeze")){
            if(args.length != 1){
                sender.sendMessage(prefix + " §cErreur §8: §e/Freeze <joueur>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfig().getString("messages.player-not-find")));
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);

            if(Freeze.isFreeze(target)){
                sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.target-only-freeze")));
            }

            Freeze.setFreeze(target, true);
            sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.player-freeze")) + target.getName());
            target.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.target-freeze")) + sender.getName());
        }

        if(cmd.getName().equalsIgnoreCase("unfreeze")){
            if(args.length != 1){
                sender.sendMessage(prefix + " §cErreur §8: §e/Unfreeze <joueur>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfig().getString("messages.player-not-find")));
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if(Freeze.isFreeze(target)){
                Freeze.setFreeze(target, false);
                sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.player-unfreeze")) + target.getName());
                target.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("messages.target-unfreeze")) + sender.getName());
            }else {
                sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&',Main.getInstance().getConfig().getString("messages.target-only-unfreeze")));
            }
        }

        return false;
    }
}
