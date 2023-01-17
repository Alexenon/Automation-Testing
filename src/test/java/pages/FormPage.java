package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class FormPage extends WebPage{

    public final String PAGE_URL = "https://demoqa.com/automation-practice-form";

    final String PICTURE_LOCATION = "D:\\Alex\\Programming\\Java\\MavenProject\\src\\test\\resources\\images\\Bart-Simpson.png";

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    @FindBy(id = "currentAddress")
    WebElement userAddress;

    @FindBy(id = "subjectsInput")
    WebElement userSubject;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureBtn;

    @FindBy(id = "state")
    WebElement stateDropdown;

    @FindBy(id = "city")
    WebElement cityDropdown;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindAll(
            @FindBy(xpath = "//table[contains(@class,'table')]//tbody//tr//td"))
    private List<WebElement> tableRows;



    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        //this.log = LogManager.getLogger(FormPage.class);
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName(String name){
        //log.debug("Fill first name with " + name);
        firstName.sendKeys(name);
        //log.error("Error, name is missing!");
    }

    public void fillLastName(String name){
        //log.debug("Fill last name with " + name);
        lastName.sendKeys(name);
    }

    public void fillUserEmail(String email){
        userEmail.sendKeys(email);
    }

    public void fillUserNumber(String phone){
        userNumber.sendKeys(phone);
    }

    public void fillUserBirth(String date){
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);
    }

    public void fillUserAddress(String address){
        userAddress.sendKeys(address);
    }

    public void fillUserSubject(String text){
        userSubject.sendKeys(text);
        userSubject.sendKeys(Keys.ENTER);
    }

    public void uploadPicture(String location){
        uploadPictureBtn.sendKeys(location);
    }

    public void fillGender(){
        Random random = new Random();
        int n = random.nextInt(3 - 1 + 1) + 1;
        String str = "[" + n + "]";
        driver.findElement(
                By.xpath("(//label[@class=\"custom-control-label\"])" + str))
                .click();
    }

    public void fillHobbies(){
        driver.findElement(
                By.xpath("(//label[@class=\"custom-control-label\"])[4]")).click();
        driver.findElement(
                By.xpath("(//label[@class=\"custom-control-label\"])[5]")).click();
    }

    public void chooseState(int index){

        WebElement dynamicMenu;
        String xPath = "//*[@id=\"state\"]/div[2]/div";

        stateDropdown.click();
        wait(2000);

        dynamicMenu = driver.findElement(By.xpath(xPath));
        if(dynamicMenu.isDisplayed()){
            xPath = String.format("%s/div[%d]", xPath, index);
            driver.findElement(By.xpath(xPath)).click();
        }


//        Actions arrowDown = new Actions(driver).sendKeys(Keys.ARROW_DOWN);
//        Actions confirm = new Actions(driver).sendKeys(Keys.ENTER);
//        stateDropdown.click();
//        arrowDown.perform();
//        stateDropdown.click();
//        arrowDown.perform();
//        stateDropdown.click();
//        arrowDown.perform();
//        confirm.perform();


//        int counter = 1;
//        while (!stateDropdown.getText().contains("Rajahstan")) {
//            for (int i = 0; i < counter; i++) {
//                arrowDown.perform();
//            }
//            //arrowDown.perform();
//            wait(2000);
//            confirm.perform();
//            System.out.println("____BEGIN____");
//            System.out.println(stateDropdown.getText());
//            System.out.println("____END____");
//            stateDropdown.click();
//            counter++;
//        }

    }

    public void chooseCity(int index){
        WebElement dynamicMenu;
        String xPath = "//*[@id=\"city\"]/div[2]/div";
        cityDropdown.click();
        wait(2000);

        dynamicMenu = driver.findElement(By.xpath(xPath));
        if(dynamicMenu.isDisplayed()){
            xPath = String.format("%s/div[%d]", xPath, index);
            driver.findElement(By.xpath(xPath)).click();
        }
    }

    public void fillForm(){
        fillFirstName("Bard");
        fillLastName("Simpson");
        fillUserEmail("bardSimpson97@gmail.com");
        scrollPage(0, 200);
        fillGender();
        fillUserNumber("8800555355");
        scrollPage(0, 200);
        fillUserBirth("");
        fillUserSubject("Math");
        fillUserSubject("Computer");
        fillUserSubject("English");
        scrollPage(0, 200);
        fillHobbies();
        uploadPicture(PICTURE_LOCATION);
        scrollPage(0, 200);
        fillUserAddress("742 Evergreen Terrace, Springfield");
        chooseState(3);
        chooseCity(2);
        submitForm();
        wait(2000);
        takeScreenshot(driver, "D:\\Alex\\Programming\\Java\\MavenProject\\src\\test\\resources\\images\\Screenshot.png");
    }

    public void submitForm(){
        submitBtn.submit();
    }

    public void validateForm(){
        for (int i = 0; i < tableRows.size(); i+=2) {
            String label = tableRows.get(i).getText().toLowerCase();
            String value = tableRows.get(i + 1).getText();
            Assert.assertNotNull(value);
        }

        WebElement formSubmitHeader
                = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));
        Assert.assertTrue("THE FORM WAS NOT SUBMITTED", formSubmitHeader.isDisplayed());
    }





}
