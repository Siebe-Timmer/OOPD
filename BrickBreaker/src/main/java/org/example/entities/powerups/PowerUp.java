package org.example.entities.powerups;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.Paddle;

import java.util.List;

public class PowerUp extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    public PowerUp(String resource, Coordinate2D brickTopLeft, Size size) {
        super(resource, new Coordinate2D(
                brickTopLeft.getX() + 32,
                brickTopLeft.getY() + 16
        ), size);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
            if (c instanceof Paddle) {
                remove();
                break;
            }
        }
    }
}
