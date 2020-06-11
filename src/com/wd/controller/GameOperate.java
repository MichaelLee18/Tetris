package com.wd.controller;

import com.wd.data.GameData;
import com.wd.view.ImageButton;
import com.wd.view.MainWindow;

public class GameOperate {
    private GameData gameData;
    private MainWindow mainWindow;
    private ImageButton up;
    private ImageButton left;
    private ImageButton down;
    private ImageButton right;
    private ImageButton start;

    public GameOperate() {
        up = new ImageButton("img/up.png") {
            @Override
            public void onclick() {
                gameData.rotate();
                mainWindow.getGameCanvas().repaint();
            }
        };
        left = new ImageButton("img/left.png") {
            @Override
            public void onclick() {
                gameData.change(true,-1);
                mainWindow.getGameCanvas().repaint();
            }
        };
        down = new ImageButton("img/down.png") {
            @Override
            public void onclick() {
                gameData.change(false,1);
                mainWindow.getGameCanvas().repaint();
            }
        };
        right = new ImageButton("img/right.png") {
            @Override
            public void onclick() {
                gameData.change(true,1);
                mainWindow.getGameCanvas().repaint();
            }
        };
        start = new ImageButton("img/start.png") {
            @Override
            public void onclick() {

            }
        };
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public ImageButton getUp() {
        return up;
    }

    public ImageButton getLeft() {
        return left;
    }

    public ImageButton getDown() {
        return down;
    }

    public ImageButton getRight() {
        return right;
    }

    public ImageButton getStart() {
        return start;
    }
}
