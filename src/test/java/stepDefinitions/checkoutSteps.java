package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

import java.util.List;
import java.util.Map;

public class checkoutSteps {
    WebDriver driver;
    @Given("Navigate to Sauce Demo site for checkout")
    public void open_browser() {
        driver = DriverFactory.getDriver();
//        StorePage storepage = new StorePage(driver);
        //      storepage.load("https://www.saucedemo.com/");
        new StorePage(driver).load("https://www.saucedemo.com/"); // created object for StorePage.java and call driver to load website

    }

    @When("User is able to enter {string} in username field for checkout")
    public void user_is_able_to_enter_in_username_field(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();

    }

    @When("User is able to enter {string} in password field for checkout")
    public void userIsAbleToEnterInPasswordFieldForCheckout(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword();
        loginPage.clickOnLoginBtn();

    }

    @Then("User is able to see Logo on home page for checkout")
    public void userIsAbleToSeeLogoOnHomePageForCheckout() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.homeScreen();
    }

    @Then("User is able to add {string} to cart for checkout")
    public void userIsAbleToAddToCartForCheckout(String productName) {

        new StorePage(driver).addToCart(productName);


//        productName = productName.toLowerCase(Locale.ROOT);
//        productName = productName.replace(' ', '-');
//        By addToCartBtn = By.xpath("//button[@data-test=\"add-to-cart-" + productName + "\"]");
//        driver.findElement(addToCartBtn).isDisplayed();
//        driver.findElement(addToCartBtn).click();

        new StorePage(driver).navigateToCart();
    }

    @And("User is able to see {string} in the cart for checkout")
    public void userIsAbleToSeeInTheCartForCheckout(String productName) {
        CartPage cartPage = new CartPage(driver);
        cartPage.itemInCart(productName);
    }
    @Then("User is able to navigate to checkout page for checkout")
    public void userIsAbleToNavigateToCheckoutPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCheckout();
    }
    @Then("User is able to fill checkout information")
    public void userIsAbleToFillCheckoutInformation(List<Map<String, String>> billingDetail) {
        CheckoutPage checkoutpage = new CheckoutPage(driver);
        checkoutpage.enterFirstName(billingDetail.get(0).get("firstname"));
        checkoutpage.enterLastName(billingDetail.get(0).get("lastname"));
        checkoutpage.enterZipCode(billingDetail.get(0).get("zipCode"));
        checkoutpage.clickContinueBtn();
//
//        boolean billingInfo = driver.findElement(billingInformation).isDisplayed();
//        Assert.assertTrue(billingInfo);

    }

    @Then("User is able to place order")
    public void userIsAbleToPlaceOrder() {
//        By finishBtn = By.xpath("//button[@data-test=\"finish\"]");
//        By successMSG = By.xpath("//div[@id=\"checkout_complete_container\"]//h2");
//        checkoutPage checkoutpage = new checkoutPage(driver);
//        checkoutpage.clickFinishBtn();
//
//        driver.findElement(finishBtn).isDisplayed();
//        driver.findElement(finishBtn).click();

        CheckoutPage checkoutpage = new CheckoutPage(driver);
        checkoutpage.clickFinishBtn();
        checkoutpage.successMsg();

//        boolean message = driver.findElement(successMSG).isDisplayed();
//        Assert.assertTrue(message);
//        String success = driver.findElement(successMSG).getText();
//        Assert.assertEquals(success, "Thank you for your order!");
//        System.out.println("============================== " + success + " =============================================");

    }

    @And("Close the browser after checkout")
    public void closeTheBrowserAfterCheckout() {
        driver.quit();
    }
}
