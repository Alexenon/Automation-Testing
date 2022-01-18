package Service_Automation.API;

import Service_Automation.Model.Book;
import Service_Automation.Model.Books;
import Service_Automation.Model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookStoreService {

    @GET("/BookStore/v1/Books")
    @Headers({"Accept: application/json"})
    Call<Books> getBooks();


    @GET("/BookStore/v1/Book?")
    @Headers({"Accept: application/json"})
    Call<Book> getBook(@Query("ISBN") String isbn);


}
