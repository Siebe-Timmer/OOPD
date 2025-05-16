package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class MultiplyPowerUp extends PowerUp {

    private static final Size DEFAULT_SIZE = new Size(20, 20);

    public MultiplyPowerUp(Coordinate2D initialLocation, Size size) {
        super("entities/multiply-powerup.png", initialLocation, size);
    }

    public MultiplyPowerUp(Coordinate2D initialLocation) {
        this(initialLocation, DEFAULT_SIZE);
    }
}
