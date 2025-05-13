package org.example.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import org.example.entities.bricks.MultiplyBrick;
import org.example.entities.bricks.NormalBrick;

import java.util.Random;

public class RandomBrickTileMap extends TileMap {


        public RandomBrickTileMap(Coordinate2D location, Size size) {
            super(location, size);
        }

        @Override
        public void setupEntities() {
            addEntity(1, NormalBrick.class);
            addEntity(2, MultiplyBrick.class);
        }


    @Override
        public int[][] defineMap() {
            int rows = 20;    // Aantal rijen bricks
            int cols = 8;   // Aantal kolommen
            int[][] map = new int[rows][cols];

            Random random = new Random();

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int chance = random.nextInt(100);

                    if (chance < 50) {
                        map[row][col] = 2;
                    } else {
                        map[row][col] = 1;
                    }
                }
            }

            return map;
        }

}
