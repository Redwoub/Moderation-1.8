package fr.redwoub.moderation;


import fr.redwoub.moderation.managers.RegisterManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;
    public List<UUID> moderateur = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        RegisterManager.register();
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }
}
