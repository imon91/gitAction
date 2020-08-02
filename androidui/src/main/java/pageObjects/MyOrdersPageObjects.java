package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;


public class MyOrdersPageObjects extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;

    public MyOrdersPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // Active Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ACTIVE ']")
    private WebElement activeTab;

    // Completed Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMPLETED ']")
    private WebElement completeTab;

    // Cancelled Tab Item
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CANCELLED ']")
    private WebElement cancelledTab;


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

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public MyOrderSearch(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        // MyOrderSearch Form
        @FindBy(xpath = "//form[@class='myorderSearch']")
        private WebElement formMyOrderSearch;

        // SearchBar
        @FindBy(xpath = "//input[@name='term']")
        private WebElement myOrdersSearchBar;

        // SearchIcon
        @FindBy(xpath = "//input[@name='term']/ancestor::div[1]/following-sibling::*[name()='svg']")
        private WebElement myOrdersSearchIcon;

    }


    @FindBy(xpath = "//form[@id='myorderSearch']/following-sibling::div[1]/div[1]/div[1]")
    private WebElement sortButton;


    @FindBy(xpath = "//form[@id='myorderSearch']/following-sibling::div[1]/div[1]/div[2]")
    private WebElement filterButton;


    public class OrderDetails{

        private AndroidDriver androidDriver;
        private MyActions myActions;
        private final String parentXpath = "//form[@id='myorderSearch']/following-sibling::div[2]/";

        public OrderDetails(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        @FindBy(xpath = parentXpath+"div[1]/span[1]")
        private WebElement totalProductsDeliveredLabel;

        @FindBy(xpath = parentXpath+"div[1]/span[2]")
        private WebElement totalProductsDeliveredCount;

        @FindBy(xpath = "//button")
        private WebElement loadMoreButton;


        public String getTotalProductsDeliveredLabel(){
            return myActions.action_getText(totalProductsDeliveredLabel);
        }

        public String getTotalProductsDeliveredCount(){
            return myActions.action_getText(totalProductsDeliveredCount);
        }


        @FindBy(xpath = parentXpath+"div[2]/div[1]/span")
        private WebElement orderIdDateLabel;

        @FindBy(xpath = parentXpath+"div[2]/div[2]/span")
        private WebElement nameAddressLabel;



        public List<WebElement> getListOfOrderItems(){
            sleep(3000);
            List<WebElement> listOfOrderItems =
                    xpathListSetter("//div[@class='column___37VPa']/p[1]");
            System.out.println("Size is : "+listOfOrderItems.size());
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
                  WebElement orderItem = getListOfOrderItems().get(orderIndex);
                  System.out.println("Clicked Order is : "+ getListOfOrderItems().get(orderIndex).getText());
                  myActions.action_click(orderItem);
              }
        }


        public void clickOnRandomOrderItem(){

        }


        public void clickOnOrderItemByOrderNumber(String orderNumber){
            int size = getListOfOrderItems().size();
            for(int i=0;i<size;i++){
            }
        }


    }

}
