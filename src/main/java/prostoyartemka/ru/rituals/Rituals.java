package prostoyartemka.ru.rituals;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import prostoyartemka.ru.rituals.crafts.DiamondPowderCraft;
import prostoyartemka.ru.rituals.crafts.RitualPowderCraft;

import java.util.Arrays;
import java.util.List;

public final class Rituals extends JavaPlugin {

    public static List<Recipe> CraftRecipes = Arrays.asList(
            new RitualPowderCraft(),
            new DiamondPowderCraft()
    );

    private void registerRecipes() {
        for (Recipe r : CraftRecipes) {
            if (!(r instanceof Keyed)) continue;

            Keyed keyed = (Keyed) r;
            if (Bukkit.getRecipe(keyed.getKey()) == null) Bukkit.addRecipe(r);
        }
    }

    @Override
    public void onEnable() {
        registerRecipes();
    }

    @Override
    public void onDisable() {

    }
}
