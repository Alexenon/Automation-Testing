package serenity_practice;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://unsplash.com/")
public class TestLoginPage extends PageObject {

    private final By BtnLogin = By.xpath("//div[@class='__uqj']/following::a");
    private final By inputEmail = By.xpath("//input[@id='user_email']");
    private final By inputPassword = By.xpath("//input[@id='user_password']");
    private final By BtnSubmitLogin = By.xpath("//input[@value='Login']");

    public TestLoginPage userClickLoginButton(){
        find(BtnLogin).click();
        return this;
    }

    public TestLoginPage userInsertEmail(String email){
        find(inputEmail).sendKeys(email);
        return this;
    }

    public TestLoginPage userInsertPassword(String password){
        find(inputPassword).sendKeys(password);
        return this;
    }

    public TestLoginPage userSubmitLogin(){
        find(BtnSubmitLogin).click();
        return this;
    }






}
