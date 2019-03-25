package interview;

import java.util.HashSet;

public class TwoStringIntersection {
    public static HashSet getCommon(String str1, String str2){
        HashSet<Character> result = new HashSet<>();

        HashSet<Character> str1Set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            str1Set.add(str1.charAt(i));
        }
        HashSet<Character> str2Set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++){
            str2Set.add(str2.charAt(i));
        }
        result = new HashSet<>(str1Set);
        for (Character c: str2Set){
            str1Set.remove(c);
        }
        for (Character c: str1Set){
            result.remove(c);
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "abbsdfdsfff";
        String str2 = "sfddfdfffaouijkl";
        System.out.println(getCommon(str1, str2).toString());
    }


}
