package prostoyartemka.ru.rituals.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import prostoyartemka.ru.events.PlayerCustomItemInteractEvent;
import prostoyartemka.ru.rituals.ritual.TestRitual;

import java.util.Objects;

public class RitualPowderListener implements Listener {

    @EventHandler
    public void OnRitualPowderInteract(PlayerCustomItemInteractEvent e) {
        if (e.getClickedBlock() == null) return;
        if (!Objects.equals(e.getItemTag(), "ritual_powder")) return;

        e.getPlayer().getInventory().setItem(e.getHand(), e.getItem().subtract(1));

        Location l = e.getClickedBlock().getLocation().toCenterLocation();
        if (l.getBlock().getType() == Material.AIR) return;

        l = l.add(0, 1, 0);
        if (l.getBlock().getType() != Material.AIR) return;

        new TestRitual(l);
    }
}
