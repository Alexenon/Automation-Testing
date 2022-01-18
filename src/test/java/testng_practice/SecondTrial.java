package testng_practice;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
    This whole class belong to "first_group"
    but some of them belongs to "init"
 */

@Test(groups = {"first_group"})
public class SecondTrial {

    @Test(groups = { "init" })
    public void passTest(){
        System.out.println("This test should pass");
        Assert.assertTrue(true, "This test should pass");
    }

    @Test(groups = { "init" })
    public void passTestToo(){
        System.out.println("This test should pass as well");
        Assert.assertTrue(true, "This test should pass as well");
    }

    @Test(dependsOnGroups = { "init.*" })
    public void dependsOnGroup(){
        System.out.println("Test depends on is active");
        Assert.assertTrue(1==1);
    }

    @Test
    @Parameters("numberOfTimes")
    public void accessPage(@Optional("numberOfTimes") int numberOfTimes) {
        Assert.assertTrue(numberOfTimes > 0,
                "Number of times isn't valid");
    }

    @Test(dependsOnMethods = { "accessPage" })
    public void dependsOnTest(){
        Assert.assertTrue(Boolean.TRUE,
                "Test 'passTest' is missing or failed!");
    }



}
