package prostoyartemka.ru.rituals.crafts;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;
import prostoyartemka.ru.items.CustomItem;
import prostoyartemka.ru.rituals.items.DiamondPowder;
import prostoyartemka.ru.rituals.items.RitualPowder;

public class RitualPowderCraft extends ShapelessRecipe {
    public static NamespacedKey PowderKey = new NamespacedKey("rituals", "ritual_powder_craft");

    public RitualPowderCraft() {
        super(PowderKey, CustomItem.GetItemStack(new RitualPowder()));

        this.addIngredient(Material.REDSTONE);
        this.addIngredient(Material.COAL);
        this.addIngredient(CustomItem.GetItemStack(new DiamondPowder()));
    }
}
