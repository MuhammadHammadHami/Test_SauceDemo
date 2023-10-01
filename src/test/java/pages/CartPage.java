package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage{
    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]") private WebElement productNameFiled;
    @FindBy(xpath = "//button[@data-test='checkout']") private WebElement checkoutBtn;
    @FindBy(xpath = "//div[@class=\"checkout_info\"]") private WebElement checkoutForm;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage itemInCart(String productName){
        String actualName = wait.until(ExpectedConditions.visibilityOf(productNameFiled)).getText();
        Assert.assertEquals(actualName,productName);

        System.out.println("=============================== Actual Product name: " + actualName + " =====================");
        return this;
    }

    public CartPage navigateToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(checkoutBtn)).click();
        boolean addressForm = wait.until(ExpectedConditions.visibilityOf(checkoutForm)).isDisplayed();
        Assert.assertTrue(addressForm);
        return this;
    }
}
