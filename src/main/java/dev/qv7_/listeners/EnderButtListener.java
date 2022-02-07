package dev.qv7_.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class EnderButtListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.hasItem()) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getItem().getItemMeta() == null) {
                    return;
                }
                if (event.getItem().getItemMeta().getDisplayName() == null) {
                    return;
                }
                if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + ChatColor.BOLD.toString() + "EnderButt" + ChatColor.RESET + ChatColor.GRAY + "(Right-Click)")) {
                    event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(2.5F));

                    event.setCancelled(true);
                    event.setUseItemInHand(Event.Result.DENY);

                    event.getPlayer().updateInventory();

                    try {
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.PORTAL, 1.0f, 1.0f);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
