package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class HomePageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //searchicon
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.customHeaderPdp___1MkCO > button")
    private WebElement SearchButton;

    //Entering the object
    @FindBy(css = "#searchTag")
    private WebElement EnterObjectToSearch;

    //searching for the object
    @FindBy(css = "#header > div.mainHeader___1D0Y8 > div.flex___1bJDE.around___2yVgM.middle___1jEMZ.searchBox___17XJm > button")
    private WebElement SearchTheObject;


    private void clickOnSearchButton(){myActions.action_click(SearchButton);}

    private void enterTheObject(String object){myActions.action_sendKeys(EnterObjectToSearch,object);}

    private void searchTheObject(){myActions.action_click(SearchTheObject);}

    /*-------Functions---------*/

    public void searchForObject(String object){
        clickOnSearchButton();
        enterTheObject(object);
        searchTheObject();
    }

}