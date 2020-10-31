/*
 * Author -- Meevs
 * Creation Date -- Fri Oct 30 22:52:57 2020
 * File Name -- resetManhunt.java
 * Notes -- 
 */

package com.meevsbox.manHunt;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class resetManhunt implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String [] args) {
	Player player = null;

	if (sender instanceof Player) {
	    player = (Player)sender;
	    if (!player.isOp ()) {
		player.sendMessage ("You do not have permissions to use that command");
	    
		return false;
	    }
	}
	
	manHunt.huntee = null;
	manHunt.hunters = null;
	
	Bukkit.getServer ().broadcastMessage ("Manhunt has been reset!");
	
	return true;		
    }
}
