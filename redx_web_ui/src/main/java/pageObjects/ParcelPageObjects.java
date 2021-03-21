package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParcelPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }


    /*----------Elements----------*/

    private WebElement nextMonthButton;
    private WebElement nextYearButton;
    private WebElement currentMonthValue;
    private WebElement currentYearValue;
    private WebElement previousMonthButton;
    private WebElement previousYearButton;
    private WebElement dateButton;

    private WebElement totalParcelsValue;
    private WebElement printLabelsButton;
    private WebElement alertCloseButton;

    private WebElement previousPageIcon;
    private WebElement nextPageIcon;
    private WebElement nextFivePageIcon;
    private WebElement pageIcon;
    private WebElement lastPage;
    private WebElement activePage;

    private String[] pickupLocations = {"Dhanmondi","CWH"};
    private String[] dateFilterTypes = {"Creation Date","Last Updated"};
    private String[] paymentStatuses = {"Settled","Unsettled"};
    private String[] statuses = {"Delivered","Deleted","Returning","Damaged","Delivery in Progress","Returned","Rejected","Picked Up","Pickup Pending","Hold"};

    /*----------Actions----------*/

    public void clickPrintLabelsButton()
    {
        printLabelsButton = xpathSetter("//button/span[contains(text(),'Print Labels')]/..");
        myActions.action_click(printLabelsButton);
    }

    public int getTotalParcelsCount()
    {
        String getText;
        waitForLoading();
        totalParcelsValue = xpathSetter("//p[contains(text(),'Total')]");
        getText = myActions.action_getText(totalParcelsValue);
        return Integer.parseInt(getText.substring(7));
    }

    public void clickPreviousPageIcon()
    {
        previousPageIcon = xpathSetter("//ul[1]/li[@title='Previous Page']");
        myActions.action_click(previousPageIcon);
        waitForLoading();
    }

    public int getActivePage()
    {
        waitForLoading();
        activePage = xpathSetter("//ul[1]/li[contains(@class,'ant-pagination-item-active')]");
        int page = Integer.parseInt(activePage.getAttribute("title"));
        return page;
    }

    public int getLastPage()
    {
        lastPage = xpathSetter("//ul[1]/li[@title][8]");
        return Integer.parseInt(lastPage.getAttribute("title"));
    }

    public void clickPageIcon(int page,int pages)
    {
        System.out.println("Page : " + page);
        int activePage = getActivePage();
        while((page!=1)&&((page>activePage+2)||(page<activePage-2))&&(page!=pages))
        {
            clickNextFivePageIcon();
            activePage = getActivePage();
        }
        pageIcon = xpathSetter("//ul[1]/li[@title='" + page + "']");
        myActions.action_click(pageIcon);
        waitForLoading();
    }

    public int[] clickPageIcon()
    {
        int page[] = new int[2];
        int pages;
        if((getTotalParcelsCount()%20)==0)
            pages = getTotalParcelsCount()/20;
        else pages = getTotalParcelsCount()/20 + 1;
        System.out.println("Total Pages : " + pages);
        page[0] = random.nextInt(pages)+1;
        clickPageIcon(page[0],pages);
        page[1] = getActivePage();
        System.out.println("Active Page : " + page[1]);
        clickPageIcon(1,pages);
        return page;
    }

    public void clickNextFivePageIcon()
    {
        nextFivePageIcon = xpathSetter("//ul[1]/li[@title='Next 5 Pages']");
        myActions.action_click(nextFivePageIcon);
        waitForLoading();
    }

    public void clickNextPageIcon()
    {
        nextPageIcon = xpathSetter("//ul[1]/li[@title='Next Page']");
        myActions.action_click(nextPageIcon);
        waitForLoading();
    }

    public void clickResetButton()
    {
        alertCloseButton = xpathSetter("//button[@class='ant-alert-close-icon']/span[contains(text(),'Reset')]");
        myActions.action_click(alertCloseButton);
        waitForLoading();
    }

    public void waitForLoading()
    {
        try {
            new WebDriverWait(getBaseDriver(),30)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-spin-nested-loading']/div[@class='ant-spin-container']")));
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public long selectEndDateRange(int date, String month, int year)
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
        if(getTotalParcelsCount()<20)
            bound = getTotalParcelsCount();
        int index = random.nextInt(bound)+1;
        System.out.println("Random Index : " + index);
        return index;
    }

    public String getRandomValue(String filter)
    {
        int index;
        String value = null;
        switch (filter)
        {
            case "Pickup Location":
                index = random.nextInt(2);
                value = pickupLocations[index];
                break;
            case "Date":
                index = random.nextInt(2);
                value = dateFilterTypes[index];
                break;
            case "Parcel Status":
                index = random.nextInt(10);
                value = statuses[index];
                break;
            case "Payment Status":
                index = random.nextInt(2);
                value = paymentStatuses[index];
                break;
        }
        return value;
    }

    public int getStoreId(String shopName)
    {
        switch (shopName)
        {
            case "Dhanmondi":
                return 64285;
            case "CWH":
                return 64286;
            default: return 0;
        }
    }

    /*------------------Classes----------------*/

    public class SearchByPageObjects
    {
        /*----------Elements----------*/

        private WebElement allPickupLocationFilter;
        private List<WebElement> pickupLocationDropDownOptions;
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

        public String choosePickupLocation()
        {
            clickAllPickupLocationFilter();
            pickupLocationDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()]");
            int size = pickupLocationDropDownOptions.size();
            int index = random.nextInt(size);
            String pickupLocation = myActions.action_getText(pickupLocationDropDownOptions.get(index));
            System.out.println("Size : " + size);
            System.out.println("Index : " + index);
            System.out.println("Pickup Location : " + pickupLocation);
            myActions.action_click(pickupLocationDropDownOptions.get(index));
            clickSearchButton();
            return Integer.toString(getStoreId(pickupLocation));
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
            System.out.println("until : " + number);
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
            waitForLoading();
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
            clearSearchButton = xpathSetter("//button/span[contains(text(),'Clear search')]");
            myActions.action_click(clearSearchButton);
            waitForLoading();
        }
        /*----------Functions----------*/
    }

    public class ParcelsListPageObjects
    {
        /*----------Elements----------*/

        private WebElement selectAllParcelsCheckbox;
        private WebElement selectParcelCheckbox;
        private List<WebElement> parcelsList;

        private WebElement creationDateValue;
        private WebElement pickupNameValue;
        private WebElement parcelIdButton;
        private WebElement invoiceIdValue;
        private WebElement shopNameValue;
        private WebElement customerDetailsValue;
        private WebElement statusValue;
        private WebElement paymentInfoValue;
        private WebElement paymentStatusValue;
        private WebElement promoCodeDiscountValue;
        private WebElement parcelDeliveryType;
        private WebElement parcelTypeValue;
        private WebElement lastUpdatedValue;


        /*----------Actions----------*/

        public void clickSelectAllParcelsCheckbox()
        {
//        selectAllParcelsCheckbox = xpathSetter("//thead//tr//input[@type='checkbox']");
            selectAllParcelsCheckbox = xpathSetter("//thead//tr//div[@class='ant-table-selection']");
            myActions.action_click(selectAllParcelsCheckbox);
        }

        public int getSelectedParcels()
        {
            parcelsList = xpathListSetter("//tbody/tr//span[@class='ant-checkbox ant-checkbox-checked']");
            return parcelsList.size();
        }

        public void clickSelectParcelCheckbox(int index)
        {
            System.out.println("Index : " + index);
            selectParcelCheckbox = xpathSetter("//tbody//tr[" + index +"]//label[@class='ant-checkbox-wrapper']");
            myActions.action_click(selectParcelCheckbox);
        }

        public int[] clickSelectParcelCheckbox()
        {
            int index,selectedParcels[]=new int[2];
            index = getRandomParcelIndex();
            clickSelectParcelCheckbox(index);
            selectedParcels[0] = index;
            selectedParcels[1] = getSelectedParcels();
            return selectedParcels;
        }

        public void clickUnSelectParcelCheckbox(int index)
        {
            selectParcelCheckbox = xpathSetter("//tbody//tr[" + index +"]//label[@class='ant-checkbox-wrapper ant-checkbox-wrapper-checked']");
            myActions.action_click(selectParcelCheckbox);
        }

        public String getCreationDateValue(int index)
        {
            creationDateValue = xpathSetter("//tbody/tr[" + index + "]/td[2]");
            return myActions.action_getText(creationDateValue);
        }

        public String getPickupNameValue(int index)
        {
            pickupNameValue = xpathSetter("//tbody/tr[" + index + "]/td[3]/span");
            return myActions.action_getText(pickupNameValue);
        }

        public String getParcelIdButton(int index)
        {
            parcelIdButton = xpathSetter("//tbody/tr[" + index + "]/td[4]//button/span");
            String parcelId = myActions.action_getText(parcelIdButton);
            return parcelId.substring(4);
        }

        public void clickParcelIdButton(int index)
        {
            parcelIdButton = xpathSetter("//tbody/tr[" + index + "]/td[4]//button   ");
            myActions.action_click(parcelIdButton);
            sleep(2000);
        }

        public String getInvoiceId(int index,int line)
        {
            invoiceIdValue = xpathSetter("//tbody/tr[" + index + "]/td[4]/div[contains(text(),'Invoice ID')]");
            List<String> details = Arrays.asList(myActions.action_getText(invoiceIdValue).split("\n"));
            if(details.get(line-1).length()>12)
                return details.get(line-1).substring(12);
            else return null;
        }

        public String getShopNameValue(int index)
        {
            shopNameValue = xpathSetter("//tbody/tr[" + index + "]/td[5]");
            return myActions.action_getText(shopNameValue);
        }

        public String getCustomerDetailsValue(int index,int line)
        {
            customerDetailsValue = xpathSetter("//tbody/tr[" + index + "]/td[6]");
            List<String> details = Arrays.asList(myActions.action_getText(customerDetailsValue).split("\n"));
            return details.get(line-1);
        }

        public String getStatusValue(int index)
        {
            statusValue = xpathSetter("//tbody/tr[" + index + "]/td[7]//span");
            return myActions.action_getText(statusValue);
        }

        public String getLowerCaseStatusValue(int index)
        {
            statusValue = xpathSetter("//tbody/tr[" + index + "]/td[7]//span");
            String status = myActions.action_getText(statusValue).toLowerCase();
            status = status.replace(" ", "-");
            return status;
        }

        public String getPaymentInfoValue(int index,int line)
        {
            paymentInfoValue = xpathSetter("//tbody/tr[" + index + "]/td[8]");
            List<String> info = Arrays.asList(myActions.action_getText(paymentInfoValue).split("\n"));
            switch (line)
            {
                case 1:
                    if(info.get(line-1).length()>20)
                        return info.get(line-1).substring(4,info.get(line-1).length()-16);
                    else return null;
                case 2:
                    if(info.get(line-1).length()>10)
                        return info.get(line-1).substring(4,info.get(line-1).length()-7);
                    else return null;
                default: return null;
            }
        }

        public String getPaymentStatusValue(int index)
        {
            paymentStatusValue = xpathSetter("//tbody/tr[" + index + "]/td[9]/span");
            return myActions.action_getText(paymentStatusValue);
        }

        public String getPromoCodeDiscountValue(int index)
        {
            promoCodeDiscountValue = xpathSetter("//tbody/tr[" + index + "]/td[10]");
            String value = myActions.action_getText(promoCodeDiscountValue).substring(4);
            return String.format("%.1f",Float.parseFloat(value));
        }

        public String getParcelDeliveryTypeValue(int index,int line)
        {
            parcelDeliveryType = xpathSetter("//tbody/tr[" + index + "]/td[11]/div");
            List<String> info = Arrays.asList(myActions.action_getText(parcelDeliveryType).split("\n"));
            return info.get(line-1).substring(0,7).toLowerCase();
        }

        public String getParcelTypeValue(int index)
        {
            parcelTypeValue = xpathSetter("//tbody/tr[" + index + "]/td[11]/span");
            return myActions.action_getText(parcelTypeValue).substring(13).toLowerCase();
        }

        public String getLastUpdatedValue(int index)
        {
            lastUpdatedValue = xpathSetter("//tbody/tr[" + index + "]/td[12]");
            return myActions.action_getText(lastUpdatedValue);
        }
    }
    public class DownloadParcelHistoryPageObjects
    {

        /*----------Elements----------*/

        private WebElement downloadParcelHistoryButton;
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

        public void clickDownloadParcelHistory()
        {
//        downloadParcelHistoryButton = xpathSetter("//button/span[contains(text(),'Download Parcel History')]");
            downloadParcelHistoryButton = xpathSetter("//button[@class='ant-btn parcel-history-btn ant-btn-link']");
            myActions.action_click(downloadParcelHistoryButton);
        }

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public void clickModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            myActions.action_click(modalTitle);
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
            downloadCsvButton = xpathSetter("//button[@class='ant-btn export-btn ant-btn-round ant-btn-lg']");
            myActions.action_click(downloadCsvButton);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//div[@class='modal-btns']/button[@class='ant-btn ant-btn-link']");
            myActions.action_click(cancelButton);
        }

        public void clickCloseDownloadParcelHistoryModal()
        {
            closeDownloadParcelHistoryModalButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeDownloadParcelHistoryModalButton);
        }

        public void chooseStartDate(int date, String month, int year)
        {
            clickDateRangeInput();
            selectDate(date,month,year);
        }

        public void chooseEndDate(int date, String month, int year)
        {
            selectEndDateRange(date,month,year);
        }

        public void chooseDateFilterType(int filterIndex)
        {
            clickDateFilterTypeInput();
            switch (filterIndex)
            {
                case 1 :
                    System.out.println("Date Filter Type : Creation Date");
//                    dateTypeFilterInputOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Creation Date']");
                    dateTypeFilterInputOption = xpathSetter("//li[text()='Creation Date']");
                    myActions.action_click(dateTypeFilterInputOption);
                    break;
                case 2 :
                    System.out.println("Date Filter Type : Last Updated");
                    dateTypeFilterInputOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Last Updated']");
                    myActions.action_click(dateTypeFilterInputOption);
                    break;
            }
        }

        public void chooseDeliveryStatusInputs(int[] deliveryStatus)
        {
            clickDeliveryStatusInput();
            String status;
            for(int statusValue:deliveryStatus)
            {
                status = statuses[statusValue];
                System.out.println("Status Value : " + status);
                deliveryStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
                myActions.action_click(deliveryStatusInputOption);
            }
            clickModalTitle();
        }

        public void choosePaymentStatusInput(int statusValue)
        {
            clickPaymentStatusInput();
            String status = paymentStatuses[statusValue];
            System.out.println("Payment Status : " + status);
            paymentStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
            myActions.action_click(paymentStatusInputOption);
        }

        /*----------Functions----------*/

        public void downloadParcelHistory(int date1,String month1,int year1,int date2,String month2,int year2, int filterIndex,int paymentStatus, int ...deliveryStatuses)
        {
            chooseStartDate(date1,month1,year1);
            chooseEndDate(date2,month2,year2);
            chooseDateFilterType(filterIndex);
            chooseDeliveryStatusInputs(deliveryStatuses);
            switch (deliveryStatuses.length)
            {
                case 1:
                    if((statuses[deliveryStatuses[0]].equalsIgnoreCase("Delivery in Progress"))||(statuses[deliveryStatuses[0]].equalsIgnoreCase("Pickup Pending")))
                        break;
                        else choosePaymentStatusInput(paymentStatus);
                        break;

                case 2:
                    if((statuses[deliveryStatuses[0]].equalsIgnoreCase("Delivery in Progress"))||(statuses[deliveryStatuses[0]].equalsIgnoreCase("Pickup Pending")))
                        if((statuses[deliveryStatuses[1]].equalsIgnoreCase("Delivery in Progress"))||(statuses[deliveryStatuses[1]].equalsIgnoreCase("Pickup Pending")))
                            break;
                        else choosePaymentStatusInput(paymentStatus);
                    else choosePaymentStatusInput(paymentStatus);
                    break;
                default: choosePaymentStatusInput(paymentStatus);
            }
            clickDownloadCsvButton();
            clickCloseDownloadParcelHistoryModal();
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
            xpathSetter("//th[7]/i").click();
//            statusFilterDropDown = xpathSetter("//th[7]/i");
//            myActions.action_click(statusFilterDropDownOption);
        }

        public void chooseStatusFilterDropDownOption(String status)
        {
            statusFilterDropDownOption = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//span[contains(text(),'" + status + "')]/..");
            myActions.action_click(statusFilterDropDownOption);
        }

        public void clickOkButton()
        {
            okButton = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//a[contains(text(),'OK')]");
            myActions.action_click(okButton);
        }

        public void clickResetButton()
        {
            resetButton = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//a[contains(text(),'Reset')]");
            myActions.action_click(resetButton);
        }

        /*----------Functions----------*/

        public void filterByStatus(String status)
        {
            System.out.println("Status : " + status);
            clickStatusFilterDropDown();
            chooseStatusFilterDropDownOption(status);
            clickOkButton();
            waitForLoading();
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
            paymentStatusFilterDropDown = xpathSetter("//th[9]//i");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",paymentStatusFilterDropDown);
            xpathSetter("//th[9]//i").click();
//            paymentStatusFilterDropDown = xpathSetter("//th[9]//i");
//            myActions.action_click(paymentStatusFilterDropDownOption);
        }

        public void choosePaymentStatusFilterDropDownOption(String status)
        {
            paymentStatusFilterDropDownOption = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//span[contains(text(),'" + status + "')]/..");
            myActions.action_click(paymentStatusFilterDropDownOption);
        }

        public void clickOkButton()
        {
            okButton = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//a[contains(text(),'OK')]");
            myActions.action_click(okButton);
        }

        public void clickResetButton()
        {
            resetButton = xpathSetter("//div[contains(@class,'ant-dropdown')][not(contains(@class,'hidden'))]//a[contains(text(),'Reset')]");
            myActions.action_click(resetButton);
        }

        /*----------Functions----------*/

        public void scrollRight()
        {
            WebElement element = xpathSetter("//th//span[contains(text(),'Last Updated')]/../../..");
            try
            {
                element.click();
            } catch (Exception e)
            {
                System.out.println("Exception");
            }
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView",element);
        }
        public void filterByStatus(String status)
        {
            System.out.println("Payment Status : " + status);
            clickPaymentStatusFilterDropDown();
            choosePaymentStatusFilterDropDownOption(status);
            clickOkButton();
            waitForLoading();
        }

    }

    public class EditParcelPageObjects
    {

        /*----------Elements----------*/

        private WebElement editButton;
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
        private WebElement toastMsg;


        /*----------Actions----------*/

        public void clickEditButton(int index)
        {
//            xpathSetter("//div[@class='ant-table-fixed-right']//tbody/tr[" + index + "]//span[contains(text(),'Edit')]/..").click();
            editButton = xpathSetter("//div[@class='ant-table-fixed-right']//tbody/tr[" + index + "]//span[contains(text(),'Edit')]/..");
            myActions.action_click(editButton);
        }

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public void enterCustomerName(String name)
        {
            customerNameInput = xpathSetter("//div[@class='input-row'][1]//input");
            customerNameInput.clear();
            myActions.action_sendKeys(customerNameInput,name);
        }

        public void enterCustomerPhone(String phone)
        {
            customerPhoneInput = xpathSetter("//div[@class='input-row'][2]//input");
            customerPhoneInput.clear();
            myActions.action_sendKeys(customerPhoneInput,phone);
        }

        public void enterArea(String area)
        {
            areaInput = xpathSetter("//div[@class='input-row'][3]//input");
            areaInput.clear();
            myActions.action_sendKeys(areaInput,area);
        }

        public void enterAddress(String address)
        {
            addressInput = xpathSetter("//div[@class='input-row'][4]//textArea");
            addressInput.clear();
            myActions.action_sendKeys(addressInput,address);
        }

        public void enterAmount(int amount)
        {
            amountInput = xpathSetter("//div[@class='input-row'][5]//input");
            amountInput.clear();
            myActions.action_sendKeys(amountInput,Integer.toString(amount));
        }

        public void enterSellingPrice(int sellingPrice)
        {
            sellingPriceInput = xpathSetter("//div[@class='input-row'][6]//input");
            sellingPriceInput.clear();
            myActions.action_sendKeys(sellingPriceInput,Integer.toString(sellingPrice));
        }

        public void enterWeight(int weight)
        {
            weightInput = xpathSetter("//div[@class='input-row'][7]//input");
            weightInput.clear();
            myActions.action_sendKeys(weightInput,Integer.toString(weight));
        }

        public void enterInstructions(String instruction)
        {
            instructionsInput = xpathSetter("//div[@class='input-row'][8]//textArea");
            instructionsInput.clear();
            myActions.action_sendKeys(instructionsInput,instruction);
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//button/span[contains(text(),'Submit')]/..");
            myActions.action_click(submitButton);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//button/span[contains(text(),'Cancel')]/..");
            myActions.action_click(cancelButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeButton);
        }

        public String getToastMsg()
        {
            toastMsg = xpathPresenceSetter("//div[@class='ant-message-notice']//span");
            return  myActions.action_getText(toastMsg);
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

        private List<WebElement> elements;
        private WebElement exchangeButton;
        private WebElement modalTitle;
        private WebElement parcelIdValue;
        private WebElement customerNameValue;
        private WebElement customerPhoneValue;
        private WebElement amountInput;
        private WebElement createParcelButton;
        private WebElement cancelButton;
        private WebElement closeButton;
        private WebElement toastMsg;

        /*----------Actions----------*/

        public String clickExchangeButton()
        {
            elements = xpathListSetter("//div[@class='ant-table-fixed-right']//tbody/tr//button[not(@disabled)]//span[contains(text(),'Exchange')]/..");
            int size = elements.size();
            System.out.println("Size : " + size);
            if(size!=0)
            {
                myActions.action_click(elements.get(random.nextInt(size)));
                return "Parcels Found : " + size;
            }
            else return "No Parcels Found to perform Action";
        }

        public void clickExchangeButton(int index)
        {
            System.out.println("Index : " + index);
            exchangeButton = xpathSetter("//div[@class='ant-table-fixed-right']//tbody/tr[" + index + "]//span[contains(text(),'Exchange')]/..");
            myActions.action_click(exchangeButton);
        }

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

        public void enterAmount(String amount)
        {
            amountInput = xpathSetter("//div[@class='input-row']//input[@placeholder='Amount']");
            myActions.action_sendKeys(amountInput,amount);
        }

        public void clickCreateParcelButton()
        {
            createParcelButton = xpathSetter("//button/span[contains(text(),'Create Parcel')]/..");
            myActions.action_click(createParcelButton);
            waitForLoading();
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//button/span[contains(text(),'Cancel')]/..");
            myActions.action_click(cancelButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeButton);
        }

        public String getToastMsg()
        {
            toastMsg = xpathPresenceSetter("//div[contains(@class,'ant-message-notice')]//span");
            return  myActions.action_getText(toastMsg);
        }

        /*----------Functions----------*/

        public void waitForLoading()
        {
            try {
                WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@disabled]/span[contains(text(),'Create Parcel')]/..")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void exchangeParcel(String amount)
        {
            System.out.println("Parcel Id : " + getParcelIdValue());
            System.out.println("Customer Name : " + getCustomerNameValue());
            System.out.println("Customer Phone : " + getCustomerPhoneValue());
            System.out.println("Amount : " + amount);
            enterAmount(amount);
            clickCreateParcelButton();
//            clickCancelButton();
        }
    }

    public class DeleteParcelPageObjects
    {
        /*----------Elements----------*/

        private WebElement deleteButton;
        private WebElement popoverMessageTitle;
        private WebElement yesButton;
        private WebElement noButton;
        private WebElement alertMessage;

        /*----------Actions----------*/


        public void clickDeleteButton(int index)
        {
            deleteButton = xpathSetter("//div[@class='ant-table-fixed-right']//tbody/tr[" + index + "]//span[contains(text(),'Delete')]/..");
            myActions.action_click(deleteButton);
        }

        public String getPopoverMessageTitle()
        {
            popoverMessageTitle = xpathSetter("//div[@class='ant-popover-message-title']");
            return myActions.action_getText(popoverMessageTitle);
        }

        public void clickYesButton()
        {
            yesButton = xpathSetter("//div[@class='ant-popover ant-popover-placement-top']//button/span[contains(text(),'Yes')]/..");
            myActions.action_click(yesButton);
        }

        public void clickNoButton()
        {
            noButton = xpathSetter("//div[@class='ant-popover ant-popover-placement-top']//button/span[contains(text(),'No')]/..");
            myActions.action_click(noButton);
        }

        public String getAlertMessage()
        {
            alertMessage = xpathSetter("//span[@class='ant-alert-message']");
            return myActions.action_getText(alertMessage);
        }
    }

    public class RaiseIssuePageObjects
    {
        /*----------Elements----------*/

        private List<WebElement> elements;
        private WebElement raiseIssueButton;
        private WebElement modalTitle;
        private WebElement parcelId;
        private WebElement titleWrapper;
        private WebElement errorText;
        private List<WebElement> issueTypeButtons;
        private WebElement issueTypeButton;
        private WebElement issueType;
        private WebElement issueComment;
        private List<WebElement> buttons;
        private WebElement backButton;
        private WebElement confirmButton;
        private WebElement closeButton;
        private WebElement closeIcon;
        private WebElement toastMsg;


        /*----------Actions----------*/

        public void clickRaiseIssueButton()
        {
            elements = xpathListSetter("//div[@class='ant-table-fixed-right']//tbody/tr//button[not(@disabled)]//span[contains(text(),'Raise an Issue')]/..");
            int size = elements.size();
            myActions.action_click(elements.get(random.nextInt(size)));
        }

        public void clickRaiseIssueButton(int index)
        {
            raiseIssueButton = xpathSetter("//div[@class='ant-table-fixed-right']//tbody/tr[" + index + "]//span[contains(text(),'Raise an Issue')]/..");
            myActions.action_click(raiseIssueButton);
        }

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public String getParcelId()
        {
            parcelId = xpathSetter("//div[@class='ant-modal-title']//p/span");
            return myActions.action_getText(parcelId);
        }

        public String getTitleWrapper()
        {
            titleWrapper = xpathSetter("//div[@class='title-wrapper']/p[1]");
            String title = myActions.action_getText(titleWrapper);
            System.out.println("Title : " + title);
            return title;
        }

        public String getTitleWrapperClass()
        {
            titleWrapper = xpathSetter("//div[@class='ant-modal-body']//p[1]");
            return titleWrapper.getAttribute("class");
        }

        public String getIssueType()
        {
            issueType = xpathSetter("//div[@class='title-wrapper']/p[2]");
            return myActions.action_getText(issueType);
        }

        public String clickIssueType()
        {
            issueTypeButtons = xpathListSetter("//div[@class='ant-modal-body']//div[@class='issue-type']");
            int size = issueTypeButtons.size();
            int index = random.nextInt(size);
            String issueType =  xpathSetter("//div[@class='ant-modal-body']//div[@class='issue-type'][" + (index+1) + "]/span").getText();
            System.out.println("Issue Type : " + issueType);
            myActions.action_click(issueTypeButtons.get(index));
            return issueType;
        }

        public void clickIssueType(String issueType)
        {
            issueTypeButton = xpathSetter("//div[@class='issue-type']/span[contains(text(),'" + issueType + "')]/..");
            myActions.action_click(issueTypeButton);
        }

        public void enterIssueComment(String comment)
        {
            issueComment = xpathSetter("//div[@class='issue-types-wrapper']/textarea");
            myActions.action_sendKeys(issueComment,comment);
        }

        public int getButtons()
        {
            buttons = xpathListSetter("//div[@class='modal-footer']/button");
            return buttons.size();
        }

        public void clickBackButton()
        {
            backButton = xpathSetter("//div[@class='modal-footer']//span[contains(text(),'Back')]/..");
            myActions.action_click(backButton);
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathSetter("//div[@class='modal-footer']//span[contains(text(),'Confirm')]/..");
            myActions.action_click(confirmButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//div[@class='modal-footer']//span[contains(text(),'Close')]/..");
            myActions.action_click(closeButton);
        }

        public void clickCloseIcon()
        {
            closeIcon = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeIcon);
        }

        public String getToastMsg()
        {
            toastMsg = xpathPresenceSetter("//div[@class='ant-notification-notice-message']");
            return  myActions.action_getText(toastMsg);
        }

        public String getErrorText()
        {
            errorText = xpathSetter("//div[@class='issue-validation-wrapper']/p[1]");
            return myActions.action_getText(errorText);
        }

        /*----------Functions----------*/

        public String raiseIssue()
        {
            System.out.println("Parcel Id : " + getParcelId());
            String title = getTitleWrapper();
            int count=1;

            while(!title.equalsIgnoreCase("Issue:"))
            {
                System.out.println(count);
                clickIssueType();
                sleep(3000);
                if(count==3)
                    break;
                title = getTitleWrapper();
                count++;
            }

            switch (getButtons())
            {
                case 1:
                    System.out.println("Error Text : " + getErrorText());
                    return getErrorText();
                case 2:
                    enterIssueComment("Testing");
                    clickConfirmButton();
                    return getToastMsg();
                default: return "Error";
            }
        }
    }

}




