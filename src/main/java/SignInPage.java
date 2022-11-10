import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SignInPage extends BasePage{

    By inputEmailLocator = By.xpath("//input[@class='input js-trim']");
    By inputPasswordLocator = By.xpath("//input[@class='input']");
    By goToHomePageLogoLocator = By.className("headerCheckout__logo__img");

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public void fillTheInputs() throws FileNotFoundException, InterruptedException {

        Scanner sc = new Scanner(new File("src/main/resources/user_account.csv"));
        sc.useDelimiter(";");

        int count = 0;

        while(sc.hasNext()) {

            if (count % 2 == 0) {
                find(inputEmailLocator).sendKeys(sc.next());
                count++;
            } else if (count % 2 == 1) {
                find(inputPasswordLocator).sendKeys(sc.next());
                count++;
            }

        }
        sc.close();
    }

    public void goToHomePage() {
        find(goToHomePageLogoLocator).click();
    }
}
