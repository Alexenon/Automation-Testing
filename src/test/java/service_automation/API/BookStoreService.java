package service_automation.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import service_automation.Model.Book;
import service_automation.Model.Books;

public interface BookStoreService {

    @GET("/BookStore/v1/Books")
    @Headers({"Accept: application/json"})
    Call<Books> getBooks();


    @GET("/BookStore/v1/Book?")
    @Headers({"Accept: application/json"})
    Call<Book> getBook(@Query("ISBN") String isbn);


}
