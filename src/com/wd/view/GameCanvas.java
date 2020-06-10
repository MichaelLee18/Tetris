package com.wd.view;

import com.wd.data.GameData;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private GameData gameData;
    public GameCanvas(GameData gameData) {
        this.gameData = gameData;
        setOpaque(false);
        setBounds(20,30,200,360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //主区域
        g.fillRect(gameData.getX(),gameData.getY(),20,20);

    }
}
