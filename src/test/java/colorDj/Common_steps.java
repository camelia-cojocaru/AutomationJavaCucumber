package colorDj;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Common_steps {
    String salonId="LO27BE9P";
    public static ChromeBrowser chrome;
    String addStylistUrl="https://d35c5nyi9oqz24.cloudfront.net/stylists-management/add-stylist";
    String editStylistUrl="https://d35c5nyi9oqz24.cloudfront.net/stylists-management/edit-stylist";
    String addClientUrl = "https://d35c5nyi9oqz24.cloudfront.net/clients";
    //String editClientUrl="";

    @Given("Open Chrome and launch the application")
    public void open_Chrome_and_launch_the_application() {
        chrome= new ChromeBrowser();
    }
    @When("Activate ColorDj Device")
    public void enter_SalonID(){
        WebElement SalonId = chrome.findElementCss("#Salon\\ id");
        WebElement btnLogIn = chrome.findElementCss("#root > div > div.middle > div > div.action > button");
        SalonId.sendKeys(salonId);
        btnLogIn.click();

    }
    @When("Wait for Offline cache")
    public void wait_for_Offline_cache() throws InterruptedException {
        Thread.sleep(10000);
    }
    @Then("Redirect to {string} page")
    public void redirect_to_Select_stylist_page(String page){
        assertEquals(chrome.findElementXpath("//*[text()='"+page+"']").getText(),page);
    }
    @Given("Click {string}")
    public void select_stylist(String name) throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementXpath("//*[text()='"+name+"']").click();
    }
    @Given("User selects {string}")
    public void user_selects(String button) throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementXpath("//*[text()='"+button+"']").click();
    }
    @When("Go to Add New page")
    public void go_to_Add_new_page() throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementClass("navbar__add-button").click();
    }
    @Then("Save {word} stylist/client")
    public void save_stylist(String word) throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementXpath("//*[text()='Save']").click();
        Thread.sleep(2000);
        assertNotEquals(chrome.getActualUrl(),addStylistUrl);
        assertNotEquals(chrome.getActualUrl(),editStylistUrl);
        assertNotEquals(chrome.getActualUrl(),addClientUrl);
        if(word.equals("new")){chrome.closeBrowser(); }
    }


}
