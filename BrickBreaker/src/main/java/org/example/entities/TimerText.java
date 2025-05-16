package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TimerText extends TextEntity {

    public TimerText(Coordinate2D initialLocation) {
        super(initialLocation, "Time: 0s");
        setFill(Color.WHITE);
        setFont(Font.font("Arial", 24));
    }
}
