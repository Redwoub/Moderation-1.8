package fr.redwoub.moderation.managers;


import fr.redwoub.moderation.Main;
import fr.redwoub.moderation.commands.FreezeCMD;
import fr.redwoub.moderation.commands.ReportCMD;
import fr.redwoub.moderation.commands.VanishCMD;
import org.bukkit.plugin.PluginManager;

public class RegisterManager {

    private static Main main = Main.getInstance();
    private static PluginManager pm = main.getServer().getPluginManager();

    public static void register(){
        main.getCommand("report").setExecutor(new ReportCMD());
        main.getCommand("freeze").setExecutor(new FreezeCMD());
        main.getCommand("unfreeze").setExecutor(new FreezeCMD());
        main.getCommand("vanish").setExecutor(new VanishCMD());

        pm.registerEvents(new InventoryReport(), main);
        pm.registerEvents(new PlayerMove(), main);
    }
}
