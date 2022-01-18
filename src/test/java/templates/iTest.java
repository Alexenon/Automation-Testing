package templates;

public interface iTest {
    default void before(){}
    void test();
    default void after(){}
}
