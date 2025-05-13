package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class Ball extends DynamicCircleEntity {

    public Ball(Coordinate2D initialLocation) {
        super(initialLocation);
        super.setRadius(10);
        super.setFill(Color.WHITE);
    }

}
