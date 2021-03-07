package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PaymentsPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public PaymentsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement allPickupLocationDropDown;
    private WebElement allPickupLocationDropDownOption;
    private List<WebElement> allPickupLocationDropDownOptions;

    private WebElement dateRangeInput;
    private WebElement nextMonthButton;
    private WebElement nextYearButton;
    private WebElement currentMonthValue;
    private WebElement currentYearValue;
    private WebElement previousMonthButton;
    private WebElement previousYearButton;
    private WebElement dateButton;
    private WebElement clearDateFilterIcon;

    private WebElement searchButton;

    private List<WebElement> payments;

    private WebElement invoiceId;
    private WebElement invoiceDate;
    private WebElement cashCollection;
    private WebElement deliveryCharge;
    private WebElement redxCredit;
    private WebElement codCharge;
    private WebElement returnCharge;
    private WebElement advancePaymentRepayment;
    private WebElement amountPaidOut;
    private WebElement downloadButton;

    /*----------Actions----------*/

    public void clickDateRangeInput()
    {
        dateRangeInput = xpathSetter("//input[@class='ant-calendar-range-picker-input']");
        myActions.action_click(dateRangeInput);
    }

    public long selectStartDate(int date, String month, int year)
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

        dateButton = xpathSetter("//td[@class='ant-calendar-cell']/div[text()='" + date + "']");
        myActions.action_click(dateButton);
        long number = convertDateToNumber(date,index,year);
        return number;
    }

    public long selectEndDate(int date, String month, int year)
    {
        previousYearButton = xpathSetter("//a[@class='ant-calendar-prev-year-btn']");
        previousMonthButton = xpathSetter("//a[@class='ant-calendar-prev-month-btn']");
        nextMonthButton = xpathSetter("//a[@class='ant-calendar-next-month-btn']");
        nextYearButton = xpathSetter("//a[@class='ant-calendar-next-year-btn']");

        List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        int index = monthList.indexOf(month);

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

        dateButton = xpathSetter("//td[@class='ant-calendar-cell ant-calendar-in-range-cell']/div[text()='" + date + "']");
        myActions.action_click(dateButton);
        long number = convertDateToNumber(date,index,year);
        return number;
    }

    public void clickClearDateFilterIcon()
    {
        clearDateFilterIcon = xpathSetter("//i[@class='anticon anticon-close-circle ant-calendar-picker-clear']");
        myActions.action_click(clearDateFilterIcon);
    }

    public void clickSearchButton()
    {
        searchButton = xpathSetter("//div[@class='filters-wrapper']/button");
        myActions.action_click(searchButton);
        sleep(1000);
    }

    public int getPaymentsSize()
    {
        payments = xpathListSetter("//tbody/tr");
        return payments.size();
    }

    public void clickInvoiceId(int index)
    {
        invoiceId = xpathSetter("//tbody/tr[" + index + "]/td[1]/button");
        myActions.action_click(invoiceId);
        sleep(2000);
    }

    public String getInvoiceIdValue(int index)
    {
        invoiceId = xpathSetter("//tbody/tr[" + index + "]/td[1]/button");
        return myActions.action_getText(invoiceId);
    }

    public String getInvoiceDateValue(int index)
    {
        invoiceDate = xpathSetter("//tbody/tr[" + index + "]/td[2]");
        return myActions.action_getText(invoiceDate);
    }

    public String getCashCollectionValue(int index)
    {
        cashCollection = xpathSetter("//tbody/tr[" + index + "]/td[3]");
        return myActions.action_getText(cashCollection);
    }

    public String getDeliveryChargeValue(int index)
    {
        deliveryCharge = xpathSetter("//tbody/tr[" + index + "]/td[4]");
        return myActions.action_getText(deliveryCharge);
    }

    public String getRedxCreditValue(int index)
    {
        redxCredit = xpathSetter("//tbody/tr[" + index + "]/td[5]");
        return myActions.action_getText(redxCredit);
    }

    public String getCodChargeValue(int index)
    {
        codCharge = xpathSetter("//tbody/tr[" + index + "]/td[6]");
        return myActions.action_getText(codCharge);
    }

    public String getReturnChargeValue(int index)
    {
        returnCharge = xpathSetter("//tbody/tr[" + index + "]/td[7]");
        return myActions.action_getText(returnCharge);
    }

    public String getAdvancePaymentRepayment(int index)
    {
        advancePaymentRepayment = xpathSetter("//tbody/tr[" + index + "]/td[8]");
        return myActions.action_getText(advancePaymentRepayment);
    }

    public String getAmountPaidOut(int index)
    {
        amountPaidOut = xpathSetter("//tbody/tr[" + index + "]/td[9]/span");
        return myActions.action_getText(amountPaidOut);
    }

    public void clickDownloadButton(int index)
    {
        downloadButton = xpathSetter("//tbody/tr[" + index + "]/td[10]/i");
        myActions.action_click(downloadButton);
    }

    /*----------Functions----------*/


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

    public int getRandomParcelIndex()
    {
        int bound = 20;
        if(getPaymentsSize()<20)
            bound = getPaymentsSize();
        int index = random.nextInt(bound)+1;
        System.out.println("Random Index : " + index);
        return index;
    }


    /*----------Classes----------*/

    public class PaymentDetailsPageObjects
    {

        /*----------Elements----------*/

        private WebElement backButton;
        private WebElement titleCaption;
        private WebElement invoiceInfo;
        private WebElement downloadButton;

        private List<WebElement> parcels;
        private WebElement parcelIdValue;
        private WebElement dateValue;
        private WebElement customerNameValue;
        private WebElement phoneNumberValue;
        private WebElement statusValue;
        private WebElement cashCollectionValue;
        private WebElement deliveryChargeValue;
        private WebElement codChargeValue;
        private WebElement returnChargeValue;
        private WebElement amountPaidValue;
        private WebElement totalPaidOutValue;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//div/i[@class='anticon anticon-left']");
            myActions.action_click(backButton);
            sleep(2000);
        }

        public String getTitleCaptionValue()
        {
            titleCaption = xpathSetter("//p[contains(@class,'payments_caption')]");
            return myActions.action_getText(titleCaption);
        }

        public String getInvoiceInfo(int line)
        {
            invoiceInfo = xpathSetter("//div/i/../div");
            List<String> details = Arrays.asList(myActions.action_getText(invoiceInfo).split("\n"));
            return details.get(line-1);
        }

        public void clickDownloadButton()
        {
            downloadButton = xpathSetter("//i[@class='anticon anticon-file-excel']");
            myActions.action_click(downloadButton);
        }

        public int getParcelsSize()
        {
            parcels = xpathListSetter("//tbody/tr");
            return parcels.size();
        }

        public String getParcelIdValue(int index)
        {
            parcelIdValue = xpathSetter("//tbody/tr[" + index + "]/td[1]");
            return myActions.action_getText(parcelIdValue);
        }

        public String getDateValue(int index)
        {
            dateValue = xpathSetter("//tbody/tr[" + index + "]/td[2]");
            return myActions.action_getText(dateValue);
        }

        public String getCustomerName(int index)
        {
            customerNameValue = xpathSetter("//tbody/tr[" + index + "]/td[3]");
            return myActions.action_getText(customerNameValue);
        }

        public String getPhoneValue(int index)
        {
            phoneNumberValue = xpathSetter("//tbody/tr[" + index + "]/td[4]");
            return myActions.action_getText(phoneNumberValue);
        }

        public String getStatusValue(int index)
        {
            statusValue = xpathSetter("//tbody/tr[" + index + "]/td[5]/span");
            return myActions.action_getText(statusValue);
        }

        public String getCashCollectionValue(int index)
        {
            cashCollectionValue = xpathSetter("//tbody/tr[" + index + "]/td[6]");
            return myActions.action_getText(cashCollectionValue);
        }

        public String getDeliveryChargeValue(int index)
        {
            deliveryChargeValue = xpathSetter("//tbody/tr[" + index + "]/td[7]");
            return myActions.action_getText(deliveryChargeValue);
        }

        public String getCodChargeValue(int index)
        {
            codChargeValue = xpathSetter("//tbody/tr[" + index + "]/td[8]");
            return myActions.action_getText(codChargeValue);
        }

        public String getReturnChargeValue(int index)
        {
            returnChargeValue = xpathSetter("//tbody/tr[" + index + "]/td[9]");
            return myActions.action_getText(returnChargeValue);
        }

        public String getAmountPaidValue(int index)
        {
            amountPaidValue = xpathSetter("//tbody/tr[" + index + "]/td[10]/span");
            return myActions.action_getText(amountPaidValue);
        }

        public String getTotalPaidOutValue()
        {
            totalPaidOutValue = xpathSetter("//div[@class='payment_tbl_total']/div[2]/span");
            return myActions.action_getText(totalPaidOutValue);
        }

        /*----------Functions----------*/

        public int getRandomParcelIndex()
        {
            int bound = 20;
            if(getParcelsSize()<20)
                bound = getParcelsSize();
            int index = random.nextInt(bound)+1;
            System.out.println("Random Index : " + index);
            return index;
        }
    }
}
