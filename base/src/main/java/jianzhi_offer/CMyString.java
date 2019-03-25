package jianzhi_offer;

public class CMyString {
    private int num;
    private String str;

    public CMyString(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public CMyString add(CMyString param){
        int num_frac = this.num + param.num;
        String str_frac = this.str + param.str;
        return new CMyString(num_frac, str_frac);
    }

    @Override
    public String toString() {
        return "CMyString{" +
                "num=" + num +
                ", str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) {
        CMyString cMyString = new CMyString(10, "abc");
        CMyString cMyString1 = new CMyString(20, "def");
        System.out.println(cMyString.add(cMyString1).toString());
    }
}
