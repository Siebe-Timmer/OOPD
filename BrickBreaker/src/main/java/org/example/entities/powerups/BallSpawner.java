package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;

public interface BallSpawner {
    void spawnExtraBall(Coordinate2D location, double angle);
}
