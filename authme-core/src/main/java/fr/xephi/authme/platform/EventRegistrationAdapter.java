package fr.xephi.authme.platform;

import fr.xephi.authme.listener.BlockListener;
import fr.xephi.authme.listener.EntityListener;
import fr.xephi.authme.listener.PlayerListener;
import fr.xephi.authme.listener.ServerListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Supplies the full listener set to register at startup for the active platform.
 */
public interface EventRegistrationAdapter {

    /**
     * Returns the full ordered list of listeners to register for this platform.
     */
    List<Class<? extends Listener>> getListeners();

    /**
     * Returns the core listeners shared by all platforms.
     */
    static List<Class<? extends Listener>> getCommonListeners() {
        List<Class<? extends Listener>> listeners = new ArrayList<>(List.of(
            PlayerListener.class,
            BlockListener.class,
            EntityListener.class,
            ServerListener.class));

        if (fr.xephi.authme.util.Utils.isClassLoaded("org.bukkit.event.player.PlayerSwapHandItemsEvent")) {
            listeners.add(fr.xephi.authme.listener.ModernPlayerListener.class);
        }
        if (fr.xephi.authme.util.Utils.isClassLoaded("org.bukkit.event.entity.EntityAirChangeEvent")) {
            listeners.add(fr.xephi.authme.listener.ModernPlayerAirChangeListener.class);
        }

        return listeners;
    }

    @SafeVarargs
    static List<Class<? extends Listener>> combineListeners(List<Class<? extends Listener>>... listenerGroups) {
        List<Class<? extends Listener>> listeners = new ArrayList<>();
        for (List<Class<? extends Listener>> listenerGroup : listenerGroups) {
            listeners.addAll(listenerGroup);
        }
        return List.copyOf(listeners);
    }
}
