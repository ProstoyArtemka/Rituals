package prostoyartemka.ru.rituals.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.persistence.PersistentDataContainer;
import prostoyartemka.ru.items.CustomItem;

import java.util.Collections;
import java.util.List;

public class RitualPowder implements CustomItem {
    @Override
    public String getName() {
        return ChatColor.WHITE + "Ритуальная пыль";
    }

    @Override
    public String getTag() {
        return "ritual_powder";
    }

    @Override
    public Material getType() {
        return Material.SUGAR;
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
