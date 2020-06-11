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
        for (Point point:gameData.getBlock().getPoints()) {
            int x = point.x +gameData.getX();
            int y = point.y +gameData.getY();
            g.fillRect(x*20,y*20,20,20);
        }

        for (int i = 19; i >1; i--) {
            for (int j = 0; j < 10; j++) {
                if(gameData.getSaveBlocks()[j][i]!=0){
                    g.fillRect(j*20,(i-2)*20,20,20);
                }
            }
        }
    }
}
