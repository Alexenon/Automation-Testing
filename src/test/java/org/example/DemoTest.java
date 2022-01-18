package org.example;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.time.Duration;


public class DemoTest {

    WebPage web;
    TextBoxPage textBoxPage;
    DownloadUploadPage downloadPage;
    FormPage formPage;

    @BeforeClass
    public void initializeWebPage(){
        web = new WebPage();
        web.initializeBrowser();
    }

    @Test
    public void TextBoxPageTest() throws Exception {
        textBoxPage = new TextBoxPage(web.driver);
        textBoxPage.visitPage();
        textBoxPage.autoFillAll();
        textBoxPage.submitForm();
        textBoxPage.checkOutput();
    }

    @Test
    public void UploadPageTest(){
        downloadPage = new DownloadUploadPage(web.driver);
        web.navigateTo(downloadPage.PAGE_URL);
        downloadPage.downloadFile();
        downloadPage.uploadFile(DownloadUploadPractice.FILE_LOCATION);
        downloadPage.checkFileExists();

        /* Waits until the output message appears */
        WebDriverWait wait = new WebDriverWait(web.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(downloadPage.UPLOADED_FILE_PATH_LOCATOR));
    }

    @Test
    public void ButtonsPageTest(){
        ButtonsPage buttonsPage = new ButtonsPage(web.driver);
        web.navigateTo(buttonsPage.PAGE_URL);
        buttonsPage.executeDoubleClick();
        buttonsPage.executeRightClick();
        buttonsPage.executeClick();
        web.scrollPage(0, 300);
    }

    @Test
    public void FormPageTest(){
        formPage = new FormPage(web.driver);
        web.navigateTo(formPage.PAGE_URL);
        formPage.fillForm();
        formPage.scrollPage(0, 250);
        formPage.validateForm();
    }

    @AfterClass
    public void closeBrowser(){
        web.closeBrowser();
    }
}
