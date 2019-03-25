package jianzhi_offer;
/**
 * @Description:    剑指offer，机器人的运动范围
 * @Author:         wy
 * @CreateDate:     2019/1/8 22:09
 * @Version:        1.0
 */

public class RobotsPath {
    // 创建一个二维数组，来控制当前移动的方向
    private int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // 方法入口
    public int movingCount(int rows, int cols, int threshold) {
        boolean[][] visits = new boolean[rows][cols];
        int count = movingCountCore(0, 0, rows, cols, visits, threshold);
        return count;
    }
    private int movingCountCore(int row, int col, int rows, int cols, boolean[][] visits, int threshold){
        int sum = 1;
        if (check(row, col, rows, cols, visits, threshold)) {
            visits[row][col] = true;
            for (int[] n : next){
                sum += movingCountCore(row + n[0], col + n[1], rows, cols, visits, threshold);
            }
        }
        return sum;
    }

    private boolean check(int row, int col, int rows, int cols, boolean[][] visits, int threshold) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && (getSum(col) + getSum(row) < threshold) && visits[row][col] == false) {
            return true;
        }
        return false;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            int a = num % 10;
            int b = num / 10;
            sum += a;
            num = b;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotsPath robotsPath = new RobotsPath();
        System.out.println(robotsPath.movingCount(2,2, 10));
    }
}
