package org.example.entities.powerups;

import org.example.entities.Ball;

public interface BallManager {
    void addBall(Ball ball);
    void removeBall(Ball ball);  // Toevoegen
    void applyTemporarySpeedBoost(double factor, int durationInSeconds);
}

