package prostoyartemka.ru.rituals.crafts;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import prostoyartemka.ru.items.CustomItem;
import prostoyartemka.ru.rituals.items.DiamondPowder;

public class DiamondPowderCraft extends SmithingRecipe {

    public static NamespacedKey DiamondPowderCraft = new NamespacedKey("rituals", "diamond_powder_craft");

    public DiamondPowderCraft() {
        super(DiamondPowderCraft, CustomItem.GetItemStack(new DiamondPowder()),
                new RecipeChoice.MaterialChoice(Material.DIAMOND), new RecipeChoice.MaterialChoice(Material.FLINT));
    }
}
