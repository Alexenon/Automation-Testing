package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends WebPage {

    public final String PAGE_URL = "https://demoqa.com/buttons";

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button")
    WebElement simpleClickBtn;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDoubleClickBtn() {
        return doubleClickBtn;
    }

    public WebElement getRightClickBtn() {
        return rightClickBtn;
    }

    public void executeDoubleClick(){
        new Actions(driver)
                .doubleClick(doubleClickBtn)
                .perform();
    }

    public void executeClick(){
        new Actions(driver)
                .click(simpleClickBtn)
                .perform();
    }

    public void executeRightClick(){
        new Actions(driver)
                .contextClick(rightClickBtn)
                .perform();
    }


}
