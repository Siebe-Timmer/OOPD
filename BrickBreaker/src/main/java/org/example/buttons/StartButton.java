package org.example.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.BrickBreaker;

public class StartButton extends TextEntity implements MouseButtonPressedListener {
    private BrickBreaker brickBreaker;

    public StartButton(Coordinate2D initialLocation, BrickBreaker brickBreaker) {
        super(initialLocation,"PLAY");
        this.brickBreaker = brickBreaker;
        setFill(Color.BLUE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        brickBreaker.setActiveScene(2);
    }

}
