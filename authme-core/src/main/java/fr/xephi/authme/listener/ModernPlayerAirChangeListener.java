package fr.xephi.authme.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;

import javax.inject.Inject;

/**
 * Listener for EntityAirChangeEvent introduced in modern Spigot versions.
 */
public class ModernPlayerAirChangeListener implements Listener {

    @Inject
    private ListenerService listenerService;

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onPlayerAirChange(EntityAirChangeEvent event) {
        if (listenerService.shouldCancelEvent(event)) {
            event.setCancelled(true);
        }
    }
}
