package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParcelPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;

    public ParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    /*----------Elements----------*/

    private WebElement allPickupLocationFilter;
    private WebElement pickupLocationDropDownOption;
    private WebElement trackingIdFilter;
    private WebElement shopInvoiceIdFilter;
    private WebElement phoneNumberOrCustomerNameFilter;
    private WebElement dateFromFilter;
    private WebElement dateToFilter;
    private WebElement dateTypeFilterDropDown;
    private WebElement dateTypeFilterDropDownOption;
    private WebElement searchButton;

    private WebElement clearSearchButton;

    private WebElement nextMonthButton;
    private WebElement nextYearButton;
    private WebElement currentMonthValue;
    private WebElement currentYearValue;
    private WebElement previousMonthButton;
    private WebElement previousYearButton;
    private WebElement dateButton;

    private WebElement totalParcelsValue;
    private WebElement printLabelsButton;
    private WebElement downloadParcelHistoryButton;

    private WebElement previousPageIcon;
    private WebElement nextPageIcon;
    private WebElement nextFivePageIcon;
    private WebElement pageIcon;

    private WebElement selectAllParcelsCheckbox;
    private WebElement selectParcelCheckbox;
    private List<WebElement> parcelsList;
    private WebElement creationDateValue;
    private WebElement pickupNameValue;
    private WebElement parcelIdButton;
    private WebElement InvoiceIdValue;
    private WebElement shopNameValue;
    private WebElement customerDetailsValue;
    private WebElement statusValue;
    private WebElement paymentInfoValue;
    private WebElement paymentStatusValue;
    private WebElement promoCodeDiscountValue;
    private WebElement moreInfoValue;
    private WebElement parcelTypeValue;
    private WebElement lastUpdatedValue;

    private WebElement editButton;
    private WebElement exchangeButton;
    private WebElement deleteButton;
    private WebElement raiseIssueButton;

    /*----------Actions----------*/

    public void clickAllPickupLocationFilter()
    {
        allPickupLocationFilter = xpathSetter("//div[@class='ant-select-selection__placeholder'][text()='All Pickup Location']");
        myActions.action_click(allPickupLocationFilter);
    }

    public void choosePickupLocation(String location)
    {
        clickAllPickupLocationFilter();
        pickupLocationDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='" + location + "']");
        myActions.action_click(pickupLocationDropDownOption);
        clickSearchButton();
    }

    public void enterTrackingIdFilter(String trackingID)
    {
        trackingIdFilter = xpathSetter("//input[@placeholder='Tracking ID']");
        myActions.action_sendKeys(trackingIdFilter,trackingID);
        clickSearchButton();
    }

    public void enterShopInvoiceIdFilter(String shopInvoice)
    {
        shopInvoiceIdFilter = xpathSetter("//input[@placeholder='Shop Invoice ID']");
        myActions.action_sendKeys(shopInvoiceIdFilter,shopInvoice);
        clickSearchButton();
    }

    public void enterPhoneNumberFilter(String phoneNumber)
    {
        phoneNumberOrCustomerNameFilter = xpathSetter("//input[@placeholder='Phone Number or Customer Name']");
        myActions.action_sendKeys(phoneNumberOrCustomerNameFilter,phoneNumber);
        clickSearchButton();
    }

    public void enterCustomerNameFilter(String customerName)
    {
        phoneNumberOrCustomerNameFilter = xpathSetter("//input[@placeholder='Phone Number or Customer Name']");
        myActions.action_sendKeys(phoneNumberOrCustomerNameFilter,customerName);
        clickSearchButton();
    }

    public long enterDateFromFilter(int date,String month, int year)
    {
        dateFromFilter = xpathSetter("//input[@placeholder='Date from']");
        myActions.action_click(dateFromFilter);
        long number = selectDate(date,month,year);
        System.out.println("since : " + number);
        return number;
    }

    public long enterDateToFilter(int date,String month, int year)
    {
        dateToFilter = xpathSetter("//input[@placeholder='Date to']");
        myActions.action_click(dateToFilter);
        long number = selectDate(date,month,year);
        System.out.println("since : " + number);
        return number;
    }

    public void clickDateFilterTypeDropDown()
    {
        dateTypeFilterDropDown = xpathSetter("//div[@class='ant-select-selection__placeholder'][text()='Date filter type']");
        myActions.action_click(dateTypeFilterDropDown);
    }

    public void chooseDateFilterTypeDropDown(String filterIndex)
    {
        clickDateFilterTypeDropDown();
        switch (filterIndex)
        {
            case "CREATED_AT" :
                dateTypeFilterDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Creation Date']");
                myActions.action_click(dateTypeFilterDropDownOption);
                clickSearchButton();
                break;
            case "UPDATED_AT" :
                dateTypeFilterDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Last Updated']");
                myActions.action_click(dateTypeFilterDropDownOption);
                clickSearchButton();
                break;
        }
    }

    public void clickSearchButton()
    {
        searchButton = xpathSetter("//button[@class='ant-btn search-submit-button ant-btn-round ant-btn-lg']");
        myActions.action_click(searchButton);
        setImplicitWait(1000);
    }

    public Boolean verifySearchButton()
    {
        searchButton = xpathSetter("//button[@class='ant-btn search-submit-button ant-btn-round ant-btn-lg']");
        Boolean isEnabled = searchButton.isEnabled();
        System.out.println("Search Button Enabled : " + isEnabled);
        return isEnabled;
    }

    public void clickClearSearchButton()
    {
        sleep(2000);
        clearSearchButton = xpathSetter("//button/span[contains(text(),'Clear search')]");
        myActions.action_click(clearSearchButton);
    }

    public void clickPrintLabelsButton()
    {
        printLabelsButton = xpathSetter("//button/span[contains(text(),'Print Labels')]");
        myActions.action_click(printLabelsButton);
    }

    public void clickDownloadParcelHistory()
    {
        downloadParcelHistoryButton = xpathSetter("//button/span[contains(text(),'Download Parcel History')]");
        myActions.action_click(downloadParcelHistoryButton);
    }

    public String getTotalParcelsCount()
    {
        String getText;
        totalParcelsValue = xpathSetter("//p[contains(text(),'Total')]");
        getText = myActions.action_getText(totalParcelsValue);
        return getText.substring(7);
    }

    public void clickPreviousPageIcon()
    {
        previousPageIcon = xpathSetter("//ul[1]/li[@title='Previous Page']");
        myActions.action_click(previousPageIcon);
    }

    public void clickPageIcon(int page)
    {
        int count = 5;
        while((page>count)&&(page!=20))
        {
            clickNextFivePageIcon();
            count = count + 4;
        }
        pageIcon = xpathSetter("//ul[1]/li[@title='" + page + "']");
        myActions.action_click(pageIcon);
    }

    public void clickNextFivePageIcon()
    {
        nextFivePageIcon = xpathSetter("//ul[1]/li[@title='Next 5 Pages']");
        myActions.action_click(nextFivePageIcon);
    }
    public void clickNextPageIcon()
    {
        nextPageIcon = xpathSetter("//ul[1]/li[@title='Next Page']");
        myActions.action_click(nextPageIcon);
    }

    public void clickSelectAllParcelsCheckbox()
    {
        selectAllParcelsCheckbox = xpathSetter("//thead//tr//input[@type='checkbox']");
        myActions.action_click(selectAllParcelsCheckbox);
    }

    public void clickSelectParcelCheckbox(int index)
    {
        selectParcelCheckbox = xpathSetter("//tbody//tr[" + index +"]//input[@type='checkbox']");
        myActions.action_click(selectParcelCheckbox);
    }



    /*----------Functions----------*/

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

        dateButton = xpathSetter("//td[@class='ant-calendar-cell']/div[text()='" + date + "']");
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

    /*------------------Classes----------------*/

    public class DownloadParcelHistoryPageObjects
    {

        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement dateRangeInput;
        private WebElement dateFilterTypeInput;
        private WebElement dateTypeFilterInputOption;
        private WebElement deliveryStatusInput;
        private WebElement deliveryStatusInputOption;
        private WebElement paymentStatusInput;
        private WebElement paymentStatusInputOption;
        private WebElement downloadCsvButton;
        private WebElement cancelButton;
        private WebElement closeDownloadParcelHistoryModalButton;


        /*----------Actions----------*/

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public void clickDateRangeInput()
        {
            dateRangeInput = xpathSetter("//div[@class='input-row'][1]//div[@class='input-column-right']");
            myActions.action_click(dateRangeInput);
        }

        public void clickDateFilterTypeInput()
        {
            dateFilterTypeInput = xpathSetter("//div[@class='input-row'][2]//div[@class='input-column-right']");
            myActions.action_click(dateFilterTypeInput);
        }

        public void clickDeliveryStatusInput()
        {
            deliveryStatusInput = xpathSetter("//div[@class='input-row'][3]//div[@class='input-column-right']");
            myActions.action_click(deliveryStatusInput);
        }

        public void clickPaymentStatusInput()
        {
            paymentStatusInput = xpathSetter("//div[@class='input-row'][4]//div[@class='input-column-right']");
            myActions.action_click(paymentStatusInput);
        }

        public void clickDownloadCsvButton()
        {
            downloadCsvButton = xpathSetter("");
            myActions.action_click(downloadCsvButton);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("");
            myActions.action_click(cancelButton);
        }

        public void clickCloseDownloadParcelHistoryModal()
        {
            closeDownloadParcelHistoryModalButton = xpathSetter("");
            myActions.action_click(closeDownloadParcelHistoryModalButton);
        }

        public void chooseStartDate(int date, String month, int year)
        {
            clickDateRangeInput();
            selectDate(date,month,year);
        }

        public void chooseEndDate(int date, String month, int year)
        {
            clickDateRangeInput();
            selectDate(date,month,year);
        }

        public void chooseDateFilterType(int filterIndex)
        {
            clickDateFilterTypeInput();
            switch (filterIndex)
            {
                case 1 :
                    dateTypeFilterInputOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Creation Date']");
                    myActions.action_click(dateTypeFilterInputOption);
                    break;
                case 2 :
                    dateTypeFilterInputOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Last Updated']");
                    myActions.action_click(dateTypeFilterInputOption);
                    break;
            }
        }

        public void chooseDeliveryStatusInputs(String[] deliveryStatus)
        {
            for(String status:deliveryStatus)
            {
                deliveryStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
                myActions.action_click(deliveryStatusInputOption);
            }
        }

        public void choosePaymentStatusInput(String status)
        {
            paymentStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
            myActions.action_click(paymentStatusInputOption);
        }

        /*----------Functions----------*/

        public void downloadParcelHistory(int date1,String month1,int year1,int date2,String month2,int year2, int filterIndex)
        {
            chooseStartDate(date1,month1,year1);
            chooseStartDate(date2,month2,year2);
            chooseDateFilterType(filterIndex);
        }

        public void downloadParcelHistory(String paymentStatus, String ...deliveryStatuses)
        {
            chooseDeliveryStatusInputs(deliveryStatuses);
            choosePaymentStatusInput(paymentStatus);
        }
    }

    public class StatusFilterPageObjects
    {

        /*----------Elements----------*/

        private WebElement statusFilterDropDown;
        private WebElement statusFilterDropDownOption;
        private WebElement okButton;
        private WebElement resetButton;

        /*----------Actions----------*/

        public void clickStatusFilterDropDown()
        {
            statusFilterDropDown = xpathSetter("//th[7]//i[@title='Filter menu']");
            myActions.action_click(statusFilterDropDownOption);
        }

        public void chooseStatusFilterDropDownOption(String status)
        {
            statusFilterDropDownOption = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-topRight']//li//span[contains(text(),'" + status + "')]");
            myActions.action_click(statusFilterDropDownOption);
        }

        public void clickOkButton()
        {
            okButton = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-topRight']//a[contains(text(),'OK')]");
            myActions.action_click(okButton);
        }

        public void clickResetButton()
        {
            resetButton = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-topRight']//a[contains(text(),'Reset')]");
            myActions.action_click(resetButton);
        }

        /*----------Functions----------*/

        public void filterByStatus(String status)
        {
            clickStatusFilterDropDown();
            chooseStatusFilterDropDownOption(status);
            clickOkButton();
        }

    }

    public class PaymentStatusFilterPageObjects
    {

        /*----------Elements----------*/

        private WebElement paymentStatusFilterDropDown;
        private WebElement paymentStatusFilterDropDownOption;
        private WebElement okButton;
        private WebElement resetButton;

        /*----------Actions----------*/

        public void clickPaymentStatusFilterDropDown()
        {
            paymentStatusFilterDropDown = xpathSetter("//th[9]//i[@title='Filter menu']");
            myActions.action_click(paymentStatusFilterDropDownOption);
        }

        public void choosePaymentStatusFilterDropDownOption(String status)
        {
            paymentStatusFilterDropDownOption = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight']//li//span[contains(text(),'" + status + "')]");
            myActions.action_click(paymentStatusFilterDropDownOption);
        }

        public void clickOkButton()
        {
            okButton = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight']//a[contains(text(),'OK')]");
            myActions.action_click(okButton);
        }

        public void clickResetButton()
        {
            resetButton = xpathSetter("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight']//a[contains(text(),'Reset')]");
            myActions.action_click(resetButton);
        }

        /*----------Functions----------*/

        public void filterByStatus(String status)
        {
            clickPaymentStatusFilterDropDown();
            choosePaymentStatusFilterDropDownOption(status);
            clickOkButton();
        }

    }

    public class EditParcelPageObjects
    {

        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement customerNameInput;
        private WebElement customerPhoneInput;
        private WebElement areaInput;
        private WebElement addressInput;
        private WebElement amountInput;
        private WebElement sellingPriceInput;
        private WebElement weightInput;
        private WebElement instructionsInput;
        private WebElement submitButton;
        private WebElement cancelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public void enterCustomerName(String name)
        {
            customerNameInput = xpathSetter("//div[@class='input-row'][1]//input");
            myActions.action_sendKeys(customerNameInput,name);
        }

        public void enterCustomerPhone(String phone)
        {
            customerPhoneInput = xpathSetter("//div[@class='input-row'][2]//input");
            myActions.action_sendKeys(customerPhoneInput,phone);
        }

        public void enterArea(String area)
        {
            areaInput = xpathSetter("//div[@class='input-row'][3]//input");
            myActions.action_sendKeys(areaInput,area);
        }

        public void enterAddress(String address)
        {
            addressInput = xpathSetter("//div[@class='input-row'][4]//textArea");
            myActions.action_sendKeys(addressInput,address);
        }

        public void enterAmount(int amount)
        {
            amountInput = xpathSetter("//div[@class='input-row'][5]//input");
            myActions.action_sendKeys(amountInput,Integer.toString(amount));
        }

        public void enterSellingPrice(int sellingPrice)
        {
            sellingPriceInput = xpathSetter("//div[@class='input-row'][6]//input");
            myActions.action_sendKeys(sellingPriceInput,Integer.toString(sellingPrice));
        }

        public void enterWeight(int weight)
        {
            weightInput = xpathSetter("//div[@class='input-row'][7]//input");
            myActions.action_sendKeys(weightInput,Integer.toString(weight));
        }

        public void enterInstructions(String instruction)
        {
            instructionsInput = xpathSetter("//div[@class='input-row'][8]//textArea");
            myActions.action_sendKeys(instructionsInput,instruction);
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//button/span[contains(text(),'Submit')]");
            myActions.action_click(submitButton);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//button/span[contains(text(),'Cancel')]");
            myActions.action_click(cancelButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeButton);
        }

        /*----------Functions----------*/

        public void editParcel(String ...inputs)
        {
            /* Input Format : String customerName,String customerPhone,String area,String address,int amount,int sellingPrice,int Weight,String instructions */
            int i;
            for(i=0;i<inputs.length;i++)
            {
                switch (i)
                {
                    case 0:
                        enterCustomerName(inputs[i]);
                        break;
                    case 1:
                        enterCustomerPhone(inputs[i]);
                        break;
                    case 2:
                        enterArea(inputs[i]);
                        break;
                    case 3:
                        enterAddress(inputs[i]);
                        break;
                    case 4:
                        enterAmount(Integer.parseInt(inputs[i]));
                        break;
                    case 5:
                        enterSellingPrice(Integer.parseInt(inputs[i]));
                        break;
                    case 6:
                        enterWeight(Integer.parseInt(inputs[i]));
                        break;
                    case 7:
                        enterInstructions(inputs[i]);
                        break;
                }
            }
            clickSubmitButton();
        }
    }

    public class ExchangeParcelPageObjects
    {
        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement parcelIdValue;
        private WebElement customerNameValue;
        private WebElement customerPhoneValue;
        private WebElement amountInput;
        private WebElement createParcelButton;
        private WebElement cancelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public String getParcelIdValue()
        {
            parcelIdValue = xpathSetter("//div[@class='input-row'][1]//div[@class='input-column-right']");
            return myActions.action_getText(parcelIdValue);
        }

        public String getCustomerNameValue()
        {
            customerNameValue = xpathSetter("//div[@class='input-row'][2]//div[@class='input-column-right']");
            return myActions.action_getText(customerNameValue);
        }

        public String getCustomerPhoneValue()
        {
            customerPhoneValue = xpathSetter("//div[@class='input-row'][3]//div[@class='input-column-right']");
            return myActions.action_getText(customerPhoneValue);
        }

        public void enterAmount(int amount)
        {
            amountInput = xpathSetter("//div[@class='input-row']//input[@placeholder='Amount']");
            myActions.action_sendKeys(amountInput,Integer.toString(amount));
        }

        public void clickCreateParcelButton()
        {
            createParcelButton = xpathSetter("//button/span[contains(text(),'Create Parcel')]");
            myActions.action_click(createParcelButton);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//button/span[contains(text(),'Cancel')]");
            myActions.action_click(cancelButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeButton);
        }

        /*----------Functions----------*/

        public void exchangeParcel(int amount)
        {
            System.out.println("Parcel Id : " + getParcelIdValue());
            System.out.println("Customer Name : " + getCustomerNameValue());
            System.out.println("Customer Phone : " + getCustomerNameValue());
            System.out.println("Amount : " + amount);

            enterAmount(amount);
            clickCreateParcelButton();
        }
    }

    public class DeleteParcelPageObjects
    {
        /*----------Elements----------*/

        private WebElement popoverMessageTitle;
        private WebElement yesButton;
        private WebElement noButton;

        /*----------Actions----------*/

        public String getPopoverMessageTitle()
        {
            popoverMessageTitle = xpathSetter("//div[@class='ant-popover-message-title']");
            return myActions.action_getText(popoverMessageTitle);
        }

        public void clickYesButton()
        {
            yesButton = xpathSetter("//button/span[contains(text(),'Yes')]");
            myActions.action_click(yesButton);
        }

        public void clickNoButton()
        {
            noButton = xpathSetter("//button/span[contains(text(),'No')]");
            myActions.action_click(noButton);
        }
    }

}
