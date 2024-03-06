package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By NEW_LINK = By.xpath("//span[normalize-space()='New']");

    public boolean clickNewLink(){
        return clickElement(NEW_LINK);
    }

}
