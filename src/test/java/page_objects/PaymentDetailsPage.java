package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.BasePage;

public class PaymentDetailsPage extends BasePage {
    public PaymentDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By CARD_NUMBER_PLACEHOLDER = By.xpath("//input[@placeholder='Kartennummer']");
    private final By EXPIRATION_DATE_PLACEHOLDER = By.xpath("//input[@placeholder='MM/JJ']");
    private final By CARD_CVC_PLACEHOLDER = By.xpath("//input[@placeholder='Prüfziffer']");
    private final By ORDER_FOR_A_FEE_BUTTON = By.xpath("//button[contains(@class, 'MuiButton-contained') and @type='button']");
    private final By PAYMENT_DETAILS_IFRAME = By.xpath("//iframe[contains(@src, 'js.stripe.com/v3/elements-inner-card')]");
    private final By ACCOUNT_OWNER_TEXT_BOX = By.xpath("//input[@name='accountHolder']");
    private final By EMAIL_TEXT_BOX = By.xpath("//input[@name='email']");
    private final By IBAN_PLACEHOLDER = By.xpath("//input[@placeholder='DE00 0000 0000 0000 0000 00']");
    private final By IBAN_IFRAME = By.xpath("//iframe[contains(@title, 'IBAN')]");
    private final By CONFIRM_SEPA_DIRECT_DEBIT_MANDATE_CHECKBOX = By.xpath("//span[@class='MuiIconButton-label']/input[@type='checkbox']");

    public boolean sendKeysToCardNumberPlaceholder(String cardNumber){
        return sendKeysToElementIniFrame(CARD_NUMBER_PLACEHOLDER, PAYMENT_DETAILS_IFRAME,cardNumber);
    }
    public boolean sendKeysToExpirationDatePlaceholder(String expirationDate){
        return sendKeysToElementIniFrame(EXPIRATION_DATE_PLACEHOLDER, PAYMENT_DETAILS_IFRAME,expirationDate);
    }
    public boolean sendKeysToCardCVCPlaceholder(String cardCVC){
        return sendKeysToElementIniFrame(CARD_CVC_PLACEHOLDER, PAYMENT_DETAILS_IFRAME,cardCVC);
    }
    public boolean clickOrderForAFeeButton(){
        return clickElement(ORDER_FOR_A_FEE_BUTTON);
    }
    public boolean sendKeysToAccountOwnerTextBox(String accountOwner){
        return sendKeysToElement(ACCOUNT_OWNER_TEXT_BOX, accountOwner);
    }
    public boolean sendKeysToEmailTextBox(String email){
        return sendKeysToElement(EMAIL_TEXT_BOX, email);
    }
    public boolean sendKeysToIBANPlaceholder(String iban){
        return sendKeysToElementIniFrame(IBAN_PLACEHOLDER, IBAN_IFRAME,iban);
    }
    public boolean clickConfirmSEPADirectDebitMandateCheckbox(){
        return checkAndSelectCheckbox(CONFIRM_SEPA_DIRECT_DEBIT_MANDATE_CHECKBOX);
    }
}
