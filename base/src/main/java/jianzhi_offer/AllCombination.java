package jianzhi_offer;
/**
 * @Description:    输出字符串的所有组合
 * @Author:         wy
 * @CreateDate:     2019/1/13 20:23
 * @Version:        1.0
 */

public class AllCombination {
    public static void getAllCombination(String str){
        int len = str.length();
        int comNum = new Double(Math.pow(2, len)-1).intValue();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= comNum; i++){
            String binaryString = Integer.toBinaryString(i);
            for (int j =0 ; j < binaryString.length(); j++){
                if (binaryString.charAt(binaryString.length() - j - 1) == '1'){
                    sb.append(str.charAt(j));
                }
            }
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }

    }

    public static void main(String[] args) {
        getAllCombination("abc");
    }
}
