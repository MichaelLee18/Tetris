package com.wd.data;

import java.awt.*;

public class GameData {
    private int x;
    private int y;
    //方块
    private Block block;
    //保存方块
    private int[][] saveBlocks;
    int deleteNum[];
    private static Block[] blocks = {
            new Block(new int[]{0, 1, 0, 1}, new int[]{0, 0, 1, 1}),
            new Block(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            new Block(new int[]{-1, 0, 1, -1}, new int[]{0, 0, 0, 1}),
    };

    public GameData() {
        saveBlocks = new int[10][20];
        initBlock();
    }
    private void initBlock() {
        x = 4;
        y = 0;
        deleteNum = new int[20];
        block = new Block(blocks[0]);
    }
    public void saveBlock(){
        for (Point point:block.getPoints()){
            saveBlocks[point.x+x][point.y+y+2] = 1;
        }
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
                if ((point.x + x + step) < 0 || (point.x + x + step) > 9
                        || saveBlocks[point.x + x+step][point.y + y + 2] != 0
                ) {
                    flag = false;
                }
            }
            if (flag) {
                x += step;
            }

        } else {
            for (Point point : block.getPoints()) {
                if ( (point.y+y + step) > 17||saveBlocks[point.x+x][point.y+y+2+step]!=0) {
                    saveBlock();
                    if(isDelete())
                        deleteLine();
                    initBlock();
                    flag = false;
                }
            }
            if (flag) {
                y += step;
            }
        }
    }

    /**
     * 判断是否消行
     */
    public boolean  isDelete(){
        boolean isDelete = false;
        for (int i = 19; i >=2; i--) {
            boolean isEmpty = false;
            for (int j = 0; j < 10; j++) {
                if(saveBlocks[j][i]==0){
                    isEmpty = true;
                    break;
                }
            }
            if(!isEmpty){//消行
                deleteNum[i-1] = deleteNum[i]+1;
                isDelete = true;
            }else{
                deleteNum[i-1] = deleteNum[i];
            }

        }
        return isDelete;
    }

    public void deleteLine(){
        for (int i = 19; i >=2; i--) {
            for (int j = 0; j < 10; j++) {
                saveBlocks[j][i+deleteNum[i]] = saveBlocks[j][i];
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

    public int[][] getSaveBlocks() {
        return saveBlocks;
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
