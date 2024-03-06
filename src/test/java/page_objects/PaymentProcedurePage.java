package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.BasePage;

public class PaymentProcedurePage extends BasePage {
    public PaymentProcedurePage(WebDriver driver) {
        super(driver);
    }

    private final By PAYING_WITH_CREDIT_CARD_DEBIT_CARD_RADIO_BUTTON = By.xpath("//input[@value='STRIPE.CARD']");
        private final By CONTINUE_TO_PAYMENT_BUTTON = By.xpath("//button[contains(@class, 'MuiButton-contained') and @type='button']");

    public boolean clickPayingWithCreditCardDebitCardRadioButton(){
        return clickElement(PAYING_WITH_CREDIT_CARD_DEBIT_CARD_RADIO_BUTTON);
    }
    public boolean clickContinueToPaymentButton(){
        return clickElement(CONTINUE_TO_PAYMENT_BUTTON);
    }
}
