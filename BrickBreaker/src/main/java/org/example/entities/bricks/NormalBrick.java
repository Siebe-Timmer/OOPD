package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.entities.powerups.PowerUpSpawner;

public class NormalBrick extends Brick {

    private final PowerUpSpawner powerUpSpawner;

    public NormalBrick(Coordinate2D location, Size size, PowerUpSpawner powerUpSpawner) {
        super("entities/normal-brick.png", location, size);
        this.powerUpSpawner = powerUpSpawner;
    }
}
