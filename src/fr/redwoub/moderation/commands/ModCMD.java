package fr.redwoub.moderation.commands;

import fr.redwoub.moderation.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette commande.");
            return false;
        }

        Player player = (Player) sender;

        if(Main.getInstance().moderateur.contains(player.getUniqueId())){
            Main.getInstance().moderateur.remove(player.getUniqueId());
            player.getInventory().clear();
            player.sendMessage("§cVous n'etes plus en mode modération !");
            //give inventaire
            return false;
        }
        Main.getInstance().moderateur.add(player.getUniqueId());
        player.sendMessage("§aVous etes en mode modération !");
        //save inventaire
        return false;
    }
}
