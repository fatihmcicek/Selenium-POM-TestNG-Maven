package selenium.pom.base;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker = new Faker();


    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.driver = driver;
    }

    public void loadPage(String endPoint) {
        driver.get("https://automationexercise.com/" + endPoint);
    }

    public void sendKey(By key, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).sendKeys(text);
    }

    public void selectElementFromDropdown(By key, String element) {
        WebElement product = driver.findElement(key);
        Select slc = new Select(product);
        slc.selectByVisibleText(element);
    }

    public void clickElement(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(key)).click();
    }

}
