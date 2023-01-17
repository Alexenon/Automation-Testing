package templates;
import java.util.List;

public class Demonstration {

    public static void main(String[] args) {
        AbstractTest test1 = new Test1();
        AbstractTest test2 = new Test2();
        AbstractTest test3 = new Test3();
        AbstractTest test4 = new Test3();
        AbstractTest test5 = new Test2();

        List<AbstractTest> tests = List.of(test1, test2, test3, test4, test5);
        TestExecutor.runTests(tests);
    }
}


