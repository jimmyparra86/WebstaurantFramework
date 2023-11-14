package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage (){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[3]//a/span")
    public List<WebElement> itemsNamesList;

    @FindBy(xpath="//div/div/input[2]")
    public List<WebElement> addToCartButtonList;

    @FindBy(xpath="//a[@class='btn btn-small btn-primary']")
    public WebElement viewCartButton;

}
