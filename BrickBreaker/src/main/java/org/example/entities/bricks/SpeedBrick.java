package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.Ball;
import org.example.entities.powerups.PowerUpSpawner;
import org.example.entities.powerups.PowerUpType;

import java.util.List;

public class SpeedBrick extends Brick {

    private final PowerUpSpawner spawner;

    public SpeedBrick(Coordinate2D initialLocation, Size size, PowerUpSpawner spawner) {
        super("entities/speed-brick.png", initialLocation, size);
        this.spawner = spawner;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Ball) {
                spawner.spawnPowerUp(getAnchorLocation(), PowerUpType.SPEED);
                remove();
                break;
            }
        }
    }
}
