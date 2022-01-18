package Service_Automation.Tests;
import Service_Automation.API.AccountClient;
import Service_Automation.Model.UserCredentials;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountTest {

    @DataProvider(name = "dataProvider")
    public Object[][] getUserCredentials(){
        return new Object[][] {
                {new UserCredentials("userN@me2021", "CreativePassword")}
                ,{new UserCredentials("ShouldP@s5OrNot", "Str0ng_P@ass")}
                ,{new UserCredentials("Either_M3", "PopC0rn4Free5D")}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void createUser(UserCredentials credentials){
        AccountClient client = new AccountClient();
        String responseDate = client.createUser(credentials);
        System.out.println(responseDate);
    }

}
