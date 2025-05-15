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

public class GameScene extends DynamicScene {

    private BrickGrid brickGrid;

    public GameScene() {
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.rgb(86, 154, 255));
    }

    @Override
    public void setupEntities() {
        var paddle = new Paddle(new Coordinate2D(getWidth() / 2, getHeight() / 6 * 5), new Size(100, 10));
        paddle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(paddle);

        var ball = new Ball(new Coordinate2D(getWidth() / 2, 500), paddle);
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);

        brickGrid = new BrickGrid();
        brickGrid.loadLayout(getLevel1Layout());

        for (Brick brick : brickGrid.getBricks()) {
            addEntity(brick);
        }
    }

    private int[][] getLevel1Layout() {
        return new int[][]{
                {1, 2, 1, 1, 0, 2, 1, 1},
                {2, 2, 1, 1, 1, 1, 2, 2},
                {1, 1, 1, 2, 1, 1, 1, 1}
        };
    }
}
