package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class PaymentPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private HomePageObjects homePageObjects;

    public PaymentPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        homePageObjects = new HomePageObjects(driver);
    }
    private List<WebElement> invoiceID;
    private List<WebElement> cashCollection;
    private List<WebElement> deliveryCharge;
    private List<WebElement> redXCredit;
    private List<WebElement> CODCharge;
    private List<WebElement> returnCharge;
    private List<WebElement> adjustments;
    private List<WebElement> advancePaymentRepayment;
    private List<WebElement> amountPaidOut;
    private List<WebElement> download;
    private List<WebElement> fromDateIcon;
    private List<WebElement> toDateIcon;
    private WebElement searchIcon;


    public String getInvoiceID(int index)
    {
        invoiceID = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[1]");
       return myActions.action_getText(invoiceID.get(index));
    }

    public String getCashCollection(int index)
    {
        cashCollection = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[3]");
       return myActions.action_getText(cashCollection.get(index));
    }

    public String getDeliveryCharge(int index)
    {
        deliveryCharge = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[4]");
        return myActions.action_getText(deliveryCharge.get(index));
    }

    public String getRedXCredit(int index)
    {
        redXCredit = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[5]");
        return myActions.action_getText(redXCredit.get(index));
    }

    public String getCODCharge(int index)
    {
        CODCharge = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[6]");
        return  myActions.action_getText(CODCharge.get(index));
    }

    public String getReturnCharge(int index)
    {
        returnCharge = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[7]");
        return  myActions.action_getText(returnCharge.get(index));
    }

    public String getAdjustmentsAmount(int index)
    {
        adjustments = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[8]");
        return myActions.action_getText(adjustments.get(index));
    }

    public String getAdvancePaymentRepayment(int index)
    {
        advancePaymentRepayment = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[9]");
        return  myActions.action_getText(advancePaymentRepayment.get(index));
    }

    public String getAmountPaidOut(int index)
    {
        amountPaidOut = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[10]");
        return  myActions.action_getText(amountPaidOut.get(index));
    }

    public void clickOnDownloadInvoiceFile(int index)
    {
        download = xpathListSetter("//tbody[@class='ant-table-tbody']/tr/td[11]");
        myActions.action_getText(download.get(index));
    }

    public void clickOnFromDateIcon()
    {
        fromDateIcon = xpathListSetter("//span[@class='ant-calendar-picker ant-calendar-picker-large']//input");
        myActions.action_getText(fromDateIcon.get(0));
    }

    public void clickOnToDateIcon()
    {
        toDateIcon = xpathListSetter("//span[@class='ant-calendar-picker ant-calendar-picker-large']//input");
        myActions.action_getText(toDateIcon.get(1));
    }

    public void clickOnSearchButton()
    {
        searchIcon = xpathSetter("//div[@class='css-o3v2hk']/div[2]/button[1]");
        myActions.action_getText(searchIcon);
    }



}
