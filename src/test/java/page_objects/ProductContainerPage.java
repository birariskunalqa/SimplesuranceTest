package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductContainerPage extends BasePage {
    public ProductContainerPage(WebDriver driver) {
        super(driver);
    }

    private final By COUNTRY_DROPDOWN = By.id("country-select");
    private final By COUNTRY_GERMANY = By.xpath("//li[@data-value='DE']//span[text()='Germany']");
    private final By PRODUCT_NAME_DROPDOWN = By.id("product-name-select");
    private final By PRODUCT_NAME_VALUE = By.xpath("//li[@data-value='Nokia_v1Allianz_global' and text()='Nokia_v1Allianz_global']");
    private final By TARIFF_DROPDOWN = By.xpath("//div[@id='tariff-name-select']");
    private final By TARIFF_VALUE = By.xpath("//li[text()='1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damage']");
    private final By INSURANCE_CATEGORY_DROPDOWN = By.xpath("//div[@id='category-name-select']");
    private final By INSURANCE_CATEGORY_VALUE = By.xpath("//li[text()='CATEGORY_SMARTPHONE']");
    private final By PERIOD_DROPDOWN = By.xpath("//div[@id='duration-select']");
    private final By PERIOD_VALUE = By.xpath("//li[text()='12 month(s)']");
    private final By PAYMENT_TYPE_DROPDOWN = By.xpath("//div[@id='frequency-select']");
    private final By PAYMENT_TYPE_VALUE = By.xpath("//li[@data-value='12 month(s)']//span[text()='One-time']");
    private final By CLASS_DROPDOWN = By.xpath("//div[@id='class-name-select']");
    private final By CLASS_DROPDOWN_VALUE = By.xpath("//li[@data-value='PDCODE677395' and text()='Nokia 3/500 - EUR 500.00']");
    private final By SERIAL_NUMBER_TEXT_BOX = By.id("input-createCertificate_serialNumber");
    private final By NEXT_BUTTON = By.xpath("//button[@type=\"button\"]//span[normalize-space()='Next']");

    public boolean clickCountryDropdown(){
        return clickElement(COUNTRY_DROPDOWN);
    }
    public boolean selectCountryGermany(){
        return clickElement(COUNTRY_GERMANY);
    }
    public boolean clickProductNameDropdown(){
        return clickElement(PRODUCT_NAME_DROPDOWN);
    }
    public boolean selectNokiav1Allianzglobal(){
        return clickElement(PRODUCT_NAME_VALUE);
    }
    public boolean clickTariffDropdown(){
        return clickElement(TARIFF_DROPDOWN);
    }
    public boolean selectTariffValue(){
        return clickElement(TARIFF_VALUE);
    }
    public boolean clickInsuranceCategoryDropDown(){
        return clickElement(INSURANCE_CATEGORY_DROPDOWN);
    }
    public boolean selectInsuranceCategoryValue(){
        return clickElement(INSURANCE_CATEGORY_VALUE);
    }
    public boolean clickPeriodDropdown(){
        return clickElement(PERIOD_DROPDOWN);
    }
    public boolean selectPeriodValue(){
        return clickElement(PERIOD_VALUE);
    }
    public boolean clickPaymentTypeDropdown(){
        return clickElement(PAYMENT_TYPE_DROPDOWN);
    }
    public boolean selectPaymentTypeValue(){
        return clickElement(PAYMENT_TYPE_VALUE);
    }
    public boolean clickClassDropdown(){
        return clickElement(CLASS_DROPDOWN);
    }
    public boolean selectClassDropdownValue(){
        return clickElement(CLASS_DROPDOWN_VALUE);
    }
    public boolean sendKeysToSerialNumberTextBox(String serialNumber){
        return sendKeysToElement(SERIAL_NUMBER_TEXT_BOX,serialNumber);
    }
    public boolean clickNextButton(){
        return clickElement(NEXT_BUTTON);
    }
}
