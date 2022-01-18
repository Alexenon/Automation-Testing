package service_automation.API;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class EmployeeClient {

    private final static Logger log = Logger.getLogger(EmployeeClient.class);
    private final static String BASE_URL = "http://dummy.restapiexample.com/";
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final EmployeService service = retrofit.create(EmployeService.class);

    public JsonObject updateEmployee(String id, JsonObject obj){
        JsonObject responseData = null;
        Call<JsonObject> call = service.updateUsers(id, obj);

        try {
            Response<JsonObject> response = call.execute();

            if(response.isSuccessful()){
                log.info("Request " + call.request() + " was executed successfully, \n with response message " + response.message());
                responseData = response.body();
            }
            else {
                log.error(String.format("Response is not successfully.\nRequest : " + call.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody().string()));
                throw new RuntimeException(String.format("Response is not successfully.\nRequest : " + call.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody().string()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public JsonObject getEmployees(){
        JsonObject responseData = null;
        Call<JsonObject> call = service.getUsers();

        try {
            Response<JsonObject> response = call.execute();

            if(response.isSuccessful()){
                log.info("Request " + call.request() + " was executed successfully, \n with response message " + response.message());
                responseData = response.body();
            }
            else {
                log.error(String.format("Response is not successfully.\nRequest : " + call.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody().string()));
                throw new RuntimeException(String.format("Response is not successfully.\nRequest : " + call.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody().string()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }


}
