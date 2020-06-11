package com.wd.data;

import java.awt.*;

public class GameData {
    private int x;
    private int y;
    private Block block;
    private static Block[] blocks = {
            new Block(new int[]{-1, 0, 1, 2}, new int[]{0, 0, 0, 0}),
            new Block(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            new Block(new int[]{-1, 0, 1, -1}, new int[]{0, 0, 0, 1}),
    };

    public GameData() {
        x = 4;
        y = 0;
        block = new Block(blocks[1]);
    }

    /**
     * 根据方向和步长改变方块位置
     * @param isHorizontal：方向
     * @param step：步长
     */
    public void change(boolean isHorizontal, int step) {
        boolean flag = true;
        if (isHorizontal) {
            for (Point point : block.getPoints()) {
                if ((point.x +x+ step) < 0 || (point.x+x + step) > 9) {
                    flag = false;
                }
            }
            if (flag) {
                x += step;
            }

        } else {
            for (Point point : block.getPoints()) {
                if ( (point.y+y + step) > 17) {
                    flag = false;
                }
            }
            if (flag) {
                y += step;
            }
        }
    }

    /**
     * 旋转
     */
    public void rotate(){
        /**
         * 旋转之后判断是否出界
         */
        for (Point point : block.getPoints()) {
            int _x = -point.y+x;
            int _y = point.x+y;
            if(_x<0||_x>9||y<0||_y>17){
                return;
            }
        }
        for (Point point : block.getPoints()) {
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }
    public Block getBlock() {
        return block;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
