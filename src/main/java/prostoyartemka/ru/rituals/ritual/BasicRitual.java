package prostoyartemka.ru.rituals.ritual;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Transformation;
import prostoyartemka.ru.rituals.Rituals;

import java.util.List;

public abstract class BasicRitual {
    private final ItemDisplay[] ritualCircles = new ItemDisplay[3];
    private final Location location;
    private final BukkitTask basicUpdate;
    public boolean Appeared = false;

    public abstract List<Boolean> getRotatingParts();
    public abstract int getStartCustomModelData();
    public abstract List<Integer> getRotationPartsSpeed();
    public abstract List<Float> getAppearSpeed();
    public abstract Material getDisplayItemsType();

    NamespacedKey RitualCircleKey = new NamespacedKey("rituals", "ritual_circle_entity");

    private void createCircles() {
        for (int i = 0; i < 3; i++) {
            ItemDisplay display = (ItemDisplay) location.getWorld().spawnEntity(location.toCenterLocation(), EntityType.ITEM_DISPLAY);
            ritualCircles[i] = display;

            Transformation transformation = display.getTransformation();
            transformation.getScale().set(0, 0, 0);

            display.setTransformation(transformation);

            ItemStack stack = new ItemStack(getDisplayItemsType());
            ItemMeta meta = stack.getItemMeta();

            meta.setCustomModelData(i + getStartCustomModelData());
            meta.getPersistentDataContainer().set(RitualCircleKey, PersistentDataType.INTEGER, 1);

            stack.setItemMeta(meta);

            display.setItemStack(stack);
        }
    }

    private void AppearAnimation() {
        new AppearRunnable(this).runTaskTimer(Rituals.Instance, 0, 1);
    }

    public BasicRitual(Location location) {
        this.location = location;

        createCircles();

        AppearAnimation();

        basicUpdate = new BukkitRunnable() {
            @Override
            public void run() {
                if (!Appeared) return;

                BasicUpdateOfRitual();
                RitualTick();
            }
        }.runTaskTimer(Rituals.Instance, 0, 1);
    }

    public abstract void RitualTick();

    public void RemoveRitual() {
        for (ItemDisplay display : ritualCircles)
            display.remove();

        basicUpdate.cancel();
    }

    private void RotateParts() {
        for (int i = 0; i < 3; i++) {
            if (!getRotatingParts().get(i)) continue;

            ItemDisplay display = ritualCircles[i];
            display.setRotation(display.getLocation().getYaw() + getRotationPartsSpeed().get(i), 0);
        }
    }

    private void BasicUpdateOfRitual() {
        RotateParts();
    }

    public Location getLocation() {
        return location;
    }

    public ItemDisplay getRitualCircle(int index) {
        return ritualCircles[index];
    }
}