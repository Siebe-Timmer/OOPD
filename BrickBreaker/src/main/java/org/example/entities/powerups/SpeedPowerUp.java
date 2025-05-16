package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.Paddle;

import java.util.List;

public class SpeedPowerUp extends PowerUp {

    private static final Size DEFAULT_SIZE = new Size(20, 20);
    private final BallManager ballManager;

    public SpeedPowerUp(Coordinate2D initialLocation, BallManager ballManager) {
        this(initialLocation, DEFAULT_SIZE, ballManager);
    }

    public SpeedPowerUp(Coordinate2D initialLocation, Size size, BallManager ballManager) {
        super("entities/speed-powerup.png", initialLocation, size);
        this.ballManager = ballManager;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Paddle) {
                remove();
                ballManager.applyTemporarySpeedBoost(1.5, 10);
                break;
            }
        }
    }
}
