package service_automation.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataService {

    @Headers("accept: application/json")
    @POST("/delay/{delayTime}")
    Call<ResponseBody> postDelay(@Path("delayTime") String delayTime);

    @Headers("accept: application/json")
    @DELETE("/delay/{delayTime}")
    Call<ResponseBody> deleteDelay(@Path("delayTime") String delayTime);

}
