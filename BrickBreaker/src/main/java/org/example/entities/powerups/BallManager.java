package org.example.entities.powerups;

import org.example.entities.Ball;

public interface BallManager {
    void addBall(Ball ball);
    void applyTemporarySpeedBoost(double factor, int durationInSeconds);
}
