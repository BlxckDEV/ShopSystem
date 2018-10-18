package blxck.dev.shopsystem.commands;

import blxck.dev.coinsapi.CoinsAPI;
import blxck.dev.shopsystem.ShopSystem;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getvip_command implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
        Player player = (Player)sender;

        player.playSound(player.getLocation(), Sound.FIREWORK_LARGE_BLAST, 3.0F, 2.0F);


        if (CoinsAPI.getCoins(player) >= ShopSystem.getInstance().getConfig().getInt("VIPKosten")) {
            CoinsAPI.removeCoins(player, ShopSystem.getInstance().getConfig().getInt("VIPKosten"));
            player.sendMessage(ShopSystem.prefix  +"§aDu hast dir §eVIP §afür einen Tag gekauft §6[5000 Coins]");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ShopSystem.getInstance().getConfig().getString("ShopCommand").replace("&", "§").toString());


        }
        else
        {
            player.sendMessage(ShopSystem.prefix  +"§cDu hast nicht genug Coins! §8[§e5000 Coins§8]");
        }
        return false;
    }

}
