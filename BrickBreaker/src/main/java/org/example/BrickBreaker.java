package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameScene;
import org.example.scenes.StartScene;

public class BrickBreaker extends YaegerGame {

    private static final String GAME_TITLE = "Brick Breaker";

    public static final Size GAME_SIZE = new Size(512, 756);

    public static final int SCENE_START = 1;
    public static final int SCENE_GAME = 2;

    private GameScene gameScene;  // Houd huidige gameScene bij

    public static void main(String[] args) {
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
        // Voeg voorlopig geen GameScene toe want die willen we dynamisch aanmaken per level
    }

    // Methode om GameScene te starten op basis van level nummer
    public void startGameScene(int levelNumber) {
        int[][] layout;
        switch (levelNumber) {
            case 1 -> layout = GameScene.getLevel1Layout();
            case 2 -> layout = GameScene.getLevel2Layout();
            case 3 -> layout = GameScene.getLevel3Layout();
            default -> layout = GameScene.getLevel1Layout();
        }
        gameScene = new GameScene(layout);
        addScene(SCENE_GAME, gameScene);
        setActiveScene(SCENE_GAME);
    }
}
