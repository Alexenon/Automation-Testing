package testng_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.BookStorePage;
import pages.LoginPage;
import pages.WebPage;

import java.time.Duration;

public class Homework {

    WebPage web;
    LoginPage page;
    BookStorePage bookStorePage;


    @BeforeSuite
    public void beforeSuite(){
        web = new WebPage();
        web.initializeBrowser();
    }


    @BeforeClass
    public void beforeClass(){
        page = new LoginPage(web.driver);
        bookStorePage = new BookStorePage(web.driver);
        web.navigateTo(page.PAGE_URL);
    }


    @Test
    @Parameters({"username", "password"})
    public void submitLogin(String username, String password){
        page.fill(username, password);
        page.submit();
    }


    @Test
    public void loginValidation(){
        WebDriverWait wait = new WebDriverWait(web.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("userName-value")));
    }


    @DataProvider(name = "data-books")
    public Object[][] getBookName(){
        return new Object[][]
                {
                     {"Git Pocket Guide"}
                    ,{"Learning JavaScript Design Patterns"}
                    ,{"Programming JavaScript Applications"}
                };
    }

    @Test(dataProvider = "data-books")
    public void books(String book_Name){
        web.navigateTo(bookStorePage.PAGE_URL);
        bookStorePage.searchForBooks(book_Name);
    }


    @AfterSuite
    public void afterSuite(){
        web.wait(3000);
        web.closeBrowser();
    }






}
