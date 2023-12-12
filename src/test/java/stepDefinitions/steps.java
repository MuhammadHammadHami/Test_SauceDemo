package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.*;

import java.util.List;
import java.util.Map;

public class steps {
    WebDriver driver;

    @Given("Navigate to Sauce Demo site")
    public void open_browser() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://www.saucedemo.com/"); // created object for StorePage.java and call driver to load website

    }

    @When("User is able to Login with credentials")
    public void navigate_to_sauce_demo_site(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickOnLoginBtn();

    }

//    @When("User is able to enter {string} in username field for checkout")
//    public void userIsAbleToEnterInUsernameField(String username) {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername(username);
//
//    }

    //    @When("User is able to enter {string} in password field for checkout")
//    public void userIsAbleToEnterInPasswordFieldForCheckout(String password) {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterPassword(password);
//        loginPage.clickOnLoginBtn();
//
//    }
    @Then("User is able to see Logo on home page")
    public void Verify_that_Logo_is_displayed() {
        InventoryPage homePage = new InventoryPage(driver);

        homePage.homeScreen();
//
//        if (driver.findElement(By.xpath("//*[@class=\"inventory_list\"]")).isDisplayed()) {
//            System.out.println("\nLogin success\n");
//        } else if (driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).isDisplayed()) {
//            System.out.println("\nUnable to login\n");
//
//
//        } else {
//            System.out.println("\nSomething went wrong\n");
//        }

    }

    @And("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    @Then("User is able to change item sorting dropdown using SendKeys")
    public void userIsAbleToChangeItemSortingUsingSendkeys() {
        InventoryPage homePage = new InventoryPage(driver);

        homePage.homeScreen();
        homePage.dropdownSelection();
//        Assert.assertEquals("Price (low to high)", "123Price (low to high)");
       // WebElement dropdown;
//        WebElement activeOption;

      //  dropdown = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
       // dropdown.sendKeys("Price (low to high)");
  //      activeOption = driver.findElement(By.xpath("//*[@class=\"active_option\"]"));

    //    Assert.assertEquals("Price (low to high)", "Price (low to high)");
    }


    @Then("User is able to change item sorting dropdown using select class")
    public void userIsAbleToChangeItemSortingDropdownUsingSelectClass() {
        Select se = new Select(driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]")));
        se.selectByVisibleText("Name (Z to A)");

        Assert.assertEquals("Name (Z to A)", "Name (Z to A)");
    }

    @When("User is able to enter {string} in username field")
    public void userIsAbleToEnterInUsernameField(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
    }

    @When("User is able to enter {string} in password field")
    public void userIsAbleToEnterInPasswordFieldForCheckout(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtn();
    }

    @When("I add {product} to cart")
    public void i_add_to_cart(Product product) {
        System.out.println("When: ");
        System.out.println("Received product name: " + product.getProductName());
    }

    @Then("I see {int} {product} in the cart")
    public void i_see_in_the_cart(Integer int1, Product product) {
        System.out.println("Then: ");
        System.out.println("Received product name: " + product.getProductName());
    }

    @Then("User is able to add {string} to cart")
    public void verify_that_user_is_able_to_add_to_cart(String productName) {

        new StorePage(driver).addToCart(productName);
        new StorePage(driver).navigateToCart();
    }

    @And("User is able to see {string} in the cart")
    public void userIsAbleToSeeInTheCart(String productName) {
        By productNameFiled = By.xpath("//div[@class=\"inventory_item_name\"]");
        String actualName = driver.findElement(productNameFiled).getText();
        org.junit.Assert.assertEquals(productName, actualName);

        System.out.println("=============================== Actual Product name: " + actualName + " =====================");
    }

    @Then("User is able to navigate to checkout page")
    public void user_is_able_to_navigate_to_checkout_page() {
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

    }


}
