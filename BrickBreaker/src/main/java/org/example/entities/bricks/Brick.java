package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.entities.Ball;

import java.util.List;

public abstract class Brick extends SpriteEntity implements Collided, Collider{

    public Brick(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Ball) {
                remove();
                break;
            }
        }
    }

}
