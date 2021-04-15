package slackBugAutomation;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;

public class downloadOptionOrderTests extends SapBaseClass {

    private WebDriver driver;
    private Random random;
    private SourcePickupPageObjects sourcePickupPageObjects;

    private int size;
    private int index;

    @BeforeClass(alwaysRun = true)
    public void downloadOptionOrderTestBeforeClass() throws Exception
    {
        System.out.println("Download Option Orders Before Class");
        driver = getBaseDriver();
        random = new Random();
        sourcePickupPageObjects = new SourcePickupPageObjects(driver);
        driver.get("https://sap.shopups1.xyz/hyperlocal/source-pickup");
        size = sourcePickupPageObjects.getParcelsSize();
        index = random.nextInt(size)+2;
    }

//    @Test(priority = 11)
    public void verifyHubFilterFunctionality()
    {
        System.out.println("Verifying Hub Filter Functionality");
        String hubName = "Kalabagan Hub";
        sourcePickupPageObjects.enterHubFilter(hubName);
        String uiValue = sourcePickupPageObjects.getAreaValue(2);
        Assert.assertEquals(uiValue,hubName);
    }

//    @Test(priority = 11)
    public void verifyAgentFilterFunctionality()
    {
        System.out.println("Verifying Agent Filter Functionality");
        String agentName = "Syed Muqsit Razee";
        String uiValue = "";
        sourcePickupPageObjects.clickResetFiltersButton();
        Assert.assertEquals(uiValue,agentName);
    }

//    @Test(priority = 11)
    public void verifyStatusFilterFunctionality()
    {
        System.out.println("Verifying Status Filter Functionality");
        String status = "";
        String uiValue = "";
        sourcePickupPageObjects.clickResetFiltersButton();
        Assert.assertEquals(uiValue,status);
    }

//    @Test(priority = 11)
    public void verifyDateFilterFunctionality()
    {
        System.out.println("Verifying Date Filter Functionality");
        String date = "";
        String uiValue = "";
        sourcePickupPageObjects.clickResetFiltersButton();
        Assert.assertEquals(uiValue,date);
    }

    @Test(priority = 11)
    public void verifyOrderIdFilterFunctionality()
    {
        System.out.println("Verifying Order Id Filter Functionality");
        String orderId = sourcePickupPageObjects.getInvoiceIdValue(index);
        System.out.println("Order Id : " + orderId);
        sourcePickupPageObjects.enterOrderIdFilter(orderId);
        String uiValue = sourcePickupPageObjects.getInvoiceIdValue(2);
        System.out.println("Ui Value : " + uiValue);
        sourcePickupPageObjects.clickResetFiltersButton();
        Assert.assertEquals(uiValue,orderId);
    }
}
