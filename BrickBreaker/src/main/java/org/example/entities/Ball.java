package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;
import org.example.entities.bricks.Brick;

import java.util.List;

public class Ball extends DynamicCircleEntity implements Collider, Collided {

    private Paddle paddle;

    public Ball(Coordinate2D initialLocation, Paddle paddle) {
        super(initialLocation);
        super.setRadius(10);
        super.setFill(Color.WHITE);
        this.paddle = paddle;
        setMotion(2, 0d);
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Paddle paddle) {
                double paddleWidth = 100; // of paddle.getWidth() als dat werkt
                double paddleCenterX = paddle.getAnchorLocation().getX();
                double ballCenterX = getAnchorLocation().getX();

                double relativeImpact = (ballCenterX - (paddleCenterX - paddleWidth / 2)) / paddleWidth;
                relativeImpact = Math.max(0, Math.min(1, relativeImpact));

                double minAngle = 225;
                double maxAngle = 135;
                double angle = minAngle + (maxAngle - minAngle) * relativeImpact;

                setMotion(getSpeed(), angle);
            } else if (c instanceof Brick) {
                // Voor nu: altijd rechtdoor omhoog
                setMotion(getSpeed(), 0d);
            }
        }
    }

}
