package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.Ball;

import java.util.List;

public class PowerUp extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    protected PowerUp(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setMotion(1, 0d);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case BOTTOM:
                remove();
                break;
            default:
                break;
        }
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
