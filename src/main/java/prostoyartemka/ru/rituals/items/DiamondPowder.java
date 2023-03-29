package prostoyartemka.ru.rituals.items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataContainer;
import prostoyartemka.ru.items.CustomItem;

import java.util.Collections;
import java.util.List;

public class DiamondPowder implements CustomItem {
    @Override
    public String getName() {
        return ChatColor.WHITE + "Алмазная пыль";
    }

    @Override
    public String getTag() {
        return "diamond_powder";
    }

    @Override
    public Material getType() {
        return Material.DIAMOND;
    }

    @Override
    public int getCustomModelData() {
        return 2;
    }

    @Override
    public List<String> getLore() {
        return Collections.emptyList();
    }

    @Override
    public void setCustomData(PersistentDataContainer persistentDataContainer) {

    }
}
