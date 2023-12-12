package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.ILoggerFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.Objects;

public class InventoryPage extends BasePage{
    @FindBy(xpath = "//*[@class='inventory_list']") private WebElement inventoryList;
    @FindBy(xpath = "//h3[@data-test='error']") private WebElement loginError;
    @FindBy(xpath = "//*[@class=\"product_sort_container\"]") private WebElement dropdown;
    @FindBy(xpath = "//span[@class=\"active_option\"]") private WebElement activeDropdownOption;

    public InventoryPage(WebDriver driver) {super(driver);}

    public void homeScreen(){
        if (inventoryList.isDisplayed()){
            String items = wait.until(ExpectedConditions.visibilityOf(inventoryList)).getText();
            Assert.assertTrue(inventoryList.isDisplayed());

            System.out.println("=========================== Inventory Items are: "+ items+ " =====================================");
        }

        else {
            System.out.println("Login Failed!");
        }
    }

    public void dropdownSelection(){
        dropdown.sendKeys("Price (low to high)");
        String activeDropdownOptionText = activeDropdownOption.getText();
        System.out.println("------------------------------------ "+ activeDropdownOptionText +" ------------------------------------");
        Assert.assertEquals(activeDropdownOptionText, "Price (low to high)");
//        Assert.assertSame(activeDropdownOptionText,"Price (low to high)");
    }

}