
package tests4.mavenproject44.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests4.mavenproject44.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.List;


public class ShopPage {
    public final By prod = By.className("thumbnail-container");
    public final By description = By.className("product-description");
    public final By winFind = By.className("ui-autocomplete-input");
    public final By searchBtn = By.xpath("//button");
    public final By tooter = By.id("footer");
    public final By img = By.className("img-responsive");
    public final By shCart = By.className("shopping-cart");
    public final By in = By.id("_desktop_user_info");
    public final By slide = By.id("carousel");
    public final By header = By.id("header");
    public final By allProd = By.className("all-product-link");

    public final EventFiringWebDriver driver;
    private final GeneralActions act;
    By elements[] ={winFind, searchBtn, tooter, img, shCart, in, slide, header, allProd};

    public ShopPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.act = new GeneralActions(driver);

    }

    public void checkShopPage() {
//        System.out.println(driver.manage().window().getSize());
//
//        List<WebElement> products = driver.findElements(description);
//        for (WebElement elem : products) {
//            System.out.println(elem.getLocation().getX());
//            System.out.println(elem.getLocation().getY());
//            System.out.println();
//        }
        act.egualsSize(prod);
        act.egualsSize(description);
        act.positionElem(prod);
        act.positionElem(description);
        for (By el:elements){
        Assert.assertTrue(driver.findElement(el).isDisplayed());}


            }
        }

