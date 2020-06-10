package com.wd.view;

import com.wd.controller.GameOperate;
import com.wd.data.GameData;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private Container container;
    private GameOperate gameOperate;
    private GameData gameData;
    public MainWindow(GameData gameData, GameOperate gameOperate)  {
        this.gameData = gameData;
        this.gameOperate = gameOperate;
        this.setBounds(50,50,400,600);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置背景
        setBack();
        //添加画布必须添加在背景图片之上

        container = this.getLayeredPane();
        container.add(new StaticCanvas());
        container.add(new GameCanvas(gameData));
    }

    private void setBack() {
        ImageIcon imageIcon = new ImageIcon("img/bg.jpg");
        JLabel bg = new JLabel(imageIcon);
        bg.setBounds(0,0,400,600);
        this.getContentPane().add(bg);
    }

}
