package interview;
/**
 * @Description:    求最长公共子序列
 * @Author:         wy
 * @CreateDate:     2019/1/14 21:07
 * @Version:        1.0
 */
public class MaxCommonSubSequence {
    public static int getMaxCommonSubsequence(String str1, String str2){
        int[][] status = new int[str1.length()+1][str2.length()+1];
        //把记忆数组的左边那一列置0
        for (int i = 0; i <= str1.length(); i++){
            status[i][0] = 0;
        }
        //把记忆数组的第一行置0
        for (int i = 0; i <= str2.length(); i++){
            status[0][i] = 0;
        }
        for (int i = 1; i <= str1.length(); i++){
            for (int j = 1; j <= str2.length(); j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    status[i][j] = status[i-1][j-1] + 1;
                }else {
                    status[i][j] = Math.max(status[i-1][j], status[i][j-1]);
                }
            }
        }
        return status[str1.length()][str2.length()];
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "eabcd";
        System.out.println(getMaxCommonSubsequence(str1, str2));
    }

}
