package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;

import java.util.Random;

public class OrderDetailsPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    private Random random;


    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='navback']")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='headerTitle']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Edit Details']")
    private WebElement editDetailsButton;

    @FindBy(xpath = "//div[text()='My Income Calculations']//parent::div//parent::div//parent::div/div[text()='Total Product Value']//parent::div//following-sibling::div")
    private WebElement totalProductValue;

    @FindBy(xpath = "//div[text()='Edit']")
    private WebElement editTotalCostButton;

    @FindBy(xpath = "//div[text()='Total Cost of Product (s)']//parent::div//parent::div//parent::div//input")
    private WebElement editTotalCostInput;

    @FindBy(xpath = "//div[text()='Total Cost of Product (s)']//parent::div//parent::div//parent::div/div[4]")
    private WebElement saveTotalCostButton;

    public OrderDetailsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
        random = new Random();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickOnEditDetailsButton(){storeWapActions.action_click(editDetailsButton);}

    public void clickOnEditTotalCostButton(){storeWapActions.action_click(editTotalCostButton);}

    public void clickOnSaveTotalCostButton(){storeWapActions.action_click(saveTotalCostButton);}

    public void enterTotalCost(String cost){storeWapActions.action_sendKeys(editTotalCostInput,cost);}


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getPageTitle(){return storeWapActions.action_getText(pageTitle);}

    public int getTotalProductValue(){return Integer.parseInt(storeWapActions.action_getText(totalProductValue));}

}
