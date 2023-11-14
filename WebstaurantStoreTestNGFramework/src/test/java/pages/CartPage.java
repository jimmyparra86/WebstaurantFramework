package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage {

    WebDriver driver;

    public CartPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public final String expectedCartPageTitle = "WebstaurantStore Cart";

    @FindBy(xpath = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//span[@class='itemDescription description overflow-visible']")
    public WebElement addedItem;

    @FindBy(id="empty-cart-title")
    public WebElement emptyCartPopUpTitle;

    @FindBy(xpath = "//footer/button[contains(text(), 'Empty')]")
    public WebElement emptyCartPopUpButton;

    @FindBy(xpath = "//p[@class='header-1']")
    public WebElement cartEmptyConfirmation;
}
