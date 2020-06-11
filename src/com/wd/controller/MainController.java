package com.wd.controller;

import com.wd.data.GameData;
import com.wd.view.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MainController extends JFrame{

    public static void main(String[] args) {
        GameData gameData = new GameData();
        GameOperate gameOperate = new GameOperate();
        MainWindow mainWindow = new MainWindow(gameData,gameOperate);
        gameOperate.setGameData(gameData);
        gameOperate.setMainWindow(mainWindow);
        new AutoMove(gameData,mainWindow).start();
        mainWindow.setVisible(true);
    }
}
class AutoMove extends Thread{
    private GameData gameData;
    private MainWindow mainWindow;

    public AutoMove(GameData gameData, MainWindow mainWindow) {
        this.gameData = gameData;
        this.mainWindow = mainWindow;
    }

    @Override
    public void run() {
        while(true){
            try {
                gameData.change(false,1);
                mainWindow.getGameCanvas().repaint();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}