package fr.redwoub.moderation.commands;

import fr.redwoub.moderation.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ReportCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette commande !");
            return false;
        }

        Player player = (Player) sender;
        if(args.length != 1){
            player.sendMessage("§7[§6Modération§7] §cErreur §8: §e/report <player>");
            return false;
        }

        if(Bukkit.getPlayer(args[0]) == null){
            player.sendMessage("§7[§6Modération§7] §cErreur §8: §cCe joueur n'existe pas !");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        Inventory inventory = Bukkit.createInventory(null, 9, "§bReport : §c" + target.getName());

        inventory.setItem(1, new ItemBuilder(Material.BOW).setName("§cSpamBow").toItemStack());
        inventory.setItem(2, new ItemBuilder(Material.IRON_SWORD).setName("§cReach").toItemStack());
        inventory.setItem(3, new ItemBuilder(Material.WEB).setName("§cForceField").toItemStack());
        inventory.setItem(4, new ItemBuilder(Material.DIAMOND_SWORD).setName("§cKill Aura").toItemStack());
        inventory.setItem(5, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§cAutoClick").toItemStack());
        inventory.setItem(6, new ItemBuilder(Material.FISHING_ROD).setName("§cRunning").toItemStack());
        inventory.setItem(7, new ItemBuilder(Material.SNOW_BALL).setName("§cToupie").toItemStack());

        player.openInventory(inventory);
        return false;
    }
}
