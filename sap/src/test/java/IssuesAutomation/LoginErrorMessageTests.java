package IssuesAutomation;
import coreUtils.CoreConstants;
import ioServices.FileServices;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.List;

public class LoginErrorMessageTests extends SapBaseClass {
    private WebDriver driver;
    private SAPPanelPageObject sapPanelPageObject;
    private FileServices fileServices;
    private List<List<String >> csvData;

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
        fileServices = new FileServices();
        csvData = fileServices.readCSVFile(SapFileUtils.loginErrorMsgData);
        System.out.println(csvData.toString());
    }

    @BeforeMethod(alwaysRun = true)
    public void loginErrorMsgBeforeMethod()
    {
        System.out.println("/**************************************************/");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verify User Error Msg Functionality",
            priority = 1
    )
    public void verifyUserErrorMsgFunctionality()
    {
        System.out.println("Verifying User Error Msg Functionality");
        System.out.println(csvData.get(1).get(2));
        sapPanelPageObject.enterPhoneNumberInput(csvData.get(1).get(2));
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message : " + alertMsg);
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertMsg,"Sorry! this phone number is not registered. So please register first.");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verify Otp Error Msg Functionality",
            priority = 2
    )
    public void verifyOtpErrorMsgFunctionality()
    {
        System.out.println("Verifying Otp Error Msg Functionality");
        System.out.println(csvData.get(2).get(2));
        sapPanelPageObject.enterPhoneNumberInput(csvData.get(2).get(2));
        System.out.println(csvData.get(2).get(3));
        sapPanelPageObject.enterOtpInput(csvData.get(2).get(3));
        sapPanelPageObject.clickLoginButton();
        String errorMsg = sapPanelPageObject.getLoginErrorMsg();
        sapPanelPageObject.clickCloseButton();
        System.out.println("Error Msg : " + errorMsg);
        Assert.assertEquals(errorMsg,"Your provided code is either invalid or expired!");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verify Authentication With Valid Credentials",
            priority = 3
    )
    public void verifyAuthenticationWithValidCredentials()
    {
        System.out.println("Verify Authentication is called");
        System.out.println(csvData.get(3).get(2));
        sapPanelPageObject.enterPhoneNumberInput(csvData.get(3).get(2));
        System.out.println(csvData.get(3).get(3));
        sapPanelPageObject.enterOtpInput(csvData.get(3).get(3));
        sapPanelPageObject.clickLoginButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        Assert.assertEquals(url,"https://sap.shopups1.xyz/dashboard");
    }

    @AfterSuite(alwaysRun = true)
    public void loginErrorMsgTestsAfterSuite()
    {
        quitBaseDriver();
    }
}