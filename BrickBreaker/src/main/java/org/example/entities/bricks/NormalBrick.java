package org.example.entities.bricks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
public class NormalBrick extends Brick{
    public NormalBrick(Coordinate2D location, Size size) {
        super("entities/normal-brick.png", location, size);
    }

}
