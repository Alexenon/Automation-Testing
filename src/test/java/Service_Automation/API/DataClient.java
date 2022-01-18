package Service_Automation.API;

import okhttp3.ResponseBody;
import org.apache.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class DataClient {

    private final static Logger log = Logger.getLogger(DataClient.class);
    private final static String BASE_URL = "https://httpbin.org/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private DataService service = retrofit.create(DataService.class);


    public String postWithDelay(String seconds){
        String responseData = null;
        Call<ResponseBody> call = service.postDelay(seconds);

        try {
            Response<ResponseBody> response = call.execute();

            if(response.isSuccessful()){
                log.info("Request " + call.request() + " was executed successfully, \n with response message " + response.message());
                responseData = response.body().string();
            }
            else {
                String error = "ERROR, SOMETHING WENT WRONG!"
                        + "\n Request: " + call.request()
                        + "\n Status code: " + response.code()
                        + "\n Response message: " + response.message()
                        + "\n Error body: " + response.errorBody();

                log.error(error);
                throw new RuntimeException(error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public String deleteWithDelay(String seconds){
        String responseData = null;
        Call<ResponseBody> call = service.deleteDelay(seconds);

        try {
            Response<ResponseBody> response = call.execute();

            if(response.isSuccessful()){
                log.info("Request " + call.request() + " was executed successfully, \n with response message " + response.message());
                responseData = response.body().string();
            }
            else {
                String error = "ERROR, SOMETHING WENT WRONG!"
                        + "\n Request: " + call.request()
                        + "\n Status code: " + response.code()
                        + "\n Response message: " + response.message()
                        + "\n Error body: " + response.errorBody();

                log.error(error);
                throw new RuntimeException(error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

}
