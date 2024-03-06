package test_cases;

import org.testng.annotations.Test;
import page_objects.*;
import page_objects.ConfirmationContainerPage;
import page_objects.CustomerContainerPage;
import page_objects.ProductContainerPage;
import page_objects.InsuranceDetailsPage;
import page_objects.PaymentDetailsPage;
import page_objects.PaymentProcedurePage;
import test_base.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class CreateNewInsurancePolicy extends BaseTest{

    @Test
    public void verifyCreateNewInsurancePolicyByFillingAllMandatoryData(){

        //Login
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("unable to click on language menu icon", loginPage.clickLanguageMenuIcon());
        assertTrue("unable to click on 'English' menu item", loginPage.clickEnglishLanguageMenuItem());

        String email = p.getProperty("email");
        assertTrue("unable to enter text in 'E-Mail' field", loginPage.sendKeysToEmail(email));

        String password = p.getProperty("password");
        assertTrue("unable to enter text in 'Password' field", loginPage.sendKeysToPassword(password));
        assertTrue("unable to click on 'NEXT' button", loginPage.clickNextButton());

        //click on New link to create New Insurance Policy
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on 'NEW' link",homePage.clickNewLink());

        //Fill the details in Product Page
        ProductContainerPage productContainerPage = new ProductContainerPage(driver);
        assertTrue("unable to click on 'Country' dropdown", productContainerPage.clickCountryDropdown());
        assertTrue("unable to click on 'Germany' option in 'Country' dropdown", productContainerPage.clickCountryGermany());
        assertTrue("unable to click on 'Product Name' dropdown", productContainerPage.clickProductNameDropdown());
        assertTrue("unable to click on 'Nokia_v1Allianz_global' option in 'Product Name' dropdown", productContainerPage.clickNokiav1Allianzglobal());
        assertTrue("unable to click on 'Tariff' dropdown", productContainerPage.clickTariffDropdown());
        assertTrue("unable to click on '1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damag' option in 'Tariff' dropdown", productContainerPage.clickTariffValue());
        assertTrue("unable to click on 'Insurance category' dropdown", productContainerPage.clickInsuranceCategoryDropDown());
        assertTrue("unable to click on 'CATEGORY_SMARTPHONE' option in 'Insurance category' dropdown", productContainerPage.clickInsuranceCategoryValue());
        assertTrue("unable to click on 'Period' dropdown", productContainerPage.clickPeriodDropdown());
        assertTrue("unable to click on '12 month(s)' option in 'Period' dropdown", productContainerPage.clickPeriodValue());
        assertTrue("unable to click on 'Payment type' dropdown", productContainerPage.clickPaymentTypeDropdown());
        assertTrue("unable to click on 'One-time' option in 'Payment type' dropdown", productContainerPage.clickPaymentTypeValue());
        assertTrue("unable to click on 'Class' dropdown", productContainerPage.clickClassDropdown());
        assertTrue("unable to click on 'Nokia 3/500 - EUR 500.00' option in 'Class' dropdown", productContainerPage.clickClassDropdownValue());
        String serialNumber = "1234567890";
        assertTrue("unable to enter text in 'Serial number' field", productContainerPage.sendKeysToSerialNumberTextBox(serialNumber));
        assertTrue("unable to click on 'NEXT' button", productContainerPage.clickNextButton());

        //Fill the details in Customer Page
        CustomerContainerPage customerContainerPage = new CustomerContainerPage(driver);
        assertTrue("unable to enter text in 'First name' field", customerContainerPage.sendKeysToFirstNameTextBox("Test"));
        assertTrue("unable to enter text in 'Last name' field", customerContainerPage.sendKeysToLastNameTextBox("User"));
        assertTrue("unable to enter text in 'E-Mail' field", customerContainerPage.sendKeysToEMailTextBox("test@user.com"));
        assertTrue("unable to enter text in 'Street' field", customerContainerPage.sendKeysToStreetTextBox("PP"));
        assertTrue("unable to enter text in 'House number' field", customerContainerPage.sendKeysToHouseNumberTextBox("10"));
        assertTrue("unable to enter text in 'Postal code' field", customerContainerPage.sendKeysToPostalCodeTextBox("12345"));
        assertTrue("unable to enter text in 'City' field", customerContainerPage.sendKeysToCityTextBox("Berlin"));
        assertTrue("unable to enter text in 'Country' field", customerContainerPage.sendKeysToCountryTextBox("DE"));
        assertTrue("unable to enter text in 'Tax Code' field", customerContainerPage.sendKeysToTaxCodeTextBox("DE"));
        assertTrue("unable to click on 'NEXT' button", customerContainerPage.clickNextButton());

        //Fill the details in Confirmation Page
        ConfirmationContainerPage confirmationContainerPage = new ConfirmationContainerPage(driver);
        assertTrue("unable to click on All Information checkbox", confirmationContainerPage.clickAllInformationCheckbox());
        assertTrue("unable to click on Data Processing Consent checkbox", confirmationContainerPage.clickDataProcessingConsentCheckbox());
        assertTrue("unable to click on Information Acknowledgment checkbox", confirmationContainerPage.clickInformationAcknowledgmentCheckbox());
        assertTrue("unable to click on Insured Product Age checkbox", confirmationContainerPage.clickInsuredProductAgeCheckbox());
        assertTrue("unable to click on 'CREATE INSURANCE' button", confirmationContainerPage.clickCreateInsuranceButton());

        //Fill the details in Payment Procedure Page
        PaymentProcedurePage paymentProcedurePage = new PaymentProcedurePage(driver);
        assertTrue("unable to click on paying with Credit card/debit card icon", paymentProcedurePage.clickPayingWithCreditCardDebitCardIcon());
        assertTrue("unable to click on 'CONTINUE TO PAYMENT' button", paymentProcedurePage.clickContinueToPaymentButton());

        //Fill the details in Payment Details Page
        PaymentDetailsPage paymentDetailsPage = new PaymentDetailsPage(driver);
        String cardNumber = "4242424242424242";
        assertTrue("unable to enter text in 'Card Number' placeholder", paymentDetailsPage.sendKeysToCardNumberPlaceholder(cardNumber));
        String expirationDate = "0125";
        assertTrue("unable to enter text in 'Expiration Date' placeholder", paymentDetailsPage.sendKeysToExpirationDatePlaceholder(expirationDate));
        String cardCVS = "123";
        assertTrue("unable to enter text in 'Card CVC' placeholder", paymentDetailsPage.sendKeysToCardCVCPlaceholder(cardCVS));
        assertTrue("unable to click on 'ORDER FOR FEE' button", paymentDetailsPage.clickOrderForAFeeButton());

        //Verify newly created Insurance Policy with Status -> Created
        InsuranceDetailsPage insuranceDetailsPage = new InsuranceDetailsPage(driver);
        assertTrue("unable to confirm 'Status' value is 'Created'", insuranceDetailsPage.confirmInsuranceStatusCreatedIsVisible());
    }
}
