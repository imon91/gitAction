package pageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;




public class MyOrderDetailsPageObject extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private Random random;
    private RightNavigationDrawer rightNavigationDrawer;
    private ActionBarObjects actionBarObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private GetMyOrderApiResponse getMyOrderApiResponse;


    public MyOrderDetailsPageObject(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        actionBarObjects = new ActionBarObjects(androidDriver);
        serviceRequestLayer = new ServiceRequestLayer();
        getMyOrderApiResponse = serviceRequestLayer.getControlOverMyOrderApiResponse();
        random = new Random();
    }


    public void enterValueToSearch(String value){
        WebElement searchInputBoxElement = xpathSetter("//android.widget.EditText[@index='0']");
        myActions.action_sendKeys(searchInputBoxElement,value);
    }

    public WebElement getSearchInputBoxElement(){
        return xpathSetter("//android.widget.EditText[@index='0']");
    }

    public WebElement getSearchIconElement(){
        return xpathSetter("//android.widget.Image[@index='1']");
    }

    public WebElement getOrderIDTextElement(){
        return xpathSetter("//android.view.View[@index='3']");
    }

    public WebElement getNameTextElement(){
        return xpathSetter("//android.view.View[@index='4']");
    }

    public WebElement getFilterButtonElement(){
        return xpathSetter("//android.view.View[@index='2']/android.widget.TextView");
    }

    public WebElement getSortButtonElement(){
        return xpathSetter("//android.view.View[@index='1']/android.widget.TextView");
    }

    //1-Order ID, 2-Name
    public List<WebElement> getOrderDetails(int index){
        List<WebElement> elementList = new ArrayList<>();
        switch (index){
            case 1 :
                elementList = listOfOrderId();
                break;
            case 2 :
                elementList = listOfName();
                break;
        }
        return elementList;
    }

    public WebElement getLoadMoreButtonElement(){
        return xpathSetter("//android.widget.Button");
    }

    public String getFirstOrderID(){
        WebElement orderIDElement = xpathSetter("//android.view.View[@index='5']/android.view.View[@index='0']");
        return orderIDElement.getText();
    }

    public String getFirstOrderCustomerName(){
        WebElement nameElement = xpathSetter("//android.view.View[@index='5']/android.view.View[@index='2']");
        return nameElement.getText();
    }

    public MyOrderDetailsNewModel getMyOrderDetails(String orderId){
        return getMyOrderApiResponse.getOrderDetailOfOrder(orderId);
    }

    public void searchToOrderId(String orderId)
    {
        WebElement searchid = xpathSetter("//android.widget.EditText[@index='0']");
        myActions.action_sendKeys(searchid,orderId);
        sleep(2000);
        WebElement searchIcon = xpathSetter("//android.widget.Image[@index='1']");
        myActions.action_click(searchIcon);
    }

    public void clickOnFilterButton()
    { WebElement filterButton = xpathSetter("//android.view.View[@text='Filter']");
    myActions.action_click(filterButton);}

    public void clickOnSortButton()
    { WebElement filterButton = xpathSetter("//android.view.View[@text='Sort']");
        myActions.action_click(filterButton);}

   public void clickOnFromIcon()
   {WebElement fromIcon = xpathSetter("//android.widget.Spinner[@resource-id='from_date']");
   myActions.action_click(fromIcon);}

   public void clickOnToIcon()
   {WebElement toIcon = xpathSetter("//android.widget.Spinner[@resource-id='to_date']");
   myActions.action_click(toIcon);}

    public String getCurrentDate()
    {WebElement currentdate = idSetter("android:id/date_picker_header_date");
    String currentDate = myActions.action_getText(currentdate);
    return currentDate; }

    public String getOrderIdAfterClickingOnOrder()
    {
        WebElement orderid = xpathSetter("//android.view.View[@index='1']");
        return myActions.action_getText(orderid);
    }

    public void clickSetOption()
    {
        WebElement setOption = idSetter("android:id/button1");
    myActions.action_click(setOption);
    }
    public void clickPreviousMonthIcon()
    {
        WebElement prevOption = idSetter("android:id/prev");
        myActions.action_click(prevOption);
    }

    public void clickOnApplyFilterButton()
    {WebElement applyFilterButton = xpathSetter("//android.widget.Button[@index='4']");
    myActions.action_click(applyFilterButton);}

    public void clickOnApplySortButton()
    {WebElement applyFilterButton = xpathSetter("//android.widget.Button[@text='Apply']");
        myActions.action_click(applyFilterButton);}


    public void clickOnOrderById(String text)
    {WebElement orderid = xpathSetter("//android.view.View[@text='"+text+"']");
        myActions.action_click(orderid);}


    public void clickOnYearIcon()
    {
        WebElement year = idSetter("android:id/date_picker_header_year");
        myActions.action_click(year);

    }

    public void selectYearScrollVerticallyToElement(String yearInt) throws Exception {
        androidDriver = getBaseDriver();
        String xpath = "//android.widget.TextView[@text='"+yearInt+"']";
        WebElement element = androidDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) androidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement scrollToOrderID(String orderId)
    {
            WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"com.mokam.app:id/pager_my_orders\")).scrollIntoView("
                            + "new UiSelector().text(\""+orderId+ "\"))"));
            return element;
    }

    public MyOrderModel getResultsOfMyOrdersApi(int k)
    {
        return getMyOrderApiResponse.getOrderDetailsInActiveTab(k);
    }

    public MyOrderDetailsModel getResultsOfMyOrderDetailsApi(String orderId)
    {
        return getMyOrderApiResponse.getOrderDetailsOfOrderId(orderId);
    }

    public void findTheOrderId(String orderId)
    {
        try {
            scrollToOrderID(orderId);
        }
        catch(Exception e)
        {
            myActions.action_click(scrollToOrderID("Load More"));
            scrollToOrderID(orderId);
        }

    }

    public List<WebElement> listOfName()
    {
        List<WebElement> names = xpathListSetter("//android.view.View[@index='2']");
        return names;
    }

    public List<WebElement> listOfOrderId()
    {
        List<WebElement> names = xpathListSetter("//android.view.View[@index='0']");
        return names;
    }

    public void clickOnLoadMore()
    {
        myActions.action_click(scrollToOrderID("Load More"));
    }

    public List<String> orderPaymentContainer(int purchaseValue,int delivery,int advance,int total)
    {
        scrollAtOrderDetailPage("Customer Details");
        sleep(4000);
        List<String> paymentContainer = new ArrayList<>();
        String totalPurchaseValueTK = myActions.action_getText(xpathSetter("//android.view.View[@text='Tk "+purchaseValue+"']"));
        String totalPurchaseValue = totalPurchaseValueTK.replaceAll("[^0-9]","");
        String deliveryChargeTK =myActions.action_getText(xpathSetter("//android.view.View[@text='Tk "+delivery+"']"));
        String deliveryCharge =   deliveryChargeTK.replaceAll("[^0-9]","");
        String advancePaidTK=myActions.action_getText(xpathSetter("//android.view.View[@text='- Tk "+advance+"']"));
        String advancePaid = advancePaidTK.replaceAll("[^0-9]","");
        String totalOrderSummaryTk = myActions.action_getText(xpathSetter("//android.view.View[@text='Tk "+total+"']"));
        String totalOrderSummary=totalOrderSummaryTk.replaceAll("[^0-9]","");
        paymentContainer.add(totalPurchaseValue);
        paymentContainer.add(deliveryCharge);
        paymentContainer.add(advancePaid);
        paymentContainer.add(totalOrderSummary);
        return paymentContainer;

    }

    public List<String> addressDetailContainer(String Name,String Address)
    {
        scrollAtOrderDetailPage("Payment Method");
        sleep(2000);

        List<String> customerDetailContainerUI = new ArrayList<>();
        String name = myActions.action_getText(xpathSetter("//android.view.View[@text='"+Name+"']"));
        String address = myActions.action_getText(xpathSetter("//android.view.View[@text='"+Address+"']"));


        customerDetailContainerUI.add(name);
        customerDetailContainerUI.add(address);
        return customerDetailContainerUI;
    }
    public WebElement scrollAtOrderDetailPage(String text)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"content\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+ "\"))"));
        return element;
    }



    /////////////////Function/////////////
    ///////////////Dynamic Xpath fucntion/////////////////////


    public void applyFilterFunction(int noOfDaysFromToday) {
        clickOnFilterButton();
        sleep(2000);
        clickOnFromIcon();
        sleep(2800);
        clickSetOption();
        sleep(2000);
        int dateMentioned;
        //converting string to date
        String todayxpath = "android:id/date_picker_header_date";
        String dates = myActions.action_getText(xpathSetter(todayxpath));
        String todaysdate = dates.replaceAll("[^0-9]", "");
        int todayDate = Integer.parseInt(todaysdate);
        System.out.println("todays date was: "+todayDate);
        dateMentioned=todayDate-noOfDaysFromToday;
        System.out.println("final date was:"+dateMentioned);

        if (noOfDaysFromToday!=0&&dateMentioned>0) {
            clickOnToIcon();
            sleep(2500);
            WebElement date = xpathSetter("//android.view.View[@text='" + dateMentioned + "']");
            System.out.println("The to date was:"+dateMentioned);
            myActions.action_click(date);
            clickSetOption();
        }
        else if(dateMentioned<=0&&noOfDaysFromToday!=0)
        {
            clickOnToIcon();
            sleep(2000);
            clickPreviousMonthIcon();
            int Date = 30+dateMentioned;
            WebElement date = xpathSetter("//android.view.View[@text='" + Date + "']");
            System.out.println("The filter was from Previous Month dated"+Date);
            myActions.action_click(date);
            sleep(500);
            clickSetOption();
        }
        sleep(2000);
        clickOnApplyFilterButton();
    }


//    public class Exercise22 {
//        public  void main(String[] args)
//        {
//            LocalDate today = LocalDate.now();
//            System.out.println("\nCurrent Date: "+today);
//            System.out.println("10 days before today will be "+today.plusDays(-10));
//            System.out.println("10 days after today will be "+today.plusDays(10)+"\n");
//        }
//    }


    public void applySortFunctionality(int sortIndex)
    {
        List<WebElement> list = xpathListSetter("//android.widget.RadioButton[@index='0'][@text='Old Orders']");
        if(sortIndex!=0&&sortIndex<=list.size())
        {
            System.out.println("list size    "+list.size());
           WebElement sort1 = xpathSetter("//android.widget.RadioButton[@index='0'][@text='Old Orders']");
           myActions.action_click(sort1);
        }
        else
        {
            WebElement sort2 = xpathSetter("//android.widget.RadioButton[@index='0'][@text='Status']");
            myActions.action_click(sort2);
        }
        sleep(2000);
        clickOnApplySortButton();
        sleep(5500);
    }



}


