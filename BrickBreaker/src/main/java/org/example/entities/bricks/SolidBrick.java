package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.powerups.PowerUpSpawner;

import java.util.List;

public class SolidBrick extends Brick {

    private final PowerUpSpawner powerUpSpawner;

    public SolidBrick(Coordinate2D initialLocation, Size size, PowerUpSpawner powerUpSpawner) {
        super("entities/solid-brick.png", initialLocation, size);
        this.powerUpSpawner = powerUpSpawner;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
    }
}
