package dev.qv7_.listeners;

import dev.qv7_.KotHub;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        p.setHealth(20);
        p.setFoodLevel(20);

        p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1F, 1F);

        // MESSAGE

        p.sendMessage(ChatColor.GREEN + p.getName() + "has joined");


        // SELECTOR

        ItemStack menu = new ItemStack(Material.COMPASS);
        {
            ItemMeta meta = menu.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Selector" + ChatColor.RESET + ChatColor.GRAY + "(Right-Click)");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Right-click to open the selector menu!");
            meta.setLore(lore);
            menu.setItemMeta(meta);
        }
        p.getInventory().setItem(0, menu);

        // ENDERBUTT

        ItemStack enderbutt = new ItemStack(Material.ENDER_PEARL);
        {
            ItemMeta endermeta = enderbutt.getItemMeta();
            endermeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "EnderButt" + ChatColor.RESET + ChatColor.GRAY + "(Right-Click)");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Right-Click to Fly");
            endermeta.setLore(lore);
            enderbutt.setItemMeta(endermeta);
        }
        p.getInventory().setItem(1, enderbutt);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
       if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
           event.setCancelled(true);
       }
    }

    @EventHandler
    public void onDisconect(PlayerQuitEvent event) {
        Player p = event.getPlayer();

        p.getInventory().clear();
        p.sendMessage(ChatColor.RED + p.getName() + "has quit");

    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Player p = (Player) event.getEntity();
            event.setCancelled(true);
            if (p.getFoodLevel() < 19.0)
                p.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onInteractSelector(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = event.getPlayer();

            if (p.getInventory().getItemInHand().getType() == Material.COMPASS) {
               Inventory inv = Bukkit.createInventory(null, 9, "Selector Menu");

               ItemStack item = new ItemStack(Material.BOW);
                {
                   ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "Kitmap");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Click to join to queue the server!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                }
               ItemStack item2 = new ItemStack(Material.FISHING_ROD);
                {
                 ItemMeta meta = item2.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "HCF");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Click to join to queue the server!");
                    meta.setLore(lore);
                    item2.setItemMeta(meta);
                }
               ItemStack item3 = new ItemStack(Material.DIAMOND_SWORD);
                {
                 ItemMeta meta = item3.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA + "Practice");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Click to join to queue the server!");
                    meta.setLore(lore);
                    item3.setItemMeta(meta);
                }
               ItemStack decoration = new ItemStack(Material.STAINED_GLASS_PANE);
                ItemMeta decorationMeta = decoration.getItemMeta();
                decorationMeta.setDisplayName(".");
                decoration.setItemMeta(decorationMeta);

                inv.setItem(2, item);
                inv.setItem(0, decoration);
                inv.setItem(1, decoration);
                inv.setItem(3, decoration);
                inv.setItem(5, decoration);
                inv.setItem(4, item2);
                inv.setItem(6, item3);
                inv.setItem(7, decoration);
                inv.setItem(8, decoration);

                p.openInventory(inv);
            }
        }
    }

    @EventHandler
    public void onClickItemMenu(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("Selector Menu")) {
            if (event.getCurrentItem().getType() == Material.BOW) {
                event.setCancelled(true);

               Player p = (Player) event.getWhoClicked();

                p.closeInventory();

                p.sendMessage(ChatColor.GREEN + "Sent you to the server Kitmap!");

                Bukkit.dispatchCommand((CommandSender) p, "send kitmap");
            }

            if (event.getCurrentItem().getType() == Material.FISHING_ROD) {
                event.setCancelled(true);

               Player p = (Player) event.getWhoClicked();

                p.closeInventory();

                p.sendMessage(ChatColor.GREEN + "Sent you to the server HCF!");

                Bukkit.dispatchCommand((CommandSender) p, "send hcf");
            }

            if (event.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                event.setCancelled(true);

               Player p = (Player) event.getWhoClicked();

                p.closeInventory();

                p.sendMessage(ChatColor.GREEN + "Sent you to the server Practice!");

                Bukkit.dispatchCommand((CommandSender) p, "send practice");
            }
        }
    }
}