import Model.ProductModel;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage extends BasePage {

    By discountItemsLocator = By.xpath("//div[@class='product__discountPercent']");
    By productContentsLocator = By.xpath("//div[@class='product__content']");

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnAllProductsPage(String url) throws InterruptedException {

        Thread.sleep(500);

        String expectedUrl = driver.getCurrentUrl();

        if (url.length() < expectedUrl.length())
            return true;
        else
            return false;

    }

    public ProductModel selectFirstDiscountItem() throws InterruptedException {

        WebElement firstDiscountItem = null;
        int firstDiscountItemDiscountRate = 0;

        int itemCount = 0;

        List<WebElement> bodySizes0fProducts = new ArrayList<WebElement>();

        System.out.println("Products Size: " + findAll(productContentsLocator).size());

        System.out.println("Discount Products Size: " + findAll(discountItemsLocator).size());

        for (WebElement we : findAll(productContentsLocator)) {

            int productDiscountRate = 0;

            try{

                System.out.println("Discount Rate of the first discount item" + we.findElement(By.className("product__prices")).findElement(By.className("product__discountPercent")).getText());

                productDiscountRate = Integer.parseInt(we.findElement(By.className("product__discountPercent")).getText().substring(1));

                //System.out.println(productDiscountRate);

                if (itemCount == 0 && productDiscountRate > 0) {

                    firstDiscountItem = we;
                    firstDiscountItemDiscountRate = productDiscountRate;
                    Actions hoverFirstDiscountItem = new Actions(driver);
                    hoverFirstDiscountItem.moveToElement(we).build().perform();
                    bodySizes0fProducts = driver.findElements(By.xpath("//label[@class='radio-box__label']"));
                    System.out.println("Size of the first discount item: " + bodySizes0fProducts.get(0).getText());
                }

                itemCount++;

            } catch (NoSuchElementException e) {
                productDiscountRate = 0;
                //System.out.println(productDiscountRate);
            }

        }
        System.out.println("First Discount Item Rate: " + firstDiscountItem.findElement(By.className("product__discountPercent")).getText());

        System.out.println(firstDiscountItem.getText());

        bodySizes0fProducts.get(0).click();

        System.out.println("SELECTED PRODUCT TITLE: " + firstDiscountItem.findElement(By.className("product__title")).getText());
        System.out.println("SELECTED PRODUCT BODY SIZE: " + bodySizes0fProducts.get(0).getText());
        System.out.println("SELECTED PRODUCT PRICE: " + firstDiscountItem.findElement(By.xpath("//span[@class='product__price -actual']")).getText());
        //System.out.println(firstDiscountItem.findElement(By.xpath("//span[@class='product__price -label -old -size']")).getText());
        //System.out.println(firstDiscountItem.findElement(By.xpath("//span[@class='product__price -label -old']")).getText());

        ProductModel selectedProduct = new ProductModel(
                firstDiscountItem.findElement(By.className("product__title")).getText(),
                firstDiscountItem.findElement(By.xpath("//span[@class='product__price -actual']")).getText(),
                firstDiscountItem.findElement(By.className("product__discountPercent")).getText(),
                bodySizes0fProducts.get(0).getText()
        );

        Thread.sleep(500);

        By goToCartButtonLocator = By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']");

        find(goToCartButtonLocator).click();

        return selectedProduct;

    }

}
