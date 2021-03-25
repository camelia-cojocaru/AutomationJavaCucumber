package colorDj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static colorDj.Common_steps.chrome;
import static org.junit.Assert.assertNotEquals;


public class Stylist_steps {

    @When("Enter {string}")
    public void enter(String name) {
        // Write code here that turns the phrase above into concrete actions
        WebElement input = chrome.findElementCss("#input");
        input.clear();
        input.sendKeys(name);
    }



    @Given("Remove {word}")
    public void remove_stylist(String page) {
        chrome.findElementXpath("//*[text()='Remove "+page+"']").click();

    }

    @Then("Confirm remove {word}")
    public void confirm_remove_stylist(String page) throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementXpath("//*[text()='Remove "+page+"']").click();
        chrome.closeBrowser();
    }

    @Then("Confirm continue")
    public void confirmContinue() {
        chrome.findElementXpath("//*[text()='Continue']").click();
        chrome.closeBrowser();
    }
}
