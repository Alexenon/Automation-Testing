package TestNG_Practice;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTrial {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @Test
    public void shouldPass(){
        System.out.println("This test should pass");
        Assert.assertTrue(true, "This test should pass");
    }

    @Test
    public void shouldPassToo(){
        System.out.println("This test should pass as well");
        Assert.assertTrue(true, "This test should pass as well");
    }

    @Test(enabled = false)
    public void shouldFail(){
        System.out.println("This test should fail");
        Assert.assertTrue(false, "This test should fail");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After tests");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("After suit");
    }

}
