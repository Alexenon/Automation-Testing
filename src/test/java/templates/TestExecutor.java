package templates;
import java.util.List;

public class TestExecutor {

    private final List<AbstractTest> tests;

    public TestExecutor(List<AbstractTest> tests) {
        this.tests = tests;
    }

    public void runTests(){
        runTests(tests);
    }

    public static void runTests(List<AbstractTest> tests){
        tests.forEach(test -> test.run());
    }
}
