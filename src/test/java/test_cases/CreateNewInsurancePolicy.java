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

        //
        HomePage homePage = new HomePage(driver);
        assertTrue("unable to click on 'NEW' link",homePage.clickNewLink());

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
        assertTrue("unable to enter text in 'Serial number' field",productContainerPage.sendKeysToSerialNumberTextBox(serialNumber));
        assertTrue("unable to click on 'NEXT' button", productContainerPage.clickNextButton());

        CustomerContainerPage customerContainerPage = new CustomerContainerPage(driver);

        customerContainerPage.sendKeysToFirstNameTextBox("Test");
        customerContainerPage.sendKeysToLastNameTextBox("User");
        customerContainerPage.sendKeysToEMailTextBox("test@user.com");
        customerContainerPage.sendKeysToStreetTextBox("PP");
        customerContainerPage.sendKeysToHouseNumberTextBox("10");
        customerContainerPage.sendKeysToPostalCodeTextBox("12345");
        customerContainerPage.sendKeysToCityTextBox("Berlin");
        customerContainerPage.sendKeysToCountryTextBox("DE");
        customerContainerPage.sendKeysToTaxCodeTextBox("DE");
        customerContainerPage.clickNextButton();

        ConfirmationContainerPage confirmationContainerPage = new ConfirmationContainerPage(driver);
        confirmationContainerPage.clickAllInformationCheckbox();
        confirmationContainerPage.clickDataProcessingConsentCheckbox();
        confirmationContainerPage.clickInformationAcknowledgmentCheckbox();
        confirmationContainerPage.clickInsuredProductAgeCheckbox();
        confirmationContainerPage.clickCreateInsuranceButton();

        PaymentProcedurePage paymentProcedurePage = new PaymentProcedurePage(driver);
        paymentProcedurePage.clickPayingWithCreditCardDebitCardRadioButton();
        paymentProcedurePage.clickContinueToPaymentButton();

        PaymentDetailsPage paymentDetailsPage = new PaymentDetailsPage(driver);
        String cardNumber = "4242424242424242";
        paymentDetailsPage.sendKeysToCardNumberPlaceholder(cardNumber);
        String expirationDate = "0125";
        paymentDetailsPage.sendKeysToExpirationDatePlaceholder(expirationDate);
        String cardCVS = "123";
        paymentDetailsPage.sendKeysToCardCVCPlaceholder(cardCVS);
        paymentDetailsPage.clickOrderForAFeeButton();

        InsuranceDetailsPage insuranceDetailsPage = new InsuranceDetailsPage(driver);
        insuranceDetailsPage.confirmInsuranceStatusCreatedIsVisible();

        String certificateNumber = insuranceDetailsPage.getCertificateNumberText();
        System.out.println(certificateNumber);
        insuranceDetailsPage.clickListLink();
    }
}
