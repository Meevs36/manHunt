/*
 * Author -- Meevs
 * Creation Date -- Fri Oct 30 21:51:25 2020
 * File Name -- useCompass.java
 * Notes -- 
 */

package com.meevsbox.manHunt;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.Bukkit;

public class useCompass implements Listener {

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
	Player hunter = event.getPlayer ();

	if (hunter.getInventory ().getItemInMainHand ().getType () == Material.COMPASS && (event.getAction () == Action.RIGHT_CLICK_AIR || event.getAction () == Action.RIGHT_CLICK_BLOCK)) {
	    if (manHunt.huntee != null && manHunt.hunters.contains (hunter))
		hunter.setCompassTarget (manHunt.huntee.getLocation ()); /* Sets the location tracked by the compass to the huntee's location */
	    else if (manHunt.hunters.contains (hunter)) {
		hunter.sendMessage ("Could not find target!");
	    }
	}
    }
    
}
