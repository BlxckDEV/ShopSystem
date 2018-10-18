package blxck.dev.shopsystem.manager;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class build_manager
{
    private ItemStack itemstack;


    
    public build_manager(Material material)
    {
        this.itemstack = new ItemStack(material);
    }

    public build_manager setAmount(int amount)
    {
        this.itemstack.setAmount(amount);

        return this;
    }

    public build_manager setDisplayname(String displayname)
    {
        ItemMeta im = this.itemstack.getItemMeta();

        im.setDisplayName(displayname);

        this.itemstack.setItemMeta(im);

        return this;
    }

    public build_manager setUnbreakable(boolean unbreakable)
    {
        ItemMeta im = this.itemstack.getItemMeta();

        im.spigot().setUnbreakable(unbreakable);

        return this;
    }

    public build_manager setMaterial(Material material)
    {
        this.itemstack.setType(material);

        return this;
    }

    public build_manager setMaterialId(short subId)
    {
        this.itemstack.setDurability(subId);

        return this;
    }

    public build_manager setSkullOwner(String skullOwner)
    {
        SkullMeta sm = (SkullMeta)this.itemstack.getItemMeta();

        sm.setOwner(skullOwner);

        this.itemstack.setItemMeta(sm);

        return this;
    }

    public build_manager addEnchantment(Enchantment enchantment, int enchantmentLevel)
    {
        this.itemstack.addEnchantment(enchantment, enchantmentLevel);

        return this;
    }

    public build_manager addUnsafeEnchantment(Enchantment enchantment, int enchantmentLevel)
    {
        this.itemstack.addUnsafeEnchantment(enchantment, enchantmentLevel);

        return this;
    }

    public build_manager setColor(int red, int green, int blue)
    {
        LeatherArmorMeta lm = (LeatherArmorMeta)this.itemstack.getItemMeta();

        lm.setColor(Color.fromRGB(red, green, blue));

        this.itemstack.setItemMeta(lm);

        return this;
    }

    public build_manager hideEnchantment()
    {
        ItemMeta im = this.itemstack.getItemMeta();

        im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

        this.itemstack.setItemMeta(im);

        return this;
    }

    public build_manager hideAttributes()
    {
        ItemMeta im = this.itemstack.getItemMeta();

        im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });

        this.itemstack.setItemMeta(im);

        return this;
    }

    public build_manager setLore(List<String> list)
    {
        ItemMeta meta = this.itemstack.getItemMeta();

        meta.setLore(list);

        this.itemstack.setItemMeta(meta);

        return this;
    }

    public build_manager setGlowing()
    {
        ItemMeta im = this.itemstack.getItemMeta();

        im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

        im.addEnchant(Enchantment.DURABILITY, 1, false);

        this.itemstack.setItemMeta(im);

        return this;
    }

    public ItemStack create()
    {
        return this.itemstack;
    }

    public ItemMeta getItemMeta()
    {
        return this.itemstack.getItemMeta();
    }
}
