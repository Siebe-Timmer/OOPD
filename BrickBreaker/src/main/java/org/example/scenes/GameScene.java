package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Ball;
import org.example.entities.BrickGrid;
import org.example.entities.Paddle;
import org.example.entities.bricks.Brick;
import org.example.entities.powerups.*;

import java.util.ArrayList;
import java.util.List;

public class GameScene extends DynamicScene implements PowerUpSpawner, BallSpawner, BallManager {

    private BrickGrid brickGrid;
    private Paddle paddle;
    private final List<Ball> balls = new ArrayList<>();

    @Override
    public void setupScene() {
        setBackgroundColor(Color.rgb(86, 154, 255));
    }

    @Override
    public void setupEntities() {
        paddle = new Paddle(new Coordinate2D(getWidth() / 2, getHeight() / 6 * 5), new Size(100, 10));
        paddle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(paddle);

        var ball = new Ball(new Coordinate2D(getWidth() / 2, 500), paddle, this);
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);
        addBall(ball);

        brickGrid = new BrickGrid(this);
        brickGrid.loadLayout(getLevel1Layout());

        for (Brick brick : brickGrid.getBricks()) {
            addEntity(brick);
        }
    }

    @Override
    public void spawnPowerUp(Coordinate2D location, PowerUpType type) {
        location = location.subtract(new Coordinate2D(10, 10)); // center fix
        switch (type) {
            case SPEED -> addEntity(new SpeedPowerUp(location, this));
            case MULTIPLIER -> addEntity(new MultiplyPowerUp(location, this));
        }
    }


    @Override
    public void spawnExtraBall(Coordinate2D location, double angle) {
        var newBall = new Ball(location, paddle, this);
        newBall.setAnchorLocation(location);
        newBall.setMotion(2, angle);
        addEntity(newBall);
        addBall(newBall);
    }



    @Override
    public void addBall(Ball ball) {
        balls.add(ball);
    }

    @Override
    public void applyTemporarySpeedBoost(double factor, int durationInSeconds) {
        for (Ball ball : balls) {
            ball.setSpeed(ball.getSpeed() * factor);
        }

        new Thread(() -> {
            try {
                Thread.sleep(durationInSeconds * 1000L);
            } catch (InterruptedException ignored) {
            }
            for (Ball ball : balls) {
                ball.setSpeed(2);
            }
        }).start();
    }


    private int[][] getLevel1Layout() {
        return new int[][]{
                {1, 2, 3, 4, 0, 2, 1, 1},
                {2, 2, 2, 3, 4, 2, 2, 2},
                {1, 4, 1, 2, 1, 1, 3, 1}
        };
    }
}
