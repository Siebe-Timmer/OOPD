package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Ball;
import org.example.entities.BrickGrid;
import org.example.entities.Paddle;
import org.example.entities.TimerText;
import org.example.entities.bricks.Brick;
import org.example.entities.powerups.*;

import java.util.ArrayList;
import java.util.List;

public class GameScene extends DynamicScene implements PowerUpSpawner, BallSpawner, BallManager, TimerContainer {

    private BrickGrid brickGrid;
    private Paddle paddle;
    private final List<Ball> balls = new ArrayList<>();

    private TimerText timerText;
    private long startTime;

    private final int[][] levelLayout;

    public GameScene(int[][] levelLayout) {
        this.levelLayout = levelLayout;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.rgb(86, 154, 255));
    }

    @Override
    public void setupEntities() {
        paddle = new Paddle(new Coordinate2D(getWidth() / 2, getHeight() / 6 * 5), new Size(100, 10));
        paddle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(paddle);

        var ball = new Ball(new Coordinate2D(getWidth() / 2, 500), this);
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);

        brickGrid = new BrickGrid(this);
        brickGrid.loadLayout(levelLayout);

        for (Brick brick : brickGrid.getBricks()) {
            addEntity(brick);
        }

        timerText = new TimerText(new Coordinate2D(20, getHeight() - 40));
        addEntity(timerText);

        startTime = System.currentTimeMillis();
    }

    @Override
    public void setupTimers() {
        Timer updateTimerText = new Timer(1000L) {
            @Override
            public void onAnimationUpdate(long timestamp) {
                long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
                timerText.setText("Time: " + elapsedSeconds + "s");
            }
        };
        addTimer(updateTimerText);
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
        var newBall = new Ball(location, this);
        newBall.setAnchorLocation(location);
        newBall.setMotion(2, angle);
        addEntity(newBall);
    }

    @Override
    public void addBall(Ball ball) {
        System.out.println("addBall called for ball: " + ball);

    }

    @Override
    public void removeBall(Ball ball) {
        System.out.println("removeBall called for ball: " + ball);
        balls.remove(ball);
        System.out.println("Aantal ballen na verwijderen: " + balls.size());
        if (balls.isEmpty()) {
            System.out.println("Alle ballen zijn weg!");
            onAllBallsLost();
        }
    }

    private void onAllBallsLost() {
        System.out.println("Alle ballen zijn weg, game over!");
        // Hier kun je de scene veranderen of game-over logica toevoegen
    }

    @Override
    public void applyTemporarySpeedBoost(double factor, int durationInSeconds) {
        for (Ball ball : balls) {
            ball.setSpeed(ball.getSpeed() * factor);
        }

        Timer resetSpeedTimer = new Timer(durationInSeconds * 1000L) {
            private boolean executed = false;

            @Override
            public void onAnimationUpdate(long timestamp) {
                if (!executed) {
                    for (Ball ball : balls) {
                        ball.setSpeed(2);
                    }
                    executed = true;
                }
            }

            @Override
            public boolean isGarbage() {
                return executed;
            }
        };

        addTimer(resetSpeedTimer);
    }

    // Public getters voor de layouts zodat BrickBreaker ze kan gebruiken

    public static int[][] getLevel1Layout() {
        return new int[][]{
                {1, 2, 3, 4, 0, 2, 1, 1},
                {2, 2, 2, 3, 4, 2, 2, 2},
                {1, 4, 1, 2, 1, 1, 3, 1}
        };
    }

    public static int[][] getLevel2Layout() {
        return new int[][]{
                {1, 2, 3, 4, 0, 2, 1, 1},
                {2, 2, 2, 3, 4, 2, 2, 2},
                {1, 4, 1, 2, 1, 1, 3, 1},
                {1, 4, 1, 2, 1, 1, 3, 1}
        };
    }

    public static int[][] getLevel3Layout() {
        return new int[][]{
                {1, 2, 3, 4, 0, 2, 1, 1},
                {2, 2, 2, 3, 4, 2, 2, 2},
                {1, 2, 3, 4, 0, 2, 1, 1},
                {2, 2, 2, 3, 4, 2, 2, 2},
                {1, 4, 1, 2, 1, 1, 3, 1}
        };
    }
}
