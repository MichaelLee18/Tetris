package com.wd.view;

import com.wd.controller.GameOperate;

import javax.swing.*;
import java.awt.*;

public class StaticCanvas extends JPanel {
    //添加按钮
    private JButton up;
    private JButton left;
    private JButton down;
    private JButton right;
    private JButton start;
    public StaticCanvas(GameOperate gameOperate) {
        up = gameOperate.getUp();
        left = gameOperate.getLeft();
        down = gameOperate.getDown();
        right = gameOperate.getRight();
        start = gameOperate.getStart();
        setOpaque(false);
        this.setLayout(null);
        this.setBounds(0,0,400,600);
        up.setBounds(80,400,80,60);
        left.setBounds(20,446,80,60);
        down.setBounds(80,495,80,60);
        right.setBounds(140,446,80,60);
        start.setBounds(78,446,80,60);
        add(up);
        add(left);
        add(down);
        add(right);
        add(start);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0,0,0,30));
        //主区域
        g.fillRect(20,30,10*20,18*20);
        //得分区
        g.fillRect(250,30,120,80);
        //图形提示区
        g.fillRect(250,130,120,100);
        //按钮区
        g.fillRect(250,250,120,140);
        //排行榜
        g.fillRect(20,405,200,140);
        //设置边框
        g.setColor(Color.white);
        ((Graphics2D)g).setStroke(new BasicStroke(3L));
        g.drawRect(18,28,204,364);
        g.drawRect(248,28,124,84);
        g.drawRect(248,128,124,104);
        g.drawRect(248,248,124,144);
        g.drawRect(18,403,204,144);
        //设置文字
        g.setFont(new Font("黑体",Font.PLAIN,20));
        g.setColor(Color.darkGray);
        g.drawString("得分",256,60);
        g.drawString("下一个",256,160);
        g.drawString("排行榜",275,280);

    }
}
