package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);

    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void clickOnLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

}


