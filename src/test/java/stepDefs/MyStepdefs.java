package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    @Given("^We have opened the web page$")
    public void weHaveOpenedTheWebPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Daff\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("^We enter any category and open first add$")
    public void weEnterAnyCategoryAndOpenFirstAdd() {
    }

    @Then("^There is a button$")
    public void thereIsAButton() {
    }

    @And("^It is clickable$")
    public void itIsClickable()  {
    }

    @And("^It is visible$")
    public void itIsVisible()  {
    }
}
