package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.List;
import java.util.Random;

public class MyOrderPageObjects extends WebAppBaseClass {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;
    private Random random;

    public MyOrderPageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        myActions = new MyActions();
        random = new Random();
    }


//selectfirstOrderId
    @FindBy(xpath = "//div[@class='column___37VPa']/p")
    private WebElement selectOrder;

//orderNo
    @FindBy(xpath = "//p[@class='thankyou_order_no']/*[2]")
    private WebElement orderno;

//navigateTohome
    @FindBy(xpath = "//a[@href='/r']/span")
    private WebElement home;

//searchOrder
    @FindBy(xpath = "//input[@class='fullWidth___3mngV inputSearch___18p3g']")
    private WebElement searchOrder;

//enterorderno
    @FindBy(xpath = "//input[@class='fullWidth___3mngV inputSearch___18p3g']")
    private WebElement EnterID;

//clickOnSearchIcon
    @FindBy(xpath = "//div[@class='flex___1bJDE search___I30gU']/*[2]")
    private WebElement searchIcon;

//sortTab
    @FindBy(xpath = "//div[@class='ripple___K-6Hk sort____ctuP']")
    private WebElement sortTab;

//recentOrders
    @FindBy(xpath = "//input[@id='recent_orders']")
    private WebElement recentOrders;

//oldOrders
   @FindBy(xpath = "//input[@id='old_orders']")
   private WebElement oldOrders;

//status
    @FindBy(xpath = "//input[@id='status']")
    private WebElement status;

//apply
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement apply;

//cancel
    @FindBy(xpath = "//button[@class='flat___n-myg flatSecondary___8V87I button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement cancel;

//closeSortBy
    @FindBy(xpath = "//div[@class='close___3yvOX']")
    private WebElement close;

//filterTab
    @FindBy(xpath = "//div[@class='ripple___K-6Hk filter___19NYL']")
    private WebElement filterTab;

//byDate
    @FindBy(xpath = "/input[@id='date']")
    private WebElement byDate;

//fromDate
    @FindBy(xpath = "//input[@id='from_date']")
    private WebElement fromDate;

//toDate
    @FindBy(xpath = "//input[@id='to_date']")
    private WebElement toDate;

//byStatus
    @FindBy(xpath = "//input[@id='status']")
    private WebElement byStatus;

//confirmed
    @FindBy(xpath = "//input[@id='confirmed']")
    private WebElement confirmed;

//inProcess
    @FindBy(xpath = "//input[@id='in_process']")
    private WebElement inProcess;

//inTransit
    @FindBy(xpath = "//input[@id='in_transit']")
    private WebElement inTransit;

//delivered
    @FindBy(xpath = "//input[@id='delivered']")
    private WebElement delivered;

//cancelled
    @FindBy(xpath = "//input[@id='cancelled']")
    private WebElement cancelled;

//loadMore
    @FindBy(xpath = "//button[@class='normal___3nyjx primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement loadMore;

//totalproductsdelivered
    @FindBy(xpath = "//div[@class='flex___1bJDE between___1AlI0 middle___1jEMZ yourTotal___3AH2q']")
    private WebElement totalproductsdelivered;

//advancepayment
    @FindBy(xpath = "//button[@class='rounded___vgOiV primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement advancepayment;

    //transactionnumber
    @FindBy(xpath = "//div[@class='input___1k2OF']")
    private WebElement transactionnumber;

    //entertransactionnumber
    @FindBy(xpath = "//input[@class='input___tfjvP']")
    private WebElement entertransactionnumber;

    //submit
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW save___38niZ']")
    private WebElement submittn;

    //cancel
    @FindBy(xpath = "//button[@class='flat___n-myg flatSecondary___8V87I button___3btga ripple___1U_Uk contain___ux0BW cancel___16T_c']")
    private WebElement canceltn;

    //detailsofadvancepayment
    @FindBy(xpath = "//div[@class='flex___1bJDE center___10Hxv middle___1jEMZ info___HeH-4 info___tUK9g']")
    private WebElement detailsofpayment;

    //closedetails
    @FindBy(xpath = "//div[@class='flex___1bJDE end___ihLmU close___3-Y6W']/*")
    private WebElement closedetails;

    //purchasevalue
    @FindBy(xpath = "//div[@class='flex___1bJDE between___1AlI0 row___25IZ9'][1]//p")
    private WebElement purchasevalue;

    //deliverycharge
    @FindBy(xpath = "//div[@class='flex___1bJDE between___1AlI0 row___25IZ9'][2]//p")
    private WebElement deliverycharge;

    //advanceamount
    @FindBy(xpath = "//div[@class='flex___1bJDE between___1AlI0 row___25IZ9'][3]//p")
    private WebElement advanceamount;

    //balance
    @FindBy(xpath = "//div[@class='flex___1bJDE between___1AlI0 row___25IZ9 balance___2aFr6']//p")
    private WebElement balance;

    //income
    @FindBy(xpath = "//span[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T bold___3nNae text-flat___3AZ-6 yourTotalIncomeText___3tOk1'][2]")
    private WebElement income;

    //changeAddress
    @FindBy(xpath = "//p[@class='link___uRycB weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6 textAlign-right___yDZfS']")
    private WebElement address;

    //back
    @FindBy(xpath = "//div[@class='portlet trackingDetails___33L0H']/button")
    private WebElement back;

    //backbutton
    @FindBy(xpath = "//div[@class='productDetails___2adJN']/button")
    private WebElement backbutton;

    //reasonforcancel
    @FindBy(xpath = "//select[@name='reason']")
    private WebElement reasonforcancel;

    //cancelorder
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement cancelorder;


/*---------Actions--------*/

public void clickOnSearchOrder(){myActions.action_click(searchOrder);}

public void EnterID(String data){myActions.action_sendKeys(EnterID,data);}

public void clickOnSearchIcon(){myActions.action_click(searchIcon);}

public String getRecentOrderId(){return myActions.action_getText(selectOrder);}

public void clickOnSortTab(){myActions.action_click(sortTab);}

public void clickOnRecentOrders(){myActions.action_click(recentOrders);}

public void clickOnOldOrders(){myActions.action_click(oldOrders);}

public void clickOnStatus(){myActions.action_click(status);}

public void clickOnApply(){myActions.action_click(apply);}

public void clickOnCancel(){myActions.action_click(cancel);}

public void clickOnClose(){myActions.action_click(close);}

public void clickOnFilterTab(){myActions.action_click(filterTab);}

public void clickOnByDate(){myActions.action_click(byDate);}

public void clickOnFromDate(){myActions.action_click(fromDate);}

public void clickOnToDate(){myActions.action_click(toDate);}

public void clickOnByStatus(){myActions.action_click(byStatus);}

public void clickOnConfirmed(){myActions.action_click(confirmed);}

public void clickOnInProcess(){myActions.action_click(inProcess);}

public void clickOnInTransit(){myActions.action_click(inTransit);}

public void clickOnDelivered(){myActions.action_click(delivered);}

public void clickOnCancelled(){myActions.action_click(cancelled);}

public String getOrderNo(){return myActions.action_getText(orderno);}

public void navigationToHome(){myActions.action_click(home);}

public void clickOnLoadMore(){myActions.action_click(loadMore);}

public String getNoofProductsDelivered(){return myActions.action_getText(totalproductsdelivered);}

public void clickOnadvancepayment(){myActions.action_click(advancepayment);}

public void clickOnTransactionnumber(){myActions.action_click(transactionnumber);}

public void enterTransactionnumber(String data){myActions.action_sendKeys(entertransactionnumber,data);}

public void submittnbutton(){myActions.action_click(submittn);}

public void canceltnbutton(){myActions.action_click(canceltn);}

public void clickOndetailsonPayment(){myActions.action_click(detailsofpayment);}

public void closedetails(){myActions.action_click(closedetails);}

public void getPurchaseValue(){myActions.action_getText(purchasevalue);}

public void getdeliveryCharge(){myActions.action_getText(deliverycharge);}

public void getAdvanceAmountpaid(){myActions.action_getText(advanceamount);}

public void getBalanceAmountToBePaid(){myActions.action_getText(balance);}

public void getTotalIncome(){myActions.action_getText(income);}

public void clickOnChangeAddress(){myActions.action_click(address);}

public void clickonbackfromstatus(){myActions.action_click(back);}

public void clickonbackfromdelete(){myActions.action_click(backbutton);}

public void clickOnreasonforCancellation(){myActions.action_click(reasonforcancel);}

public void clickOnCancelOrder(){myActions.action_click(cancelorder);}


/*---------Functions---------*/



public void orderConfirmation(){
      getOrderNo();
      navigationToHome();
}

public void verifyOrder(String ID){
     clickOnSearchOrder();
     EnterID(ID);
     clickOnSearchIcon();
}

/*------dynamicfunctions---------*/





         public int clickOnOrder(int orderno){
             String ordersXpath = "//a[@class='card___30lJu']";
             List<WebElement> ordersList = driver.findElements(By.xpath(ordersXpath));
             String order;
             int choosenOrder;
             if(orderno != 0){
                 order = ordersXpath+"["+orderno+"]";
                 choosenOrder = orderno;
             }
             else{
                 int id = random.nextInt(ordersList.size());
                 order = ordersXpath+"["+ ++id +"]";
                 choosenOrder = id;
             }
             WebElement chooseOrder = driver.findElement(By.xpath(ordersXpath));
             myActions.action_click(chooseOrder);
             return choosenOrder;
         }

         public String orderid(int orderno) {
                 String ordersXpath = "//a[@class='card___30lJu']";
                 try {
                     new WebDriverWait(driver,30)
                             .until(ExpectedConditions.elementToBeClickable(By.xpath(ordersXpath)));
                     List<WebElement> ordersList = driver.findElements(By.xpath(ordersXpath));
                     String orderid;
                     if (orderno != 0) {
                         orderid = ordersXpath+"["+orderno+"]//p[@class='link___uRycB weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6']";
                     }
                     else{
                         int id = random.nextInt(ordersList.size());
                         orderid = ordersXpath+"["+ ++id +"]//p[@class='link___uRycB weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6']";
                     }
                     WebElement idofOrder = driver.findElement(By.xpath(orderid));
                     String idofSelectedorder = myActions.action_getText(idofOrder);
                     return idofSelectedorder;

                 }catch (StaleElementReferenceException e){
                     orderid(orderno);
                 }
             return null;
         }


         public String orderdate(int orderno) {
                 String ordersXpath = "//a[@class='card___30lJu']";
                 List<WebElement> ordersList = driver.findElements(By.xpath(ordersXpath));
                 String orderdate;
                 if (orderno != 0) {
                     orderdate = ordersXpath+"["+orderno+"]//div[@class='column___37VPa']//p[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6']";
                 }
                 else{
                     int id = random.nextInt(ordersList.size());
                     orderdate = ordersXpath+"["+ ++id +"]//div[@class='column___37VPa']//p[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6']";
                 }
                 WebElement dateofOrder = driver.findElement(By.xpath(orderdate));
                 String dateofSelectedorder = myActions.action_getText(dateofOrder);
                 return dateofSelectedorder;
         }


         public String name(int orderno) {
                 String ordersXpath = "//a[@class='card___30lJu']";
                 List<WebElement> ordersList = driver.findElements(By.xpath(ordersXpath));
                 String name;
                 if (orderno != 0) {
                     name = ordersXpath+"["+orderno+"]//div[@class='flex___1bJDE between___1AlI0 column___37VPa']//p[1]";
                 }
                 else{
                     int id = random.nextInt(ordersList.size());
                     name = ordersXpath+"["+ ++id +"]//div[@class='flex___1bJDE between___1AlI0 column___37VPa']//p[1]";
                 }
                 WebElement nameofcustomer = driver.findElement(By.xpath(name));
                 String customernameofSelectedorder = myActions.action_getText(nameofcustomer);
                 return customernameofSelectedorder;
         }


         public void detailsofOrder(int data){
             System.out.println(orderid(data));
             System.out.println(orderdate(data));
             System.out.println(name(data));
         }



         public String nameofproduct(int productno){
             String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
             List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
             String productname;
             if(productno != 0){
                 productname = productsXpath+"["+productno+"]//span[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6 productName___c9mQB']/font";
             }
             else{
                 int id = random.nextInt(productslist.size());
                 productname = productsXpath+"["+ ++id +"]//span[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6 productName___c9mQB']/font";
             }
             WebElement nameElement = driver.findElement(By.xpath(productname));
             String nameofproduct = myActions.action_getText(nameElement);
             return nameofproduct;
         }


    public String sizeofproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productsize;
        if(productno != 0){
            productsize = productsXpath+"["+productno+"]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//span[1]";
        }
        else{
            int id = random.nextInt(productslist.size());
            productsize = productsXpath+"["+ ++id +"]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//span[1]";
        }
        WebElement sizeElement = driver.findElement(By.xpath(productsize));
        String sizeofproduct = myActions.action_getText(sizeElement);
        return sizeofproduct;
    }

    public String quantityofproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productquantity;
        if(productno != 0){
            productquantity = productsXpath+"["+productno+"]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//span[2]";
        }
        else{
            int id = random.nextInt(productslist.size());
            productquantity = productsXpath+"["+ ++id +"]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//span[2]";
        }
        WebElement quantityElement = driver.findElement(By.xpath(productquantity));
        String quantityofproduct = myActions.action_getText(quantityElement);
        return quantityofproduct;
    }

    public String priceofproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productprice;
        if(productno != 0){
            productprice = productsXpath+"["+productno+"]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//p[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6 textAlign-right___yDZfS']/font";
        }
        else {
            int id = random.nextInt(productslist.size());
            productprice = productsXpath + "[" + ++id + "]//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']//p[@class='primary___3k9Ts weight-4___ZQvdQ text-14___yZ_9T text-flat___3AZ-6 textAlign-right___yDZfS']/font";
        }
        WebElement priceElement = driver.findElement(By.xpath(productprice));
            String priceofproduct = myActions.action_getText(priceElement);
            return priceofproduct;
         }

    public String incomefromproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productincome;
        if(productno != 0){
            productincome = productsXpath+"["+productno+"]//div[@class='sectionBig___3NAav']//p[@class='success___3Wbvy weight-4___ZQvdQ text-16___-Np8V bold___3nNae text-flat___3AZ-6 textAlign-right___yDZfS']/font";
        }
        else{
            int id = random.nextInt(productslist.size());
            productincome = productsXpath+"["+ ++id +"]//div[@class='sectionBig___3NAav']//p[@class='success___3Wbvy weight-4___ZQvdQ text-16___-Np8V bold___3nNae text-flat___3AZ-6 textAlign-right___yDZfS']/font";
        }
        WebElement incomeElement = driver.findElement(By.xpath(productincome));
        String incomeofproduct = myActions.action_getText(incomeElement);
        return incomeofproduct;
    }

    public void productdetails(int data){
             System.out.println(nameofproduct(data));
             System.out.println(sizeofproduct(data));
             System.out.println(quantityofproduct(data));
             System.out.println(priceofproduct(data));
             System.out.println(incomefromproduct(data));
    }

    public void getstatusofproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productstatus;
        if(productno != 0){
            productstatus = productsXpath+"["+productno+"]//a/*";
        }
        else{
            int id = random.nextInt(productslist.size());
            productstatus = productsXpath+"["+ ++id +"]//a/*";
        }
        WebElement statusElement = driver.findElement(By.xpath(productstatus));
        myActions.action_getText(statusElement);
    }


    public String deleteproduct(int productno){
        String productsXpath = "//div[@class='orderDetailsCards___1n74H']";
        List<WebElement> productslist = driver.findElements(By.xpath(productsXpath));
        String productname;
        if(productno != 0){
            productname = productsXpath+"["+productno+"]//div[@class='deleteActive___SWGaJ']/*";
        }
        else{
            int id = random.nextInt(productslist.size());
            productname = productsXpath+"["+ ++id +"]//div[@class='deleteActive___SWGaJ']/*";
        }
        WebElement nameElement = driver.findElement(By.xpath(productname));
        String nameofproduct = myActions.action_getText(nameElement);
        return nameofproduct;
    }


    public String selectreason(int optionid){
             String option;
             String optionXpath = "//select[@class='selectText___2iGx7']//option";
             List<WebElement> optionslist = driver.findElements(By.xpath(optionXpath));
             if(optionid != 0){
                 option = optionXpath+"["+optionid+"]/font";
             } else{
                 int id = random.nextInt(optionslist.size());
                 option = optionXpath+"["+ ++id +"]/font";
             }
             WebElement optionElement = driver.findElement(By.xpath(option));
             String reasonSelected = myActions.action_getText(optionElement);
             myActions.action_click(optionElement);
             return reasonSelected;
    }



}
