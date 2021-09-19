package fr.redwoub.moderation;


import fr.redwoub.moderation.managers.RegisterManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;
    public List<Player> vanish = new ArrayList<>();
    public String prefix;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        instance = this;
        RegisterManager.register();
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.prefix"));
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }
}
