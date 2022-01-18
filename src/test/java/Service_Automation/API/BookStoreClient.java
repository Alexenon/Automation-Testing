package Service_Automation.API;

import Service_Automation.Model.Book;
import Service_Automation.Model.Books;
import org.apache.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class BookStoreClient {

    private final static Logger log = Logger.getLogger(BookStoreClient.class);
    private final static String BASE_URL = "https://demoqa.com";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BookStoreService service = retrofit.create(BookStoreService.class);

    public Books getBooks(){
        Books books = null;
        Call<Books> request = service.getBooks();

        try {
            Response<Books> response = request.execute();

            if(response.isSuccessful()){
                log.info("Request " + request.request() + " was executed succesifully, \n with response message " + response.message());
                books = response.body();
            }
            else {
                log.error(String.format("Response is not succesifull.\nRequest : " + request.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody()));
                throw new RuntimeException(String.format("Response is not succesifull.\nRequest : " + request.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody()));
            }

        } catch (IOException e) {
            log.error("Something got wrong whilst the request was being executed", e);
            throw new RuntimeException(e);
        }

        return books;

    }

    public Book getBook(String isbn){
        Book book = null;
        Call<Book> request = service.getBook(isbn);

        try {
            Response<Book> response = request.execute();

            if(response.isSuccessful()){
                log.info("Request " + request.request() + " was executed succesifully, \n with response message " + response.message());
                book = response.body();
            }
            else {
                log.error(String.format("Response is not succesifull.\nRequest : " + request.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody()));
                throw new RuntimeException(String.format("Response is not succesifull.\nRequest : " + request.request() +  " Status code " + response.code()
                        + ", Response message " + response.message() + "\nError body " + response.errorBody()));
            }

        } catch (IOException e) {
            log.error("Something got wrong whilst the request was being executed", e);
            throw new RuntimeException(e);
        }

        return book;

    }



}
