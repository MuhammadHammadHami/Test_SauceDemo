package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class StorePage extends BasePage {
    @FindBy(xpath ="//a[@class=\"shopping_cart_link\"]") private WebElement cartIconBtn;
    String productName;

    public StorePage(WebDriver driver) {
        super(driver);

    }

    public void addToCart(String productName){
        productName = productName.toLowerCase(Locale.ROOT);
        productName = productName.replace(' ', '-');

        By addToCartBtn = By.xpath("//button[@data-test=\"add-to-cart-" + productName + "\"]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        System.out.println("=============================== "+productName+" added to cart ===============================");

    }

    public void navigateToCart(){

        wait.until(ExpectedConditions.elementToBeClickable(cartIconBtn)).click();
        System.out.println("=============================== Navigated to cart ===============================");
    }
}
