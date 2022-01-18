package pages;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class WebPage {

    public WebDriver driver;
    public JavascriptExecutor js;
    //public Logger log;

    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        js = (JavascriptExecutor) driver;
        //log = LogManager.getLogger(WebPage.class);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void navigateTo(String url){
        //log.info("Navigate to " + url);
        driver.get(url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void scrollPage(int width, int height){
        String script = String.format("window.scrollBy(%d, %d)", width, height);
        wait(500);
        js.executeScript(script);
    }

    public void wait(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeSreenshot(WebDriver webdriver, String fileWithPath){
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = (TakesScreenshot)webdriver;
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file to destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
            System.out.println("Screenshot was saved at " + fileWithPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

}
