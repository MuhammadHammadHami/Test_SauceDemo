package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    @FindBy(xpath = "//input[@data-test=\"firstName\"]") private WebElement firstNameField;
    @FindBy(xpath = "//input[@data-test=\"lastName\"]" ) private WebElement lastNameField;
    @FindBy(xpath = "//input[@data-test=\"postalCode\"]") private WebElement zipCodeField;
    @FindBy(xpath = "//input[@data-test=\"continue\"]") private WebElement continueBtn;
    @FindBy(xpath = "//button[@data-test=\"cancel\"]") private WebElement cancelBtn;

    @FindBy(xpath = "//div[@class=\"summary_info\"]") private WebElement billingInformation;
    @FindBy(xpath = "//button[@data-test=\"finish\"]") private WebElement finishBtn;
    @FindBy(xpath = "//div[@id=\"checkout_complete_container\"]//h2") private WebElement successMSG;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]") private WebElement messageText;

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]") private WebElement productNameFiled;


    public CheckoutPage(WebDriver driver) { super(driver); }


    public CheckoutPage enterFirstName(String firstName){
        WebElement obj = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        obj.clear();
        obj.sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        WebElement obj = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        obj.clear();
        obj.sendKeys(lastName);
        return this;
    }
    public CheckoutPage enterZipCode(String zipCode){
        WebElement obj = wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        obj.clear();
        obj.sendKeys(zipCode);
        return this;
    }

    public CheckoutPage clickContinueBtn(){
        wait.until(ExpectedConditions.visibilityOf(continueBtn)).click();
        return this;
    }
    public CheckoutPage clickCancelBtn(){
        wait.until(ExpectedConditions.visibilityOf(cancelBtn)).click();
        return this;
    }
    public CheckoutPage clickFinishBtn(){
        wait.until(ExpectedConditions.visibilityOf(finishBtn)).click();
        return this;
    }
    public CheckoutPage successMsg(){
     wait.until(ExpectedConditions.visibilityOf(successMSG)).isDisplayed();
        String message =wait.until(ExpectedConditions.visibilityOf(messageText)).getText();

        Assert.assertEquals(message, "Thank you for your order!");
        System.out.println("============================== " + message + " =============================================");
     return this;
    }
}
