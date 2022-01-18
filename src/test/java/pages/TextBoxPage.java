package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TextBoxPage extends WebPage {

    public final String PAGE_URL = "https://demoqa.com/text-box";

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(id = "output")
    WebElement output;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;


    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }

    public void fillUserName(String name){
        getUserName().sendKeys(name);
    }

    public void fillUserEmail(String email){
        getUserEmail().sendKeys(email);
    }

    public void fillUserCurrentAddress(String address){
        getCurrentAddress().sendKeys(address);
    }

    public void fillUserPermanentAddress(String address){
        getPermanentAddress().sendKeys(address);
    }

    public void autoFillAll(){
        fillUserName("Alex");
        fillUserEmail("demoEmail@gmail.com");
        fillUserCurrentAddress("Some random stuff");
        fillUserPermanentAddress("Another random stuff");
    }

    public void submitForm(){;
        js.executeScript("arguments[0].click();", getSubmitBtn());
        //js.executeScript("arguments[0].scrollIntoView();", getSubmitBtn());
        scrollPage(0,300);
    }

    public void checkOutput() throws Exception {
        //Assert.assertTrue(output.isDisplayed());
        if(output.isDisplayed())
            System.out.println("The form was submitted successfully");
        else
            throw new Exception("ERROR, THE OUTPUT IS MISSING!");
    }

    public void visitPage() {
        driver.get(PAGE_URL);
    }
}
