package GongsiZhenti;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:    字节跳动2018年真题，求集合的最大点
 * @Author:         wy
 * @CreateDate:     2019/1/8 7:17
 * @Version:        1.0
 */
public class MaxPoints {
    public static TreeMap<Integer, Integer> getMaxPoints(int[][] array){
        TreeMap<Integer, Integer> result = new TreeMap<>();
        TreeMap<Integer, Integer> input = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  //按照Y进行排序
            }
        });
        for (int i = 0; i < array.length; i++){
            input.put(array[i][1], array[i][0]);  // put的顺序为（Y,X）
        }
        Iterator<Map.Entry<Integer, Integer>> it = input.entrySet().iterator();
        int max = -1;
        while (it.hasNext()){
            Map.Entry<Integer, Integer> item = it.next();
            if (item.getValue() > max){
                result.put(item.getValue(),item.getKey());
                max = item.getValue();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1,2},{5,3},{4,6},{7,5},{9,0}};
        System.out.println(getMaxPoints(inputs));

    }
}
