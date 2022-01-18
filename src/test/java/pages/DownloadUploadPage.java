package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DownloadUploadPage extends WebPage {

    public final String PAGE_URL = "https://demoqa.com/upload-download";
    public final String FILE_LOCATION = "C:\\Users\\asus\\Downloads\\sampleFile.jpeg";

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    @FindBy(id = "uploadFile")
    WebElement uploadFileButton;


    public final By UPLOADED_FILE_PATH_LOCATOR = By.id("uploadedFilePath");
    //private final By UPLOAD_FILE_LOCATOR = By.id("uploadFile");

    public DownloadUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDownloadButton() {
        return downloadButton;
    }

    public WebElement getUploadFile() {
        return uploadFileButton;
    }

    public void navigateTo(){
        driver.get(PAGE_URL);
    }

    public void downloadFile(){
        getDownloadButton().click();
    }

    public void uploadFile(String location){
        getUploadFile().sendKeys(location);
    }

    public String getUploadedFilePath(){
        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        return uploadedFilePath.getText();
    }

    public void checkFileExists(){
        File file = new File(FILE_LOCATION);
        Assert.assertTrue(file.exists());
        System.out.println("The file was downloaded successfully");
    }

    public void close(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }




}
