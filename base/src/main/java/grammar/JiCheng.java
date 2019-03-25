package grammar;
/**
 * @Description:
 * @Author:         wy
 * @CreateDate:     2019/1/19 21:26
 * @Version:        1.0
 */
public class JiCheng extends SuperClass {
    {
        System.out.println("子类的代码块");
    }

    public JiCheng() {
        System.out.println("子类的构造函数");
    }

    public static void main(String[] args) {
        JiCheng jiCheng = new JiCheng();
    }
}
class SuperClass{
    {
        System.out.println("父类的代码块");
    }

    public SuperClass() {
        System.out.println("父类的构造函数");
    }
}