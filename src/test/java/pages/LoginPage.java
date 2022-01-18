package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebPage{

    public final String PAGE_URL = "https://demoqa.com/login";

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public void fill(String username, String pass){
        userName.sendKeys(username);
        password.sendKeys(pass);
    }

    public void submit(){
        js.executeScript("arguments[0].click();", loginBtn);
    }




}
