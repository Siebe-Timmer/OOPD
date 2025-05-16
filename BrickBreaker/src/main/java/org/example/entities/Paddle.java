package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Paddle extends DynamicSpriteEntity implements KeyListener, Collider {
    public Paddle(Coordinate2D initialLocation, Size size) {
        super("entities/normal-paddle.png", initialLocation, size);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            if(getLocationInScene().getX() < 50){
                setSpeed(0);
            } else {
                setMotion(5, 270d);
            }
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            if(getLocationInScene().getX() > 462){
                setSpeed(0);
            } else {
                setMotion(5, 90d);
            }
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }


}
