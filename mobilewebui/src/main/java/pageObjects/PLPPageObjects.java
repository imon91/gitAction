package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.Random;
import java.util.Set;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static utils.WebAppBaseClass.sleep;

public class PLPPageObjects {

        private AndroidDriver<WebElement> driver;
        private MyActions myActions;

        public PLPPageObjects(AndroidDriver<WebElement> androidDriver) {
            this.driver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
            myActions = new MyActions();
        }


    //list1object
    @FindBy(xpath = "//button[@class='twoview']")
    private WebElement ListOneButton;

    //list2Object
    @FindBy(xpath = "//button[@class='threeview']")
    private WebElement ListTwoButton;

    //sortTab
    @FindBy(xpath = "//p[contains(text(),'SORT')]")
    private WebElement SortTab;

     /*public void switchingToWebView(){
        driver.context("NATIVE_APP");

        MyActions myactions;

        //newestfirst
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='What's New']")
        private androidElement sortByNewest;



        driver.context("WEBVIEW_com.shopup.reseller");
    }*/


    //filterTab
    @FindBy(xpath = "//p[contains(text(),'FILTER')]")
    private WebElement FilterTab;

    //filterByCategory
    @FindBy(xpath = "//button[contains(text(),'category')]")
    private WebElement ByCategory;

    //fileterbyprice
    @FindBy(xpath = "//button[contains(text(),'price')]")
    private WebElement ByPrice;

    //filterbydiscount
    @FindBy(xpath = "//button[contains(text(),'discount')]")
    private WebElement ByDiscount;

    //MenShirtsCheckbox
    @FindBy(xpath = "//label[contains(text(),'Men Shirts')]")
    private WebElement MenShirtsCheckbox;

    //MenT_ShirtsCheckbox
    @FindBy(xpath = "//label[contains(text(),'Men T-Shirts')]")
    private WebElement MenT_ShirtsCheckbox;

    //Dress Materials
    @FindBy(xpath = "//label[contains(text(),'Dress Materials')]")
    private WebElement DressMaterialsCheckbox;

    //Men Sweaters & Sweatshirts
    @FindBy(xpath = "//label[contains(text(),'Men Sweaters & Sweatshirts')]")
    private WebElement SweatersCheckbox;

    //T-Shirts
    @FindBy(xpath = "//label[contains(text(),'T-Shirts')]")
    private WebElement T_ShirtsCheckbox;

    //Jackets
    @FindBy(xpath = "//label[contains(text(),'Jackets')]")
    private WebElement JacketsCheckbox;

    //Dresses
    @FindBy(xpath = "//label[contains(text(),'Dresses')]")
    private WebElement DressesCheckbox;

    //Kids T-Shirts
    @FindBy(xpath = "//label[contains(text(),'Kids T-Shirts')]")
    private WebElement KidsT_ShirtsCheckbox;

    //Men Jackets
    @FindBy(xpath = "//label[contains(text(),'Men Jackets')]")
    private WebElement MenJacketsCheckbox;

    //Men Watches
    @FindBy(xpath = "//label[contains(text(),'Men Watches')]")
    private WebElement MenWatchesCheckbox;

    //Below 500 Tk
    @FindBy(xpath = "//label[contains(text(),'Below 500 Tk')]")
    private WebElement Below500TkCheckbox;

    //500 - 1000 Tk
    @FindBy(xpath = "//label[contains(text(),'500 - 1000 Tk')]")
    private WebElement r500_1000TkCheckbox;

    //1000 - 1500 Tk
    @FindBy(xpath = "//label[contains(text(),'1000 - 1500 Tk')]")
    private WebElement r1000_1500TkCheckbox;

    //1500 - 2000 Tk
    @FindBy(xpath = "//label[contains(text(),'1500 - 2000 Tk')]")
    private WebElement r1500_2000TkCheckbox;

    //Above 2000 Tk
    @FindBy(xpath = "//label[contains(text(),'Above 2000 Tk')]")
    private WebElement Above2000TkCheckbox;

    //70+discount
    @FindBy(xpath = "//label[contains(text(),'70% and above')]")
    private WebElement Above70Checkbox;

    //60+discount
    @FindBy(xpath = "//label[contains(text(),'60% and above')]")
    private WebElement Above60Checkbox;

    //50+discount
    @FindBy(xpath = "//label[contains(text(),'50% and above')]")
    private WebElement Above50Checkbox;

    //40+discount
    @FindBy(xpath = "//label[contains(text(),'40% and above')]")
    private WebElement Above40Checkbox;

    //30+discount
    @FindBy(xpath = "//label[contains(text(),'30% and above')]")
    private WebElement Above30Checkbox;

    //20+discount
    @FindBy(xpath = "//label[contains(text(),'20% and above')]")
    private WebElement Above20Checkbox;

    //10+discount
    @FindBy(xpath = "//label[contains(text(),'10% and above')]")
    private WebElement Above10Checkbox;

    //ClearallFilters
    @FindBy(xpath = "//button[contains(text(),'clear all')]")
    private WebElement ClearallFiltersButton;

    //apply
    @FindBy(xpath = "//button[contains(text(),'apply')]")
    private WebElement ApplyFiltersButton;

    //closeFilters
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div/button/div/svg")
    private WebElement closeFiltersButton;

/*--------Actions--------*/

    public void clickToListOneProduct(){myActions.action_click(ListOneButton);};

    public void clickToListTwoProduct(){myActions.action_click(ListTwoButton);};

    public void clickOnFilterTab(){myActions.action_click(FilterTab);};

    public void clickOnSortTab(){myActions.action_click(SortTab);};

    public void clickOnFilterByCategory(){myActions.action_click(ByCategory);};

    public void clickOnFilterByPrice(){myActions.action_click(ByPrice);};

    public void clickOnFilterByDiscount(){myActions.action_click(ByDiscount);};

    public void clickOnMenShirtsCheckBox(){myActions.action_click(MenShirtsCheckbox);};

    public void clickOnMenT_ShirtsCheckBox(){myActions.action_click(MenT_ShirtsCheckbox);};

    public void clickOnDressMaterialsCheckBox(){myActions.action_click(DressMaterialsCheckbox);};

    public void clickOnSweatersCheckBox(){myActions.action_click(SweatersCheckbox);};

    public void clickOnJacketsCheckbox(){myActions.action_click(JacketsCheckbox);};

    public void clickOnKidsT_ShirtsCheckBox(){myActions.action_click(KidsT_ShirtsCheckbox);};

    public void clickOnT_ShirtsCheckBox(){myActions.action_click(T_ShirtsCheckbox);};

    public void clickOnJacketsCheckBox(){myActions.action_click(JacketsCheckbox);};

    public void clickOnMenJacketsCheckBox(){myActions.action_click(MenJacketsCheckbox);};

    public void clickOnMenWatchesCheckBox(){myActions.action_click(MenWatchesCheckbox);};

    public void clickOnBelow500TkCheckBox(){myActions.action_click(Below500TkCheckbox);};

    public void clickOn500_1000TkCheckBox(){myActions.action_click(r500_1000TkCheckbox);};

    public void clickOn1000_1500TkCheckBox(){myActions.action_click(r1000_1500TkCheckbox);};

    public void clickOn1500_2000CheckBox(){myActions.action_click(r1500_2000TkCheckbox);};

    public void clickOnAbove2000TkCheckbox(){myActions.action_click(Above2000TkCheckbox);};

    public void clickOnAbove70Checkbox(){myActions.action_click(Above70Checkbox);};

    public void clickOnAbove60CheckBox(){myActions.action_click(Above60Checkbox);};

    public void clickOnAbove50CheckBox(){myActions.action_click(Above50Checkbox);};

    public void clickOnAbove40CheckBox(){myActions.action_click(Above40Checkbox);};

    public void clickOnAbove30CheckBox(){myActions.action_click(Above30Checkbox);};

    public void clickOnAbove20CheckBox(){myActions.action_click(Above20Checkbox);};

    public void clickOnAbove10CheckBox(){myActions.action_click(Above10Checkbox);};

    public void clickOnCancelFilters(){myActions.action_click(ClearallFiltersButton);};

    public void clickOnApplyFilters(){myActions.action_click(ApplyFiltersButton);};

    public void clickOnCloseFilterTab(){myActions.action_click(closeFiltersButton);};

/*-------Functions-------*/


    public void FilteringProduct(){
        clickOnFilterTab();
        clickOnFilterByCategory();
        clickOnMenShirtsCheckBox();
        clickOnFilterByPrice();
        clickOnBelow500TkCheckBox();
        clickOnFilterByDiscount();
        clickOnAbove20CheckBox();
        clickOnApplyFilters();
    }

    public void switchingcontext(){
        sleep(2000);
        // Context Switching
        Set<String> contextNames = driver.getContextHandles();
        int n = contextNames.size();
        String contextData[] = new String[n];
        contextData = contextNames.toArray(contextData);
        for(int i=0;i<contextData.length;i++){
            System.out.println(contextData[i]);
        }
        driver.context("NATIVE_APP");
        System.out.println("context switched to native");
    }

    public void selectOneObject(){
        //driver
        //Random rand = new Random();
        //int x = rand.nextInt();
        driver.findElementByXPath("//li[@class='col-xs-6 col-sm-6'][2]").click();
    }

}
