package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class CheckoutAddressPageObjects extends AndroidBaseClass{


    // Cart/MyBag os completely a WebView

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;

    public CheckoutAddressPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }

    @FindBy(xpath = "//div[@class='summary-container']/div[2]//p/span[1]")
    private WebElement cartValueLabelText;

    @FindBy(xpath = "//div[@class='summary-container']/div[2]//p/span[3]/span[2]")
    private WebElement totalItemsCountValue;

    @FindBy(xpath = "(//button[contains(text(),'Proceed to Payment')])[1]")
    private WebElement proceedToPaymentButtonTop;

    @FindBy(xpath = "(//button[contains(text(),'Proceed to Payment')])[2]")
    private WebElement proceedToPaymentButtonBottom;


    public String getCartValueLabelText(){
        return myActions.action_getText(cartValueLabelText);
    }

    public String getTotalItemsCountValue(){
        return myActions.action_getText(totalItemsCountValue);
    }

    public void clickOnProceedToPaymentTopButton(){
        myActions.action_click(proceedToPaymentButtonTop);
    }

    public void clickOnProceedToPaymentBottomButton(){
        myActions.action_click(proceedToPaymentButtonBottom);
    }


    public class SelectAddress{

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public SelectAddress(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@class='select_address_heading']/p")
        private WebElement selectAddressHeadingText;

        @FindBys(@FindBy( xpath = "//div[@class='select_address_inputs']//li"))
        private List<WebElement> inputAddress;

        @FindBy(xpath = "//div[@class='showMore-address']/span[1]/span[1]")
        private WebElement showMoreAddress;

        @FindBy(xpath = "//div[@class='showMore-address']/span[2]")
        private WebElement addNewAddress;


        public String getSelectAddressHeadingText(){
            return myActions.action_getText(selectAddressHeadingText);
        }

        public List<WebElement> getListOfVisibleAddress(){
            return inputAddress;
        }

        public void clickOnShowMoreAddress(){
            myActions.action_click(showMoreAddress);
        }

        public void clickOnAddNewAddress(){
            myActions.action_click(addNewAddress);
        }

        public void selectAnAddress(WebElement address){
            myActions.action_click(address);
        }


        public class AddressField{


            private AndroidDriver<WebElement> androidDriver;
            private MyActions myActions;

            public AddressField(AndroidDriver<WebElement> androidDriver){
                this.androidDriver = androidDriver;
                PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
                myActions = new MyActions();
            }


            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[1]/span[2]"))
            private List<WebElement> firstNameList;

            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[1]/span[4]"))
            private List<WebElement> lastNameList;

            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[4]/span[2]"))
            private List<WebElement> chooseAreaList;

            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[2]/span[2]"))
            private List<WebElement> addressList;

            @FindBys(@FindBy( xpath = ""))
            private List<WebElement> localityList;

            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[3]"))
            private List<WebElement> landMarkList;

            @FindBys(@FindBy( xpath = "//div[@class='address-field']/p[5]/span[2]"))
            private List<WebElement> phoneNumberList;

            @FindBys(@FindBy( xpath = ""))
            private List<WebElement> alternatePhoneList;

            @FindBys(@FindBy( xpath = "//div[@class='edit-delete-address']/span"))
            private List<WebElement> deleteButtonList;

            @FindBys(@FindBy( xpath = "//p[@class='edit-delete ']"))
            private List<WebElement> editAddressButtonList;


            public List<WebElement> getListOfFulName(){
                return firstNameList;
            }

            public List<WebElement> getListOfLastName(){
                return lastNameList;
            }

            public List<WebElement> getListOfChooseArea(){
                return chooseAreaList;
            }

            public List<WebElement> getListOfAddress(){
                return addressList;
            }

            public List<WebElement> getListOfLocality(){
                return localityList;
            }

            public List<WebElement> getListOfLandMark(){
                return landMarkList;
            }

            public List<WebElement> getLisOfPhoneNumber(){
                return phoneNumberList;
            }

            public List<WebElement> getListOfAlternatePhone(){
                return alternatePhoneList;
            }

            public List<WebElement> getListOfDeleteButtons(){
                return deleteButtonList;
            }

            public List<WebElement> getListOfEditAddressButtons(){
                return editAddressButtonList;
            }

            public void clickOnDeleteAddressButton(WebElement deleteButton){
                myActions.action_click(deleteButton);
            }

            public void clickOnEditAddressButton(WebElement editButton){
                myActions.action_click(editButton);
            }
        }
    }


    public class EstimatedDeliveryDates{

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public EstimatedDeliveryDates(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@class='estimated_delivery_dates']")
        private WebElement estimateDeliveryDatesLabelText;

        @FindBys(@FindBy( xpath = "//div[@class='estimated_delivery_dates']//li"))
        private List<WebElement> estimatedDeliveryList;


        public String getEstimateDeliveryDatesLabelText(){
            return myActions.action_getText(estimateDeliveryDatesLabelText);
        }

        public List<WebElement> getListOfEstimatedDeliveryItems(){
            return estimatedDeliveryList;
        }

        public class EstimatedDeliveryDatesItems{

            private AndroidDriver<WebElement> androidDriver;
            private MyActions myActions;

            public EstimatedDeliveryDatesItems(AndroidDriver<WebElement> androidDriver){
                this.androidDriver = androidDriver;
                PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
                myActions = new MyActions();
            }


            @FindBys(@FindBy( xpath = "//div[@class='image_est-del']/img"))
            private List<WebElement> estimatedDeliveryImagesList;

            @FindBys(@FindBy( xpath = "//div[@class='image_est-del']/ancestor::div[1]/following-sibling::div[1]/p[1]/span"))
            private List<WebElement> deliveryInWorkingDaysList;

            @FindBys(@FindBy( xpath = "//div[@class='image_est-del']/ancestor::div[1]/following-sibling::div[1]/p[2]/span"))
            private List<WebElement> estimatedDeliveryItemDeleteList;


            public List<WebElement> getListOfEstimatedDeliveryImages(){
                return estimatedDeliveryImagesList;
            }

            public List<WebElement> getListOfDeliveryInWorkingDays(){
                return deliveryInWorkingDaysList;
            }

            public List<WebElement> getListOfEstimatedDeliveryItemDelete(){
                return estimatedDeliveryItemDeleteList;
            }

            public String getEstimatedDeliveryImageUrl(WebElement imageElement){
                return imageElement.getAttribute("src");
            }

            public String getDeliveryInWorkingDaysText(WebElement deliveryInWorkingDaysElement){
                return myActions.action_getText(deliveryInWorkingDaysElement);
            }

            public void clickOnEstimatedDeliveryItem(WebElement estimatedDeliveryItem){
                myActions.action_click(estimatedDeliveryItem);
            }

        }

    }

}