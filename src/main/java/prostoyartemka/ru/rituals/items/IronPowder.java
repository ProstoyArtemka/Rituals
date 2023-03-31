package prostoyartemka.ru.rituals.items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataContainer;
import prostoyartemka.ru.items.CustomItem;

import java.util.Collections;
import java.util.List;

public class IronPowder implements CustomItem {
    @Override
    public String getName() {
        return ChatColor.WHITE + "Железная пыль";
    }

    @Override
    public String getTag() {
        return "iron_powder";
    }

    @Override
    public Material getType() {
        return Material.IRON_INGOT;
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
    public void setCustomData(PersistentDataContainer persistentDataContainer) {

    }
}
