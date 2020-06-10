package com.wd.data;

import java.awt.*;

public class Block {
    private Point[] points;

    public Block(int[] xs,int[] ys) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(xs[i],ys[i]);
        }
    }

    public Block(Block block) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(block.points[i].x,block.points[i].y);
        }
    }

    public Point[] getPoints() {
        return points;
    }
}
