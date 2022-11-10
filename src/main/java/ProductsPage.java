import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends BasePage {

    By resultLocator = By.xpath("//div[@class='resultInfo']");
    By showMoreProduct = By.xpath("//button[@class='button -secondary -sm relative']");

    static Boolean showMoreProductButtonState = false;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return isDisplayed(resultLocator);
    }

    public void scrollDown() {
        scrollToElement(showMoreProduct);
    }

    public void getAllProducts() {
        scrollDown();
        click(showMoreProduct);
        showMoreProductButtonState = true;
    }

    public Boolean isShowMoreButtonClicked() {
        return showMoreProductButtonState;
    }

}
