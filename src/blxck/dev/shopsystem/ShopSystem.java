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

        new loading();


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
    private class loading {
        public loading() {

            new Logger(Logger.LogType.INFO, "§7§M§l-------------------------------------------------");
            new Logger(Logger.LogType.INFO, "Das §6 " + getDescription().getName() + " §7System wird §agestartet§7...");
            new Logger(Logger.LogType.INFO, "§7§M§l-------------------------------------------------");

            this.fetchingClasses();
            this.MethodsfromClasses();

            this.pluginInfoMSG();

            new Logger(Logger.LogType.SUCCES,
                    "Das §6" + getDescription().getName() + "§7System wurde §aerfolgreich §7gestartet.");
            new Logger(Logger.LogType.INFO, "§7§M§l-------------------------------------------------");

        }

        private void MethodsfromClasses() {
            try {

                new Logger(Logger.LogType.SUCCES, "Alle §6Methoden §7wurden ausgeführt.");
            } catch (Exception e) {
                new Logger(Logger.LogType.ERROR, "Fehler beim ausführen der §6Methoden§7.");
                e.printStackTrace();
            }
        }

        private void fetchingClasses() {
            try {
                new Logger(Logger.LogType.SUCCES, "Alle §6Classen §7wurden geladen.");
            } catch (Exception e) {
                new Logger(Logger.LogType.ERROR, "Fehler beim Laden der §6Classen§7.");
                e.printStackTrace();
            }
        }

        private void registerCommands() {
            try {
                new Logger(Logger.LogType.SUCCES, "Alle §6Commands §7wurden geladen.");
            } catch (Exception e) {
                new Logger(Logger.LogType.ERROR, "Fehler beim Laden der §6Commands§7.");
                e.printStackTrace();
            }
        }


        public void pluginInfoMSG() {
            new Logger(Logger.LogType.INFO, "§7§M§l-------------------------------------------------");
            new Logger(Logger.LogType.INFO, "Name: §b" + getDescription().getName());
            new Logger(Logger.LogType.INFO, "Author: §b" + getDescription().getAuthors());
            new Logger(Logger.LogType.INFO, "Version: §b" + getDescription().getVersion());
            new Logger(Logger.LogType.INFO, "Website: §b" + getDescription().getWebsite());
            new Logger(Logger.LogType.INFO, "§7§M§l-------------------------------------------------");
        }
    }

    public static class Logger {
        public Logger(Logger.LogType type, String msg) {
            Bukkit.getConsoleSender().sendMessage(getInstance().prefix + type.getPrefix() + msg);
        }

        public enum LogType {
            INFO("§7[§fINFO§7] "), WARNING("§7[§cWARNING§7] "), ERROR("§7[§4ERROR§7] "), SUCCES("§7[§aSUCCES§7] ");

            String prefix;

            public String getPrefix() {
                return prefix;
            }

            LogType(String prefix) {
                this.prefix = prefix;
            }
        }
    }
}
