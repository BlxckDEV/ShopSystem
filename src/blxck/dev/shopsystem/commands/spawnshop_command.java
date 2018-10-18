package black.dev.block.main;

import blxck.dev.shopsystem.ShopSystem;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class spawnshop_command implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
        Player player = (Player)sender;
        if (player.hasPermission("shopsystem.spawn")) {
            Villager v = (Villager)player.getWorld().spawnCreature(player.getLocation(), CreatureType.VILLAGER);
            player.sendMessage("§7§m-------------------------------------");
            player.sendMessage("");
            player.sendMessage("§8§ §e§lSHOP §8§ §7Du hast den §aShop gesetzt!");
            player.sendMessage("");
            player.sendMessage("§7§m-------------------------------------");
            player.playSound(player.getLocation(), Sound.FIREWORK_LARGE_BLAST, 3.0F, 2.0F);
            v.setCustomNameVisible(true);
            v.setCustomName(ShopSystem.getInstance().getConfig().getString("VillagerName").replace("&", "§").toString());
            v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 365000, 365000));
        }
        return false;
    }
}