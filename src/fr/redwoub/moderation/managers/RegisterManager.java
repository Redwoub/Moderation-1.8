package fr.redwoub.moderation.managers;


import fr.redwoub.moderation.Main;
import fr.redwoub.moderation.commands.ModCMD;
import fr.redwoub.moderation.commands.ReportCMD;

public class RegisterManager {

    private static Main main = Main.getInstance();

    public static void register(){
        main.getCommand("mod").setExecutor(new ModCMD());
        main.getCommand("report").setExecutor(new ReportCMD());
    }
}
