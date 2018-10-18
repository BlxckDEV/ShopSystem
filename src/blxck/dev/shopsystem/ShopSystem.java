package blxck.dev.shopsystem;


import black.dev.block.main.spawnshop_command;
import blxck.dev.shopsystem.commands.getvip_command;
import blxck.dev.shopsystem.listener.interact_listener;
import blxck.dev.shopsystem.manager.villager_class;
import blxck.dev.shopsystem.manager.villager_manager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ShopSystem extends JavaPlugin {
    public static ShopSystem instance;
    public static String prefix = "§8» §6Shop§eSystem §7× ";

    public void onEnable() {


        instance = this;

        loadConfig();

        getServer().getPluginManager().registerEvents(new interact_listener(), this);
        getServer().getPluginManager().registerEvents(new villager_class(), this);
        getServer().getPluginManager().registerEvents(new villager_manager(), this);


        Bukkit.getConsoleSender().sendMessage("§aDas ShopSystem wird gestaret!");
        this.getCommand("getvip").setExecutor(new getvip_command());
        this.getCommand("spawnshop").setExecutor(new spawnshop_command());

        try {

            this.registerEvents();

        }
        catch (Exception e) {

        }

        super.onEnable();

    }

    public static ShopSystem getInstance() {
    return instance;
  }

    @Override
    public void onLoad() {

        Bukkit.getConsoleSender().sendMessage("§cDas ShopSystem wird beendet!");

        super.onLoad();
    }

    public void onDisable() {
        super.onDisable();
    }

    private void registerEvents() throws Exception {
        PluginManager pm = Bukkit.getPluginManager();
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

}