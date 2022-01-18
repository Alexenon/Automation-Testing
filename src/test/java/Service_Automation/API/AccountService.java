package Service_Automation.API;

import Service_Automation.Model.UserCredentials;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface AccountService {

    @FormUrlEncoded
    @Headers("accept: application/json")
    @POST("/Account/v1/User")
    Call<ResponseBody> createUser(@Field("userName") String userName, @Field("password") String password);

    @Headers("accept: application/json")
    @POST("/Account/v1/User")
    Call<ResponseBody> createUser(@Body UserCredentials credentials);

}
