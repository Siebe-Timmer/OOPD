package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.example.entities.Ball;
import org.example.entities.Paddle;
import org.example.tilemaps.RandomBrickTileMap;

public class GameScene extends DynamicScene implements TileMapContainer {

    public GameScene() {
    }

    @Override
    public void setupScene(){
        setBackgroundColor(Color.rgb(86, 154, 255));
    }

    @Override
    public void setupEntities(){
        var paddle = new Paddle(new Coordinate2D(getWidth()/2, getHeight()/6*5), new Size(100, 15));
        paddle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(paddle);

        var ball = new Ball(new Coordinate2D(getWidth()/2, 500));
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);
    }

    @Override
    public void setupTileMaps(){
        var tilemap = new RandomBrickTileMap(new Coordinate2D(getWidth()/2, 0+375/2), new Size(512, 375));
        tilemap.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addTileMap(tilemap);
    }

}
