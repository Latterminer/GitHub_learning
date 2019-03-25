package interview;

public class SingletenInnerStaticClass {
    private static class SingletenClassHolder{
        private static final SingletenInnerStaticClass instance = new SingletenInnerStaticClass();
    }
    private SingletenInnerStaticClass() {
    }
    public SingletenInnerStaticClass getInstance(){
        return SingletenClassHolder.instance;
    }
}
