package test_cases;

import org.testng.annotations.Test;
import page_objects.*;
import test_base.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class CreateNewInsurancePolicyWithSEPADirectDebit extends BaseTest {

    @Test
    public void verifyCreateNewInsurancePolicyWithSEPADirectDebitByFillingAllMandatoryData() {

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
        assertTrue("unable to click on 'NEW' link", homePage.clickNewLink());

        //Fill the details in Product Page
        ProductContainerPage productContainerPage = new ProductContainerPage(driver);
        assertTrue("unable to click on 'Country' dropdown", productContainerPage.clickCountryDropdown());
        String countryName = "Germany";
        assertTrue("unable to select 'Germany' option in 'Country' dropdown", productContainerPage.selectGivenCountry(countryName));
        assertTrue("unable to click on 'Product Name' dropdown", productContainerPage.clickProductNameDropdown());
        String productName = "Nokia_v1Allianz_global";
        assertTrue("unable to select 'Nokia_v1Allianz_global' option in 'Product Name' dropdown", productContainerPage.selectGivenProductNameOption(productName));
        assertTrue("unable to click on 'Tariff' dropdown", productContainerPage.clickTariffDropdown());
        assertTrue("unable to select '1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damag' option in 'Tariff' dropdown", productContainerPage.selectTariffValue());
        assertTrue("unable to click on 'Insurance category' dropdown", productContainerPage.clickInsuranceCategoryDropDown());
        assertTrue("unable to select 'CATEGORY_SMARTPHONE' option in 'Insurance category' dropdown", productContainerPage.selectInsuranceCategoryValue());
        assertTrue("unable to click on 'Period' dropdown", productContainerPage.clickPeriodDropdown());
        assertTrue("unable to select '12 month(s)' option in 'Period' dropdown", productContainerPage.selectPeriodValue());
        assertTrue("unable to click on 'Payment type' dropdown", productContainerPage.clickPaymentTypeDropdown());
        assertTrue("unable to select 'One-time' option in 'Payment type' dropdown", productContainerPage.selectPaymentTypeValue());
        assertTrue("unable to click on 'Class' dropdown", productContainerPage.clickClassDropdown());
        assertTrue("unable to select 'Nokia 3/500 - EUR 500.00' option in 'Class' dropdown", productContainerPage.selectClassDropdownValue());
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
        assertTrue("unable to click on paying with Credit card/debit card icon", paymentProcedurePage.clickPayingWithDirectDebitRadioButton());
        assertTrue("unable to click on 'CONTINUE TO PAYMENT' button", paymentProcedurePage.clickContinueToPaymentButton());

        //Fill the SEPA Direct Debit details in Payment Details Page
        PaymentDetailsPage paymentDetailsPage = new PaymentDetailsPage(driver);
        paymentDetailsPage.sendKeysToAccountOwnerTextBox("ABC");
        paymentDetailsPage.sendKeysToEmailTextBox("test@test.com");
        String directDebit = p.getProperty("directDebitDetails");
        paymentDetailsPage.sendKeysToIBANPlaceholder(directDebit);
        paymentDetailsPage.clickConfirmSEPADirectDebitMandateCheckbox();
        assertTrue("unable to click on 'ORDER FOR FEE' button", paymentDetailsPage.clickOrderForAFeeButton());

        //Verify newly created Insurance Policy with Status -> Created
        InsuranceDetailsPage insuranceDetailsPage = new InsuranceDetailsPage(driver);
        assertTrue("unable to confirm 'Status' value is 'Created'", insuranceDetailsPage.confirmInsuranceStatusCreatedIsVisible());
    }
}