package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;
import java.util.Random;

public class PLPPageObject {
    private WebDriver driver;
    private MyActions myActions;
    Random random = new Random();

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

    //sizeL
    @FindBy(xpath = "//div[@class='filter-inner']/div[5]//ul/li[4]//label")
    private WebElement filterSizeL;

    //searchButton from action bar
    @FindBy(xpath = "//i[text()='search']")
    private WebElement searchIcon;



    public void clickOnMenShirt() {
        myActions.action_click(menShirt);
    }

    public void clickOnPrice() {
        myActions.action_click(price500to1500);
    }

    public void clickOnSizeL() {
        myActions.action_click(filterSizeL);
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


       /////////////////////////*************Dynamic Xpath functions****************///////////
    /*----------Filter functionality -------*/

    public String ApplyFilter(int filterType,int filterIndex){
        String filterItemLabelClicked = "";
        String filterInnerXpath = "//div[@class='filter-inner']/div[@class='filter-main']["+filterType+"]//ul/li";
        List<WebElement> filterItemList = driver.findElements(By.xpath(filterInnerXpath));
        if((filterIndex!=0)&&(filterIndex<=filterItemList.size()))
        {
            String  item = filterInnerXpath+"["+filterIndex+"]//input";
            WebElement itemClicked = driver.findElement(By.xpath(item));
            myActions.action_click(itemClicked);
            String itemLable = filterInnerXpath+"["+filterIndex+"]//label/span[1]";
            WebElement filterItemLabel = driver.findElement(By.xpath(itemLable));
            filterItemLabelClicked = myActions.action_getText(filterItemLabel);
        }
        else{
            int index =  random.nextInt(filterItemList.size());
            index++;
            String item = filterInnerXpath+"["+index+"]//input";
            WebElement itemClicked = driver.findElement(By.xpath(item));
            myActions.action_click(itemClicked);
            String itemLabel = filterInnerXpath+"["+index+"]//label/span[1]";
            WebElement filterItemLabel = driver.findElement(By.xpath(itemLabel));
            filterItemLabelClicked = myActions.action_getText(filterItemLabel);
        }

        return filterItemLabelClicked;
    }



    /*--------------------product Selection---------------*/

    public String product(int productNumber){
        String productNameClicked = "";
        String productsXpath = "//ul[@class='col-4 grid-list list-inline text-left']/li";
        List<WebElement> productList = driver.findElements(By.xpath(productsXpath));
        if((productNumber!=0)&&(productNumber<=productList.size()))
        {
            String  product = productsXpath+"["+productNumber+"]";
            WebElement productClicked = driver.findElement(By.xpath(product));
            myActions.action_click(productClicked);
            String productLable = productsXpath+"["+productNumber+"]//div[@class='item-name']";
            WebElement clickedProductName = driver.findElement(By.xpath(productLable));
            productNameClicked = myActions.action_getText(clickedProductName);
        }
        else{
            int index =  random.nextInt(productList.size());
            index++;
            String product = productsXpath+"["+index+"]";
            WebElement productClicked = driver.findElement(By.xpath(product));
            myActions.action_click(productClicked);
            String productName = productsXpath+"["+index+"]//div[@class='item-name']";
            WebElement clickedProductName = driver.findElement(By.xpath(productName));
            productNameClicked = myActions.action_getText(clickedProductName);
        }

        return productNameClicked;
    }

    /*--------------------------sort function--------------------*/


    public String applySort(int sortNumber)
    {
        String sortLabelClicked = "";
        String sortInnerXpath = "//div[@class='flex-end sort-texts mrvoonik-sort-texts']/p[1]/span";
        List<WebElement> sortList = driver.findElements(By.xpath(sortInnerXpath));
        if (sortNumber!=0&&sortNumber<=sortList.size())
        {
            String sort = sortInnerXpath+"["+sortNumber+"]";
            WebElement sortnumber = driver.findElement(By.xpath(sort));
            sortLabelClicked=myActions.action_getText(sortnumber);
            myActions.action_click(sortnumber);
        }
        else
        {
            int index = random.nextInt(sortList.size());
            index++;
            String sort = sortInnerXpath+"["+index+"]";
            WebElement sortnumber = driver.findElement(By.xpath(sort));
            sortLabelClicked=myActions.action_getText(sortnumber);
            myActions.action_click(sortnumber);
        }
        return sortLabelClicked;
    }

    public String applyPriceSort(int sortNumber)
    {
        String priceLabelClicked = "";
        String price;
        String priceInnerXpath = "//div[@class='flex-end sort-texts mrvoonik-sort-texts']/p[2]/span";
        List<WebElement> priceList = driver.findElements(By.xpath(priceInnerXpath));
        if (sortNumber!=0&&sortNumber<=priceList.size())
        {
            price = priceInnerXpath+"["+sortNumber+"]";
        }
        else
        {
            int index=random.nextInt(priceList.size());
             price = priceInnerXpath+"["+ ++index +"]";
        }
        WebElement pricenumber = driver.findElement(By.xpath(price));
        priceLabelClicked=myActions.action_getText(pricenumber);
        myActions.action_click(pricenumber);
        return priceLabelClicked;
    }


    public String applyShow(int showNumber)
    {
        String showLabelClicked="";
        String showXpath= "//div[@id='catalog-view']/button";
        List<WebElement> showList= driver.findElements(By.xpath(showXpath));
        if (showNumber!=0&&showNumber<=showList.size())
        {
            String show=showXpath+"["+showNumber+"]";
            WebElement shownumber= driver.findElement(By.xpath(show));
            showLabelClicked=myActions.action_getText(shownumber);
            myActions.action_click(shownumber);
        }
        else
        {
            int index = random.nextInt(showList.size());
            index++;
            String show=showXpath+"["+index+"]";
            WebElement shownumber= driver.findElement(By.xpath(show));
            showLabelClicked=myActions.action_getText(shownumber);
            myActions.action_click(shownumber);
        }
        return showLabelClicked;
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
