package tests4.mavenproject44;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class GeneralActions {
    private final WebDriver driver;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waiteFor(By locat) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locat));
        WebElement waitedElement = driver.findElement(locat);
        Assert.assertNotNull(waitedElement, "Element not found");
        return waitedElement;
    }

    public void findClick(By locat) {
        WebElement el = driver.findElement(locat);
        Assert.assertNotNull(el, "Element not found");
        el.click();
    }

    public void findClickWait(By locat1, By locat2) {
        WebElement el = driver.findElement(locat1);
        el.click();
        waiteFor(locat2);
    }

    public void findClickWaitClick(By locat1, By locat2) {
        findClick(locat1);
        WebElement waitedElement = waiteFor(locat2);
        waitedElement.click();
        Assert.assertNotNull(waitedElement, "Element not found");
    }

    public void findPrint(By locat, String keys) {
        driver.findElement(locat).sendKeys(keys);
        Assert.assertNotNull(driver.findElement(locat), "Element not found");
    }

    public void findCleanPrint(By locat, String keys) {
        WebElement el=driver.findElement(locat);
        el.sendKeys("\b\b\b\b\b\b\b\b");
        el.sendKeys(keys);
        Assert.assertNotNull(driver.findElement(locat), "Element not found");
    }


    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void egualsEls(By locat,String text) {
        WebElement element = driver.findElement(locat);
        String str = element.getText();
        Assert.assertEquals(str, text, "Element not found");
    }

    public void egualsSize(By locat){
        List<WebElement> elems= driver.findElements(locat);
        boolean sizeEq=true;
        for(int i=0; i<elems.size()-1; i++)
    {
        sizeEq=sizeEq&&(elems.get(i).getSize().getHeight()==elems.get(i+1).getSize().getHeight())
                &&(elems.get(i).getSize().getWidth()==elems.get(i+1).getSize().getWidth());
    }
        Assert.assertTrue(sizeEq, "The sizes of objects do not match");}

    public void positionElem (By locat) {
            List<WebElement> els = driver.findElements(locat);
            int i = 0;
            int j = 0;
            int m = 1;
            int n = 1;
            for (int k = 1; k < els.size(); k++) {
                if (els.get(k).getLocation().getY() == els.get(0).getLocation().getY()) {  m++; }
            }
            for (int k = 1; k < els.size(); k++) {
                if (els.get(k).getLocation().getX() == els.get(0).getLocation().getX()) { n++;}
            }
            WebElement[][] arrEl = new WebElement[n][m];
            int k = 0;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    if (k < els.size()) {
                        arrEl[i][j] = els.get(k);
                        k++;
                    }
                }
            }
            boolean allEl = true;
            for (i = 1; i < n; i++) {
                allEl = allEl && (arrEl[i].length == m);
            }
            boolean onLine = true;
            if (n > 1) {
                for (j = 0; j < m; j++) {
                    if (j <= arrEl[n - 1].length) {
                        k = n;
                    } else k = n - 1;
                    if (k > 1) {
                        for (i = 1; i < k; i++) {
                            if (arrEl[i][j] != null) {
                                onLine = onLine && (arrEl[0][j].getLocation().getX() == arrEl[i][j].getLocation().getX());
                            }
                        }
                    }
                }
            }
            Assert.assertTrue(allEl, "Element omitted");
            Assert.assertTrue(onLine, "Element off-line");
        }
}
