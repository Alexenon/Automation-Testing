package Service_Automation.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface DataService {

    @Headers("accept: application/json")
    @POST("/delay/{delayTime}")
    Call<ResponseBody> postDelay(@Path("delayTime") String delayTime);

    @Headers("accept: application/json")
    @DELETE("/delay/{delayTime}")
    Call<ResponseBody> deleteDelay(@Path("delayTime") String delayTime);

}
