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
        mainWindow.setVisible(true);
    }


}
