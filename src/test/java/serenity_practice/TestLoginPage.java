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

    public void userClickLoginButton() {
        find(BtnLogin).click();
    }

    public void userInsertEmail(String email) {
        find(inputEmail).sendKeys(email);
    }

    public void userInsertPassword(String password) {
        find(inputPassword).sendKeys(password);
    }

    public void userSubmitLogin() {
        find(BtnSubmitLogin).click();
    }

}
