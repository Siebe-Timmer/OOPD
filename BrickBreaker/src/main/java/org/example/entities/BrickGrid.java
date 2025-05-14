package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.entities.bricks.Brick;
import org.example.entities.bricks.MultiplyBrick;
import org.example.entities.bricks.NormalBrick;

import java.util.ArrayList;
import java.util.List;

public class BrickGrid {

    private final List<Brick> bricks = new ArrayList<>();

    public void loadLayout(int[][] layout) {
        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                int type = layout[row][col];

                Size size = new Size(64, 32);

                Brick brick = switch (type) {
                    case 1 -> new NormalBrick(new Coordinate2D(col * 64, row * 32), size);
                    case 2 -> new MultiplyBrick(new Coordinate2D(col * 64, row * 32), size);
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
