package stepDefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LoginPage;
import pages.StorePage;

import java.util.List;
import java.util.Map;

public class steps {
    WebDriver driver;

    @Given("Navigate to Sauce Demo site")
    public void open_browser() {
        driver = DriverFactory.getDriver();
//        StorePage storepage = new StorePage(driver);
        //      storepage.load("https://www.saucedemo.com/");
        new StorePage(driver).load("https://www.saucedemo.com/"); // created object for StorePage.java and call driver to load website

    }

    @When("User is able to Login with credentials")
    public void navigate_to_sauce_demo_site() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLoginBtn();

    }

    @Then("User is able to see Logo on home page")
    public void Verify_that_Logo_is_displayed() {
        if (driver.findElement(By.xpath("//*[@class=\"inventory_list\"]")).isDisplayed()) {
            System.out.println("\nLogin success\n");
        } else if (driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).isDisplayed()) {
            System.out.println("\nUnable to login\n");

        } else {
            System.out.println("\nSomething wnet wrong\n");
        }

//        boolean logoStatus = driver.findElement(By.xpath("//*[@class=\"inventory_list\"]")).isDisplayed();
//        WebElement errorStatus = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
//        Assert.assertEquals(logoStatus,true);
//        if (errorStatus.isDisplayed()){
//            System.out.println("Login Failed");
//            errorStatus.getText();
//        }

    }

    @And("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    @Then("User is able to change item sorting dropdown using SendKeys")
    public void userIsAbleToChangeItemSortingUsingSendkeys() {
        WebElement dropdown;
        WebElement activeOption;

        dropdown = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
        dropdown.sendKeys("Price (low to high)");
        activeOption = driver.findElement(By.xpath("//*[@class=\"active_option\"]"));

        Assert.assertEquals("Price (low to high)", "Price (low to high)");
    }


    @Then("User is able to change item sorting dropdown using select class")
    public void userIsAbleToChangeItemSortingDropdownUsingSelectClass() {
        Select se = new Select(driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]")));
        se.selectByVisibleText("Name (Z to A)");

        Assert.assertEquals("Name (Z to A)", "Name (Z to A)");
    }

    @When("User is able to enter {string} in username field")
    public void user_is_able_to_enter_in_username_field(String username) {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);

    }

    @When("User is able to enter {string} in password field")
    public void user_is_able_to_enter_in_password_field(String password) {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        WebElement clickLogin = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        clickLogin.click();
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


//        productName = productName.toLowerCase(Locale.ROOT);
//        productName = productName.replace(' ', '-');
//        By addToCartBtn = By.xpath("//button[@data-test=\"add-to-cart-" + productName + "\"]");
//        driver.findElement(addToCartBtn).isDisplayed();
//        driver.findElement(addToCartBtn).click();

        new StorePage(driver).navigateToCart();

    }

    @And("User is able to see {string} in the cart")
    public void userIsAbleToSeeInTheCart(String productName) {
        By productNameFiled = By.xpath("//div[@class=\"inventory_item_name\"]");
        String actualName = driver.findElement(productNameFiled).getText();
        org.junit.Assert.assertEquals(productName, actualName);

        System.out.println("=============================== Actual Product name: " + actualName + " =====================");
    }

//    @Then("User is able to navigate to checkout page")
//    public void userIsAbleToNavigateToCheckoutPage() {
//        By checkoutBtn = By.xpath("//button[@id=\"checkout\"]");
//        By checkoutForm = By.xpath("//div[@class=\"checkout_info\"]");
//
//        driver.findElement(checkoutBtn).click();
//        Boolean formDisplayed = driver.findElement(checkoutForm).isDisplayed();
//        Assert.assertTrue(formDisplayed);
//    }







}
