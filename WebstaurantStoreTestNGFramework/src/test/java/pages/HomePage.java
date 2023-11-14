package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    WebDriver driver;

    public HomePage (){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public final String expectedHomePageTitle =
            "WebstaurantStore: Restaurant Supplies & Foodservice Equipment";

    @FindBy(id = "searchval")
    public WebElement searchBox;
}
