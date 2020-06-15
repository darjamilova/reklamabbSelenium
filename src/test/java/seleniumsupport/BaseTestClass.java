package seleniumsupport;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseTestClass extends SeleniumBaseClass {
    @Before
    public void setUp() throws Exception {
        Controller.instance.start();
    }

    @After
    public void tearDown() {
        driver().manage().deleteAllCookies();
        Controller.instance.stop();

    }

    public WebDriver getDriver() {
        return driver();
    }

    public void maximizeWindow() {
        driver().manage().window().maximize();
    }

    public void getURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver().get(url);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!element.isDisplayed()) {
            ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(false);", element);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //redefine common driver methods according to your needs

    public List<WebElement> findElements(By locator) {
        return driver().findElements(locator);
    }

    public WebElement findElement(By locator) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println("Element by" + locator + " was not found or not clickable");
        }
        return driver().findElement(locator);
    }

    public void hoverOverElement(WebElement webElement) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver()).executeScript(javaScript, webElement);
    }

}
