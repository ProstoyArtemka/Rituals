package prostoyartemka.ru.rituals.crafts;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import prostoyartemka.ru.items.CustomItem;
import prostoyartemka.ru.rituals.items.DiamondPowder;
import prostoyartemka.ru.rituals.items.IronPowder;

public class IronPowderCraft extends SmithingRecipe {
    public static NamespacedKey DiamondPowderCraft = new NamespacedKey("rituals", "iron_powder_craft");

    public IronPowderCraft() {
        super(DiamondPowderCraft, CustomItem.GetItemStack(new IronPowder()),
                new RecipeChoice.MaterialChoice(Material.IRON_INGOT), new RecipeChoice.MaterialChoice(Material.FLINT));
    }
}
