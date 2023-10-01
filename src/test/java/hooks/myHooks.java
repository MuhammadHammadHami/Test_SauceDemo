package hooks;

import Factory.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.ja.然し;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Factory.*;

public class myHooks {
    private WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("AFTER ALL");

    }

    @Before
    public void before(Scenario scenario){
        driver = DriverFactory.initializeDriver();
        System.out.println("Scenario name: ===================== "+ scenario.getName());
        System.out.println("Scenario status: ==================== "+scenario.getStatus());
        System.out.println("Scenario isFail: ==================== "+scenario.isFailed());

    }

    @After
    public void after(Scenario scenario){
        System.out.println("Scenario name: ==================== "+ scenario.getName());
        System.out.println("Scenario status: ==================== "+scenario.getStatus());
        System.out.println("Scenario isFail: ==================== "+scenario.isFailed());
        driver.quit();
    }
}
