package prostoyartemka.ru.rituals.crafts;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import prostoyartemka.ru.blocks.CustomBlock;
import prostoyartemka.ru.items.CustomItem;
import prostoyartemka.ru.rituals.blocks.Pedestal;
import prostoyartemka.ru.rituals.items.IronPowder;

public class PedestalCraft extends ShapedRecipe {
    public static NamespacedKey PedestalCraftKey = new NamespacedKey("rituals", "pedestal_craft");

    public PedestalCraft() {
        super(PedestalCraftKey, CustomBlock.GetItemStack(new Pedestal()));

        shape("SWS",
              "ARA",
              "SWS");

        setIngredient('S', Material.DARK_OAK_SLAB);
        setIngredient('A', Material.AIR);
        setIngredient('W', Material.DARK_OAK_WOOD);

        setIngredient('R', CustomItem.GetItemStack(new IronPowder()));
    }
}
