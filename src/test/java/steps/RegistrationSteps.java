package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class RegistrationSteps {

    WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://automationexercise.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Automation Exercise"));
    }

    @When("user clicks on 'Signup \\/ Login' button")
    public void user_clicks_on_signup_login_button() {
        driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
    }

    @When("user enters valid name {string} and email address {string}")
    public void user_enters_valid_name_and_email_address(String name, String email) {

        String uniqueEmail = System.currentTimeMillis() + email;

        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(uniqueEmail);
    }

    @When("user clicks 'Signup' button")
    public void user_clicks_signup_button() {
        driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();
    }

    @When("user fills valid details in the registration form")
    public void user_fills_valid_details_in_the_registration_form() {
        // Gender
        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.cssSelector("[data-qa='password']")).sendKeys("Password123");

        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByValue("5"); // May
        new Select(driver.findElement(By.id("years"))).selectByValue("1990");

        driver.findElement(By.id("first_name")).sendKeys("Magid");
        driver.findElement(By.id("last_name")).sendKeys("Tester");
        driver.findElement(By.id("address1")).sendKeys("Luxor Street 123");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("Luxor Gov");
        driver.findElement(By.id("city")).sendKeys("Luxor");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("01000000000");
    }

    // ------------------- TC01 Register Steps -------------------

    @When("user clicks 'Create Account' button")
    public void user_clicks_create_account_button() {
        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
    }

    @Then("{string} message should be visible")
    public void message_should_be_visible(String expectedMessage) {
        WebElement msg = driver.findElement(By.cssSelector("[data-qa='account-created']"));
        Assert.assertTrue(msg.isDisplayed());
        Assert.assertEquals(msg.getText(), expectedMessage);
    }

    @When("user clicks 'Continue' button")
    public void user_clicks_continue_button() {
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
    }

    @Then("user should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),' Logout')]"));
        Assert.assertTrue(logoutBtn.isDisplayed(), "User is not on homepage (Logout button missing)");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ------------------- TC02 Login Steps (Positive & Negative) -------------------

    @When("user enters correct email {string} and password {string}")
    public void user_enters_correct_email_and_password(String email, String password) {
        driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys(password);
    }

    @When("user enters incorrect email {string} and password {string}")
    public void user_enters_incorrect_email_and_password(String email, String password) {
        driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys(password);
    }

    @When("user clicks 'Login' button")
    public void user_clicks_login_button() {
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();
    }

    @Then("'Logged in as username' text should be visible at top header")
    public void logged_in_as_username_text_should_be_visible_at_top_header() {
        boolean isDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'Logged in as')]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Login failed: 'Logged in as' text is not visible");
    }

    @Then("error message {string} should be visible")
    public void error_message_should_be_visible(String expectedMessage) {
        WebElement errorMessageElement = driver.findElement(By.xpath("//form[@action='/login']/p"));

        Assert.assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed!");

        Assert.assertEquals(errorMessageElement.getText(), expectedMessage);
    }

    // ------------------- TC03 Logout Steps -------------------

    @When("user waits for {int} seconds")
    public void user_waits_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @When("user clicks on 'Logout' button")
    public void user_clicks_on_logout_button() {
        driver.findElement(By.xpath("//a[contains(text(),' Logout')]")).click();
    }

    @Then("user should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "User is not on the login page!");

        boolean isLoginHeaderDisplayed = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed();
        Assert.assertTrue(isLoginHeaderDisplayed);
    }


    // ------------------- TC04 Contact Us Steps -------------------

    @When("user clicks on 'Contact Us' button")
    public void user_clicks_on_contact_us_button() {
        driver.findElement(By.xpath("//a[contains(text(),' Contact us')]")).click();
    }

    @When("user enters name {string}, email {string}, subject {string} and message {string}")
    public void user_enters_details(String name, String email, String subject, String message) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.id("message")).sendKeys(message);
    }

    @When("user uploads a file")
    public void user_uploads_a_file() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/pom.xml";
        driver.findElement(By.name("upload_file")).sendKeys(filePath);
    }

    @When("user clicks 'Submit' button")
    public void user_clicks_submit_button() {
        driver.findElement(By.name("submit")).click();
    }

    @When("user clicks OK button on the alert popup")
    public void user_clicks_ok_button_on_the_alert_popup() {
        driver.switchTo().alert().accept();
    }


    @Then("success message {string} should be visible")
    public void contact_us_success_message(String expectedText) {
        WebElement msg = driver.findElement(By.cssSelector(".status.alert.alert-success"));
        Assert.assertTrue(msg.getText().contains(expectedText));
    }

    // ------------------- TC05 Add To Cart Steps -------------------

    @When("user clicks on 'Products' button")
    public void user_clicks_on_products_button() {
        driver.findElement(By.xpath("//a[@href='/products']")).click();
    }

    @When("user clicks on 'View Product' for the first product")
    public void user_clicks_on_view_product_for_the_first_product() {
        WebElement viewProductBtn = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewProductBtn);
        js.executeScript("arguments[0].click();", viewProductBtn);
    }

    @When("user clicks 'Add to cart' button")
    public void user_clicks_add_to_cart_button() {
        driver.findElement(By.cssSelector("button.btn.btn-default.cart")).click();
    }

    @When("user clicks 'View Cart' link in the modal")
    public void user_clicks_view_cart_link_in_the_modal() {

        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();
    }

    @Then("the product should be visible in the cart page")
    public void the_product_should_be_visible_in_the_cart_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("view_cart"), "User is not on the cart page!");


        boolean productExists = driver.findElement(By.id("product-1")).isDisplayed();
        Assert.assertTrue(productExists, "The product was not found in the cart!");
    }


    // ------------------- TC06 Place Order Steps -------------------

    @When("user clicks 'Proceed To Checkout' button")
    public void user_clicks_proceed_to_checkout_button() {
        WebElement proceedBtn = driver.findElement(By.cssSelector(".btn.btn-default.check_out"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedBtn);
    }

    @When("user enters description in comment area {string} and clicks 'Place Order'")
    public void user_enters_description_and_clicks_place_order(String comment) {
        driver.findElement(By.name("message")).sendKeys(comment);

        WebElement placeOrderBtn = driver.findElement(By.xpath("//a[@href='/payment']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderBtn);
    }

    @When("user enters payment details: Name {string}, CardNumber {string}, CVC {string}, Expiration {string} and {string}")
    public void user_enters_payment_details(String name, String cardNum, String cvc, String month, String year) {
        driver.findElement(By.name("name_on_card")).sendKeys(name);
        driver.findElement(By.name("card_number")).sendKeys(cardNum);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.findElement(By.name("expiry_month")).sendKeys(month);
        driver.findElement(By.name("expiry_year")).sendKeys(year);
    }

    @When("user clicks 'Pay and Confirm Order' button")
    public void user_clicks_pay_and_confirm_order_button() {
        WebElement payBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", payBtn);
    }

    @Then("the order success message {string} should be visible")
    public void order_success_message_should_be_visible(String expectedMsg) {
        WebElement msg = driver.findElement(By.cssSelector("[data-qa='order-placed']"));
        Assert.assertTrue(msg.isDisplayed(), "Order placed message is not visible!");
        Assert.assertEquals(msg.getText(), expectedMsg);
    }



    // ------------------- TC07 Subscription Steps -------------------

    @When("user scrolls down to footer")
    public void user_scrolls_down_to_footer() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("user enters valid email address {string} in subscription input")
    public void user_enters_email_in_subscription_input(String email) {
        driver.findElement(By.id("susbscribe_email")).sendKeys(email);
    }

    @When("user clicks the arrow button")
    public void user_clicks_the_arrow_button() {
        driver.findElement(By.id("subscribe")).click();
    }

    @Then("subscription success message {string} should be visible")
    public void subscription_success_message_should_be_visible(String expectedText) {

        WebElement successMsg = driver.findElement(By.id("success-subscribe"));
        Assert.assertTrue(successMsg.isDisplayed());
        Assert.assertEquals(successMsg.getText(), expectedText);
    }

}
