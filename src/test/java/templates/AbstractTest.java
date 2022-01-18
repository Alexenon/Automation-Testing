package templates;

public abstract class AbstractTest implements iTest {

    public void run(){
        before();
        test();
        after();
    }


}
