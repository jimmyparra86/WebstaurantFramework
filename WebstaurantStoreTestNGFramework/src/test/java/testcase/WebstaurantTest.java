package testcase;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.ConfigReader;

import java.util.List;

public class WebstaurantTest extends TestBase {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();

    @Test
    public void verifyE2EFunctionality() {
    //  Go to https://www.webstaurantstore.com/
        driver.get(ConfigReader.getProperty("WebstaurantURL"));
        String homePageActualTitle = driver.getTitle();
        Assert.assertEquals(homePageActualTitle,homePage.expectedHomePageTitle);

    //  Search for 'stainless work table'
        String searchValue = "stainless work table";
        homePage.searchBox.sendKeys(searchValue+ Keys.ENTER);

    //  Check the search result ensuring every product has the word 'Table' in its title.
        for (WebElement n: searchPage.itemsNamesList) {
            Assert.assertTrue(n.getText().toLowerCase().contains("table"));
        }
        int lastItemIndex = searchPage.itemsNamesList.size()-1;
        String lastItemName = searchPage.itemsNamesList.get(lastItemIndex).getText();

    // Add the last of found items to Cart
        int lastButtonIndex = searchPage.addToCartButtonList.size()-1;
        searchPage.addToCartButtonList.get(lastButtonIndex).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.viewCartButton));
        searchPage.viewCartButton.click();

        Assert.assertEquals(cartPage.addedItem.getText(),lastItemName);

    // Empty Cart
        String cartPageActualTitle = driver.getTitle();
        Assert.assertEquals(cartPageActualTitle,cartPage.expectedCartPageTitle);
        cartPage.emptyCartButton.click();
        Assert.assertEquals(cartPage.emptyCartPopUpTitle.getText(),"Empty Cart");
        cartPage.emptyCartPopUpButton.click();
        Assert.assertEquals(cartPage.cartEmptyConfirmation.getText(),"Your cart is empty.");















    }
}
