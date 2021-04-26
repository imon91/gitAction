package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPageObjects;
import utils.DeliveryAgentsBaseClass;

public class AuthenticationSteps extends DeliveryAgentsBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;

    @Given("I Launch Delivery Agents App")
    public void launchApp()
    {
        System.out.println("Launching Application");
//        androidDriver = getBaseDriver();
//        loginPageObjects = new LoginPageObjects();
    }

    @When("Performing Authentication")
    public void performAuthentication()
    {
        System.out.println("Performing Authentication");
//        loginPageObjects.performAuthentication("8801935019282","6666");
    }

    @Then("Verify Element Presence")
    public void verifyElementPresence()
    {
        System.out.println("Verifying Element Presence");
    }

    @And("Quit Driver")
    public void quitDriver()
    {
        System.out.println("Quiting Driver");
//        quitBaseDriver();
    }
}
