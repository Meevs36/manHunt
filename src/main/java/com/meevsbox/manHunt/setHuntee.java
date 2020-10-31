/*
 * Author -- Meevs
 * Creation Date -- Fri Oct 30 22:35:43 2020
 * File Name -- setHuntee.java
 * Notes -- 
 */

package com.meevsbox.manHunt;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class setHuntee implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String [] args) {
	Player huntee = null;
	
	if (sender instanceof Player) {
	    huntee = (Player) sender;

	    if (manHunt.huntee == null && (manHunt.hunters == null || !manHunt.hunters.contains (huntee))) {
		manHunt.huntee = huntee;
		Bukkit.getServer ().broadcastMessage (huntee.getDisplayName () + " is now the huntee!");
	    }
	    else if (manHunt.huntee != null) {
		huntee.sendMessage ("There's already a huntee!");
	    }
	    else {
		huntee.sendMessage ("You're already a hunter!");
	    }
		
	    
	    return true;
	}
	    
	
	return false;
    }
}
