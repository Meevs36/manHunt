/*
 * Author -- Meevs
 * Creation Date -- Fri Oct 30 22:21:04 2020
 * File Name -- setHunter.java
 * Notes -- 
 */

package com.meevsbox.manHunt;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Bukkit;

public class setHunter implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String [] args) {
	Player hunter = null;

	if (sender instanceof Player) {
	    hunter = (Player) sender;

	    if (manHunt.huntee != hunter) {
		/* Initializes the array list if one doesn't already exist */
		if (manHunt.hunters == null)
		    manHunt.hunters = new ArrayList ();
	    
		if (!manHunt.hunters.contains (hunter))
		    {
			manHunt.hunters.add (hunter); /* Adds the given player to the list of hunters */
			Bukkit.getServer ().broadcastMessage (hunter.getDisplayName () + " is now a hunter!");
			hunter.getInventory ().setItemInMainHand (new ItemStack (Material.COMPASS));		    
		    }
		else
		    hunter.sendMessage ("You're already a hunter you goon!");	    
	    }
	    else {
		hunter.sendMessage ("You're already the huntee!");
	    }		
	    
	    return true;
	}

	return false;
    }    
}
