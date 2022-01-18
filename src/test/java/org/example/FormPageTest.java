package org.example;

import org.junit.Test;
import pages.FormPage;
import pages.WebPage;

public class FormPageTest {

    @Test
    public void autofillForm(){
        WebPage web = new WebPage();
        web.initializeBrowser();
        FormPage formPage = new FormPage(web.driver);
        web.navigateTo(formPage.PAGE_URL);
        formPage.fillForm();
//        TextBoxPage page = new TextBoxPage(web.driver);
//        web.navigateTo(page.PAGE_URL);
        web.closeBrowser();
    }

}
