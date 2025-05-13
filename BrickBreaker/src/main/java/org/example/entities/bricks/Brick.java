package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Brick extends SpriteEntity {

    public Brick(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

}
