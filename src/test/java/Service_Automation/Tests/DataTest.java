package Service_Automation.Tests;

import Service_Automation.API.DataClient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class DataTest {

    public Object[][] positiveData(){
        return new Object[][] {
                {"0"}
                ,{"2"}
                ,{"1.20"}
        };
    }

    public Object[][] negativeData(){
        return new Object[][] {
                {""}
                ,{"-2"}     // Curious but this actually works :D
                ,{"3,30"}
                ,{"#"}
        };
    }

    /* DataProvider merge 2 objects */
    @DataProvider(name = "dataProvider")
    public Object[][] dp() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(positiveData()));
        result.addAll(Arrays.asList(negativeData()));
        return result.toArray(new Object[result.size()][]);
    }

    /* POST */
    @Test(dataProvider = "dataProvider")
    public void postUsingDelays(String delay){
        DataClient client = new DataClient();
        String responseDate = client.postWithDelay(delay);
        System.out.println(responseDate);
    }

    /* DELETE */
    @Test(dataProvider = "dataProvider")
    public void deleteUsingDelays(String delay){
        DataClient client = new DataClient();
        String responseDate = client.deleteWithDelay(delay);
        System.out.println(responseDate);
    }




}
