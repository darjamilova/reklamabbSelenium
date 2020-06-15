package seleniumsupport;


import org.openqa.selenium.WebDriver;

public abstract class SeleniumBaseClass {
    protected WebDriver driver() {
        return Controller.instance.driver;
    }

}
