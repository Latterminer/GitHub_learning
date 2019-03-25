package jianzhi_offer;
/**
 * @Description:    从数组选择某几个元素，使其和等于给定的数target
 * @Author:         wy
 * @CreateDate:     2019/1/12 10:29
 * @Version:        1.0
 */
public class ValueSumInArray {
    public static boolean judge(int[] array, int index, int target){
        if (target == 0){
            return true;
        }
        if (index ==0){
            return array[index] == target;
        }
        if (array[index] > target){
            return judge(array, index-1, target);
        } else {
            return judge(array, index-1, target - array[index]) || judge(array, index-1, target);
        }
    }

    public static boolean judgeNonRec(int[] array, int target){
        boolean[][] dp = new boolean[array.length][target+1];
        for (int i = 0; i< dp.length; i++){
            dp[i][0] = true;
        }
        dp[0][array[0]] = true;
        for (int i = 1; i < array.length; i++){
            for (int j = 1; j < target+1; j++){
                if(array[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i]];
                }
            }
        }
        return dp[array.length-1][target];
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 34, 5, 18};
//        System.out.println(judge(array, array.length-1, 17));
        System.out.println(judgeNonRec(array, 18));

    }
}
