package grammar;
/**
 * @Description:    代码块在构造函数之前执行
 * @Author:         wy
 * @CreateDate:     2019/1/19 21:25
 * @Version:        1.0
 */
public class StaticDemo {

    public StaticDemo() {
        System.out.println("constructor");
    }

    {
        System.out.printf("code block");
    }

    public static void show(){
        System.out.println("show method");
    }

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        staticDemo.show();
    }
}
