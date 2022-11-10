import Model.ProductModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By productPriceLocator = By.xpath("//span[@class='cartItem__price -sale']");
    By productOldPriceLocator = By.xpath("//span[@class='cartItem__price -old -labelPrice']");
    By continueButtonLocator = By.xpath("//button[@class='continueButton n-button large block text-center -primary']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isPriceEqual(ProductModel pm) {

        System.out.println("From Products Page: " + pm.getPrice());
        System.out.println("From Cart Page: " + find(productPriceLocator).getText());

        if (pm.getPrice().equals(find(productPriceLocator).getText()))
            return true;
        else
            return false;
    }

    public Boolean compareOldAndLastPrices() {

        String price = find(productPriceLocator).getText().split(" ")[0];
        price = price.replaceAll("\\.","");
        price = price.replaceAll("\\,", "");

        String oldPrice = find(productOldPriceLocator).getText().split(" ")[0];
        oldPrice = oldPrice.replaceAll("\\.", "");
        oldPrice = oldPrice.replaceAll("\\,", "");

        System.out.println("PRICE: " + price);
        System.out.println("OLD PRICE: " + oldPrice);

        int priceInt = Integer.parseInt(price);
        int oldPriceInt = Integer.parseInt(oldPrice);

        if (oldPriceInt > priceInt) {
            return true;
        }
        else {
            return false;
        }

    }

    public void goToSignInScreen() {
        find(continueButtonLocator).click();
    }
}
