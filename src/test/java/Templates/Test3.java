package Templates;

public class Test3 extends AbstractTest{

    @Override
    public void before(){
        System.out.println("Before but without after");
    }

    @Override
    public void test() {
        System.out.println("Test3 is displayed");
    }

}
