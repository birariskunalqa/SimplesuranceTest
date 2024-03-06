package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentProcedurePage extends BasePage {
    public PaymentProcedurePage(WebDriver driver) {
        super(driver);
    }

    private final By PAYING_WITH_CREDIT_CARD_DEBIT_CARD_ICON = By.xpath("//div[@class='MuiBox-root jss40 jss29']//*[name()='svg']");
        private final By CONTINUE_TO_PAYMENT_BUTTON = By.xpath("//button[contains(@class, 'MuiButton-contained') and @type='button']");

    public boolean clickPayingWithCreditCardDebitCardIcon(){
        return clickElement(PAYING_WITH_CREDIT_CARD_DEBIT_CARD_ICON);
    }
    public boolean clickContinueToPaymentButton(){
        return clickElement(CONTINUE_TO_PAYMENT_BUTTON);
    }
}
