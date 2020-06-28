package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.MyActions;

import java.util.List;

public class MyOrdersPageObjects {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public MyOrdersPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // Active Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ACTIVE ']")
    private AndroidElement activeTab;

    // Completed Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMPLETED ']")
    private AndroidElement completeTab;

    // Cancelled Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CANCELLED ']")
    private AndroidElement cancelledTab;


    public void clickOnActiveTabItem(){
        myActions.action_click(activeTab);
    }


    public void clickOnCompleteTabItem(){
        myActions.action_click(completeTab);
    }


    public void clickOnCancelledTabItem(){
        myActions.action_click(cancelledTab);
    }


    public class MyOrderSearch{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;

        public MyOrderSearch(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        // MyOrderSearch Form
        @FindBy(xpath = "//form[@class='myorderSearch']")
        private AndroidElement formMyOrderSearch;

        // SearchBar
        @FindBy(xpath = "//input[@name='term']")
        private AndroidElement myOrdersSearchBar;

        // SearchIcon
        @FindBy(xpath = "//input[@name='term']/ancestor::div[1]/following-sibling::*[name()='svg']")
        private AndroidElement myOrdersSearchIcon;

    }


    @FindBy(xpath = "//form[@id='myorderSearch']/following-sibling::div[1]/div[1]/div[1]")
    private AndroidElement sortButton;


    @FindBy(xpath = "//form[@id='myorderSearch']/following-sibling::div[1]/div[1]/div[2]")
    private AndroidElement filterButton;


    public class OrderDetails{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;
        private final String parentXpath = "//form[@id='myorderSearch']/following-sibling::div[2]/";

        public OrderDetails(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        @FindBy(xpath = parentXpath+"div[1]/span[1]")
        private AndroidElement totalProductsDeliveredLabel;

        @FindBy(xpath = parentXpath+"div[1]/span[2]")
        private AndroidElement totalProductsDeliveredCount;


        public String getTotalProductsDeliveredLabel(){
            return myActions.action_getText(totalProductsDeliveredLabel);
        }

        public String getTotalProductsDeliveredCount(){
            return myActions.action_getText(totalProductsDeliveredCount);
        }


        @FindBy(xpath = parentXpath+"div[2]/div[1]/span")
        private AndroidElement orderIdDateLabel;

        @FindBy(xpath = parentXpath+"div[2]/div[2]/span")
        private AndroidElement nameAddressLabel;



        public List<AndroidElement> getListOfOrderItems(){
            List<AndroidElement> listOfOrderItems =
                    androidDriver.findElements(By.xpath("//div[@class='column___37VPa']"));
            return listOfOrderItems;
        }


        public void clickOnOrderItemByIndex(int orderIndex){
              if(orderIndex>=getListOfOrderItems().size()){
                  System.out.println("Please Specify Valid Order Index, input is :"
                          +orderIndex+" max is : "+(getListOfOrderItems().size()-1));
              }else if(orderIndex<0) {
                  System.out.println("Please Specify Valid Order Index, input is :"
                          +orderIndex+" min is : 0");
              }else {
                  AndroidElement orderItem = getListOfOrderItems().get(orderIndex);
                  myActions.action_click(orderItem);
              }
        }


        public void clickOnRandomOrderItem(){

        }


        public void clickOnOrderItemByOrderNumber(String orderNumber){

        }


    }

}
