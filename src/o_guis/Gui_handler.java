package o_guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import items.give_items;

public class Gui_handler implements Listener
{
	
	public void openConfigOne(Player player) {
		player.closeInventory();
        final Inventory guia = Bukkit.createInventory(null, 27, new StringBuilder().append(ChatColor.BOLD).append(ChatColor.GOLD).append("Settings | Page 1").toString());
        final ItemStack a = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack b = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack c = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack d = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack e = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack f = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack g = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack h = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack i = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack j = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack k = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack l = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack m = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack n = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack o = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack p = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack q = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack r = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack s = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack t = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack u = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack v = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack w = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack x = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack y = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack z = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        final ItemStack aa = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        int z2 = 7;
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowBommer")) {
            a.setType(Material.GREEN_CONCRETE);
            final ItemMeta aaa = a.getItemMeta();
            aaa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            aaa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            aaa.setDisplayName(ChatColor.GREEN + "Boomer is currently enabled");
            aaa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            a.setItemMeta(aaa);
            --z2;
        }
        else {
            a.setType(Material.RED_CONCRETE);
            final ItemMeta aaa = a.getItemMeta();
            aaa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            aaa.setDisplayName(ChatColor.RED + "Boomer is currently disabled");
            aaa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            aaa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            a.setItemMeta(aaa);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowEndsword")) {
            b.setType(Material.GREEN_CONCRETE);
            final ItemMeta bb = b.getItemMeta();
            bb.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            bb.setDisplayName(ChatColor.GREEN + "Endsword is currently enabled");
            bb.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            bb.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            b.setItemMeta(bb);
            --z2;
        }
        else {
            b.setType(Material.RED_CONCRETE);
            final ItemMeta bb = b.getItemMeta();
            bb.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            bb.setDisplayName(ChatColor.RED + "Endsword is currently disabled");
            bb.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            bb.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            b.setItemMeta(bb);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowBlitzer")) {
            c.setType(Material.GREEN_CONCRETE);
            final ItemMeta cc = c.getItemMeta();
            cc.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            cc.setDisplayName(ChatColor.GREEN + "Blitzer is currently enabled");
            cc.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
            cc.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            c.setItemMeta(cc);
            --z2;
        }
        else {
            c.setType(Material.RED_CONCRETE);
            final ItemMeta cc = c.getItemMeta();
            cc.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            cc.setDisplayName(ChatColor.RED + "Blitzer is currently disabled");
            cc.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
            cc.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            c.setItemMeta(cc);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCrafter")) {
            d.setType(Material.GREEN_CONCRETE);
            final ItemMeta dd = d.getItemMeta();
            dd.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            dd.setDisplayName(ChatColor.GREEN + "Crafter is currently enabled");
            dd.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            dd.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            d.setItemMeta(dd);
            --z2;
        }
        else {
            d.setType(Material.RED_CONCRETE);
            final ItemMeta dd = d.getItemMeta();
            dd.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            dd.setDisplayName(ChatColor.RED + "Crafter is currently disabled");
            dd.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            dd.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            d.setItemMeta(dd);
        }
        if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowBlazer")) {
            e.setType(Material.GREEN_CONCRETE);
            final ItemMeta ee = e.getItemMeta();
            ee.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ee.setDisplayName(ChatColor.GREEN + "Blazer is currently enabled");
            ee.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
            ee.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            --z2;
            e.setItemMeta(ee);
        }
        else {
            e.setType(Material.RED_CONCRETE);
            final ItemMeta ee = e.getItemMeta();
            ee.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ee.setDisplayName(ChatColor.RED + "Blazer is currently disabled");
            ee.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
            ee.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            e.setItemMeta(ee);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowBower")) {
            f.setType(Material.GREEN_CONCRETE);
            final ItemMeta ff = f.getItemMeta();
            ff.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ff.setDisplayName(ChatColor.GREEN + "Bower is currently enabled");
            ff.addEnchant(Enchantment.DIG_SPEED, 1, true);
            ff.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            f.setItemMeta(ff);
            --z2;
        }
        else {
            f.setType(Material.RED_CONCRETE);
            final ItemMeta ff = f.getItemMeta();
            ff.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ff.setDisplayName(ChatColor.RED + "Bower is currently disabled");
            ff.addEnchant(Enchantment.DIG_SPEED, 1, true);
            ff.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            f.setItemMeta(ff);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowPigCannon")) {
            g.setType(Material.GREEN_CONCRETE);
            final ItemMeta gg = g.getItemMeta();
            gg.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            gg.setDisplayName(ChatColor.GREEN + "Pig Cannon is currently enabled");
            gg.addEnchant(Enchantment.DURABILITY, 1, true);
            gg.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            g.setItemMeta(gg);
            --z2;
        }
        else {
            g.setType(Material.RED_CONCRETE);
            final ItemMeta gg = g.getItemMeta();
            gg.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            gg.setDisplayName(ChatColor.RED + "Pig Cannon is currently disabled");
            gg.addEnchant(Enchantment.DURABILITY, 1, true);
            gg.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            g.setItemMeta(gg);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowFlyFeather")) {
            j.setType(Material.GREEN_CONCRETE);
            final ItemMeta jj = j.getItemMeta();
            jj.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            jj.setDisplayName(ChatColor.GREEN + "Fly Feather is currently enabled");
            jj.addEnchant(Enchantment.DURABILITY, 1, true);
            jj.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            j.setItemMeta(jj);
        }
        else {
            j.setType(Material.RED_CONCRETE);
            final ItemMeta jj = j.getItemMeta();
            jj.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            jj.setDisplayName(ChatColor.RED + "Fly Feather is currently disabled");
            jj.addEnchant(Enchantment.DURABILITY, 1, true);
            jj.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            j.setItemMeta(jj);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowAntiFall")) {
            l.setType(Material.GREEN_CONCRETE);
            final ItemMeta ll = l.getItemMeta();
            ll.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ll.setDisplayName(ChatColor.GREEN + "Anti Fall is currently enabled");
            ll.addEnchant(Enchantment.DURABILITY, 1, true);
            ll.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            l.setItemMeta(ll);
        }
        else {
            l.setType(Material.RED_CONCRETE);
            final ItemMeta ll = l.getItemMeta();
            ll.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ll.setDisplayName(ChatColor.RED + "Anti Fall is currently disabled");
            ll.addEnchant(Enchantment.DURABILITY, 1, true);
            ll.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            l.setItemMeta(ll);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftOtherItems")) {
            m.setType(Material.GREEN_CONCRETE);
            final ItemMeta mm = m.getItemMeta();
            mm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            mm.setDisplayName(ChatColor.GREEN + "Allow craft other Items is currently enabled");
            mm.addEnchant(Enchantment.DURABILITY, 1, true);
            mm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            m.setItemMeta(mm);
        }
        else {
            m.setType(Material.RED_CONCRETE);
            final ItemMeta mm = m.getItemMeta();
            mm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            mm.setDisplayName(ChatColor.RED + "Allow craft other Items is currently disabled");
            mm.addEnchant(Enchantment.DURABILITY, 1, true);
            mm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            m.setItemMeta(mm);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowHookofVelectory")) {
            n.setType(Material.GREEN_CONCRETE);
            final ItemMeta nn = n.getItemMeta();
            nn.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            nn.setDisplayName(ChatColor.GREEN + "Hook of Velectory is currently enabled");
            nn.addEnchant(Enchantment.DURABILITY, 1, true);
            nn.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            n.setItemMeta(nn);
        }
        else {
            n.setType(Material.RED_CONCRETE);
            final ItemMeta nn = n.getItemMeta();
            nn.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            nn.setDisplayName(ChatColor.RED + "Hook of Velectory is currently disabled");
            nn.addEnchant(Enchantment.DURABILITY, 1, true);
            nn.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            n.setItemMeta(nn);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftNightVisor")) {
            o.setType(Material.GREEN_CONCRETE);
            final ItemMeta oo = o.getItemMeta();
            oo.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            oo.setDisplayName(ChatColor.GREEN + "Crafting Night Visor is currently enabled");
            oo.addEnchant(Enchantment.DURABILITY, 1, true);
            oo.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            o.setItemMeta(oo);
        }
        else {
            o.setType(Material.RED_CONCRETE);
            final ItemMeta oo = o.getItemMeta();
            oo.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            oo.setDisplayName(ChatColor.RED + "Crafting Night Visor is currently disabled");
            oo.addEnchant(Enchantment.DURABILITY, 1, true);
            oo.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            o.setItemMeta(oo);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftWaterHelmet")) {
            p.setType(Material.GREEN_CONCRETE);
            final ItemMeta pp = p.getItemMeta();
            pp.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            pp.setDisplayName(ChatColor.GREEN + "Crafting Night Visor is currently enabled");
            pp.addEnchant(Enchantment.DURABILITY, 1, true);
            pp.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            p.setItemMeta(pp);
        }
        else {
            p.setType(Material.RED_CONCRETE);
            final ItemMeta pp = p.getItemMeta();
            pp.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            pp.setDisplayName(ChatColor.RED + "Crafting Night Visor is currently disabled");
            pp.addEnchant(Enchantment.DURABILITY, 1, true);
            pp.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            p.setItemMeta(pp);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftFireShoes")) {
            q.setType(Material.GREEN_CONCRETE);
            final ItemMeta qq = q.getItemMeta();
            qq.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            qq.setDisplayName(ChatColor.GREEN + "Crafting Fire Shoes is currently enabled");
            qq.addEnchant(Enchantment.DURABILITY, 1, true);
            qq.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            q.setItemMeta(qq);
        }
        else {
            q.setType(Material.RED_CONCRETE);
            final ItemMeta qq = q.getItemMeta();
            qq.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            qq.setDisplayName(ChatColor.RED + "Crafting Fire Shoes is currently disabled");
            qq.addEnchant(Enchantment.DURABILITY, 1, true);
            qq.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            q.setItemMeta(qq);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftLaucher")) {
            r.setType(Material.GREEN_CONCRETE);
            final ItemMeta rr = r.getItemMeta();
            rr.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            rr.setDisplayName(ChatColor.GREEN + "Crafting Launcher is currently enabled");
            rr.addEnchant(Enchantment.DURABILITY, 1, true);
            rr.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            r.setItemMeta(rr);
        }
        else {
            r.setType(Material.RED_CONCRETE);
            final ItemMeta rr = r.getItemMeta();
            rr.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            rr.setDisplayName(ChatColor.RED + "Crafting Launcher is currently disabled");
            rr.addEnchant(Enchantment.DURABILITY, 1, true);
            rr.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            r.setItemMeta(rr);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftFireShoes")) {
            s.setType(Material.GREEN_CONCRETE);
            final ItemMeta ss = s.getItemMeta();
            ss.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ss.setDisplayName(ChatColor.GREEN + "Crafting Fire Shoes is currently enabled");
            ss.addEnchant(Enchantment.DURABILITY, 1, true);
            ss.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            s.setItemMeta(ss);
        }
        else {
            s.setType(Material.RED_CONCRETE);
            final ItemMeta ss = s.getItemMeta();
            ss.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ss.setDisplayName(ChatColor.RED + "Crafting Fire Shoes is currently disabled");
            ss.addEnchant(Enchantment.DURABILITY, 1, true);
            ss.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            s.setItemMeta(ss);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftWandOfBoom")) {
            t.setType(Material.GREEN_CONCRETE);
            final ItemMeta tt = t.getItemMeta();
            tt.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            tt.setDisplayName(ChatColor.GREEN + "Crafting Wand of Boom is currently enabled");
            tt.addEnchant(Enchantment.DURABILITY, 1, true);
            tt.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            t.setItemMeta(tt);
        }
        else {
            t.setType(Material.RED_CONCRETE);
            final ItemMeta tt = t.getItemMeta();
            tt.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            tt.setDisplayName(ChatColor.RED + "Crafting Wand of Boom is currently disabled");
            tt.addEnchant(Enchantment.DURABILITY, 1, true);
            tt.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            t.setItemMeta(tt);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftWandOfInvisiblity")) {
            u.setType(Material.GREEN_CONCRETE);
            final ItemMeta uu = u.getItemMeta();
            uu.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            uu.setDisplayName(ChatColor.GREEN + "Crafting Wand of Invisibility is currently enabled");
            uu.addEnchant(Enchantment.DURABILITY, 1, true);
            uu.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            u.setItemMeta(uu);
        }
        else {
            q.setType(Material.RED_CONCRETE);
            final ItemMeta uu = u.getItemMeta();
            uu.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            uu.setDisplayName(ChatColor.RED + "Crafting Wand of Invisibilit is currently disabled");
            uu.addEnchant(Enchantment.DURABILITY, 1, true);
            uu.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            u.setItemMeta(uu);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftSpeedLeggings")) {
            v.setType(Material.GREEN_CONCRETE);
            final ItemMeta vv = v.getItemMeta();
            vv.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            vv.setDisplayName(ChatColor.GREEN + "Crafting Speed Leggings is currently enabled");
            vv.addEnchant(Enchantment.DURABILITY, 1, true);
            vv.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            v.setItemMeta(vv);
        }
        else {
            v.setType(Material.RED_CONCRETE);
            final ItemMeta vv = v.getItemMeta();
            vv.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            vv.setDisplayName(ChatColor.RED + "Crafting Speed Leggings is currently disabled");
            vv.addEnchant(Enchantment.DURABILITY, 1, true);
            vv.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            v.setItemMeta(vv);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftSuperSponge")) {
            w.setType(Material.GREEN_CONCRETE);
            final ItemMeta ww = w.getItemMeta();
            ww.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ww.setDisplayName(ChatColor.GREEN + "Crafting Super Sponge is currently enabled");
            ww.addEnchant(Enchantment.DURABILITY, 1, true);
            ww.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            w.setItemMeta(ww);
        }
        else {
            w.setType(Material.RED_CONCRETE);
            final ItemMeta ww = w.getItemMeta();
            ww.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            ww.setDisplayName(ChatColor.RED + "Crafting Super Sponge is currently disabled");
            ww.addEnchant(Enchantment.DURABILITY, 1, true);
            ww.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            w.setItemMeta(ww);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftWandOfMassiveBoom")) {
            z.setType(Material.GREEN_CONCRETE);
            final ItemMeta zz = z.getItemMeta();
            zz.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            zz.setDisplayName(ChatColor.GREEN + "Crafting Wand of massive Boom is currently enabled");
            zz.addEnchant(Enchantment.DURABILITY, 1, true);
            zz.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            z.setItemMeta(zz);
        }
        else {
            z.setType(Material.RED_CONCRETE);
            final ItemMeta zz = z.getItemMeta();
            zz.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            zz.setDisplayName(ChatColor.RED + "Crafting Wand of massive Boom is currently disabled");
            zz.addEnchant(Enchantment.DURABILITY, 1, true);
            zz.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            z.setItemMeta(zz);
        }
        if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCrafLavaSponge")) {
            x.setType(Material.GREEN_CONCRETE);
            final ItemMeta xx = x.getItemMeta();
            xx.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            xx.setDisplayName(ChatColor.GREEN + "Crafting Lava Sponge is currently enabled");
            xx.addEnchant(Enchantment.DURABILITY, 1, true);
            xx.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            x.setItemMeta(xx);
        }
        else {
            x.setType(Material.RED_CONCRETE);
            final ItemMeta xx = x.getItemMeta();
            xx.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            xx.setDisplayName(ChatColor.RED + "Crafting Lava Sponge is currently disabled");
            xx.addEnchant(Enchantment.DURABILITY, 1, true);
            xx.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            x.setItemMeta(xx);
        }
        y.setType(Material.ORANGE_CONCRETE);
        final ItemMeta yy = y.getItemMeta();
        yy.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        yy.setDisplayName(ChatColor.GREEN + "The Cooldown for Wand of (massive) Boom is: " + ChatColor.BOLD + cel20.op.Main.getPluginInstance().getConfig() .getDouble("wand_of_(massive)_boom_cooldown_MiliSeconds") / 1000.0 + ChatColor.RESET + ChatColor.GREEN + " Seconds");
        yy.addEnchant(Enchantment.DURABILITY, 1, true);
        yy.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        y.setItemMeta(yy);
        aa.setType(Material.ORANGE_CONCRETE);
        aa.setType(Material.ORANGE_CONCRETE);
        final ItemMeta aaaa = aa.getItemMeta();
        aaaa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        aaaa.setDisplayName(ChatColor.GREEN + "The Cooldown for Launcher is: " + ChatColor.BOLD + cel20.op.Main.getPluginInstance().getConfig() .getDouble("launcher_cooldown_MiliSeconds") / 1000.0 + ChatColor.RESET + ChatColor.GREEN + " Seconds");
        aaaa.addEnchant(Enchantment.DURABILITY, 1, true);
        aaaa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        aa.setItemMeta(aaaa);
        h.setType(Material.REDSTONE_TORCH);
        final ItemMeta hh = h.getItemMeta();
        hh.setDisplayName(ChatColor.ITALIC + "Edit the Settings in the config.yml file");
        hh.addEnchant(Enchantment.DURABILITY, 1, true);
        hh.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        h.setItemMeta(hh);
        i.setType(Material.BARRIER);
        final ItemMeta ii = i.getItemMeta();
        ii.setDisplayName(ChatColor.RED + "Close Menu");
        ii.addEnchant(Enchantment.DURABILITY, 1, true);
        ii.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        i.setItemMeta(ii);
        k.setType(Material.ARROW);
        final ItemMeta kk = k.getItemMeta();
        kk.setDisplayName(new StringBuilder().append(ChatColor.GOLD + "Next Page").toString());
        kk.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        kk.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        k.setItemMeta(kk);
        guia.setItem(0, a);
        guia.setItem(1, b);
        guia.setItem(2, c);
        guia.setItem(3, d);
        guia.setItem(4, e);
        guia.setItem(5, f);
        guia.setItem(6, g);
        guia.setItem(7, j);
        guia.setItem(8, l);
        guia.setItem(9, m);
        guia.setItem(10, n);
        guia.setItem(11, o);
        guia.setItem(12, p);
        guia.setItem(13, q);
        guia.setItem(14, r);
        guia.setItem(15, s);
        guia.setItem(16, t);
        guia.setItem(17, u);
        guia.setItem(18, v);
        guia.setItem(19, w);
        guia.setItem(20, x);
        guia.setItem(22, y);
        guia.setItem(21, z);
        guia.setItem(23, aa);
        guia.setItem(24, k);
        guia.setItem(25, h);
        guia.setItem(26, i);
        player.openInventory(guia);
    
	}
	

	@EventHandler(priority = EventPriority.HIGH)
	public void onInventoryClick(final InventoryClickEvent event) {
        final HumanEntity player = event.getWhoClicked();
        final ItemStack item = event.getCursor();
        final Inventory inv = event.getClickedInventory();
        if (event.getCurrentItem() == null) {
            //
        }
        else {
            if (event.getCurrentItem().getType() == Material.REDSTONE_TORCH && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
                openConfigOne((Player)player);
            }
                
                
            if (event.getCurrentItem().getType() == Material.GREEN_CONCRETE && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
            }
            if (event.getCurrentItem().getType() == Material.RED_CONCRETE && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
            }
            if (event.getCurrentItem().getType() == Material.ORANGE_CONCRETE && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
            }
            if (event.getCurrentItem().getType() == Material.REDSTONE_TORCH && event.getCurrentItem().containsEnchantment(Enchantment.DURABILITY)) {
                event.setCancelled(true);
            }
            if (event.getCurrentItem().getType() == Material.REDSTONE_TORCH && event.getCurrentItem().containsEnchantment(Enchantment.SOUL_SPEED)) {
                event.setCancelled(true);
                event.getWhoClicked().getOpenInventory().close();
                final Player sender = (Player)event.getWhoClicked();
                ((Player)player).chat("/opitemshelp");
            }
            if (event.getCurrentItem().getType() == Material.REDSTONE_TORCH && event.getCurrentItem().containsEnchantment(Enchantment.WATER_WORKER)) {
                event.setCancelled(true);
                event.getWhoClicked().getOpenInventory().close();
                final Player sender = (Player)event.getWhoClicked();
                ((Player)player).chat("/opitemsversion");
            }
            if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().containsEnchantment(Enchantment.DURABILITY)) {
                event.setCancelled(true);
                event.getWhoClicked().getOpenInventory().close();
            }
            if (event.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                if (event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                    event.setCancelled(true);
                    final Player ptemp = (Player)player;
                    give_items.giveItems(ptemp);
                }
            }
            else if (event.getCurrentItem().getType() == Material.CRAFTING_TABLE) {
                if (event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                    event.setCancelled(true);
                    player.openWorkbench((Location)null, true);
                }
            }
            else if (event.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                if (event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                    event.setCancelled(true);
                }
            }
            else if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
                event.getWhoClicked().getOpenInventory().close();
                
            }
        
        
        //SECOND PAGE
        
        else if (event.getCurrentItem().getType() == Material.ARROW) {
        	if (event.getCurrentItem().containsEnchantment(Enchantment.DIG_SPEED)) {
        		openConfigOne((Player)player);
        	}
            if (event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.setCancelled(true);
                event.getWhoClicked().getOpenInventory().close();
                
                final ItemStack a1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a3 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a4 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a5 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a6 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a7 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a8 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a9 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a10 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a11 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a12 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a13 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a14 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a15 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a16 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a17 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a18 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a19 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack a20 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                
                int z2 = 7;
                if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftTNTDetonator")) {
                    a1.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a1.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "TNT Detonator is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a1.setItemMeta(aa);
                    --z2;
                }
                else {
                    a1.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a1.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "TNT Detonator is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a1.setItemMeta(aa);
                }
                
                //---------
                
                if (cel20.op.Main.getPluginInstance().getConfig() .getBoolean("AllowCraftEnderpealer")) {
                    a2.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a1.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Enderpearler is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a1.setItemMeta(aa);
                    --z2;
                }
                else {
                	a2.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a1.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Enderpearler is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a1.setItemMeta(aa);
                }
                
                //-----
                
                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftCursedSword")) {
                    a3.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a3.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Cursed Sword is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a3.setItemMeta(aa);
                    --z2;
                } else {
                    a3.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a3.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Cursed Sword is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a3.setItemMeta(aa);
                }

                //---------

                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("PrivatePocketDimensionEnabled")) {
                    a4.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a4.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Private Pocket Dimension is enabled");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a4.setItemMeta(aa);
                    --z2;
                } else {
                    a4.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a4.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Private Pocket Dimension is disabled");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a4.setItemMeta(aa);
                }

                //---------

                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftPrivatePocketDimension")) {
                    a5.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a5.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Private Pocket Dimension is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a5.setItemMeta(aa);
                    --z2;
                } else {
                    a5.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a5.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Private Pocket Dimension is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a5.setItemMeta(aa);
                }
                
                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftCursedSword")) {
                    a3.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a3.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Cursed Sword is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a3.setItemMeta(aa);
                    --z2;
                } else {
                    a3.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a3.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Cursed Sword is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a3.setItemMeta(aa);
                }

                //---------

                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("PrivatePocketDimensionEnabled")) {
                    a4.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a4.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Private Pocket Dimension is enabled");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a4.setItemMeta(aa);
                    --z2;
                } else {
                    a4.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a4.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Private Pocket Dimension is disabled");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a4.setItemMeta(aa);
                }

                //---------

                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftPrivatePocketDimension")) {
                    a5.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a5.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Private Pocket Dimension is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a5.setItemMeta(aa);
                    --z2;
                } else {
                    a5.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a5.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Private Pocket Dimension is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a5.setItemMeta(aa);
                }

                //---------

                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftAntiExplosionHelmet")) {
                    a7.setType(Material.GREEN_CONCRETE);
                    final ItemMeta aa = a7.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Anti-Explosion Helmet is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a7.setItemMeta(aa);
                    --z2;
                } else {
                    a7.setType(Material.RED_CONCRETE);
                    final ItemMeta aa = a7.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Anti-Explosion Helmet is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a7.setItemMeta(aa);
                }

                //---------

                int antiExploEnchLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("AntiExplosionHelmetAntiExploEnchLevel");
                String helmetDisplayName = ChatColor.GREEN + "Anti-Explosion Helmet Enchantment Level: " + ChatColor.BOLD + antiExploEnchLevel;
                a8.setType(Material.YELLOW_CONCRETE);
                ItemMeta aa = a8.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(helmetDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a8.setItemMeta(aa);

                //---------

                double oreSpawnChance = cel20.op.Main.getPluginInstance().getConfig().getDouble("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock");
                String oreSpawnChanceDisplayName = ChatColor.GREEN + "Ore Spawn Chance per Generated Stone Block: " + ChatColor.BOLD + oreSpawnChance;
                a9.setType(Material.YELLOW_CONCRETE);
                final ItemMeta bb = a9.getItemMeta();
                bb.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                bb.setDisplayName(oreSpawnChanceDisplayName);
                bb.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                bb.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a9.setItemMeta(bb);
                
                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("CursedSwordEnabled")) {
                    a10.setType(Material.GREEN_CONCRETE);
                    aa = a7.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Cursed Sword is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a10.setItemMeta(aa);
                    --z2;
                } else {
                	a10.setType(Material.RED_CONCRETE);
                     aa = a7.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Cursed Sword is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a10.setItemMeta(aa);
                }
                
                int wandOfBoomExplosionStrength = cel20.op.Main.getPluginInstance().getConfig().getInt("Wand_of_Boom_Explosion_Strenght");
                String wandOfBoomDisplayName = ChatColor.GREEN + "Wand of Boom Explosion Strength: " + ChatColor.BOLD + wandOfBoomExplosionStrength;
                a10.setType(Material.YELLOW_CONCRETE);
               aa = a10.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(wandOfBoomDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a10.setItemMeta(aa);

                //---------

                int wandOfMassiveBoomExplosionStrength = cel20.op.Main.getPluginInstance().getConfig().getInt("Wand_of_Massive_Boom_Explosion_Strenght");
                String wandOfMassiveBoomDisplayName = ChatColor.GREEN + "Wand of Massive Boom Explosion Strength: " + ChatColor.BOLD + wandOfMassiveBoomExplosionStrength;
                a11.setType(Material.YELLOW_CONCRETE);
             aa = a11.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(wandOfMassiveBoomDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a11.setItemMeta(aa);

                //---------

                int knockbackEnchantmentLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("CraftedKnockyTheStickKnockbackEnchantmentLevel");
                String knockbackEnchantmentDisplayName = ChatColor.GREEN + "Crafted Knocky The Stick Knockback Enchantment Level: " + ChatColor.BOLD + knockbackEnchantmentLevel;
                a12.setType(Material.YELLOW_CONCRETE);
               aa = a12.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(knockbackEnchantmentDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a12.setItemMeta(aa);

                //---------

                int damageAllEnchantmentLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("CraftedBlockySwordDamageAllEnchantmentLevel");
                String damageAllEnchantmentDisplayName = ChatColor.GREEN + "Crafted Blocky Sword Damage All Enchantment Level: " + ChatColor.BOLD + damageAllEnchantmentLevel;
                a13.setType(Material.YELLOW_CONCRETE);
                aa = a13.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(damageAllEnchantmentDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a13.setItemMeta(aa);

                //---------

                int protectionEnchantmentLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("CraftedTheAntiDamageProtectionEnchantmentLevel");
                String protectionEnchantmentDisplayName = ChatColor.GREEN + "Crafted The Anti-Damage Protection Enchantment Level: " + ChatColor.BOLD + protectionEnchantmentLevel;
                a14.setType(Material.YELLOW_CONCRETE);
                aa = a14.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(protectionEnchantmentDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a14.setItemMeta(aa);

                //---------

                int digSpeedEnchantmentLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("CraftedPickyPickDigSpeedEnchantmentLevel");
                String digSpeedEnchantmentDisplayName = ChatColor.GREEN + "Crafted Picky Pick Dig Speed Enchantment Level: " + ChatColor.BOLD + digSpeedEnchantmentLevel;
                a15.setType(Material.YELLOW_CONCRETE);
                aa = a15.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(digSpeedEnchantmentDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a15.setItemMeta(aa);

                //---------

                int lootBonusBlocksEnchantmentLevel = cel20.op.Main.getPluginInstance().getConfig().getInt("CraftedPickyPickLootBonusBlocksEnchantmentLevel");
                String lootBonusBlocksEnchantmentDisplayName = ChatColor.GREEN + "Crafted Picky Pick Loot Bonus Blocks Enchantment Level: " + ChatColor.BOLD + lootBonusBlocksEnchantmentLevel;
                a16.setType(Material.YELLOW_CONCRETE);
                 aa = a16.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(lootBonusBlocksEnchantmentDisplayName);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a16.setItemMeta(aa);

                //---------------
                
                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftandActivatedWandofHome")) {
                    a17.setType(Material.GREEN_CONCRETE);
                    aa = a17.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "Wand of Home is currently craftable and activated");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a17.setItemMeta(aa);
                    --z2;
                } else {
                	a17.setType(Material.RED_CONCRETE);
                     aa = a17.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "Wand of Home is currently not craftable and deaktivated");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a17.setItemMeta(aa);
                }
                if (cel20.op.Main.getPluginInstance().getConfig().getBoolean("AllowCraftTNTBow")) {
                	a18.setType(Material.GREEN_CONCRETE);
                    aa = a18.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.setDisplayName(ChatColor.GREEN + "TNT Bow is currently craftable");
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a18.setItemMeta(aa);
                    --z2;
                } else {
                	a18.setType(Material.RED_CONCRETE);
                     aa = a18.getItemMeta();
                    aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                    aa.setDisplayName(ChatColor.RED + "TNT Bow is currently not craftable");
                    aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    a18.setItemMeta(aa);
                }
                //------
                int t1 = cel20.op.Main.getPluginInstance().getConfig().getInt("TNTBowTNTAmount");
                String t2 = ChatColor.GREEN + "TNT Bow Amount Primed TNT Spawn/Shot: " + ChatColor.BOLD + t1;
                a19.setType(Material.YELLOW_CONCRETE);
                 aa = a19.getItemMeta();
                aa.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                aa.setDisplayName(t2);
                aa.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                aa.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                a19.setItemMeta(aa);
                
                //------//-7
                
                final ItemStack h = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                final ItemStack i = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                
                final ItemStack k = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                
                final ItemStack guiglass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                final ItemMeta guiglassi = guiglass.getItemMeta();
                guiglassi.setDisplayName(new StringBuilder().append(ChatColor.GOLD).toString().toString());
                guiglassi.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                guiglassi.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                guiglassi.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
                guiglass.setItemMeta(guiglassi);
                
                h.setType(Material.REDSTONE_TORCH);
                final ItemMeta hh = h.getItemMeta();
                hh.setDisplayName(ChatColor.ITALIC + "Edit the Settings in the config.yml file");
                hh.addEnchant(Enchantment.DURABILITY, 1, true);
                hh.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                h.setItemMeta(hh);
                i.setType(Material.BARRIER);
                final ItemMeta ii = i.getItemMeta();
                ii.setDisplayName(ChatColor.RED + "Close Menu");
                ii.addEnchant(Enchantment.DURABILITY, 1, true);
                ii.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                i.setItemMeta(ii);
                k.setType(Material.ARROW);
                final ItemMeta kk = k.getItemMeta();
                kk.setDisplayName(new StringBuilder().append(ChatColor.GOLD + "Previous Page").toString());
                kk.addEnchant(Enchantment.DIG_SPEED, 1, true);
                kk.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                k.setItemMeta(kk);
                
                //--|
                
                
                final Inventory guia = Bukkit.createInventory(null, 27, new StringBuilder().append(ChatColor.BOLD).append(ChatColor.GOLD).append("Settings | Page 2").toString());
                
                /*
                guia.setItem(0, a1);
                guia.setItem(1, a2);
                guia.setItem(2, a3);
                guia.setItem(3, a4);
                guia.setItem(4, a5);
                guia.setItem(5, a6);
                guia.setItem(6, a7);
                guia.setItem(7, a8);
                guia.setItem(8, a9);
                guia.setItem(9, a10);
                guia.setItem(10, a11);
                guia.setItem(11, a12);
                guia.setItem(12, a13);
                guia.setItem(13, a14);
                guia.setItem(14, a15);
                guia.setItem(15, a16);
                guia.setItem(16, a17);
                guia.setItem(17, a18);
                guia.setItem(18, a19);
                guia.setItem(19, a20);
                guia.setItem(20, a21);
                guia.setItem(21, a22);
                guia.setItem(22, a23);
                guia.setItem(23, a24);
                guia.setItem(24, a25);
                guia.setItem(25, a26);
                guia.setItem(26, a27);
                Placeholder
                */
                
                guia.setItem(0, a1);
                guia.setItem(1, a2);
                guia.setItem(2, a3);
                guia.setItem(3, a4);
                guia.setItem(4, a5);
                guia.setItem(5, a17);
                guia.setItem(6, a7);
                guia.setItem(7, a8);
                guia.setItem(8, a9);
                guia.setItem(9, a10);
                guia.setItem(10, a11);
                guia.setItem(11, a12);
                guia.setItem(12, a13);
                guia.setItem(13, a14);
                guia.setItem(14, a15);
                guia.setItem(15, a16);
                guia.setItem(16, a18);
                guia.setItem(17, a19);
                guia.setItem(18, guiglass);
                guia.setItem(19, guiglass);
                guia.setItem(20, guiglass);
                guia.setItem(21, guiglass);
                guia.setItem(22, guiglass);
                guia.setItem(23, guiglass);
                guia.setItem(24, k);
                guia.setItem(25, h);
                guia.setItem(26, i);
                player.openInventory(guia);
            }
        }
            
        }
        
        if(!(event.getCurrentItem() == null)) {
        if (event.getCurrentItem().getType() == Material.YELLOW_CONCRETE && event.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
            event.setCancelled(true);
        }
    }
	}
	

	
}
