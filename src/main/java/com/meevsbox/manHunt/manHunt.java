/*
 * Author -- Meevs
 * Creation Date -- Fri Oct 30 21:43:30 2020
 * File Name -- manHunt.java
 * Notes -- 
 */

package com.meevsbox.manHunt;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class manHunt extends JavaPlugin {

    static Player huntee = null;
    static ArrayList <Player> hunters;
    
    @Override
    public void onEnable () {
	/* Register listener for use of compass */
	getServer ().getPluginManager ().registerEvents (new useCompass (), this);

	/* Registers commands to be used for Man Hunt */
	this.getCommand ("hunter").setExecutor (new setHunter ());
	this.getCommand ("huntee").setExecutor (new setHuntee ());
	this.getCommand ("resetManhunt").setExecutor (new resetManhunt ());
    }

    @Override
    public void onDisable () {

    }
}
