package testng_practice;

import org.testng.annotations.*;
import pages.BookStorePage;
import pages.LoginPage;
import pages.WebPage;

public class HomeworkTestCase {

    WebPage web;
    LoginPage page;
    BookStorePage bookStorePage;

    @BeforeSuite
    public void beforeSuite() {
        web = new WebPage();
        web.initializeBrowser();
    }

    @BeforeClass
    public void beforeClass() {
        page = new LoginPage(web.driver);
        bookStorePage = new BookStorePage(web.driver);
        web.navigateTo(page.PAGE_URL);
    }

    @Test
    @Parameters({"username", "password"})
    public void submitLogin(String username, String password) {
        page.fill(username, password);
        page.submit();
    }

    @DataProvider(name = "data-books")
    public Object[][] getBookName() {
        return new Object[][]
                {
                        {"Git Pocket Guide"},
                        {"Learning JavaScript Design Patterns"},
                        {"Programming JavaScript Applications"}
                };
    }

    @Test(dataProvider = "data-books")
    public void books(String book_Name) {
        web.navigateTo(bookStorePage.PAGE_URL);
        bookStorePage.searchForBooks(book_Name);
    }

    @AfterSuite
    public void afterSuite() {
        web.wait(3000);
        web.closeBrowser();
    }

}
