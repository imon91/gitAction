package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class PLPPageObject {
    private WebDriver driver;
    private MyActions myActions;

    public PLPPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    //category
    @FindBy(xpath = "//label[@for='offer_1118']")
    private WebElement menShirt;

    //price
    @FindBy(xpath = "//label[@for='offer_34']")
    private WebElement price500to1500;

    //discount
    @FindBy(xpath = "//label[@for='offer_1048']")
    private WebElement discount10andAbove;

    //searchButton from action bar
    @FindBy(xpath = "//i[text()='search']")
    private WebElement searchIcon;



    public void clickOnMenShirt() {
        myActions.action_click(menShirt);
    }

    public void clickOnPrice() {
        myActions.action_click(price500to1500);
    }

    public void clickOnDiscount() {
        myActions.action_click(discount10andAbove);
    }

    public void clickOnSearchIcon() {
        myActions.action_click(searchIcon);
    }

    /*--------Click On Product------*/

    //productNo1
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][1]")
    private WebElement productNo1;

    //productNo2
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][2]")
    private WebElement productNo2;

    //productNo3
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][3]")
    private WebElement productNo3;

    //productNo4
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][4]")
    private WebElement productNo4;

    //productNo5
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][5]")
    private WebElement productNo5;

    //productNo6
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][6]")
    private WebElement productNo6;

    //productNo7
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][7]")
    private WebElement productNo7;

    //productNo8
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][8]")
    private WebElement productNo8;

    //productNo9
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][9]")
    private WebElement productNo9;

    //productNo10
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][10]")
    private WebElement productNo10;

    //productNo11
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][11]")
    private WebElement productNo11;

    //productNo12
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][12]")
    private WebElement productNo12;

    //productNo13
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][13]")
    private WebElement productNo13;

    //productNo14
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][14]")
    private WebElement productNo14;

    //productNo15
    @FindBy(xpath = "//li[@class='col-xs-4 col-sm-4'][15]")
    private WebElement productNo15;

    //productName-2
    @FindBy(xpath = "//ul[@class='col-4 grid-list list-inline text-left']/li[2]/div/div/div/div[1]")
    private WebElement productname2;

    //productName-3
    @FindBy(xpath = "//ul[@class='col-4 grid-list list-inline text-left']/li[3]/div/div/div/div[1]")
    private WebElement productname3;



    public void clickOnProduct1() {
        myActions.action_click(productNo1);
    }

    public void clickOnProduct2() {
        myActions.action_click(productNo2);
    }

    public void clickOnProduct3() {
        myActions.action_click(productNo3);
    }

    public void clickOnProduct4() {
        myActions.action_click(productNo4);
    }

    public void clickOnProduct5() {
        myActions.action_click(productNo5);
    }

    public void clickOnProduct6() {
        myActions.action_click(productNo6);
    }

    public void clickOnProduct7() {
        myActions.action_click(productNo7);
    }

    public void clickOnProduct8() {
        myActions.action_click(productNo8);
    }

    public void clickOnProduct9() {
        myActions.action_click(productNo9);
    }

    public void clickOnProduct10() {
        myActions.action_click(productNo10);
    }

    public void clickOnProduct11() {
        myActions.action_click(productNo11);
    }

    public void clickOnProduct12() {
        myActions.action_click(productNo12);
    }

    public void clickOnProduct13() {
        myActions.action_click(productNo13);
    }

    public void clickOnProduct14() {
        myActions.action_click(productNo14);
    }

    public void clickOnProduct15() {
        myActions.action_click(productNo15);
    }

    public String productName2() {
        String ProductName=myActions.action_getText(productname2);
        return ProductName ;
    }
    public String productName3() {
        String ProductName=myActions.action_getText(productname3);
        return ProductName ;
    }













    /*--------Function--------*/

   public void verifyAllProductsAreClickable() {

       clickOnProduct1();
       clickOnSearchIcon();
       clickOnProduct2();
       clickOnSearchIcon();
       clickOnProduct3();
       clickOnSearchIcon();
       clickOnProduct4();
       clickOnSearchIcon();
       clickOnProduct5();
       clickOnSearchIcon();
       clickOnProduct6();
       clickOnSearchIcon();
       clickOnProduct7();
       clickOnSearchIcon();
       clickOnProduct8();
       clickOnSearchIcon();
       clickOnProduct9();
       clickOnSearchIcon();
       clickOnProduct10();
       clickOnSearchIcon();
       clickOnProduct11();
       clickOnSearchIcon();
       clickOnProduct12();
       clickOnSearchIcon();
       clickOnProduct13();
       clickOnSearchIcon();
       clickOnProduct14();
       clickOnSearchIcon();
       clickOnProduct15();
       clickOnSearchIcon();
   }


}
