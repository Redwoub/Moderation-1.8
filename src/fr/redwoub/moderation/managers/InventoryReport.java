package fr.redwoub.moderation.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryReport implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        String tareget = inventory.getName().substring(13);
        Player target = Bukkit.getPlayer(tareget);
        if(inventory.getName().startsWith("§bReport")){
            switch (itemStack.getType()){
                case BOW:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cSpamBow")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case IRON_SWORD:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cReach")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case WEB:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cForceField")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case DIAMOND_SWORD:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cKill Aura")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case FLINT_AND_STEEL:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cAutoClick")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case FISHING_ROD:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cRunning")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                case SNOW_BALL:
                    if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§cToupie")){
                        player.closeInventory();
                        player.sendMessage("§aVous avez bien report : §c" + target.getName());
                        sendToModeraters(itemStack.getItemMeta().getDisplayName(), target);
                    }
                    break;
                default: break;
            }
        }
        event.setCancelled(true);
    }

    private void sendToModeraters(String reason, Player target) {

        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("moderation.recive")){
                players.sendMessage("§bLe joueur : §a" + target.getName() + " §ba était signalé pour : " + reason);
            }
        }
    }
}
