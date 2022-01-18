package service_automation.API;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeService {

    @PUT("/public/api/v1/update/{id}")
    Call<JsonObject> updateUsers(@Path("id") String id, @Body JsonObject params);

    @GET("/api/v1/employees")
    Call<JsonObject> getUsers();

}
