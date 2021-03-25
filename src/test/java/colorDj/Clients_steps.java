package colorDj;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static colorDj.Common_steps.chrome;
import java.util.List;

public class Clients_steps {

    public List<Client> clients;

    @And("User fills in the {string}, {string} and {string} fields")
    public void userFillsInTheAndFields(String name, String phone, String email) throws InterruptedException {
        WebElement nameInput =chrome.findElementXpath("//*[@id=\"ClientName\"]");
        WebElement phoneInput=chrome.findElementCss(".input__style.form-control");
        WebElement emailInput=chrome.findElementXpath("//*[@id=\"email\"]");
        WebElement ckbInput=chrome.findElementClass("form__input");

        phoneInput.sendKeys("07");
        //clea() did not work, so CTRL+A+DELETE
        nameInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        phoneInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        emailInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

        nameInput.sendKeys(name);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);

        if(!ckbInput.isSelected()){
            ckbInput.click();
        }

    }

    @When("Go to View client info page")
    public void goToViewClientInfoPage() throws InterruptedException {
        Thread.sleep(2000);
        chrome.findElementXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/button").click();
    }

}

