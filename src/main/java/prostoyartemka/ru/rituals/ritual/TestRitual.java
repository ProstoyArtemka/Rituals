package prostoyartemka.ru.rituals.ritual;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class TestRitual extends BasicRitual {
    public TestRitual(Location location) {
        super(location);

        ParticleBuilder builder = new ParticleBuilder(Particle.REDSTONE);
        builder.location(location.clone());

        builder.color(Color.RED);
        builder.count(10);

        builder.spawn();
    }

    @Override
    public void RitualTick() {
        Location l = getLocation().clone();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                if (Math.abs(x) == Math.abs(y)) continue;

                ParticleBuilder builder = new ParticleBuilder(Particle.REDSTONE);
                builder.location(l.clone().add(x * 1.5f, 0, y * 1.5f));

                builder.color(Color.RED);
                builder.count(5);

                builder.spawn();
            }
        }
    }

    @Override
    public List<Boolean> getRotatingParts() {
        return Arrays.asList(true, true, true);
    }

    @Override
    public int getStartCustomModelData() {
        return 5;
    }

    @Override
    public List<Integer> getRotationPartsSpeed() {
        return Arrays.asList(1, 3, 5);
    }

    @Override
    public Material getDisplayItemsType() {
        return Material.REDSTONE;
    }
}
