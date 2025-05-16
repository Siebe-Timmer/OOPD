package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SizePowerUp extends PowerUp {

    private static final Size DEFAULT_SIZE = new Size(20, 20);

    public SizePowerUp(Coordinate2D initialLocation, Size size) {
        super("entities/size-powerup.png", initialLocation, size);
    }

    public SizePowerUp(Coordinate2D initialLocation) {
        this(initialLocation, DEFAULT_SIZE);
    }
}
