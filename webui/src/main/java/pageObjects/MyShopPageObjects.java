package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.MyActions;

import java.util.Random;

public class MyShopPageObjects {
    private WebDriver driver;
    private MyActions myActions;



    public MyShopPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }
     /*--------------------Left corner Informations options--------*/

    //My income option
    @FindBy(xpath = "//p[text()='My Income']")
    private WebElement myincomeButton;

    //My credit option
    @FindBy(xpath = "//p[text()='My Credits']")
    private WebElement mycreditButton;

    //Personal Imformation Option
    @FindBy(xpath = "//p[text()='Personal Information']")
    private WebElement personalinformationButton;

    //My shop
    @FindBy(xpath = "//p[text()='My Shop']")
    private WebElement myshopbutton;



    public void clickOnMyincomeOption(){myActions.action_click(myincomeButton);}

    public void clickOnMycreditOPtion(){myActions.action_click(mycreditButton);}

    public void clickOnPersonalInformationOption(){myActions.action_click(personalinformationButton);}

    public void clickOnMyshopOption(){myActions.action_click(myshopbutton);}



    /*----------Add New collection tab--------------*/

    //Add new collection Icon
    @FindBy(xpath = "//div[text()='ADD NEW']")
    private WebElement addNewCollectionButton;

    //add your collection text
    @FindBy(xpath = "//input[@type='text'][@id='wl-new-clname']")
    private WebElement addYourCollectionText;

    //add button
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;



    public void clickOnAddNewCollectionButton(){myActions.action_click(addNewCollectionButton);}

    public void clickOnAddYourCollectionText(){myActions.action_click(addYourCollectionText);}

    public void clickOnAddButton(){myActions.action_click(addButton);}




    /*----------------Functions-------------------*/





}

