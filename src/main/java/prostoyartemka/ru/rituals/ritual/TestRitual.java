package prostoyartemka.ru.rituals.ritual;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.Arrays;
import java.util.List;

public class TestRitual extends BasicRitual {

    private List<Integer> RotationPartsSpeed = Arrays.asList(1, 3, 5);

    public TestRitual(Location location) {
        super(location);

        ParticleBuilder builder = new ParticleBuilder(Particle.REDSTONE);
        builder.location(location.clone());

        builder.color(Color.RED);
        builder.count(10);

        builder.spawn();
    }

    private void candlesCheck() {
        Location l = getLocation().clone();

        int countOfCandles = 1;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                if (Math.abs(x) == Math.abs(y)) continue;
                Location candleLocation = l.clone().add(x, 0, y);

                ParticleBuilder builder = new ParticleBuilder(Particle.REDSTONE);
                builder.location(candleLocation.toCenterLocation());

                builder.color(Color.RED);
                builder.count(5);

                if (!Tag.CANDLES.isTagged(candleLocation.getBlock().getType())) builder.spawn();
                else countOfCandles++;
            }
        }

        for (int i = 0; i < 3; i++) {
            RotationPartsSpeed = Arrays.asList(countOfCandles, 3 * countOfCandles, 5 * countOfCandles);
        }

    }

    @Override
    public void RitualTick() {
        candlesCheck();
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
        return RotationPartsSpeed;
    }

    @Override
    public List<Float> getAppearSpeed() {
        return Arrays.asList(0.04f, 0.03f, 0.02f);
    }

    @Override
    public Material getDisplayItemsType() {
        return Material.REDSTONE;
    }
}
