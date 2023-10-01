package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
