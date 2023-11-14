package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
