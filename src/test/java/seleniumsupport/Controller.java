package seleniumsupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;

public class Controller {
    public static Browser executionBrowser = Browser.FIREFOX;

    public enum Browser {
        FIREFOX,
        IE,
        CHROME,
    }

    public static Controller instance = new Controller();
    public WebDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch (executionBrowser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer32.exe");
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
