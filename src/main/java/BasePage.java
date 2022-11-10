import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void submit(By locator) {
        find(locator).submit();
    }

    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void scrollToElement(By locator) {
        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(find(by)).build().perform();
    }

}
