package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class HomePageObjects {

    private WebDriver driver;
    private MyActions myActions;

    public HomePageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }


    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
