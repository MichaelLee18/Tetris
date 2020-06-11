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

    /**-1,0,1,2
     * -1,0
     * 0,0
     * 1,0
     * 2,0
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
        for (Point point:gameData.getBlock().getPoints()) {
            int x = point.x +gameData.getX();
            int y = point.y +gameData.getY();
            g.fillRect(x*20,y*20,20,20);
        }


    }
}
