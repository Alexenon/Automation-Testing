package Service_Automation.API;

import Service_Automation.Model.UserCredentials;
import okhttp3.ResponseBody;
import org.apache.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class AccountClient {

    private final static Logger log = Logger.getLogger(BookStoreClient.class);
    private final static String BASE_URL = "https://demoqa.com";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private AccountService service = retrofit.create(AccountService.class);


    public String createUser(UserCredentials credentials){
        String responseData = null;
        Call<ResponseBody> call = service.createUser(credentials);

        try {
            Response<ResponseBody> response = call.execute();

            if(response.isSuccessful()){
                log.info("Request " + call.request() + " was executed successfully, \n with response message " + response.message());
                responseData = response.body().string();
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

