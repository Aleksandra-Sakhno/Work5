
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.testng.annotations.*;
import tests4.mavenproject44.BaseTest;
import tests4.mavenproject44.pages.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import tests4.mavenproject44.utils.logging.EventHandler;


public class NewTestsNGTest {

    private ShopPage shPage;
    private EventFiringWebDriver driver;


    @Test
    public void CheckShopTest() {
        shPage = new ShopPage(driver);
        shPage.checkShopPage();
    }

    @Test
    public void CheckProductTest(){

    }

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(String br, String urlPage) {
        driver = new EventFiringWebDriver(BaseTest.getDriver(br));
        driver.register(new EventHandler());
        Reporter.setEscapeHtml(false);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlPage);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}


