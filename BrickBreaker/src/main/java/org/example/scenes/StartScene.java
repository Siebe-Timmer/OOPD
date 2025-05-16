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
        var brickbreakerText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "BrickBreaker"
        );
        brickbreakerText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        brickbreakerText.setFill(Color.BLACK);
        brickbreakerText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(brickbreakerText);

        var level1Button = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50), brickBreaker, 1);
        addEntity(level1Button);

        // Level 2 knop
        var level2Button = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), brickBreaker, 2);
        addEntity(level2Button);

        // Level 3 knop
        var level3Button = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 150), brickBreaker, 3);
        addEntity(level3Button);
    }


}
