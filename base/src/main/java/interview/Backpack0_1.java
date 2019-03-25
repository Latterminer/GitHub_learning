package interview;

/**
 * @Description: 0-1背包问题
 * @Author: wy
 * @CreateDate: 2019/1/15 23:25
 * @Version: 1.0
 */
public class Backpack0_1 {
    public static void getSolution(int[] values, int[] weights, int V, int num) {
        int[][] status = new int[V + 1][num + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= num; j++) {
                if (weights[j-1] > i) {
                    status[i][j] = status[i][j - 1];
                } else {
                    status[i][j] = Math.max(status[i - weights[j-1]][j - 1] + values[j-1], status[i][j - 1]);
                }
            }
        }
        System.out.println(status[V][num]);
    }

    public static void main(String[] args) {
        int[] value = {2, 1, 4, 3, 7, 8};
        int[] weight = {3, 6, 3, 1, 5, 2};
        int capacity = 10;
        getSolution(value, weight, capacity, 6);
    }
}
