package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class ActionBarObjects {

    private WebDriver driver;
    private MyActions myActions;

    public ActionBarObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }


    // HamburgerMenu Icon
    @FindBy(id = "com.shopup.reseller:id/side_menu_button")
    private WebElement hamburgerMenuIcon;

    // ShopUp Logo
    @FindBy(id = "com.shopup.reseller:id/app_icon_container")
    private WebElement shopUpAppIcon;

    // Search Icon
    @FindBy(className = "android.widget.ImageButton[1]")
    private WebElement searchImageButton;

    // Bag Icon
    @FindBy(className = "android.widget.ImageButton[2]")
    private WebElement bagImageButton;

    // UserProfile Icon
    @FindBy(className = "android.widget.ImageButton[3]")
    private WebElement userProfileImageButton;



    public void clickOnHamburgerMenuIcon(){
        myActions.action_click(hamburgerMenuIcon);
    }

    public void clickOnShopUpAppIcon(){
        myActions.action_click(shopUpAppIcon);
    }

    public void clickOnSearchImageButton(){
        myActions.action_click(searchImageButton);
    }

    public void clickOnBagImageButton(){
        myActions.action_click(bagImageButton);
    }

    public void clickOnUserProfileImageButton(){
        myActions.action_click(userProfileImageButton);
    }
}
