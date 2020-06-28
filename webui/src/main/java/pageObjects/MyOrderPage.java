package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;
import java.util.Random;

public class MyOrderPage {


    private WebDriver driver;
    private MyActions myActions;
    Random random = new Random();



    public MyOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();

    }


    //Outer class
    //Home option
    @FindBy(xpath = "//div[@class='const']/ol/li[1]")
    private WebElement homeOption;

    //MyAccount Option
    @FindBy(xpath = "//div[@class='const']/ol/li[2]")
    private WebElement myAccountOption;

    //MyOrderOption
    @FindBy(xpath = "//div[@class='const']/ol/li[3]")
    private WebElement myOrderOption;

    //Load older orders Button
    @FindBy(xpath = "//div[@class='const']/ol/div[@class='flex pull-right']/button[1]")
    private WebElement loadOlderOrderButton;

    //Load cancelled Orders Button
    @FindBy(xpath = "//div[@class='const']/ol/div[@class='flex pull-right']/button[2]")
    private WebElement loadCancelledOrderButton;

    public void clickOnHomeOption(){myActions.action_click(homeOption);}

    public void clickOnMyAccountOption(){myActions.action_click(myAccountOption);}

    public void clickOnMyOrderOption(){myActions.action_click(myOrderOption);}

    public void clickOnOlderOrderButton(){myActions.action_click(loadOlderOrderButton);}

    public void clickOnCancelledOrderButton(){myActions.action_click(loadCancelledOrderButton);}




    ////****************Dynamic Xpath Function*******************////////////

    //Get all product details

    public void orderDetails(int orderIndex)
    {
        String ordersXpath = "//div[@class='myorders-inner']";
        List<WebElement> orderList = driver.findElements(By.xpath(ordersXpath));

        if (orderIndex!=0)
        {
            //orderid
            String orderid = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']/p[1]/b/span[2]";
            WebElement orderId = driver.findElement(By.xpath(orderid));
            String OrderId=myActions.action_getText(orderId);
            //orderTotal
            String ordertotal = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']/p[1]/span[2]";
            WebElement orderTotal = driver.findElement(By.xpath(ordertotal));
            String OrderTotal=myActions.action_getText(orderTotal);
            //orderDate
            String orderdate = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']/p[1]/span[4]";
            WebElement orderDate = driver.findElement(By.xpath(orderdate));
            String OrderDate=myActions.action_getText(orderDate);
            //ordermonth
            String ordermonth = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']/p[1]/span[4]";
            WebElement orderMonth = driver.findElement(By.xpath(ordermonth));
            String OrderMonth=myActions.action_getText(orderMonth);
            System.out.println("Order Id was:"+OrderId);
            System.out.println("Order Total Amount was:"+OrderTotal);
            System.out.println("Order Date at :"+OrderDate+" "+ OrderMonth);
        }

    }


    //Get product details -which gives the details of all the products
    public void getProductDetails(int orderIndex)
    {
        int i;
        String orderXpath = "//div[@class='myorders-inner']";
        String productsXpath = orderXpath + "[" + orderIndex + "]//div[@class='list-of-order-rows']/ul";
        List<WebElement> productList = driver.findElements(By.xpath(productsXpath));
        for(i=1;i<=productList.size();i++)
        {
            String productdetail=productsXpath+"["+i+"]//div[@class='item-name-size']";
            WebElement productDetails = driver.findElement(By.xpath(productdetail));
            System.out.println(myActions.action_getText(productDetails));
        }


    }

    //Get number of product in that order
    public void getNumberOfProductsInthatOrder(int orderIndex)
    {
        if (orderIndex!=0)
        {
            String orderXpath = "//div[@class='myorders-inner']";
            String productsXpath = orderXpath + "[" + orderIndex + "]//div[@class='list-of-order-rows']/ul";
            List<WebElement> productList = driver.findElements(By.xpath(productsXpath));
            int TotalProduct = productList.size();
            System.out.println(TotalProduct);
        }
        else
        {
            String orderXpath = "//div[@class='myorders-inner']";
            List<WebElement> orderList = driver.findElements(By.xpath(orderXpath));
            int index = random.nextInt(orderList.size());
            index++;
            String productsXpath = orderXpath + "[" + index + "]//div[@class='list-of-order-rows']/ul";
            List<WebElement> productList = driver.findElements(By.xpath(productsXpath));
            int TotalProduct = productList.size();
            System.out.println(TotalProduct);
        }
    }

    //click add payment button
    public void clickOnAddPaymentButton(int orderIndex)
    {
        String ordersXpath = "//div[@class='myorders-inner']";
        List<WebElement> orderList = driver.findElements(By.xpath(ordersXpath));

        if (orderIndex!=0)
        {
            String button = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']/p[2]/button";
            WebElement addpaymentButton = driver.findElement(By.xpath(button));
            myActions.action_getText(addpaymentButton);
        }
        else
        {
            int index = random.nextInt(orderList.size());
            index++;
            String button = ordersXpath+"["+index+"]//div[@class='order-pannel-header flex justify-between']/p[2]/button";
            WebElement addpaymentButton = driver.findElement(By.xpath(button));
            myActions.action_getText(addpaymentButton);
        }
    }

    //click add payment button
    public void clickOnOrderButton(int orderIndex)
    {
        String ordersXpath = "//div[@class='myorders-inner']";
        List<WebElement> orderList = driver.findElements(By.xpath(ordersXpath));

        if (orderIndex!=0)
        {
            String button = ordersXpath+"["+orderIndex+"]//div[@class='order-pannel-header flex justify-between']//a/button";
            WebElement vieworderButton = driver.findElement(By.xpath(button));
            myActions.action_getText(vieworderButton);
        }
        else
        {
            int index = random.nextInt(orderList.size());
            String button = ordersXpath+"["+index+"]//div[@class='order-pannel-header flex justify-between']//a/button";
            WebElement vieworderButton = driver.findElement(By.xpath(button));
            myActions.action_getText(vieworderButton);
        }
    }





}
