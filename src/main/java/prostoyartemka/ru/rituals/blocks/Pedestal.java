package prostoyartemka.ru.rituals.blocks;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import prostoyartemka.ru.blocks.CustomBlock;
import prostoyartemka.ru.blocks.Rotation;

import java.util.Collections;
import java.util.List;

public class Pedestal implements CustomBlock {

    public static NamespacedKey PedestalItemEntity = new NamespacedKey("rituals", "pedestal_item_entity");

    @Override
    public String getName() {
        return ChatColor.WHITE + "Пьедестал";
    }

    @Override
    public String getTag() {
        return "pedestal";
    }

    @Override
    public Material getType() {
        return Material.DARK_OAK_FENCE;
    }

    @Override
    public int getCustomModelData() {
        return 1;
    }

    @Override
    public List<String> getLore() {
        return Collections.emptyList();
    }

    @Override
    public Rotation getRotation() {
        return Rotation.NONE;
    }

    @Override
    public boolean isPistonMovable() {
        return false;
    }

    @Override
    public void setCustomData(PersistentDataContainer persistentDataContainer) {

    }
}
