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

public class CreateNewInsurancePolicy extends BaseTest{

    @Test
    public void verifyCreateNewInsurancePolicyByFillingAllMandatoryData(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLanguageMenuIcon();
        loginPage.clickEnglishLanguageMenuItem();

        String email = p.getProperty("email");
        System.out.println(email);
        loginPage.sendKeysToEmail(email);

        String password = p.getProperty("password");
        loginPage.sendKeysToPassword(password);
        loginPage.clickNextButton();

        HomePage homePage = new HomePage(driver);
        homePage.clickNewLink();

        ProductContainerPage productContainerPage = new ProductContainerPage(driver);
        productContainerPage.clickCountryDropdown();
        productContainerPage.clickCountryGermany();
        productContainerPage.clickProductNameDropdown();
        productContainerPage.clickNokiav1Allianzglobal();
        productContainerPage.clickTariffDropdown();
        productContainerPage.clickTariffValue();
        productContainerPage.clickInsuranceCategoryDropDown();
        productContainerPage.clickInsuranceCategoryValue();
        productContainerPage.clickPeriodDropdown();
        productContainerPage.clickPeriodValue();
        productContainerPage.clickPaymentTypeDropdown();
        productContainerPage.clickPaymentTypeValue();
        productContainerPage.clickClassDropdown();
        productContainerPage.clickClassDropdownValue();
        String serialNumber = "1234567890";
        productContainerPage.sendKeysToSerialNumberTextBox(serialNumber);
        productContainerPage.clickNextButton();

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
