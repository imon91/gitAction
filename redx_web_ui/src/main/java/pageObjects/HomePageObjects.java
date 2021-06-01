package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HomePageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }


    /*----------Elements----------*/

    private WebElement toastMessage;

    private WebElement allPickupLocationFilter;
    private WebElement pickUpLocations;
    private List<WebElement> pickupLocationDropDownOptions;
    private WebElement startDateFilter;
    private WebElement endDateFilter;
    private WebElement nextMonthButton;
    private WebElement nextYearButton;
    private WebElement currentMonthValue;
    private WebElement currentYearValue;
    private WebElement previousMonthButton;
    private WebElement previousYearButton;
    private WebElement selectedDate;
    private WebElement dateButton;

    private WebElement redxCreditButton;
    private WebElement redxCreditValue;
    private WebElement ordersPlacedValue;
    private WebElement ordersDeliveredValue;
    private WebElement ordersInTransitValue;
    private WebElement ordersReturnedValue;
    private WebElement successfulDeliveriesValue;
    private WebElement ordersToBeReturnedValue;
    private WebElement totalSalesValue;
    private WebElement totalDeliveryFeesPaidValue;
    private WebElement totalUnpaidAmountValue;
    private WebElement paymentProcessingValue;


    private WebElement myShopButton;
    private WebElement newParcelButton ;


    /*----------Actions----------*/


    public String getToastMessage()
    {
        toastMessage = xpathPresenceSetter("//div[@class='ant-message']//span[text()]");
        try
        {
            String text = toastMessage.getText();
            sleep(2000);
            return text;
        }catch (Exception e){
        }
        return "true";
    }

    public void clickOnDropDownMyShopButton()
    {
        myShopButton = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[1]"));
        myActions.action_click(myShopButton);
    }

    public void clickOnCreateParcelButton()
    {
        newParcelButton = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[5]"));
        myActions.action_click(newParcelButton);
    }

    public void clickOnAllPickupLocation()
    {
        allPickupLocationFilter = xpathSetter("//div[@class='ant-select-selection__placeholder']");
        myActions.action_click(allPickupLocationFilter);
    }

    public void choosePickupLocation(String location)
    {
        pickUpLocations = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='" + location + "']");
        myActions.action_click(pickUpLocations);
    }

    public String choosePickupLocation()
    {
        clickOnAllPickupLocation();
        pickupLocationDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()]");
        int size = pickupLocationDropDownOptions.size();
        int index = random.nextInt(size);
        String pickupLocation = myActions.action_getText(pickupLocationDropDownOptions.get(index));
        System.out.println("Size : " + size);
        System.out.println("Index : " + index);
        System.out.println("Pickup Location : " + pickupLocation);
        myActions.action_click(pickupLocationDropDownOptions.get(index));
        return pickupLocation;
    }

    public int getSelectedDate()
    {
        selectedDate = xpathSetter("//td[@class='ant-calendar-cell ant-calendar-selected-day']/div");
        String date = myActions.action_getText(selectedDate);
        return Integer.parseInt(date);
    }

    public long selectDate(int date, String month, int year)
    {
        previousYearButton = xpathSetter("//a[@class='ant-calendar-prev-year-btn']");
        previousMonthButton = xpathSetter("//a[@class='ant-calendar-prev-month-btn']");
        nextMonthButton = xpathSetter("//a[@class='ant-calendar-next-month-btn']");
        nextYearButton = xpathSetter("//a[@class='ant-calendar-next-year-btn']");

        List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        int index = monthList.indexOf(month);
        while(true)
        {
            currentYearValue = xpathPresenceSetter("//a[@class='ant-calendar-year-select']");
            if(Integer.parseInt(currentYearValue.getText())==year)
                break;
            else {
                if(Integer.parseInt(currentYearValue.getText())>year)
                    myActions.action_click(previousYearButton);
                else
                    myActions.action_click(nextYearButton);
            }
        }

        while(true)
        {
            currentMonthValue = xpathSetter("//a[@class='ant-calendar-month-select']");
            if(currentMonthValue.getText().equalsIgnoreCase(month))
                break;
            else {
                if(index>5)
                    myActions.action_click(nextMonthButton);
                else
                    myActions.action_click(previousMonthButton);
            }
        }

        if(getSelectedDate()!=date)
            dateButton = xpathSetter("//td[@class='ant-calendar-cell']/div[text()='" + date + "']");
        else dateButton = xpathSetter("//td[@class='ant-calendar-cell ant-calendar-selected-day']/div");

        myActions.action_click(dateButton);
        long number = convertDateToNumber(date,index,year);
        return number;
    }

    public long convertDateToNumber(int date, int month, int year)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateFormat = date + "-" + (month+1) + "-" + year +" 23:59:59";
        Date d = null;
        try {
            d = sdf.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long number = d.getTime();
        System.out.println("Date : " + new Date(number));
        return number;
    }

    public long enterStartDate(int date, String month, int year)
    {
        startDateFilter = xpathSetter("//form[@class='ant-form ant-form-inline dateRange']/div[1]");
        myActions.action_click(startDateFilter);
        long number = selectDate(date,month,year);
        System.out.println("since : " + number);
        return number;
    }

    public long enterEndDate(int date, String month, int year)
    {
        endDateFilter = xpathSetter("//form[@class='ant-form ant-form-inline dateRange']/div[2]");
        myActions.action_click(endDateFilter);
        long number = selectDate(date,month,year);
        System.out.println("until : " + number);
        return number;
    }

    public void clickRedxCreditButton()
    {
        redxCreditButton = xpathSetter("//a[@class='credit-link']//button");
        myActions.action_click(redxCreditButton);
        waitForLoading();
    }

    public String getRedxCreditValue()
    {
        redxCreditValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][1]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(redxCreditValue);
    }

    public String getOrdersPlacedValue()
    {
        ordersPlacedValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][2]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(ordersPlacedValue);
    }

    public String getOrdersDeliveredValue()
    {
        ordersDeliveredValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][3]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(ordersDeliveredValue);
    }

    public String getOrdersInTransitValue()
    {
        ordersInTransitValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][4]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(ordersInTransitValue);
    }

    public String getOrdersReturnedValue()
    {
        ordersReturnedValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][5]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(ordersReturnedValue);
    }

    public String getSuccessfulDeliveriesValue()
    {
        successfulDeliveriesValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][6]//p[@class='value css-1y8lftn']");
        String value = myActions.action_getText(successfulDeliveriesValue);
        return value.substring(0,value.length()-1);
    }

    public String getOrdersToBeReturnedValue()
    {
        ordersToBeReturnedValue = xpathSetter("//div[@class='ant-col ant-col-xs-12 ant-col-lg-8'][7]//p[@class='value css-1y8lftn']");
        return myActions.action_getText(ordersReturnedValue);
    }

    public String getTotalSalesValue()
    {
        totalSalesValue = xpathSetter("//p[@class='value greenValue css-1y8lftn']");
        String value = myActions.action_getText(totalSalesValue);
        return value.substring(4);
    }

    public String getTotalDeliveryFeesPaidValue()
    {
        totalDeliveryFeesPaidValue = xpathSetter("//div[@class='ant-row prison'][2]/div[2]//p[contains(@class,'value')]");
        String value = myActions.action_getText(totalDeliveryFeesPaidValue);
        return value.substring(4);
    }

    public String getTotalUnPaidAmountValue()
    {
        totalUnpaidAmountValue = xpathSetter("//div[@class='ant-row prison'][2]/div[3]//p[contains(@class,'value')]");
        String value = myActions.action_getText(totalUnpaidAmountValue);
        return value.substring(4);
    }

    public String getPaymentProcessingValue()
    {
        paymentProcessingValue = xpathSetter("//div[@class='ant-row prison'][2]/div[4]//p[contains(@class,'value')]");
        String value = myActions.action_getText(paymentProcessingValue);
        return value.substring(4);
    }

    public void waitForLoading()
    {
        while (driver.getCurrentUrl().equalsIgnoreCase(RedXWebUrlUtils.dashboardUrl))
            sleep(100);
    }

}
