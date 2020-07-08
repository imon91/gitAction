package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static utils.WebAppBaseClass.getBaseDriver;
import static utils.WebAppBaseClass.sleep;

public class PLPPageObjects {

        private AndroidDriver<WebElement> driver = getBaseDriver();
        private final MyActions myActions;
        private final Random random;

        public PLPPageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
            this.driver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
            myActions = new MyActions();
            random = new Random();
        }


    //list1object
    @FindBy(xpath = "//button[@class='twoview']")
    private WebElement ListOneButton;

    //list2Object
    @FindBy(xpath = "//button[@class='threeview']")
    private WebElement ListTwoButton;

    //resultofsearch
    @FindBy(xpath = "//div[@class='flex feed-item-title']/h1")
    private WebElement resultOfSearch;

    //no.of items
    @FindBy(xpath = "//div[@class='flex feed-item-title']//span[2]/span")
    private WebElement noofItems;

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
    @FindBy(xpath = "//button[@class='md-icon-button md-primary md-button md-ink-ripple']")
    private WebElement closeFiltersButton;

/*--------Actions--------*/

    public void clickToListOneProduct(){myActions.action_click(ListOneButton);}

    public void clickToListTwoProduct(){myActions.action_click(ListTwoButton);}

    public String getTheNameOfProductDisplayed(){return myActions.action_getText(resultOfSearch);}

    public String getNoOfItemsOfTheProduct(){return myActions.action_getText(noofItems);}

    public void clickOnFilterTab(){myActions.action_click(FilterTab);}

    public void clickOnSortTab(){myActions.action_click(SortTab);}

    public void clickOnFilterByCategory(){myActions.action_click(ByCategory);}

    public void clickOnFilterByPrice(){myActions.action_click(ByPrice);}

    public void clickOnFilterByDiscount(){myActions.action_click(ByDiscount);}

    public void clickOnMenShirtsCheckBox(){myActions.action_click(MenShirtsCheckbox);}

    public void clickOnMenT_ShirtsCheckBox(){myActions.action_click(MenT_ShirtsCheckbox);}

    public void clickOnDressMaterialsCheckBox(){myActions.action_click(DressMaterialsCheckbox);}

    public void clickOnSweatersCheckBox(){myActions.action_click(SweatersCheckbox);}

    public void clickOnJacketsCheckbox(){myActions.action_click(JacketsCheckbox);}

    public void clickOnKidsT_ShirtsCheckBox(){myActions.action_click(KidsT_ShirtsCheckbox);}

    public void clickOnT_ShirtsCheckBox(){myActions.action_click(T_ShirtsCheckbox);}

    public void clickOnJacketsCheckBox(){myActions.action_click(JacketsCheckbox);}

    public void clickOnMenJacketsCheckBox(){myActions.action_click(MenJacketsCheckbox);}

    public void clickOnMenWatchesCheckBox(){myActions.action_click(MenWatchesCheckbox);}

    public void clickOnBelow500TkCheckBox(){myActions.action_click(Below500TkCheckbox);}

    public void clickOn500_1000TkCheckBox(){myActions.action_click(r500_1000TkCheckbox);}

    public void clickOn1000_1500TkCheckBox(){myActions.action_click(r1000_1500TkCheckbox);}

    public void clickOn1500_2000CheckBox(){myActions.action_click(r1500_2000TkCheckbox);}

    public void clickOnAbove2000TkCheckbox(){myActions.action_click(Above2000TkCheckbox);}

    public void clickOnAbove70Checkbox(){myActions.action_click(Above70Checkbox);}

    public void clickOnAbove60CheckBox(){myActions.action_click(Above60Checkbox);}

    public void clickOnAbove50CheckBox(){myActions.action_click(Above50Checkbox);}

    public void clickOnAbove40CheckBox(){myActions.action_click(Above40Checkbox);}

    public void clickOnAbove30CheckBox(){myActions.action_click(Above30Checkbox);}

    public void clickOnAbove20CheckBox(){myActions.action_click(Above20Checkbox);}

    public void clickOnAbove10CheckBox(){myActions.action_click(Above10Checkbox);}

    public void clickOnCancelFilters(){myActions.action_click(ClearallFiltersButton);}

    public void clickOnApplyFilters(){myActions.action_click(ApplyFiltersButton);}

    public void clickOnCloseFilterTab(){myActions.action_click(closeFiltersButton);}

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


    public void filter(int a,int b){
        clickOnFilterTab();
        filterType(a);
        filterItem(b);
        sleep(2000);
        clickOnApplyFilters();
        System.out.println("filter applied");
        sleep(3000);
    }


    public void switchingcontext(){
        sleep(2000);
        // Context Switching
        Set<String> contextNames = driver.getContextHandles();
        int n = contextNames.size();
        String[] contextData = new String[n];
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


/*--------dynamicfunctions----------*/



             public String filterType(int filterTypeid) {
                 String filterType;
                 String filterTypeXpath = "//div[@class='col-md-5 col-sm-5 col-xs-5 filter-category']/ul/li";
                 List<WebElement> filterTypesList = driver.findElements(By.xpath(filterTypeXpath));
                 if (filterTypeid != 0) {
                     filterType = filterTypeXpath + "[" + filterTypeid + "]";
                 } else {
                     int id = random.nextInt(filterTypesList.size());
                     filterType = filterTypeXpath + "[" + ++id + "]";
                 }
                 String filterTypeSelected = filterType + "/button";
                 WebElement filterTypeElement = driver.findElement(By.xpath(filterTypeSelected));
                 myActions.action_click(filterTypeElement);
                 return myActions.action_getText(filterTypeElement);
             }


             public String filterItem(int filterItemid) {
                 String filterItem;
                 String filterItemXpath = "//div[@class='col-md-7 col-sm-7 col-xs-7 filter-subcat']//div[@class='tab-pane fade active in']//ul/li";
                 List<WebElement> filterItemsList = driver.findElements(By.xpath(filterItemXpath));
                 if (filterItemid != 0) {
                     filterItem = filterItemXpath + "[" + filterItemid + "]";
                 } else {
                     int id = random.nextInt(filterItemsList.size());
                     filterItem = filterItemXpath + "[" + ++id + "]";
                 }
                 String filterItemInput = filterItem + "//input";
                 String filterItemLabel = filterItem + "//label";
                 WebElement filterItemInputElement = driver.findElement(By.xpath(filterItemInput));
                 WebElement filterItemLabelElement = driver.findElement(By.xpath(filterItemLabel));
                 String filterItemLabelSelected = myActions.action_getText(filterItemLabelElement);
                 myActions.action_click(filterItemLabelElement);
                 return filterItemLabelSelected;
             }


             public void sorttype(int sortTypeid) {
                 String sortType;
                 String sortTypeXpath = "//select";
                 Select select = new Select(driver.findElement(By.xpath(sortTypeXpath)));
                 if (sortTypeid != 0) {
                     select.selectByIndex(sortTypeid);
                 } else {
                     int id = random.nextInt(8);
                     select.selectByIndex(++id);
                 }
                 //String sortTypeSelected = select.getFirstSelectedOption().getText();
                 //myActions.action_click(sortTypeElement);
                 //return sortTypeSelected;
             }


             String productXpath = "//div[@class='feed-grid-container']/ul/li";
             List<WebElement> productsList = driver.findElements(By.xpath(productXpath));

             public int chooseProductFromFeed(int feedid) {
                 String product;
                 int productid;
                 if (feedid != 0) {
                     product = productXpath + "[" + feedid + "]";
                     productid = feedid;
                 } else {
                     int id = random.nextInt(productsList.size());
                     product = productXpath + "[" + ++id + "]";
                     productid = id;
                 }
                 WebElement chooseProduct = driver.findElement(By.xpath(product));
                 myActions.action_click(chooseProduct);
                 return productid;
             }


             public String nameOfProduct(int feedid) {
                 String productName;
                 if (feedid != 0) {
                     productName = productXpath + "[" + feedid + "]/div//div[@class='productNameContainer___M7bIM']/p";
                 } else {
                     int id = random.nextInt(productsList.size());
                     productName = productXpath + "[" + ++id + "]/div//div[@class='productNameContainer___M7bIM']/p";
                 }
                 WebElement nameOfProduct = driver.findElement(By.xpath(productName));
                 String productNameSelected = myActions.action_getText(nameOfProduct);
                 return productNameSelected;
             }


             public String price(int feedid) {
                 String price;
                 if (feedid != 0) {
                     price = productXpath + "[" + feedid + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/span[1]";
                 } else {
                     int id = random.nextInt(productsList.size());
                     price = productXpath + "[" + ++id + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/span[1]";
                 }
                 WebElement priceofProduct = driver.findElement(By.xpath(price));
                 String priceOfSelectedProduct = myActions.action_getText(priceofProduct);
                 return priceOfSelectedProduct;
             }


             public String oldPrice(int feedid) {
                 String oldPrice;
                 if (feedid != 0) {
                     oldPrice = productXpath + "[" + feedid + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/del/span";
                 } else {
                     int id = random.nextInt(productsList.size());
                     oldPrice = productXpath + "[" + ++id + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/del/span";
                 }
                 WebElement oldPriceofProduct = driver.findElement(By.xpath(oldPrice));
                 String oldPriceOfSelectedProduct = myActions.action_getText(oldPriceofProduct);
                 return oldPriceOfSelectedProduct;
             }


             public String discount(int feedid) {
                 String discount;
                 if (feedid != 0) {
                     discount = productXpath + "[" + feedid + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/span[2]";
                 } else {
                     int id = random.nextInt(productsList.size());
                     discount = productXpath + "[" + ++id + "]/div//div[@class='flex___1bJDE baseline___35KO7 prices___1_OgE']/span[2]";
                 }
                 WebElement discountofProduct = driver.findElement(By.xpath(discount));
                 String discountOfSelectedProduct = myActions.action_getText(discountofProduct);
                 return discountOfSelectedProduct;
             }


             public void detailsOfProduct(int data) {
                 System.out.println(nameOfProduct(data));
                 System.out.println(price(data));
                 System.out.println(oldPrice(data));
                 System.out.println(discount(data));
             }



}
