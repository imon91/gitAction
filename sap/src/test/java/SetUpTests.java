import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import pageObjects.SAPPanelPageObject;
import utils.SapBaseClass;

public class SetUpTests extends SapBaseClass {

    private WebDriver driver;
    private SAPPanelPageObject sapPanelPageObject;

    @BeforeSuite(alwaysRun = true)
    public void sapBeforeSuite() throws Exception
    {
        System.out.println("Sap Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getSapBaseUrl());
        setImplicitWait(10000);
//        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
//        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
        driver.manage().window().maximize();
        sapPanelPageObject = new SAPPanelPageObject(driver);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY,CoreConstants.GROUP_SLACK_BUG},priority = 1)
    public void setUpTest()
    {
        System.out.println("Setting Up Tests");
//        sapPanelPageObject.performAuthentication("01401122188","6666");
    }

    @AfterSuite(alwaysRun = true)
    public void sapWebAfterSuite()
    {
        System.out.println("Sap Web After Suite");
        quitBaseDriver();
    }
}
