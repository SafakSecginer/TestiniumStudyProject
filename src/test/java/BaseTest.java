import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver driver;

    static Logger logger;

    @BeforeAll
    public void setUp() {
        logger = Logger.getLogger(BaseTest.class);
        TestItarations.logger.info("Test has been started.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.network.com.tr/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
        logger.info("Test has been finished.");
    }

}
