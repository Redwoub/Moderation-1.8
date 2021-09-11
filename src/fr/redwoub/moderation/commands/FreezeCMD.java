package fr.redwoub.moderation.commands;

import fr.redwoub.moderation.utils.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        String prefix = "§7[§6Modération§7]";

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette commande.");
            return false;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("freeze")){
            if(args.length != 1){
                player.sendMessage(prefix + " §cErreur §8: §e/Freeze <joueur>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'existe pas !");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);
            Freeze.setFreeze(target, true);
            player.sendMessage(prefix + " §aVous avez freeze : §b" + target.getName());
            target.sendMessage(prefix + " §cVous avez était freeze par : §a" + player.getName());
        }

        if(cmd.getName().equalsIgnoreCase("unfreeze")){
            if(args.length != 1){
                player.sendMessage(prefix + " §cErreur §8: §e/Unfreeze <joueur>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'existe pas !");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if(Freeze.isFreeze(target)){
                Freeze.setFreeze(target, false);
                player.sendMessage(prefix + " §cVous avez unfreeze : §b" + target.getName());
                target.sendMessage(prefix + " §aVous avez était unfreeze par : §c" + player.getName());
            }else {
             player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'est pas freeze !");
            }
        }

        return false;
    }
}
