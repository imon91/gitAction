package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class SuppliersPageObjects {
    private WebDriver driver;
    private MyActions myActions;

    public SuppliersPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    //Migrate Seller Tab
    @FindBy(xpath = "//a[text()='Migrate Seller']")
    private WebElement migrateSellerTab;

    //Migrate Seller Tab
    @FindBy(xpath = "//a[text()='Migrate Seller']")
    private WebElement suppliersListTab;

    //Sellers List Tab
    @FindBy(xpath = "//a[text()='Sellers List']")
    private WebElement sellersListTab;

    // Seller Code Entry Field
    @FindBy(xpath = "//input[@role='spinbutton']")
    private WebElement sellerCodeEntry;

    //Submit Seller Code Button
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitSellerCodeButton;



    /*--------------Actions-------------------*/
    public void clickMigrateSellerTab(){myActions.action_click(migrateSellerTab);}

    public void clickSuppliersListTab(){myActions.action_click(suppliersListTab);}

    public void clickSellersListTab(){myActions.action_click(sellersListTab);}

    public void setSellerCodeEntry(String sellerCode){myActions.action_sendKeys(sellerCodeEntry,sellerCode);}

    public void clickSubmitSellerCodeButton(){myActions.action_click(submitSellerCodeButton);}



    /*--------------Functions-------------------*/
    public void migrateSeller(String sellerCode){
        setSellerCodeEntry(sellerCode);
        clickSubmitSellerCodeButton();
    }





}

