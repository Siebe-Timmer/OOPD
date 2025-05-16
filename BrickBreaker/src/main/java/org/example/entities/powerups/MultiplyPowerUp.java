package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.Paddle;

import java.util.List;
import java.util.Random;

public class MultiplyPowerUp extends PowerUp {

    private static final Size DEFAULT_SIZE = new Size(20, 20);
    private final BallSpawner ballSpawner;

    public MultiplyPowerUp(Coordinate2D initialLocation, BallSpawner ballSpawner) {
        super("entities/multiply-powerup.png", initialLocation, DEFAULT_SIZE);
        this.ballSpawner = ballSpawner;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Paddle) {
                spawnExtraBalls();
                remove();
                break;
            }
        }
    }

    private void spawnExtraBalls() {
        Coordinate2D spawnLocation = getAnchorLocation();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            double angle = random.nextDouble() * 360;
            ballSpawner.spawnExtraBall(spawnLocation, angle);
        }
    }
}
