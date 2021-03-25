package colorDj;

import org.openqa.selenium.*;

public class ChromeBrowser {
    public static WebDriver driver;
    String chromePath ="C:\\\\selenium-3.141.59\\\\chromedriver.exe";
    String url ="https://d35c5nyi9oqz24.cloudfront.net/home-page";

    public ChromeBrowser(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver= new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement findElementClass(String s){return driver.findElement(By.className(s)); }

    public WebElement findElementCss(String s){return driver.findElement(By.cssSelector(s)); }

    public WebElement findElementXpath(String s){return driver.findElement(By.xpath(s)); }

    public String getActualUrl(){ return driver.getCurrentUrl(); }

    public void closeBrowser(){driver.close();}




}
