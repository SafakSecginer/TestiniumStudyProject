import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By shoppingBagLocator = By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']");
    By basketProductRemoveLocator = By.xpath("//div[@class='header__basketProductBtn header__basketModal -remove']");
    By confirmRemovingLocator = By.xpath("//button[@class='btn -black o-removeCartModal__button']");
    By productsInTheBagCountLocator = By.xpath("//a[@class='header__basketMobile']");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public Boolean isOnHomePage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        if (driver.getCurrentUrl().equals("https://www.network.com.tr/"))
            return true;
        else
            return false;
    }

    public void goToMyBag() throws InterruptedException {
        find(shoppingBagLocator).click();
        Thread.sleep(1000);
        find(basketProductRemoveLocator).click();
        Thread.sleep(1000);
        find(confirmRemovingLocator).click();
    }

    public boolean isBagEmpty() {
        String count = find(productsInTheBagCountLocator).getText();

        if (count.equals(""))
            return true;
        else
            return false;

    }

}
