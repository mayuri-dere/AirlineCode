package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@test",
        plugin = {
                  "pretty",
                  "html:target/cucumber-reports.html",
                  "json:target/cucumber-reports.json"
        }
)
public class TestRunner {

    public static WebDriver driver;

    @BeforeClass
    public static void setupBeforeClass() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/driver/chromedriver_win32/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }


    }
}