package templates;

public class Test2 extends AbstractTest{

    @Override
    public void before(){
        System.out.println("Before");
    }

    @Override
    public void test() {
        System.out.println("Test2 is displayed");
    }

    @Override
    public void after(){
        System.out.println("After");
    }
}
