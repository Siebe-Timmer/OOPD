package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;

public interface PowerUpSpawner {
    void spawnPowerUp(Coordinate2D location, PowerUpType type);
}
