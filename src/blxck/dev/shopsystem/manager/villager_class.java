package blxck.dev.shopsystem.manager;

import java.util.ArrayList;

import blxck.dev.shopsystem.ShopSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class villager_class implements Listener {

    private ItemStack itemstack;

    public void build(Material material) {
        this.itemstack = new ItemStack(material);
    }


    @EventHandler



    public void onInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.VILLAGER) {
            Villager v = (Villager)event.getRightClicked();
            if (v.getCustomName().equalsIgnoreCase(ShopSystem.getInstance().getConfig().getString("VillagerName").replace("&", "§").toString())) {
                event.setCancelled(true);

                Inventory inv = Bukkit.createInventory(null, 27, "§8» §eSHOP");

                event.setCancelled(true);

                ArrayList<String> lore2 = new ArrayList();
                lore2.add("§7§l§m---------------------------");
                lore2.add("§7");
                lore2.add("§7Hole dir VIP!");
                lore2.add("§7");
                lore2.add("§7§l§m---------------------------");

                ItemStack dr = new ItemStack(Material.GOLD_INGOT);
                ItemMeta drMeta = dr.getItemMeta();
                drMeta.setLore(lore2);
                drMeta.setDisplayName("§e§lVIP");
                dr.setItemMeta(drMeta);
                for (int i = 0; i < inv.getSize(); i++) {
                    inv.setItem(i, new build_manager(Material.STAINED_GLASS_PANE).setDisplayname("§7").create());
                }
                inv.setItem(13, dr);

                event.getPlayer().openInventory(inv);
            }
        }
    }
}
