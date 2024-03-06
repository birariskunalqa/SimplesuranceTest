package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.BasePage;

public class InsuranceDetailsPage extends BasePage {
    public InsuranceDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By INSURANCE_STATUS_CREATED = By.xpath("//tr[td[@class='jss28' and .//span='Status']]/td[@class='jss28' and .//span='Created']");
    private final By CERTIFICATE_NUMBER = By.xpath("//span[text()='Certificate number']/ancestor::td/following-sibling::td//div");
    private final By LIST_LINK = By.xpath("//span[normalize-space()='List']");
    public boolean confirmInsuranceStatusCreatedIsVisible(){
        return confirmElementIsVisible(INSURANCE_STATUS_CREATED);
    }
    public String getCertificateNumberText(){
        return getElementText(CERTIFICATE_NUMBER);
    }
    public boolean clickListLink(){
        return clickElement(LIST_LINK);
    }
}
