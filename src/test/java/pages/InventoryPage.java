package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage{
    @FindBy(xpath = "//*[@class='inventory_list']") private WebElement inventoryList;
    @FindBy(xpath = "//h3[@data-test='error']") private WebElement loginError;

    public InventoryPage(WebDriver driver) {super(driver);}

    public void homeScreen(){
        if (inventoryList.isDisplayed()){
            String items = wait.until(ExpectedConditions.visibilityOf(inventoryList)).getText();
            System.out.println("Inventory Items are: "+ items);
        }

        else {
            System.out.println("Login Failed!");
        }

    }

}
