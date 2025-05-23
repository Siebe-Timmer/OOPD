package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.BrickBreaker;
import org.example.entities.Ball;
import org.example.entities.powerups.PowerUpSpawner;
import org.example.entities.powerups.PowerUpType;

import java.util.List;

public class MultiplyBrick extends Brick{

    private PowerUpSpawner spawner;

    public MultiplyBrick(Coordinate2D initialLocation, Size size, PowerUpSpawner spawner) {
        super("entities/multiply-brick.png", initialLocation, size);
        this.spawner = spawner;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Ball) {
                spawner.spawnPowerUp(getAnchorLocation(), PowerUpType.MULTIPLIER);
                remove();
                break;
            }
        }
    }




}
