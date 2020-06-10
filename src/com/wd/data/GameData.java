package com.wd.data;

public class GameData {
    private int x;
    private int y;
    private Block block;
    private static Block[] blocks = {
            new Block(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
            new Block(new int[]{-1,0,1,2},new int[]{0,0,0,0}),
            new Block(new int[]{-1,0,1,-1},new int[]{0,0,0,1}),
    };
    public GameData() {
        x = 4;
        y = 0;
        block = new Block(blocks[0]);
    }

    public void change(boolean isHorizontal, int step){
        if (isHorizontal){
            x+=step;
        }else{
            y+=step;
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
