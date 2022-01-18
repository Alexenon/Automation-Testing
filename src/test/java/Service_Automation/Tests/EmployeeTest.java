package Service_Automation.Tests;
import Service_Automation.API.EmployeeClient;
import Service_Automation.Model.Employee;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeTest {


    private Map<String, String> getEmployeeData(){

        Map<String, String> map = new HashMap<String, String>();

        map.put("employee_name", RandomString.make());
        map.put("employee_salary", "35000");
        map.put("employee_age", "30");

        return map;
    }

    @DataProvider(name = "dataProvider")
    public Object[][] getISBN(){
        return new Object[][] {
                {"23", getEmployeeData()},
                {"34", getEmployeeData()},
                {"56", getEmployeeData()},
                {"10", getEmployeeData()}
        };
    }

    @Test(dataProvider = "dataProvider")
    private void firstTest(String id, Map<String, String> map){

        EmployeeClient employeeClient = new EmployeeClient();

        JsonObject jsonObject = new JsonObject();
        map.forEach((key, value) -> {jsonObject.add(key, new JsonPrimitive(value));});

        JsonObject response = employeeClient.updateEmployee(id, jsonObject);
        System.out.println(response);

        Assert.assertTrue(response.has("status"));
        Assert.assertTrue(response.has("data"));
        Assert.assertTrue(response.has("message"));

        Assert.assertEquals(response.get("status").getAsString(), "success");
        Assert.assertEquals(response.get("message").getAsString(), "Successfully! Record has been updated.");

        Assert.assertTrue(response.get("data").isJsonObject());
        JsonObject data = response.getAsJsonObject("data");

        map.forEach((key, value) -> {
            Assert.assertTrue(data.has(key));
            Assert.assertEquals(data.get(key).getAsString(), value);
        });

    }


    @Test
    private void getUsersTest(){
        EmployeeClient employeeClient = new EmployeeClient();

        JsonObject responseJSON = employeeClient.getEmployees();
        System.out.println(responseJSON);

        List<Employee> employees = new LinkedList<Employee>();
        JsonArray jsonArray = responseJSON.getAsJsonArray("data");
        jsonArray.forEach(jsonElement -> {
            JsonObject obj = jsonElement.getAsJsonObject();
            Employee employee = new Employee.Builder()
                    .setId(obj.get("id").getAsString())
                    .setName(obj.get("employee_name").getAsString())
                    .setSalary(obj.get("employee_salary").getAsString())
                    .setAge(obj.get("employee_age").getAsString())
                    .build();
            employees.add(employee);
        });

        employees.forEach(System.out::println);
    }

}
