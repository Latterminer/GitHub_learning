package interview;

import java.util.LinkedList;

/**
 * @Description: 求矩阵中的最短路径，宽度优先遍历
 * @Author: wy
 * @CreateDate: 2019/1/14 21:53
 * @Version: 1.0
 */
public class ShortestPath {
    public static int getShortestPath(int[][] pathArray, int start_row, int start_col) {
        int[][] status = new int[pathArray.length][pathArray[0].length];
        int[][] next = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        LinkedList<MyNode> list = new LinkedList<>();
        MyNode node = new MyNode(start_row,start_col,0);
        list.offer(node);
        status[start_row][start_col] = 0;
        while (list.size() != 0){
            MyNode temp = list.poll();
            for (int[] next_step: next) {
                if (judge(temp, next_step, pathArray, status)){
                    list.add(new MyNode(temp.getRow()+next_step[0],
                            temp.getCol()+next_step[1], temp.getRound()+1));
                    status[temp.getRow()+next_step[0]][temp.getCol()+next_step[1]] = temp.getRound() +1;
                }
            }
        }
        return status[pathArray.length-1][pathArray[0].length-1];
    }

    public static boolean judge(MyNode node, int[] step, int[][] pathArray, int[][] status){
        int temp_row = node.getRow()+step[0];
        int temp_col = node.getCol()+step[1];
        int rows = pathArray.length;
        int cols = pathArray[0].length;
        if (temp_row >=0 && temp_col >= 0 && temp_row < rows && temp_col < cols
                && pathArray[temp_row][temp_col] != 1 && status[temp_row][temp_col] == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] pathArray = {{0,0,0},{0,0,0},{1,1,1}};
        System.out.println(getShortestPath(pathArray, 0,0));
    }
}


class MyNode{
    private int row;
    private int col;
    private int round;

    public MyNode(int row, int col, int round) {
        this.row = row;
        this.col = col;
        this.round = round;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}