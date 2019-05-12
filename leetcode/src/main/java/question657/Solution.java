package question657;

/**
 * @author wangyong
 * @date 2019/5/12
 * @description
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return false;
        }
        String movesUpper = moves.toUpperCase();
        int uCount=0, dCount=0, lCount=0, rCount=0;
        for (char c : movesUpper.toCharArray()) {
            switch (c) {
                case 'U':
                    uCount++;
                    break;
                case 'D':
                    dCount++;
                    break;
                case 'L':
                    lCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
                default:
            }
        }
        if (uCount != dCount || lCount != rCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean judgeCircle = solution.judgeCircle("UD");
        System.out.println(judgeCircle);
    }
}
