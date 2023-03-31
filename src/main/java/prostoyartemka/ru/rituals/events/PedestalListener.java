package prostoyartemka.ru.rituals.events;

import com.sun.org.apache.xalan.internal.xsltc.runtime.output.TransletOutputHandlerFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;
import prostoyartemka.ru.events.CustomBlockBreakEvent;
import prostoyartemka.ru.events.CustomBlockPlaceEvent;
import prostoyartemka.ru.events.PlayerInteractAtCustomBlockEvent;
import prostoyartemka.ru.rituals.blocks.Pedestal;

import java.awt.font.TransformAttribute;
import java.util.Objects;

public class PedestalListener implements Listener {

    private static final Vector itemOffset = new Vector(0, 0.75f, 0);

    private @Nullable ItemDisplay getPedestalItem(Location location) {
        for (ItemDisplay i : location.getNearbyEntitiesByType(ItemDisplay.class, 0.1f)) {
            if (i.getPersistentDataContainer().has(Pedestal.PedestalItemEntity, PersistentDataType.STRING))
                return i;
        }

        return null;
    }

    private void clickedEmptyHand(Location location, Player player) {
        Location itemLocation = location.add(itemOffset);
        ItemDisplay item = getPedestalItem(itemLocation);

        if (item == null) return;
        if (item.getItemStack() == null) return;
        if (item.getItemStack().getType() == Material.AIR) return;

        player.getInventory().setItem(EquipmentSlot.HAND, item.getItemStack());
        item.setItemStack(new ItemStack(Material.AIR));
    }

    private void clickedWithItem(Location location, Player player) {
        Location itemLocation = location.add(itemOffset);
        ItemDisplay item = getPedestalItem(itemLocation);

        if (item == null) return;
        if (item.getItemStack() == null) return;
        if (item.getItemStack().getType() != Material.AIR) return;

        item.setItemStack(player.getInventory().getItem(EquipmentSlot.HAND).asOne());
        player.getInventory().setItem(EquipmentSlot.HAND, player.getInventory().getItem(EquipmentSlot.HAND).subtract());
    }

    @EventHandler
    public void onPlayerInteractAtPedestal(PlayerInteractAtCustomBlockEvent e) {
        if (!e.getAction().isRightClick()) return;
        if (e.getHand() != EquipmentSlot.HAND) return;
        if (!Objects.equals(e.getTag(), new Pedestal().getTag())) return;
        if (e.getClickedBlock() == null) return;

        e.setCancel(true);

        Location customBlockLocation = e.getClickedBlock().getLocation().toCenterLocation();

        if (e.getItem().getType() == Material.AIR) clickedEmptyHand(customBlockLocation, e.getPlayer());
        else clickedWithItem(customBlockLocation, e.getPlayer());
    }

    @EventHandler
    public void onPlayerPlacePedestal(CustomBlockPlaceEvent e) {
        if (!Objects.equals(e.getBlockTag(), new Pedestal().getTag())) return;
        if (e.getBlock() == null) return;

        Location itemCreateLocation = e.getBlock().getLocation().clone().toCenterLocation().add(itemOffset);
        ItemDisplay item = (ItemDisplay) itemCreateLocation.getWorld().spawnEntity(itemCreateLocation, EntityType.ITEM_DISPLAY);

        item.setBillboard(Display.Billboard.VERTICAL);
        item.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.GUI);
        item.setItemStack(new ItemStack(Material.AIR));

        Transformation transformation = item.getTransformation();
        transformation.getScale().set(0.5);

        item.setTransformation(transformation);

        item.getPersistentDataContainer().set(Pedestal.PedestalItemEntity, PersistentDataType.STRING, "yea");
    }

    @EventHandler
    public void onPedestalBreak(CustomBlockBreakEvent e) {
        if (!Objects.equals(e.getTag(), new Pedestal().getTag())) return;
        if (e.getBlock() == null) return;

        Location itemLocation = e.getBlock().getLocation().clone().toCenterLocation().add(itemOffset);
        ItemDisplay item = getPedestalItem(itemLocation);
        if (item == null) return;

        if (item.getItemStack() != null) itemLocation.getWorld().dropItem(itemLocation, item.getItemStack());
        item.remove();
    }
}
