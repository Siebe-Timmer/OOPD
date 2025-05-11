package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.BrickBreaker;
import org.example.buttons.StartButton;

public class StartScene extends StaticScene {

    private BrickBreaker brickBreaker;

    public StartScene(BrickBreaker brickBreaker) {
        this.brickBreaker = brickBreaker;
    }

    @Override
    public void setupScene(){
        setBackgroundColor(Color.WHITE);
    }

    @Override
    public void setupEntities(){
        var waterworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "BrickBreaker"
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.BLACK);
        waterworldText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(waterworldText);

        var startButton = new StartButton(new Coordinate2D(getWidth()/2, getHeight()/2 + 100), brickBreaker);
        addEntity(startButton);
    }


}
