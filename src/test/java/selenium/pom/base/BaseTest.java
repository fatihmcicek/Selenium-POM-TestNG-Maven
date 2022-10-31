package selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.pom.factory.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = new DriverManager().initializeDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
