package seleniumsupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Controller {
    public static Browser executionBrowser = Browser.IE;

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
                DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
                cap.setCapability("nativeEvents", false);
                cap.setCapability("unexpectedAlertBehaviour", "accept");
                cap.setCapability("ignoreProtectedModeSettings", true);
                cap.setCapability("disable-popup-blocking", true);
                cap.setCapability("enablePersistentHover", true);
                cap.setCapability("ignoreZoomSetting", true);
                cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.merge(cap);
                driver = new InternetExplorerDriver(options);
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
