package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.BrickBreaker;
import org.example.entities.bricks.*;
import org.example.entities.powerups.PowerUpSpawner;

import java.util.ArrayList;
import java.util.List;

public class BrickGrid {

    private final List<Brick> bricks = new ArrayList<>();
    private final PowerUpSpawner powerUpSpawner;

    public BrickGrid(PowerUpSpawner powerUpSpawner) {
        this.powerUpSpawner = powerUpSpawner;
    }

    public void loadLayout(int[][] layout) {
        bricks.clear();

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                int type = layout[row][col];
                Size size = new Size(64, 32);

                Brick brick = switch (type) {
                    case 1 -> new SolidBrick(new Coordinate2D(col * 64, row * 32), size, powerUpSpawner);
                    case 2 -> new NormalBrick(new Coordinate2D(col * 64, row * 32), size, powerUpSpawner);
                    case 3 -> new MultiplyBrick(new Coordinate2D(col * 64, row * 32), size, powerUpSpawner);
                    case 4 -> new SizeBrick(new Coordinate2D(col * 64, row * 32), size, powerUpSpawner);
                    case 5 -> new SpeedBrick(new Coordinate2D(col * 64, row * 32), size, powerUpSpawner);
                    default -> null;
                };

                if (brick != null) {
                    bricks.add(brick);
                }
            }
        }
    }

    public List<Brick> getBricks() {
        return bricks;
    }
}

