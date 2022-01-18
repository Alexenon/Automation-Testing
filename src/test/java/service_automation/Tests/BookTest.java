package service_automation.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service_automation.API.BookStoreClient;
import service_automation.Model.Book;
import service_automation.Model.Books;

public class BookTest {

    @Test
    public void getBookTest(){
        BookStoreClient client = new BookStoreClient();
        Books books = client.getBooks();
        Assert.assertTrue(books.arePresent(), "Check if the books are received");
        books.getBooks().forEach(System.out::println);
    }

    @DataProvider(name = "isbnProvider")
    public Object[][] getISBN(){
        return new Object[][] {
                {"9781449325862","Git Pocket Guide"}, //success
                {"9781449331818","Learning JavaScript Design Patterns"}, //success
                {"9781491950296","Designing Evolvable Web APIs with ASP.NET"}, //fail
                {"23432","java"} //fail
        };
    }

    @Test(dataProvider = "isbnProvider")
    public void getBookTest(String isbn, String title){
        BookStoreClient client = new BookStoreClient();
        Book book = client.getBook(isbn);
        Assert.assertNotNull(book, "Check that book is received ");
        System.out.println(book);
        Assert.assertEquals(book.getTitle(), title, "Check that titles are equals");
    }


}
