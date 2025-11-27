package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
//        tags = "@TC01_Register",
//        tags = "@TC02_Login",
//        tags = "@TC03_Logout",
//        tags = "@TC04_ContactUs",
//        tags = "@TC05_AddToCart",
//        tags = "@TC06_PlaceOrder",
//        tags = "@TC07_Subscription",

        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
