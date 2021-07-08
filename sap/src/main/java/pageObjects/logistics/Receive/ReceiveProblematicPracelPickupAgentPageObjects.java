package pageObjects.logistics.Receive;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.SapBaseClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReceiveProblematicPracelPickupAgentPageObjects extends SapBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ReceiveProblematicPracelPickupAgentPageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement titleValue;
    private WebElement searchBarInput;
    private WebElement chooseAgentInput;
    private WebElement assignedParcelsValue;
    private WebElement deliveredParcelsValue;
    private WebElement scannedParcelsValue;
    private WebElement parcel;
    private WebElement dropDownOption;
    private WebElement modalCloseButton;
    private WebElement problematicStatusDropDownOption;
    private WebElement problematicStatusDropDown;
    private WebElement cashReceivedValue;
    private WebElement cashReceivedButton;
    private WebElement yesButton;
    private WebElement returnButton;
    private WebElement printButton;
    private WebElement returnTitle;
    private WebElement updateDateButton;
    private WebElement latestTrackingid;
    private WebElement shopUpReturnedButton;
    private WebElement shopUpReturnedYesButton;
    private WebElement getTextPrintButton;
    private List <WebElement> afterSearch;
    private List<WebElement> trackingIds;

    private String[] problematicStatuses = {"Return","Hold","Problematic"};


    /*----------Actions----------*/

    public void enterSearchBar(String searchTerm)
    {
        searchBarInput = xpathSetter("//input[@ng-model='freshQuery']");
        searchBarInput.clear();
        myActions.action_sendKeys(searchBarInput,searchTerm);
    }

    public ArrayList<String>  getTranckingId() {

        //small
        ArrayList<String> allTrackingId = new ArrayList<String>();
        trackingIds = xpathListSetter("//small");

        for (WebElement webElement : trackingIds) {
            String name = myActions.action_getText(webElement);
            allTrackingId.add(name);
            System.out.println("Tacking id all of UI  "+name);
        }
        System.out.println("from page objet all tracking id size"+allTrackingId.size());
        return allTrackingId;


    }
    public void clickShopUpReturnedButton(){

        shopUpReturnedButton = xpathSetter("//button[contains(.,'ShopUp Returned')]");
        myActions.action_click(shopUpReturnedButton);
        shopUpReturnedYesButton = xpathSetter("//button[contains(.,'Yes')]");
        myActions.action_click(shopUpReturnedYesButton);


    }

    public int countReturnNumber(){

        assignedParcelsValue = xpathSetter("//div[@class='panels']/div[2]//div[@class='header-right']/div");
        String value = myActions.action_getText(assignedParcelsValue);

        int position = value.indexOf('/');
        //System.out.println("total hold  Postion"+  position);
        //System.out.println("total of hold size"+value.length());
        System.out.println(value);
        String count = value.substring(0,position);
        //System.out.println("total of Hold........ "+count);
        int number = Integer.parseInt(count.trim());
        return number;

    }

    public String clickReturnButton(String section,int index) {

        System.out.println("section will be "+section);
        //holdButton=xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'unassignedParcels ')][1]//button[contains(text(),'Hold')]");
        returnButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+ "')]["+index+"]//button[contains(text(),'Returned')]");
        myActions.action_click(returnButton);
        String getTitle = returnedTitle();
        return getTitle;

    }

    public String returnedTitle(){
        returnTitle = xpathSetter("//span[@class='ng-binding']");
        String title =myActions.action_getText(returnTitle);
        return title;
    }

    public int getCountAfterSearchInput(){
        int count = xpathListSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'unassignedParcels')]").size();
        searchBarInput.clear();
        return count;

    }

    public int[] getAssignedParcelsValue()
    {
        assignedParcelsValue = xpathSetter("//div[@class='panels']/div[1]//div[@class='header-right']/div");
        String value = myActions.action_getText(assignedParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }

    public int getNumberOfAssignParcel(){
        assignedParcelsValue = xpathSetter("//div[@class='panels']/div[1]//div[@class='header-right']/div");
        String value = myActions.action_getText(assignedParcelsValue);

        int position = value.indexOf('/');
        System.out.println("total Postion"+  position);
      System.out.println("total of text size"+value.length());
        System.out.println(value);
        String count = value.substring(position+1,value.length());
//        System.out.println("total Postion"+  position);
//        System.out.println("total of text size"+value.length());
        System.out.println("total of text "+count);

        int number = Integer.parseInt(count.trim());

        return number;

    }


    public int[] getDeliveredParcelsValue()
    {
        deliveredParcelsValue = xpathSetter("//div[@class='panels']/div[2]//div[@class='header-right']/div");
        String value = myActions.action_getText(deliveredParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }

    public int[] getProblematicParcelsValue()
    {
        scannedParcelsValue = xpathSetter("//div[@class='panels']/div[3]//div[@class='header-right']/div");
        String value = myActions.action_getText(scannedParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }



    public void clickParcel(String section,int index)
    {
        //div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'returnHoldParcels')]

        parcel = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+"')]["+ index +"]");
        myActions.action_click(parcel);
    }

    public String  getLatestTrackingID(String section,int index){
        //div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'unassignedParcels')][1]//small

        latestTrackingid = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+"')]["+ index +"]//small");
        String id =myActions.action_getText(latestTrackingid);
        return id;
    }


    public void clickModalCloseButton()
    {
        modalCloseButton = xpathSetter("//button[text()='Close']");
        myActions.action_click(modalCloseButton);
    }

    public void clickDropDownOptionByTitle(String option)
    {
        dropDownOption = xpathSetter("//a[@title='" + option.trim() + "']");
        myActions.action_click(dropDownOption);
    }


    public void ProblematicStatus(String option)
    {
        System.out.println("Status : " + option);
        problematicStatusDropDownOption = xpathSetter("//div[@class='bottom']//button[contains(text(),'"+option+"')]");
        myActions.action_click(problematicStatusDropDownOption);
    }

    public String chooseProblematicStatus()
    {
        int index = random.nextInt(2);
        String status = problematicStatuses[index];
        ProblematicStatus(status);
        return status;
    }


    public int getCashReceivedValue()
    {
        cashReceivedValue = xpathSetter("//div[@class='receiving-footer']//h5[contains(text(),'Cash Received')]");
        String value = myActions.action_getText(cashReceivedValue);
        return Integer.parseInt(value.substring(16));
    }

    public void clickCashReceivedButton()
    {
        cashReceivedButton = xpathSetter("//button[contains(text(),'Cash Received')]");
        myActions.action_click(cashReceivedButton);
        clickYesButton();
    }
    public void clickYesButton()
    {
        yesButton = xpathSetter("//button[contains(text(),'Yes')]");
        myActions.action_click(yesButton);
    }


    public void clickPrintButton(String section,int index)
    {
        clickParcel(section, index);
        printButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(@ng-click,'print')]");
        myActions.action_click(printButton);
    }

    public String getPopUpTextClickPrintButton(){
        getTextPrintButton=  xpathSetter("//span[@class='ng-binding']");
        String text = myActions.action_getText(getTextPrintButton);
        return text;

    }

    public void waitForLoading()
    {
        int size =0;
        int count = 0;
        while(size<3)
        {
            count++;
            assignedParcelsValue = xpathSetter("//div[@class='panels']/div[1]//div[@class='header-right']/div");
            String value = myActions.action_getText(assignedParcelsValue);
            size = value.length();
//            System.out.println(value + " : " + value.length());
            if(count>20)
                break;
        }
    }

    public String getCurrentDateTime()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = currentDate.format(format);
//        System.out.println("Current Date Time Actual: " + currentDate.format(formatter));
        return date;
    }



    //div[@class='bottom']//button[contains(text(),'Hold')]


//    public void clickProblematicStatusDropDown()
//    {
//        problematicStatusDropDown = xpathSetter("//select[@ng-model='chosenReason']");
//        myActions.action_click(problematicStatusDropDown);
//    }

//select[@ng-model='chosenReason']/option[@label='পার্সেলটি ত্রুটিপূর্ণ থাকায় মার্চেন্ট রিসিভ করেন নি']

//    public void chooseProblematicStatusDropDownOption(String option)
//    {
//        System.out.println("Status : " + option);
//        clickProblematicStatusDropDown();
//        problematicStatusDropDownOption = xpathSetter("//select[@ng-model='chosenReason']/option[@label='" + option + "']");
//        myActions.action_click(problematicStatusDropDownOption);
//    }
    public class RaiseIssueModalPageObjects {
    private WebElement raiseIssueButton;
    private WebElement issueTypeTitle;
    private WebElement agentInput;
    private WebElement descriptionInput;
    private WebElement raiseIssueSubmitButton;
    private List<WebElement> issueTypes;

    public void clickRaiseIssueButton(String section, int index) {
        clickParcel(section, index);
        raiseIssueButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(@ng-click,'raiseIssue')]");
        myActions.action_click(raiseIssueButton);
    }

    public String getModalTitle() {
        issueTypeTitle = xpathSetter("//div[@class='modal-body']//h4/span[not(contains(@class,'hide'))]");
        System.out.println(myActions.action_getText(issueTypeTitle));
        return myActions.action_getText(issueTypeTitle);
    }

    public void enterAgentInput(String agentName) {
        myActions.action_click(xpathSetter("//input[@placeholder='Select Agent']/.."));
        sleep(1000);
        agentInput = xpathSetter("//input[@placeholder='Select Agent']");
        sleep(3000);
        myActions.action_sendKeys(agentInput, agentName);
        sleep(1000);
        agentInput.sendKeys(Keys.ENTER);
    }



    public void enterDescriptionInput(String input) {
        descriptionInput = xpathSetter("//div[@class='modal-body']//textarea");
        myActions.action_sendKeys(descriptionInput, input);
    }

    public void clickRaiseIssueSubmitButton() {
        raiseIssueSubmitButton = xpathSetter("//div[@class='modal-body']//button[@type='submit']");
        myActions.action_click(raiseIssueSubmitButton);
    }

    public void performRaiseIssue(String section, String agentName) {
        //System.out.println("Performing Raise Issue for " + trackingId);
//        switch (section) {
//            case "unassigned":
//                enterSearchBar("unscanned",trackingId);
//                break;
//            case "delivered":
//                break;
//            case "problematic":
//                enterSearchBar("scanned",trackingId);
//                break;
//        }
        clickRaiseIssueButton(section, 1);
        String title;
        do {
            //driver.navigate().refresh();
            issueTypes = xpathListSetter("//div[@class='issue-tree']/div");
            //issueTypes = xpathListSetter("/html/body/div[1]/div/div/div/div/div/form/div[1]/div[1]");
            int issues = issueTypes.size();
            int issue = random.nextInt(issues);
            myActions.action_click(issueTypes.get(issue));
            title = getModalTitle();
        } while (title.equalsIgnoreCase("Select an Issue Type"));
        enterAgentInput(agentName);
        enterDescriptionInput("Test");
        clickRaiseIssueSubmitButton();
    }

}

    public class HoldModalPageObjects{
        private WebElement holdButton;
        private WebElement reasonCategoryDropDown;
        private WebElement holdParcelButton;
        private WebElement reasonDropDown;
        private WebElement calenderIcon;
        private WebElement calenderDate;
        private WebElement getDeliveryDate;
        private WebElement holdDateChangeButton;
        private List<WebElement> reasonCategoryDropDownOptions;
        private List<WebElement> reasonDropDownOptions;

        public int countHoldNumber(){

            assignedParcelsValue = xpathSetter("//div[@class='panels']/div[3]//div[@class='header-right']/div");
            String value = myActions.action_getText(assignedParcelsValue);

            int position = value.indexOf('/');
            //System.out.println("total hold  Postion"+  position);
            //System.out.println("total of hold size"+value.length());
            System.out.println(value);
            String count = value.substring(0,position);
            //System.out.println("total of Hold........ "+count);
            int number = Integer.parseInt(count.trim());
            return number;

        }
        public void clickUpdateDateButton()
        {
            //updateDateButton = xpathSetter("//button[@type='button'])[2]");
            updateDateButton = xpathSetter("/html/body/div[1]/div/div/div/div/div/div[2]/button[2]");
            myActions.action_click(updateDateButton);
        }
        public void clickHoldButton(String section,int index) {
            System.out.println("section will be "+section);
            //holdButton=xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'unassignedParcels ')][1]//button[contains(text(),'Hold')]");
            holdButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+ "')]["+index+"]//button[contains(text(),'Hold')]");
            myActions.action_click(holdButton);
        }
        public void clickReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[1]");
            myActions.action_click(reasonCategoryDropDown);
        }

        public String chooseReasonCategoryOption()
        {
            clickReasonCategoryDropDown();
            reasonCategoryDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[1]/option");
            int size = reasonCategoryDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reasonCategory = myActions.action_getText(reasonCategoryDropDownOptions.get(index));
            myActions.action_click(reasonCategoryDropDownOptions.get(index));
            return  reasonCategory;
        }
        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[2]");
            myActions.action_click(reasonDropDown);
        }

        public String chooseReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[2]/option");
            int size = reasonDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reason = myActions.action_getText(reasonDropDownOptions.get(index));
            myActions.action_click(reasonDropDownOptions.get(index));
            return  reason;
        }


        public void clickHoldParcelButton()
        {
            holdParcelButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'Hold parcel')]");
            myActions.action_click(holdParcelButton);
        }

        public void clickHoldDateChange(String section,int index){
            holdDateChangeButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+ "')]["+index+"]//button[contains(text(),'Hold: Date Change')]");
            myActions.action_click(holdDateChangeButton);

        }

        public void clickCalenderIconForHold(String date){
            calenderIcon= xpathSetter("//span[@class='input-group-btn']");
            myActions.action_click(calenderIcon);
            calenderDate = xpathSetter("//span[contains(.,'"+date+"')]");
            myActions.action_click(calenderDate);


        }

        public String  getDateFromHoldSection(String section,int index){

            getDeliveryDate=  xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'"+section+"')]["+index+"]//p[@class='ng-binding']");

            String dateContext = myActions.action_getText(getDeliveryDate);
            System.out.println(dateContext);
            String target=dateContext.copyValueOf("Delivery Date:".toCharArray());
            String newdateContext=dateContext.replace(target, "");
            return newdateContext;

        }

        public void performDateChange(String section,int index,String date){
            clickHoldDateChange(section,1);
            clickCalenderIconForHold(date);
            //clickHoldDateChange(section,1);
            clickUpdateDateButton();

        }



        public List<String> performHoldParcel(String section)
        {
            List<String> reason = new ArrayList<>();
            //System.out.println("Performing Hold Parcel for " + trackingId);
//            switch (section) {
//                case "unassigned":
//                    enterSearchBar("unscanned",trackingId);
//                    clickHoldButton(section,1);
//                    break;
//                case "delivered":
//                    int index = new ReceiveDeliveryAgentsParcelPageObjects.ParcelDetailsPageObjects().getIndexValue(section,trackingId);
//                    clickParcel(section,index);
//                    clickHoldButton(section,index);
//                    if(!isCtAgent)
//                        return null;
//                    break;
//                case "problematic":
//                    enterSearchBar("scanned",trackingId);
//                    clickHoldButton(section,1);
//                    if(!isCtAgent)
//                        return null;
//                    break;
//            }

            clickHoldButton(section,1);
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickHoldParcelButton();
            return reason;
        }
    }


    public  class ProlematicModal{
        private WebElement problematicButton;
        private WebElement updateproblematicButton;
        private WebElement reasonCategoryDropDown;
        private WebElement IssueCount;
        private WebElement reasonDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private List<WebElement> reasonDropDownOptions;

        public int countProlematicNumber(){
            assignedParcelsValue = xpathSetter("//div[@class='panels']/div[4]//div[@class='header-right']/div");
            String value = myActions.action_getText(assignedParcelsValue);
            int position = value.indexOf('/');
            System.out.println(value);
            String count = value.substring(0,position);
            int number = Integer.parseInt(count.trim());
            return number;

        }


        public void clickProblematicButton(String section,int index){
            //div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'Hold')]["1"]//button[contains(text(),'Problematic')]
            problematicButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Problematic')]");
            myActions.action_click(problematicButton);
        }
        public void clickReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[1]");
            myActions.action_click(reasonCategoryDropDown);
        }
        public String chooseReasonCategoryOption()
        {
            clickReasonCategoryDropDown();
            reasonCategoryDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[1]/option");
            int size = reasonCategoryDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reasonCategory = myActions.action_getText(reasonCategoryDropDownOptions.get(index));
            myActions.action_click(reasonCategoryDropDownOptions.get(index));
            return  reasonCategory;
        }
        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[2]");
            myActions.action_click(reasonDropDown);
        }
        public String chooseReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[2]/option");
            int size = reasonDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reason = myActions.action_getText(reasonDropDownOptions.get(index));
            myActions.action_click(reasonDropDownOptions.get(index));
            return  reason;
        }
        public void updateProblematicParcelButton()
        {
            updateproblematicButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'Update Parcel')]");
            myActions.action_click(updateproblematicButton);
        }

        public String prolematicIssueCount(){
            //section[@class='scanned-section']/div[@class='section-header']/div[@class='header-right']/div[@class='ng-binding']
            IssueCount = xpathSetter("//section[@class='scanned-section']/div[@class='section-header']/div[@class='header-right']/div[@class='ng-binding']");
            String text =  myActions. action_getText(IssueCount)     ;
            return text;


        }

        public List<String> performProblematicParcel(String section)
        {
            List<String> reason = new ArrayList<>();
            clickProblematicButton(section,1);
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            updateProblematicParcelButton();
            return reason;

        }


    }


}
