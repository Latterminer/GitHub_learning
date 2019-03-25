package interview;

import java.util.ArrayList;

public class ArrayStack {
    private ArrayList<Object> array = new ArrayList<>();
    public void push(Object node){
        array.add(node);
    }
    public Object pop(){
        int len = array.size();
        if (len == 0){
            return null;
        }
        return array.get(len -1);
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(new String("abc"));
        arrayStack.push(new String("def"));
        arrayStack.push(new String("g"));
        System.out.println(arrayStack.pop());
    }
}
