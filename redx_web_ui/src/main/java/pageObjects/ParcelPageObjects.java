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

    private WebElement previousPageIcon;
    private WebElement nextPageIcon;
    private WebElement nextFivePageIcon;
    private WebElement pageIcon;
    private WebElement lastPage;
    private WebElement activePage;

    /*----------Actions----------*/

    public void clickPrintLabelsButton()
    {
        printLabelsButton = xpathSetter("//button/span[contains(text(),'Print Labels')]/..");
        myActions.action_click(printLabelsButton);
    }

    public int getTotalParcelsCount()
    {
        String getText;
        totalParcelsValue = xpathSetter("//p[contains(text(),'Total')]");
        getText = myActions.action_getText(totalParcelsValue);
        return Integer.parseInt(getText.substring(7));
    }

    public void clickPreviousPageIcon()
    {
        previousPageIcon = xpathSetter("//ul[1]/li[@title='Previous Page']");
        myActions.action_click(previousPageIcon);
    }

    public int getActivePage()
    {
        activePage = xpathSetter("//ul[1]/li[contains(@class,'ant-pagination-item-active')]");
        return Integer.parseInt(activePage.getAttribute("title"));
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
        while((page!=1)&&((page>activePage+3)||(page<activePage-3))&&(page!=pages))
        {
            clickNextFivePageIcon();
            activePage = getActivePage();
        }
        pageIcon = xpathSetter("//ul[1]/li[@title='" + page + "']");
        myActions.action_click(pageIcon);
    }

    public int[] clickPageIcon()
    {
        int page[] = new int[2];
        int pages = getLastPage();
        page[0] = random.nextInt(pages);
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
    }

    public void clickNextPageIcon()
    {
        nextPageIcon = xpathSetter("//ul[1]/li[@title='Next Page']");
        myActions.action_click(nextPageIcon);
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

    /*------------------Classes----------------*/

    public class SearchByPageObjects
    {
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
            return myActions.action_getText(parcelIdButton);
        }

        public void clickParcelIdButton(int index)
        {
            parcelIdButton = xpathSetter("//tbody/tr[" + index + "]/td[4]//button   ");
            myActions.action_click(parcelIdButton);
            sleep(2000);
        }

        public String getInvoiceId(int index)
        {
            invoiceIdValue = xpathSetter("//tbody/tr[" + index + "]/td[4]/div[contains(text(),'Invoice ID')]");
            return myActions.action_getText(invoiceIdValue);
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

        public String getPaymentInfoValue(int index,int line)
        {
            paymentInfoValue = xpathSetter("//tbody/tr[" + index + "]/td[8]");
            List<String> info = Arrays.asList(myActions.action_getText(paymentInfoValue).split("\n"));
            return info.get(line-1);
        }

        public String getPaymentStatusValue(int index)
        {
            paymentStatusValue = xpathSetter("//tbody/tr[" + index + "]/td[9]/span");
            return myActions.action_getText(paymentStatusValue);
        }

        public String getPromoCodeDiscountValue(int index)
        {
            promoCodeDiscountValue = xpathSetter("//tbody/tr[" + index + "]/td[10]");
            return myActions.action_getText(promoCodeDiscountValue);
        }

        public String getMoreInfoValue(int index)
        {
            parcelDeliveryType = xpathSetter("//tbody/tr[" + index + "]/td[11]/div");
            return myActions.action_getText(parcelDeliveryType);
        }

        public String getParcelTypeValue(int index)
        {
            parcelTypeValue = xpathSetter("//tbody/tr[" + index + "]/td[11]/span");
            return myActions.action_getText(parcelTypeValue);
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
//                    dateTypeFilterInputOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='Creation Date']");
                    dateTypeFilterInputOption = xpathSetter("//li[text()='Creation Date']");
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
            clickDeliveryStatusInput();
            for(String status:deliveryStatus)
            {
                deliveryStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
                myActions.action_click(deliveryStatusInputOption);
            }
            clickModalTitle();
        }

        public void choosePaymentStatusInput(String status)
        {
            clickPaymentStatusInput();
            paymentStatusInputOption = xpathSetter("//li[@role='option'][text()='" + status + "']");
            myActions.action_click(paymentStatusInputOption);
        }

        /*----------Functions----------*/

        public void downloadParcelHistory(int date1,String month1,int year1,int date2,String month2,int year2, int filterIndex,String paymentStatus, String ...deliveryStatuses)
        {
            chooseStartDate(date1,month1,year1);
            chooseEndDate(date2,month2,year2);
            chooseDateFilterType(filterIndex);
            chooseDeliveryStatusInputs(deliveryStatuses);
            choosePaymentStatusInput(paymentStatus);
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
//            statusFilterDropDown = xpathSetter("//thead/tr[1]/th[7]/i[1]");
//            myActions.action_click(statusFilterDropDownOption);
        }

        public void chooseStatusFilterDropDownOption(String status)
        {
            statusFilterDropDownOption = xpathSetter("//body/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]");
//            System.out.println("List : " + statusFilterDropDownOption.getAttribute("role"));
            myActions.action_click(statusFilterDropDownOption);
        }

        public void clickOkButton()
        {
            okButton = xpathSetter("//body/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]");
            System.out.println("Ok Button : " + okButton.getText() );
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
            editButton = xpathSetter("//tbody/tr[1]/td[13]//button/span[contains(text(),'Edit')]/..");
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

        private WebElement exchangeButton;
        private WebElement modalTitle;
        private WebElement parcelIdValue;
        private WebElement customerNameValue;
        private WebElement customerPhoneValue;
        private WebElement amountInput;
        private WebElement createParcelButton;
        private WebElement cancelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public void clickExchangeButton(int index)
        {
            exchangeButton = xpathSetter("//tbody/tr[1]/td[13]//button/span[contains(text(),'Exchange')]/..");
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

        public void exchangeParcel(String amount)
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

        private WebElement deleteButton;
        private WebElement popoverMessageTitle;
        private WebElement yesButton;
        private WebElement noButton;

        /*----------Actions----------*/

        public void clickDeleteButton(int index)
        {
            deleteButton = xpathSetter("//tbody/tr[1]/td[13]//button/span[contains(text(),'Delete')]/..");
            myActions.action_click(deleteButton);
        }

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

    public class RaiseIssuePageObjects
    {
        /*----------Elements----------*/

        private WebElement raiseIssueButton;
        private WebElement modalTitle;
        private WebElement titleWrapper;
        private List<WebElement> issueTypeButton;
        private WebElement backButton;
        private WebElement confirmButton;
        private WebElement closeButton;


        /*----------Actions----------*/

        public void clickRaiseIssueButton(int index)
        {
            raiseIssueButton = xpathSetter("//tbody/tr[1]/td[13]//button/span[contains(text(),'Raise an Issue')]/..");
            myActions.action_click(raiseIssueButton);
        }

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            System.out.println("Modal Title : " + myActions.action_getText(modalTitle));
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p/span");
            return myActions.action_getText(modalTitle);
        }

        public String getTitleWrapper()
        {
            titleWrapper = xpathSetter("//div[@class='title-wrapper']/p");
            return myActions.action_getText(titleWrapper);
        }

        public void clickIssueType(String issueType)
        {
            issueTypeButton = xpathListSetter("//div[@class='ant-modal-body']//div[@class='issue-type']");
            int size = issueTypeButton.size();
        }

        public void clickBackButton()
        {
            backButton = xpathSetter("//div[@class='modal-footer']//span[contains(text(),'Back')]/..");
            myActions.action_click(backButton);
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathSetter("//div[@class='modal-footer']//span[contains(text(),'Confirm')]");
            myActions.action_click(confirmButton);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeButton);
        }
    }

}


