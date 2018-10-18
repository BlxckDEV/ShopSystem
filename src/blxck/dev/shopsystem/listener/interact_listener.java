package blxck.dev.shopsystem.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class interact_listener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        if ((event.getInventory().getName().equals("§8» §eSHOP")) &&
                (event.getCurrentItem().getType() == Material.GOLD_INGOT)) {
            player.performCommand("getvip");
            player.closeInventory();
        }
    }
}


