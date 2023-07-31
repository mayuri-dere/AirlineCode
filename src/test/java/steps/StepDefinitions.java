package steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class StepDefinitions {

    public  WebDriver driver;


    @Before
    public void before(Scenario s) throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/driver/chromedriver_win32/chromedriver.exe");

    }
    @After
    public void after(Scenario s) {
        driver.close();
    }

/////////////////////////////////////// LH Login  ////////////////////////////////////////////

    @Given("User launches lufthansa web application")
    public void user_launches_lufthansa_web_application() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.lufthansa.com/in/en/homepage");
       Thread.sleep(2000);
    }


    @And("User handles privacy settings")
    public void userHandlesPrivacySettings() {
        WebElement agreeButton = driver.findElement(By.xpath("//button[text()='Agree']"));
        agreeButton.click();
    }

    @When("User clicks on Login & Registration Button")
    public void userClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//span[text()='Login & Registration']"));
        loginButton.click();
    }

    @And("User enters {string} address")
    public void userEntersEmailAddress(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='id-emailLoginStepOne-textfield']"));
        emailField.sendKeys(email);
    }

    @And("User clicks on Next Button")
    public void userClicksOnNextButton() {
        WebElement nextButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        nextButton.click();
    }

    @And("User enters {string}")
    public void userEntersPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='id-emailLoginStepTwo-textfield']"));
        passwordField.sendKeys(password);
    }

    @Then("User clicks on Log in Button")
    public void userClicksOn_LoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='travelid-button travelid-button--fullwidth travelid-button--filled travelid-button--primary travelid-button--emailLogin travelid-login__loginButton']"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
     /////////////////////////////////////// Hotel Booking ///////////////////////////////////////////

    @And("User clicks on Hotel button")
    public void user_clicks_on_Hotel_button()
    {
            driver.findElement(By.xpath("//span[text()='Hotel']")).click();
    }

    @And("User enters destination")
    public void user_enters_destination() {
        driver.findElement(By.xpath("//input[@placeholder='Destination']")).sendKeys("Mumbai");
    }

    @And("User clicks on search hotel button")
    public void user_clicks_on_search_hotel_button() {
        driver.findElement(By.xpath("//span[text()='Search hotel']")).click();
       // driver.findElement(By.xpath("//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 ae1678b153']   ")).click();
    }
    /////////////////////////////////////  Flight Status //////////////////////////////////////////////
    @And("User clicks on flight status button")
    public void user_clicks_on_flight_status_button() {
        driver.findElement(By.xpath("//span[text()='Flight status']")).click();

    }

    @And("User scroll up the page")
    public void user_scroll_up_the_page() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, window.innerHeight)");
    }


    @And("User clicks on search by route or airport button")
    public void user_clicks_on_search_by_route_or_airport_button() {
        driver.findElement(By.xpath("//a[text()='Search by route or airport']")).click();
    }

    @And("User clicks on flight route tab")
    public void user_clicks_on_flight_route_tab() {
        // getting stale element refearnce exception
        driver.findElement(By.xpath("//span[text()='Flight route']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//span[text()='Flight route']")).click();
    }

    @And("User enters from city")
    public void user_enters_from_city() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Frankfurt");
        Thread.sleep(2000);
    }

    @And("User enters To city")
    public void user_enters_To_city() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
        Thread.sleep(2000);
    }

    @And("User clicks on search")
    public void user_clicks_on_search() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Search']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
    }

    /////////////////////////////////////////////// Flight Search ///////////////////////////////////////////

    @When("User clicks on one way trip on Flights")
    public void user_clicks_on_one_way_trip_on_flights()
    {
        driver.findElement(By.xpath("(//i[@class='icon icon-right lh lh-arrow-expand'])[1]")).click();
        driver.findElement(By.xpath("//div[text()='One-way']")).click();
    }
    @And("User enters from place of departure")
    public void user_enters_from_place_of_departure()
    {
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Dubai");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @And("User enters departure date")
    public void user_enters_departure_date()
    {
        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        driver.findElement(By.xpath("(//div[text()='30'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
    }
    @And("User enters to place of arrival")
    public void user_enters_to_place_of_arrival() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Frankfurt");
        Thread.sleep(2000);
    }
    @Then("User clicks on search flight")
    public void user_clicks_on_search_flight() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Search flights']")).click();
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
    }
/////////////////////////////////// Rental Car //////////////////////////////////////////////


    @When("User clicks on rental car")
    public void user_clicks_on_rental_car()
    {
        driver.findElement(By.xpath("//span[text()='Rental Car']")).click();
    }

    @When("User clicks on drop off car to different location")
    public void user_clicks_on_drop_off_car_to_different_location()
    {
        driver.findElement(By.xpath("//span[text()='Drop-off car to a different location']")).click();
    }

    @When("User enters pick up location")
    public void user_enters_pick_up_location() throws InterruptedException {
        WebElement pickup=driver.findElement(By.xpath("//input[@name='pickupLocation']"));
        pickup.sendKeys("Pune");
        driver.findElement(By.xpath("(//div[text()='Pune, Maharashtra, India'])[2]")).click();
        Thread.sleep(1000);
    }
    @When("User enters drop off location")
    public void user_enters_drop_off_location() throws InterruptedException {
        WebElement dropoff=driver.findElement(By.xpath("//input[@name='dropoffLocation']"));
        dropoff.sendKeys("Pune");
        driver.findElement(By.xpath("(//div[text()='Pune, Maharashtra, India'])[3]")).click();
        Thread.sleep(1000);
    }
    @Then("User clicks on search button")
    public void user_clicks_on_search_button()
    {
        driver.findElement(By.xpath("//button[text()='Search']")).click();
    }

    /////////////////////////////////////////////// Calculate baggage ///////////////////////////////////////////

    @And("User scrolls upto the end of page")
    public void user_scrolls_upto_the_end_of_page()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1010)", "");
    }

    @And("User clicks on Baggage section")
    public void user_clicks_on_Baggage_section() {
        driver.findElement(By.xpath("//*[@id=\"footer-list-1\"]/li[3]/a")).click();
    }

    @When("User clicks on to the calculator tab")
    public void user_clicks_on_to_the_calculator_tab()
    {
        driver.findElement(By.xpath("//span[text()='To the calculator']")).click();
    }

    @And("User enters origin")
    public void user_enters_origin()
    {
        driver.findElement(By.xpath("//input[@placeholder='Origin']")).sendKeys("Mumbai");
    }

    @And("User able to enters destination")
    public void user_able_to_enters_destination() throws InterruptedException {
        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Destination']"));
        destination.sendKeys("Frankfurt");
        Thread.sleep(2000);
    }

    @Then("User clicks on calculate button")
    public void user_clicks_on_calculate_button() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Calculate baggage']")).click();
        Thread.sleep(2000);
    }
///////////////////////////////////// Sign up ////////////////////////////////////////////////

    @And("User clicks on Register for Travel ID")
    public void userClicksOnRegisterForTravelID () {
        WebElement registerButton = driver.findElement(By.xpath("(//a[@class='travelid-link travelid-link--internal'])[2]"));
        registerButton.click();
    }

    @When("User enters new {string} address on Registration page")
    public void userEntersNewEmailAddressOnRegistrationPage (String email){
        WebElement emailField = driver.findElement(By.xpath("//input[@id='id-email-textfield']"));
        emailField.sendKeys(email);
    }

    @And("User enters new {string} on Registration page")
    public void userEntersNewPasswordOnRegistrationPage (String password){
        WebElement passwordField = driver.findElement(By.xpath("(//input[@class='travelid-form__input travelid-form__input--textfield   '])[2]"));
        passwordField.sendKeys(password);
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton () {
        WebElement continueButton = driver.findElement(By.xpath("//button[@name='createAccount_next']"));
        continueButton.click();
    }

    @And("User clicks on Activate later")
    public void userClicksOnActivateLater () throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement activateButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        activateButton.click();
        Thread.sleep(2000);
    }

    @And("User enters {string} on personal detail page")
    public void userEntersFirstnameOnPersonalDetailPage (String firstname) throws InterruptedException
    {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));

        Boolean nn =driver.findElement(By.xpath("//input[@id='id-firstName-textfield']")).isEnabled();
        if(nn) {
            System.out.println("Yes ! Element is Present");
        }
        else {
            System.out.println("NO ! Element is not Present");
        }

        // WebElement first_Name= driver.findElement(By.xpath("//*[@id=\"id-firstName-textfield\"]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(150));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id-firstName-textfield\"]")));
        driver.findElement(By.xpath("//*[@id=\"id-firstName-textfield\"]")).sendKeys(firstname);
    }



    @And("User enters {string} on the personal detail page")
    public void userEntersSurnameOnThePersonalDetailPage (String surname)
    {
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(surname);
    }

    @And("User enters other detail on personal detail page")
    public void userEntersOtherDetailOnPersonalDetailPage () throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='id-birthday-textfield']")).sendKeys("08");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='id-birthmonth-textfield']")).sendKeys("03");
        driver.findElement(By.xpath("//input[@id='id-birthyear-textfield']")).sendKeys("2003");
    }

    @And("User clicks on Continue button on personal detail page")
    public void userClicksOnContinueButtonOnPersonalDetailPage ()
    {
        WebElement continueButton = driver.findElement(By.xpath("(//span[text()='Continue'])[2]"));
        continueButton.click();
    }

    @And("User clicks on permission checkbox and confirmation button")
    public void userClicksOnPermissionCheckboxAndConfirmationButton ()
    {
        WebElement permissionBox = driver.findElement(By.xpath("//input[@id='76ec55e1c2cebacedd0dd9145426613fc1314c0bd3374f6398c2cf77f7a96ba2']"));
        permissionBox.click();
        WebElement confirmButton = driver.findElement(By.xpath("//span[text()='Confirm and continue']"));
        // confirmButton.click();
    }


}