package IssuesAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class LoginErrorMessageTests extends SapBaseClass {

    private WebDriver driver;
    private SAPPanelPageObject sapPanelPageObject;

    private String cookie;

    @BeforeSuite(alwaysRun = true)
    public void sapBeforeSuite() throws Exception
    {
        System.out.println("Sap Before Suite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getSapBaseUrl());
        setImplicitWait(10000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void loginErrorMsgBeforeClass()
    {
        sapPanelPageObject = new SAPPanelPageObject(driver);
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verify User Error Msg",
            priority = 1
    )
    public void verifyUserErrorMsg()
    {
        System.out.println("verify user Error Msg is called");
        sapPanelPageObject.enterPhoneNumberInput("01401122001");
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message : " + alertMsg);
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertMsg,"Error Occurred to send OTP");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verify Otp Error Msg",
            priority = 2
    )
    public void verifyOtpErrorMsg()
    {
        System.out.println("verify Otp Error Msg is called");
        sapPanelPageObject.enterPhoneNumberInput("01401122188");
        sapPanelPageObject.enterOtpInput("1234");
        sapPanelPageObject.clickLoginButton();
        String errorMsg = sapPanelPageObject.getLoginErrorMsg();
        System.out.println("Error Msg : " + errorMsg);
        Assert.assertEquals(errorMsg,"Your provided code is either invalid or expired!");
    }

    @AfterSuite(alwaysRun = true)
    public void loginErrorMsgTestsAfterSuite()
    {
        driver.quit();
    }
}
