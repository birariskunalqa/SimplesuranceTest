package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.BasePage;

public class CustomerContainerPage extends BasePage {
    public CustomerContainerPage(WebDriver driver) {
        super(driver);
    }

    private final By FIRST_NAME_TEXT_BOX = By.id("input-createCertificate_firstName");
    private final By LAST_NAME_TEXT_BOX = By.name("lastName");
    private final By EMAIL_TEXT_BOX = By.id("input-createCertificate_email");
    private final By STREET_TEXT_BOX = By.xpath("//input[@id='input-createCertificate_streetName']");
    private final By HOUSE_NUMBER_TEXT_BOX = By.xpath("//input[@id='input-createCertificate_streetNumber']");
    private final By POSTAL_CODE_TEXT_BOX = By.xpath("//input[@id='input-createCertificate_zip']");
    private final By CITY_TEXT_BOX = By.id("input-createCertificate_city");
    private final By COUNTRY_TEXT_BOX = By.id("input-createCertificate_country");
    private final By TAX_CODE_TEXT_BOX = By.id("input-createCertificate_taxCode");
    private final By NEXT_BUTTON = By.xpath("//span[normalize-space()='Next']");

    public boolean sendKeysToFirstNameTextBox(String firstName){
        return sendKeysToElement(FIRST_NAME_TEXT_BOX, firstName);
    }
    public boolean sendKeysToLastNameTextBox(String lastName){
        return sendKeysToElement(LAST_NAME_TEXT_BOX, lastName);
    }
    public boolean sendKeysToEMailTextBox(String email){
        return sendKeysToElement(EMAIL_TEXT_BOX, email);
    }
    public boolean sendKeysToStreetTextBox(String street){
        return sendKeysToElement(STREET_TEXT_BOX, street);
    }
    public boolean sendKeysToHouseNumberTextBox(String houseNumber){
        return sendKeysToElement(HOUSE_NUMBER_TEXT_BOX, houseNumber);
    }
    public boolean sendKeysToPostalCodeTextBox(String postalCode){
        return sendKeysToElement(POSTAL_CODE_TEXT_BOX, postalCode);
    }
    public boolean sendKeysToCityTextBox(String city){
        return sendKeysToElement(CITY_TEXT_BOX, city);
    }
    public boolean sendKeysToCountryTextBox(String country){
        return sendKeysToElement(COUNTRY_TEXT_BOX, country);
    }
    public boolean sendKeysToTaxCodeTextBox(String taxCode){
        return sendKeysToElement(TAX_CODE_TEXT_BOX, taxCode);
    }
    public boolean clickNextButton(){
        return clickElement(NEXT_BUTTON);
    }
}