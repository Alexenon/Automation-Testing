package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.DownloadUploadPage;
import java.io.File;
import java.time.Duration;

public class DownloadUploadPractice {

    private WebDriver driver;
    DownloadUploadPage page;
    public static final String FILE_LOCATION = "C:\\Users\\asus\\Downloads\\sampleFile.jpeg";

    @BeforeClass
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void downloadFileTest(){
        page = new DownloadUploadPage(driver);
        page.navigateTo();
        page.downloadFile();
    }

    @Test
    public void uploadFileTest(){
        page.uploadFile(FILE_LOCATION);
    }

    @Test
    public void checkFileExists(){
        File file = new File(FILE_LOCATION);
        Assert.assertTrue(file.exists());
    }

    @AfterClass
    public void closeBrowser(){
        page.wait(3000);
        driver.close();
    }

}
