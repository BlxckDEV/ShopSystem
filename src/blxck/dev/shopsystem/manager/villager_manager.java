package blxck.dev.shopsystem.manager;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class villager_manager implements Listener {

    @EventHandler
    public void oninventoryclick(InventoryClickEvent event) {
        if ((event.getCurrentItem().getType() == Material.GOLD_INGOT) &&
                (event.getInventory().getName().equals("§8» §eSHOP"))) {
            event.setCancelled(true);
        }
        if ((event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) &&
                (event.getInventory().getName().equals("§8» §eSHOP"))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event)
    {
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.hasItemMeta())
        {
            if (item.getItemMeta().getDisplayName().equals("§e§lVIP")) {
                event.setCancelled(true);
            }
            if ((item.hasItemMeta()) &&
                    (item.getItemMeta().getDisplayName().equals("§7"))) {
                event.setCancelled(true);
            }
        }
    }

}

