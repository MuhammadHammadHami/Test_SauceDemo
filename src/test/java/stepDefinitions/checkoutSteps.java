package stepDefinitions;

import Factory.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class checkoutSteps {
    WebDriver driver;

    @Given("Navigate to Sauce Demo site for checkout")
    public void open_browser() {
        driver = Driver.getDriver();
        new StorePage(driver).load("https://www.saucedemo.com/"); // created object for StorePage.java and call driver to load website

    }

    @When("User is able to enter {string} in username field for checkout")
    public void user_is_able_to_enter_in_username_field(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);

    }

    @When("User is able to enter {string} in password field for checkout")
    public void userIsAbleToEnterInPasswordFieldForCheckout(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
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
//    @Then("User is able to fill checkout information")
//    public void userIsAbleToFillCheckoutInformation(List<Map<String, String>> billingDetail) {
//        CheckoutPage checkoutpage = new CheckoutPage(driver);
//        checkoutpage.enterFirstName(billingDetail.get(0).get("firstname"));
//        checkoutpage.enterLastName(billingDetail.get(0).get("lastname"));
//        checkoutpage.enterZipCode(billingDetail.get(0).get("zipCode"));
//        checkoutpage.clickContinueBtn();
//
//    }

    @Then("User is able to place order")
    public void userIsAbleToPlaceOrder() {

        CheckoutPage checkoutpage = new CheckoutPage(driver);
        checkoutpage.clickFinishBtn();
        checkoutpage.successMsg();

    }

    @And("Close the browser after checkout")
    public void closeTheBrowserAfterCheckout() {
        driver.quit();
    }
}
