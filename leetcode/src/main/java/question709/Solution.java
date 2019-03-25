package question709;

/**
 * @author wangyong
 * @date 2019/3/20
 * @description 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
 * 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class Solution {
    public String toLowerCase(String str) {
        StringBuilder stringBuffer = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char c = stringBuffer.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stringBuffer.setCharAt(i, (char) (c + 'a'-'A'));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        char a = 'A';
        char b = 'a';
        System.out.println(b-a);
    }


}
