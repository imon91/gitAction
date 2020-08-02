package pageObjects;


import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;



public class MyOrderDetailsPageObject extends WebAppBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private GetMyOrderApiResponse getMyOrderApiResponse;


    public MyOrderDetailsPageObject(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        getMyOrderApiResponse = serviceRequestLayer.getControlOverMyOrderApiResponse();
        random = new Random();
    }


    //****************************api response**********************//

    public MyOrderModel getResultsOfMyOrdersApi(int k)
    {
        return getMyOrderApiResponse.getOrderDetailsInActiveTab(k);
    }

    public MyOrderDetailsModel getResultsOfMyOrderDetailsApi(String orderId)
    {
        return getMyOrderApiResponse.getOrderDetailsOfOrderId(orderId);
    }


    //----------------container and list of elements------------------//

    public WebElement listOfOrderIdWeb(String orderId)
    {
        WebElement orderIdText = androidDriver.findElement(By.xpath("//p[text()='"+orderId+"']"));
        return orderIdText;
    }

    public String getOrderIdAfterClickWeb()
    {
        String orderId = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='flex___1bJDE middle___1jEMZ']/p")));
        return orderId;
    }

    public List<String> productPropertiesContainerUI(int index)
    {
        //element List
        List<String> propertiesContainer = new ArrayList<>();
        List<WebElement>  listOfNames = androidDriver.findElements(By.xpath("//div[@class='orderDetailsCards___1n74H']/div/span"));
        List<WebElement>  listOfSize = androidDriver.findElements(By.xpath("//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']/div[1]/span"));;
        List<WebElement>  listOfQuantity = androidDriver.findElements(By.xpath("//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']/div[2]/span"));
        List<WebElement>  listOfPrice= androidDriver.findElements(By.xpath("//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']/div[3]/p"));
        List<WebElement> listOfIncome = androidDriver.findElements(By.xpath("//div[@class='flex___1bJDE between___1AlI0 baseline___35KO7 body___5orBh']/div[4]/p"));
        Double income =Double.parseDouble(myActions.action_getText(listOfIncome.get(index)).replaceAll("[^0-9.]",""))/1.0;

        //container
        propertiesContainer.add(myActions.action_getText(listOfNames.get(index)));
        propertiesContainer.add(myActions.action_getText(listOfSize.get(index)));
        propertiesContainer.add(myActions.action_getText(listOfQuantity.get(index)));
        propertiesContainer.add(myActions.action_getText(listOfPrice.get(index)).replaceAll("[^0-9]",""));
        propertiesContainer.add(String.valueOf(income));
        return propertiesContainer;

    }

    public List<String> paymentContainerWebUI()
    {
        //elements
        List<String> paymentContainer = new ArrayList<>();
        List<WebElement> purchaseValue_DeliveryCharge_advancePaid= androidDriver.findElements(By.xpath("//div[@class='flex___1bJDE between___1AlI0 row___25IZ9']//p"));
        String balance = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='flex___1bJDE between___1AlI0 row___25IZ9 balance___2aFr6']/p")));
        //container
        paymentContainer.add(myActions.action_getText(purchaseValue_DeliveryCharge_advancePaid.get(0)).replaceAll("[^0-9]",""));
        paymentContainer.add(myActions.action_getText(purchaseValue_DeliveryCharge_advancePaid.get(1)).replaceAll("[^0-9]",""));
        paymentContainer.add(myActions.action_getText(purchaseValue_DeliveryCharge_advancePaid.get(2)).replaceAll("[^0-9]",""));
        paymentContainer.add(balance.replaceAll("[^0-9]",""));
        try {
            String totalIncome = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='flex___1bJDE between___1AlI0 yourTotalIncome___1RtHv android___1ypBL']/span[2]"))).replaceAll("[^0-9]", "");
            paymentContainer.add(totalIncome);
        }
        catch (Exception e) {}
        return paymentContainer;
    }

    public List<String> customerDetailsWebUI(){
        //elements
        List<String> customerContainer = new ArrayList<>();
        String name = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='flex___1bJDE between___1AlI0 row___1fbyk marginTop12___2Ay7X'][2]/p")));
        String address1 = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='address___1l3Eo']/p[1]")));
        String address2 = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='address___1l3Eo']/p[2]")));
        String mobileNo = myActions.action_getText(androidDriver.findElement(By.xpath("//button[@class='rounded___vgOiV primary___OLr69 button___3btga ripple___1U_Uk']/span")));


        //container
        customerContainer.add(name);
        customerContainer.add(address1);
        customerContainer.add(address2);
        customerContainer.add("88"+mobileNo);
        return customerContainer;

    }

    public String paymentMethod()
    {
        return myActions.action_getText(androidDriver.findElement(By.xpath("//div[@class='flex___1bJDE between___1AlI0 row___1fbyk']/p")));
    }


}


