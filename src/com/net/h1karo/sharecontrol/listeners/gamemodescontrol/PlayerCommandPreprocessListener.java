package com.net.h1karo.sharecontrol.listeners.gamemodescontrol;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.net.h1karo.sharecontrol.Permissions;
import com.net.h1karo.sharecontrol.ShareControl;
import com.net.h1karo.sharecontrol.configuration.Configuration;
import com.net.h1karo.sharecontrol.localization.Localization;

public class PlayerCommandPreprocessListener implements Listener
{
	@SuppressWarnings("unused")
	private final ShareControl main;
	
	public PlayerCommandPreprocessListener(ShareControl h)
	{
		this.main = h;
	}
	
	@EventHandler
	public void PlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		if(!Configuration.GamemodesControlEnabled || Permissions.perms(e.getPlayer(), "gamemodescontrol.*") || e.isCancelled()) return;
		if(!Permissions.perms(e.getPlayer(), "gamemodescontrol.survival")) {
			if(e.getMessage().compareToIgnoreCase("/gamemode 0") == 0 || e.getMessage().compareToIgnoreCase("/gamemode s") == 0 || e.getMessage().toLowerCase().contains("/gamemode survi") || e.getMessage().compareToIgnoreCase("/gm 0") == 0 || e.getMessage().compareToIgnoreCase("/gm s") == 0 || e.getMessage().toLowerCase().contains("/gm survi") ) 
				if(!ShareControl.getFoundEssentials() || (ShareControl.getFoundEssentials() && e.getPlayer().hasPermission("essentials.gamemode"))) {
					Localization.NotAllowedGamemode(e.getPlayer(), "survival");
					e.setCancelled(true);
				}
		}
		
		if(!Permissions.perms(e.getPlayer(), "gamemodescontrol.creative")) {
			if(e.getMessage().compareToIgnoreCase("/gamemode 1") == 0 || e.getMessage().compareToIgnoreCase("/gamemode c") == 0 || e.getMessage().toLowerCase().contains("/gamemode creat") || e.getMessage().compareToIgnoreCase("/gm 1") == 0 || e.getMessage().compareToIgnoreCase("/gm c") == 0 || e.getMessage().toLowerCase().contains("/gm creat") )
				if(!ShareControl.getFoundEssentials() || (ShareControl.getFoundEssentials() && e.getPlayer().hasPermission("essentials.gamemode"))) {
					Localization.NotAllowedGamemode(e.getPlayer(), "creative");
					e.setCancelled(true);
				}
		}
		
		if(!Permissions.perms(e.getPlayer(), "gamemodescontrol.adventure")) {
			if(e.getMessage().compareToIgnoreCase("/gamemode 2") == 0 || e.getMessage().compareToIgnoreCase("/gamemode a") == 0 || e.getMessage().toLowerCase().contains("/gamemode advent") || e.getMessage().compareToIgnoreCase("/gm 2") == 0 || e.getMessage().compareToIgnoreCase("/gm a") == 0 || e.getMessage().toLowerCase().contains("/gm advent") )
				if(!ShareControl.getFoundEssentials() || (ShareControl.getFoundEssentials() && e.getPlayer().hasPermission("essentials.gamemode"))) {
					Localization.NotAllowedGamemode(e.getPlayer(), "adventure");
					e.setCancelled(true);
				}
		}
		
		if(!Permissions.perms(e.getPlayer(), "gamemodescontrol.spectator")) {
			if(e.getMessage().compareToIgnoreCase("/gamemode 3") == 0 || e.getMessage().compareToIgnoreCase("/gamemode sp") == 0 || e.getMessage().toLowerCase().contains("/gamemode spect") || e.getMessage().compareToIgnoreCase("/gm 3") == 0 || e.getMessage().compareToIgnoreCase("/gm sp") == 0 || e.getMessage().toLowerCase().contains("/gm spect") )
				if(!ShareControl.getFoundEssentials() || (ShareControl.getFoundEssentials() && e.getPlayer().hasPermission("essentials.gamemode"))) {
					Localization.NotAllowedGamemode(e.getPlayer(), "spectator");
					e.setCancelled(true);
				}
		}
	}
}