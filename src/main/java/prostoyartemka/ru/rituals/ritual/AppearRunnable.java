package prostoyartemka.ru.rituals.ritual;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

import java.util.Arrays;

public class AppearRunnable extends BukkitRunnable {

    private final BasicRitual ritual;

    public  AppearRunnable(BasicRitual ritual) {
        this.ritual = ritual;
    }

    @Override
    public void run() {

        boolean[] skip = new boolean[3];
        Arrays.fill(skip, false);

        for (int i = 0; i < 3; i++) {
            if (skip[i]) continue;

            ItemDisplay display = ritual.getRitualCircle(i);
            float speed = ritual.getAppearSpeed().get(i);

            Transformation transformation = display.getTransformation();
            transformation.getScale().set(transformation.getScale().x + speed);

            display.setTransformation(transformation);

            if (transformation.getScale().x > 1) {
                skip[i] = true;

                transformation.getScale().set(1);
                display.setTransformation(transformation);
            }
        }

        if (skip[0] && skip[1] && skip[2]) {
            this.cancel();

            ritual.Appeared = true;
        }
    }
}
