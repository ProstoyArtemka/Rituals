package prostoyartemka.ru.rituals;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import prostoyartemka.ru.rituals.crafts.DiamondPowderCraft;
import prostoyartemka.ru.rituals.crafts.RitualPowderCraft;
import prostoyartemka.ru.rituals.events.RitualPowderListener;

import java.util.Arrays;
import java.util.List;

public final class Rituals extends JavaPlugin {
    public static List<Recipe> CraftRecipes = Arrays.asList(
            new RitualPowderCraft(),
            new DiamondPowderCraft()
    );

    public static List<Listener> Listeners = Arrays.asList(
            new RitualPowderListener()
    );

    public static Rituals Instance;

    private void registerRecipes() {
        for (Recipe r : CraftRecipes) {
            if (!(r instanceof Keyed)) continue;

            Keyed keyed = (Keyed) r;
            if (Bukkit.getRecipe(keyed.getKey()) == null) Bukkit.addRecipe(r);
        }
    }

    private void registerListeners() {
        for (Listener l : Listeners) {
            Bukkit.getPluginManager().registerEvents(l, this);
        }
    }

    @Override
    public void onEnable() {
        Instance = this;

        registerRecipes();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }
}
