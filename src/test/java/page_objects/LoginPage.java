package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By EMAIL_TEXT_BOX = By.id("login_username");
    private final By PASSWORD_TEXT_BOX = By.id("login_password");
    private final By NEXT_BUTTON = By.xpath("//span[normalize-space()='Next']");

    private final By LANGUAGE_MENU_ICON = By.xpath("//button[@aria-label='Menu']");
    private final By ENGLISH_LANGUAGE_MENU_ITEM = By.xpath("//ul[@role='menu']//li[span[contains(text(),'Eng')]]");


    public boolean sendKeysToEmail(String email){
        return sendKeysToElement(EMAIL_TEXT_BOX,email);
    }

    public boolean sendKeysToPassword(String password){
        return sendKeysToElement(PASSWORD_TEXT_BOX,password);
    }

    public boolean clickNextButton(){
        return clickElement(NEXT_BUTTON);
    }
    public boolean clickLanguageMenuIcon(){
        return clickElement(LANGUAGE_MENU_ICON);
    }
    public boolean clickEnglishLanguageMenuItem(){
        return clickElement(ENGLISH_LANGUAGE_MENU_ITEM);
    }
}
