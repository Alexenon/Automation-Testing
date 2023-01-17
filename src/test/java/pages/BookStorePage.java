package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStorePage extends WebPage{

    public final String PAGE_URL = "https://demoqa.com/books";

    @FindBy(xpath = "//div[contains(@class,'rt-tr-group')]//div//div//div//span//a")
    private List<WebElement> tableRows;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForBooks(String bookName){
        for (WebElement tableRow : tableRows) {
            scrollPage(0, 100);
            wait(750);
            if (tableRow.getText().equals(bookName)) {
                tableRow.click();
                break;
            }
        }
        scrollPage(0, 500);
        wait(2000);
        addBook();
    }

    private void addBook(){
        driver.get(driver.getCurrentUrl());
        WebElement addBookBtn = driver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].click();", addBookBtn);
        wait(2000);
    }
}
