package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean sendKeysToElement(By locator, String keys) {
        try {
            WebElement elementToReceiveKeys = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
            elementToReceiveKeys.sendKeys(keys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickElement(By locator) {
        try {
            WebElement elementToClick = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(locator));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkAndSelectCheckbox(By locator) {
        boolean selected = false;
        try {
            WebElement checkbox = driver.findElement(locator);
            selected = checkbox.isSelected();

            // If the checkbox is not selected, select it
            if (!selected) {
                checkbox.click();
                selected = true; // Update the selected status
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return selected;
    }

    public boolean sendKeysToElementIniFrame(By locator, By iframeLocator, String textToSend) {
        try {
            // Switch to the iframe
            WebElement iframeElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
            driver.switchTo().frame(iframeElement);

            // Find and send keys to the element within the iframe
            WebElement elementToSendKeys = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            elementToSendKeys.sendKeys(textToSend);

            // Switch back to the main content (outside the iframe)
            driver.switchTo().defaultContent();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean confirmElementIsVisible(By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public String getElementText(By locator) {
        try {
            WebElement elementText = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return elementText.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to get text from Element.";
        }
    }
}
