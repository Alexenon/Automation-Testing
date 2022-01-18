package service_automation.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Books {

    @SerializedName("books")
    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean arePresent(){
        return books != null && !books.isEmpty();
    }

}
