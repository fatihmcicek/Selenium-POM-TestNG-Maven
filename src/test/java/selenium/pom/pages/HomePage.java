package selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.pom.base.BasePage;


public class HomePage extends BasePage {

    protected WebElement changeElement;

    private final By CLICK_SIGNUP_LOGIN_BUTTON = By.cssSelector("a[href='/login']");
    private final By VERIFY_USER_SIGNUP = By.cssSelector("div[class='signup-form'] h2");
    private final By NEW_USER_NAME_INPUT = By.cssSelector("input[placeholder='Name']");
    private final By NEW_USER_EMAIL_INPUT = By.cssSelector("input[data-qa='signup-email']");
    private final By CLICK_SIGNUP_BUTTON = By.cssSelector("button[data-qa='signup-button']");
    private final By VERIFY_ACCOUNT_INFORMATION = By.xpath("/html//section[@id='form']//div[@class='login-form']/h2/b[.='Enter Account Information']");

    private final By CHOOSE_TITLE = By.cssSelector("#id_gender1");
    private final By PASSWORD = By.cssSelector("#password");
    private final By DAYS = By.cssSelector("#days");
    private final By MONTHS = By.cssSelector("#months");
    private final By YEARS = By.cssSelector("#years");
    private final By CLICK_NEWSLETTER = By.cssSelector("#newsletter");

    private final By FIRST_NAME_ELEMENT = By.id("first_name");
    private final By LAST_NAME_ELEMENT = By.id("last_name");
    private final By COMPANY_ELEMENT = By.id("company");
    private final By ADDRESS_1_ELEMENT = By.id("address1");
    private final By COUNTRY_ELEMENT = By.id("country");
    private final By STATE_ELEMENT = By.id("state");
    private final By CITY_ELEMENT = By.id("city");
    private final By ZIP_CODE_ELEMENT = By.id("zipcode");
    private final By MOBILE_NUMBER_ELEMENT = By.id("mobile_number");
    private final By CONTINUE_ELEMENT = By.xpath("//button[contains(text(),'Create Account')]");

    public static String firstName = "";
    public static String lastName = "";
    public static String company = "";
    public static String address1 = "";
    public static String city = "";
    public static String state = "";
    public static String country = "";
    public static String zipcode = "";
    public static String mobile_number = "";

    private final By clickContinueBtn = By.cssSelector(".btn.btn-primary");
    private final By DELETE_ACCOUNT = By.cssSelector("a[href='/delete_account']");
    private final By VERIFY_ACCOUNT_DELETED = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private final By CONTINUE_BUTTON_ELEMENT = By.xpath("//a[contains(text(),'Continue')]");

    private final By USER_NAME_INPUT = By.cssSelector("input[data-qa='login-email']");
    private final By USER_EMAIL_INPUT = By.cssSelector("input[placeholder='Password']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage loadPage() {
        loadPage("/");
        return this;
    }

    public HomePage isOnHomePage() {
        String e = driver.getCurrentUrl();
        Assert.assertEquals(e, "https://automationexercise.com//");
        return this;
    }

    public HomePage clickSignupLoginButton() {
        clickElement(CLICK_SIGNUP_LOGIN_BUTTON);
        return this;
    }

    public HomePage verifyUserSignUp() {
        String e = driver.findElement(VERIFY_USER_SIGNUP).getText();
        Assert.assertEquals(e, "New User Signup!");
        return this;
    }


    public HomePage enterNameAndEmailAddress() throws InterruptedException {
        driver.findElement(NEW_USER_NAME_INPUT).sendKeys(faker.name().firstName());
        Thread.sleep(1500);
        driver.findElement(NEW_USER_EMAIL_INPUT).sendKeys(faker.internet().emailAddress());
        Thread.sleep(1500);
        return this;
    }

    public HomePage clickSignUpButton() {
        clickElement(CLICK_SIGNUP_BUTTON);
        return this;
    }

    public HomePage verifyAccountInformation() throws InterruptedException {
        String e = driver.findElement(VERIFY_ACCOUNT_INFORMATION).getText();
        Assert.assertEquals(e, "ENTER ACCOUNT INFORMATION");
        Thread.sleep(1500);
        return this;
    }


    public HomePage fillDetailsForm() {
        changeElement = driver.findElement(CHOOSE_TITLE);
        changeElement.click();
        sendKey(PASSWORD, faker.internet().password());
        selectElementFromDropdown(DAYS, "12");
        selectElementFromDropdown(MONTHS, "March");
        selectElementFromDropdown(YEARS, "1995");
        driver.findElement(CLICK_NEWSLETTER).click();

        firstName = faker.name().firstName();
        sendKey(FIRST_NAME_ELEMENT, firstName);

        lastName = faker.name().lastName();
        sendKey(LAST_NAME_ELEMENT, lastName);

        company = faker.name().lastName();
        sendKey(COMPANY_ELEMENT, company);

        address1 = faker.address().fullAddress();
        sendKey(ADDRESS_1_ELEMENT, address1);

        country = "United States";
        selectElementFromDropdown(COUNTRY_ELEMENT, country);

        state = faker.address().state();
        sendKey(STATE_ELEMENT, state);

        city = faker.address().city();
        sendKey(CITY_ELEMENT, city);

        zipcode = faker.address().zipCode();
        sendKey(ZIP_CODE_ELEMENT, zipcode);

        mobile_number = faker.phoneNumber().cellPhone();
        sendKey(MOBILE_NUMBER_ELEMENT, mobile_number);

        clickElement(CONTINUE_ELEMENT);
        return this;
    }

    public HomePage verifyCreatedAccount() {
        String e = driver.findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
        System.out.println(e);
        Assert.assertEquals(e, "ACCOUNT CREATED!");
        return this;
    }

    public HomePage clickContinueButton() {
        clickElement(clickContinueBtn);
        return this;
    }

    public HomePage setDeleteAccount() {
        clickElement(DELETE_ACCOUNT);
        return this;
    }

    public HomePage verifyAccountDeleted() throws InterruptedException {
        String e = driver.findElement(VERIFY_ACCOUNT_DELETED).getText();
        Assert.assertEquals(e, "ACCOUNT DELETED!");
        Thread.sleep(1000);
        clickElement(CONTINUE_BUTTON_ELEMENT);
        return this;
    }

    //--------- Test Case 2 ---------
    private final By verifyLoginYourAccount = By.cssSelector("div[class='login-form'] h2");
    private final By enterCorrectEmail = By.cssSelector("input[data-qa='login-email']");
    private final By enterCorrectPassword = By.cssSelector("input[placeholder='Password']");
    private final By clickLoginButtonElement = By.cssSelector("button[data-qa='login-button']");

    public HomePage setVerifyLoginYourAccount() {
        String e = driver.findElement(verifyLoginYourAccount).getText();
        Assert.assertEquals(e, "Login to your account");
        return this;
    }

    public HomePage enterCorrectEmailAndPassword() {
        sendKey(enterCorrectEmail, "notest123@gmail.com");
        sendKey(enterCorrectPassword, "notest123");
        return this;
    }

    public HomePage clickLoginButton() {
        clickElement(clickLoginButtonElement);
        return this;
    }

    //--------- Test Case 3 ---------
    private final By incorrectEmailAndPasswordElement = By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > p:nth-child(4)");

    public HomePage incorrectEmailAndPassword() {
        String e = driver.findElement(incorrectEmailAndPasswordElement).getText();
        Assert.assertEquals(e, "Your email or password is incorrect!");
        return this;
    }

    public HomePage enterFakeNameAndEmailAddress() throws InterruptedException {
        driver.findElement(USER_NAME_INPUT).sendKeys(faker.internet().emailAddress());
        Thread.sleep(1500);
        driver.findElement(USER_EMAIL_INPUT).sendKeys(faker.internet().emailAddress());
        Thread.sleep(1500);
        return this;
    }

    //--------- Test Case 4 ---------

    private final By CLICK_LOGOUT = By.cssSelector("a[href='/logout']");

    public HomePage clickLogout() {
        clickElement(CLICK_LOGOUT);
        return this;
    }

    //--------- Test Case 5 ---------

    private final By VERIFY_NEW_USER_SIGNUP = By.cssSelector("div[class='signup-form'] h2");
    private final By SEND_NAME = By.cssSelector("input[placeholder='Name']");
    private final By SEND_EMAIL = By.cssSelector("input[data-qa='signup-email']");
    private final By CLICK_SIGNUP_BUTTON3 = By.cssSelector("button[data-qa='signup-button']");
    private final By ALREADY_EXIST = By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > form:nth-child(2) > p:nth-child(5)");
}
