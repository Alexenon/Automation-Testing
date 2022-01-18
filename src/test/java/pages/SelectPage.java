package pages;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage extends WebPage{

    public final String PAGE_URL = "https://demoqa.com/select-menu";

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        //this.log = LogManager.getLogger(SelectPage.class);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"withOptGroup\"]")
    WebElement selectWithGroup;

    public void setSelectWithGroup(){
        Actions arrowDown = new Actions(driver).sendKeys(Keys.ARROW_DOWN);
        Actions confirm = new Actions(driver).sendKeys(Keys.ENTER);
        selectWithGroup.click();
        arrowDown.perform();
        arrowDown.perform();
        arrowDown.perform();
        arrowDown.perform();
        arrowDown.perform();
        wait(1000);
        confirm.perform();
    }





}
