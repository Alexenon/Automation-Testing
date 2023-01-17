package pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class WebPage {

    public WebDriver driver;
    public JavascriptExecutor js;
    public Logger log;

    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.js = (JavascriptExecutor) driver;
        this.log = LogManager.getLogger(WebPage.class);
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void navigateTo(String url) {
        log.info("Navigate to " + url);
        driver.get(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void scrollPage(int width, int height) {
        String script = String.format("window.scrollBy(%d, %d)", width, height);
        wait(500);
        js.executeScript(script);
    }

    public void wait(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert web driver object to TakeScreenshot <p>
     * Call getScreenshotAs method to create image file <p>
     * Move image file to new destination <p>
     * Copy file to destination
     */
    public void takeScreenshot(WebDriver webdriver, String fileWithPath) {
        TakesScreenshot scrShot = (TakesScreenshot) webdriver;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
            System.out.println("Screenshot was saved at " + fileWithPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

}
