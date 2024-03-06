package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.BasePage;

public class ConfirmationContainerPage extends BasePage {
    public ConfirmationContainerPage(WebDriver driver) {
        super(driver);
    }


    private final By ALL_INFORMATION_CHECKBOX = By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]/input[@type='checkbox'])[1]");
    private final By DATA_PROCESSING_CONSENT_CHECKBOX = By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]/input[@type='checkbox'])[2]");
    private final By INFORMATION_ACKNOWLEDGMENT_CHECKBOX = By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]/input[@type='checkbox'])[3]");
    private final By INSURED_PRODUCT_AGE_CHECKBOX = By.xpath("(//span[contains(@class, 'MuiCheckbox-root')]/input[@type='checkbox'])[4]");
    private final By CREATE_INSURANCE_BUTTON = By.xpath("//span[normalize-space()='Create insurance']");

    public boolean clickAllInformationCheckbox(){
        return checkAndSelectCheckbox(ALL_INFORMATION_CHECKBOX);
    }
    public boolean clickDataProcessingConsentCheckbox(){
        return checkAndSelectCheckbox(DATA_PROCESSING_CONSENT_CHECKBOX);
    }
    public boolean clickInformationAcknowledgmentCheckbox(){
        return checkAndSelectCheckbox(INFORMATION_ACKNOWLEDGMENT_CHECKBOX);
    }
    public boolean clickInsuredProductAgeCheckbox(){
        return checkAndSelectCheckbox(INSURED_PRODUCT_AGE_CHECKBOX);
    }
    public boolean clickCreateInsuranceButton(){
        return clickElement(CREATE_INSURANCE_BUTTON);
    }
}
