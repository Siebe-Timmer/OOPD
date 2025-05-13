package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameScene;
import org.example.scenes.StartScene;


public class BrickBreaker extends YaegerGame
{

    private static final String GAME_TITLE = "Brick Breaker";

    public static final Size GAME_SIZE = new Size(512, 756);

    public static final int SCENE_START = 1;
    public static final int SCENE_GAME = 2;

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle(GAME_TITLE);
        setSize(GAME_SIZE);
    }

    @Override
    public void setupScenes() {
        addScene(SCENE_START, new StartScene(this));
        addScene(SCENE_GAME, new GameScene());
    }
}
