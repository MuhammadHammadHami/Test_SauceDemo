package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
                plugin = {"pretty","html:target/cucumber.html"},
                glue = {"stepDefinitions","hooks", "types"},
                features = {"src/test/java/Features/"},
               // tags = "@Demo",
                dryRun = false,

                snippets = CAMELCASE
)

public class TestRunner {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}
