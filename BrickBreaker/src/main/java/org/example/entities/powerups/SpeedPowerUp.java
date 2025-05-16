package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SpeedPowerUp extends PowerUp {

    private static final Size DEFAULT_SIZE = new Size(20, 20);

    public SpeedPowerUp(Coordinate2D initialLocation, Size size) {
        super("entities/speed-powerup.png", initialLocation, size);
    }

    public SpeedPowerUp(Coordinate2D initialLocation) {
        this(initialLocation, DEFAULT_SIZE);
    }
}
