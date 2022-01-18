package Templates;

public class Test1 extends AbstractTest{

    @Override
    public void before(){
        System.out.println("Before");
    }

    @Override
    public void test() {
        System.out.println("Test1 is displayed");
    }

    @Override
    public void after(){
        System.out.println("After");
    }

}
