package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import org.example.entities.bricks.Brick;
import org.example.entities.powerups.BallManager;

import java.util.List;

public class Ball extends DynamicCircleEntity implements Collider, Collided, SceneBorderTouchingWatcher {

    private BallManager ballManager;

    public Ball(Coordinate2D initialLocation, BallManager ballManager) {
        super(initialLocation);
        this.ballManager = ballManager;

        super.setRadius(10);
        super.setFill(Color.WHITE);
        setMotion(2, 0d);

        ballManager.addBall(this);
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof Paddle paddle) {
                double paddleWidth = 100;
                double paddleCenterX = paddle.getAnchorLocation().getX();
                double ballCenterX = getAnchorLocation().getX();

                double relativeImpact = (ballCenterX - (paddleCenterX - paddleWidth / 2)) / paddleWidth;
                relativeImpact = Math.max(0, Math.min(1, relativeImpact));

                double minAngle = 225;
                double maxAngle = 135;
                double angle = minAngle + (maxAngle - minAngle) * relativeImpact;

                setMotion(getSpeed(), angle);

            } else if (c instanceof Brick brick) {

                double ballX = getAnchorLocation().getX();
                double ballY = getAnchorLocation().getY();
                double brickX = brick.getAnchorLocation().getX();
                double brickY = brick.getAnchorLocation().getY();

                double dx = Math.abs(ballX - brickX);
                double dy = Math.abs(ballY - brickY);

                double halfWidth = 64 / 2.0;
                double halfHeight = 32 / 2.0;

                double overlapX = halfWidth - dx;
                double overlapY = halfHeight - dy;

                double direction = getDirection();
                double newDirection;

                if (overlapX < overlapY) {
                    newDirection = (360 - direction) % 360;
                } else {
                    newDirection = (180 - direction + 360) % 360;
                }

                setDirection(newDirection);


            }
        }
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        double direction = getDirection();

        switch (sceneBorder) {
            case LEFT:
            case RIGHT:
                setDirection((360 - direction) % 360);
                break;

            case TOP:
                setDirection((180 - direction + 360) % 360);
                break;
            case BOTTOM:
                ballManager.removeBall(this);  // Laat GameScene weten dat deze bal weg is
                remove();
                break;



        }

    }

}