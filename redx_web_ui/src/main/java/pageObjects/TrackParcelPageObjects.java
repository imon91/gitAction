package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.RedXWebBaseClass;

import java.util.ArrayList;
import java.util.List;

public class TrackParcelPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public TrackParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement trackingId;
    private List<WebElement> trackingElements;
    private WebElement currentDateValue;
    private WebElement dateValues;

    /*----------Actions----------*/

    public String getTrackingId()
    {
        trackingId = xpathSetter("//div[@class='left-side']//div[@class='subtitle-wrapper']/p");
        return myActions.action_getText(trackingId);
    }

    public int getTrackingElementSize()
    {
        trackingElements = xpathListSetter("//div[@class='tracking-wrapper']/div/div");
        return trackingElements.size();
    }

    public String getCurrentDateValue()
    {
        currentDateValue = xpathSetter("//div[@class='tracking-wrapper']/div/div//span[@class='date current']");
        return myActions.action_getText(currentDateValue);
    }

    public String getDateValue(int index)
    {
        dateValues = xpathSetter("//div[@class='tracking-wrapper']/div/div[" + index + "]//span[@class='date']");
        return myActions.action_getText(dateValues);
    }

    /*----------Functions----------*/

    public List<String> getTrackingDateValues()
    {
        int i,index = getTrackingElementSize();
        List<String> dateValues = new ArrayList<>();
        for(i=0;i<index-1;i++)
        {
            String dateValue = getDateValue(index-i);
            System.out.println("Date in UI : " + dateValue);
            dateValues.add(dateValue);
        }
        dateValues.add(getCurrentDateValue());
        System.out.println("Date in UI : " + getCurrentDateValue());
        return dateValues;
    }

    /*----------Classes----------*/

    public class CustomerDetailsPageObjects
    {

        /*----------Elements----------*/

        private WebElement parcelIdValue;
        private WebElement customerAddressValue;
        private WebElement customerPhoneValue;
        private WebElement customerNameValue;
        private WebElement areaValue;
        private WebElement weightValue;
        private WebElement priceValue;
        private WebElement deliveryChargeValue;
        private WebElement codChargeValue;

        /*----------Actions----------*/


        public String getParcelIdValue()
        {
            parcelIdValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][1]//p[@class='subtitle']");
            return myActions.action_getText(parcelIdValue);
        }

        public String getCustomerAddressValue()
        {
            customerAddressValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][2]//p[@class='subtitle']");
            return myActions.action_getText(customerAddressValue);
        }

        public String getCustomerPhoneValue()
        {
            customerPhoneValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][3]//p[@class='subtitle']");
            return myActions.action_getText(customerPhoneValue);
        }

        public String getCustomerNameValue()
        {
            customerNameValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][4]//p[@class='subtitle']");
            return myActions.action_getText(customerNameValue);
        }

        public String getAreaValue()
        {
            areaValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][5]//p[@class='subtitle']");
            return myActions.action_getText(areaValue);
        }

        public String getWeightValue()
        {
            weightValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][6]//p[@class='subtitle']");
            return myActions.action_getText(weightValue);
        }

        public String getPriceValue()
        {
            priceValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][7]//p[@class='subtitle']");
            return myActions.action_getText(priceValue);
        }

        public String getDeliveryChargeValue()
        {
            deliveryChargeValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][8]//p[@class='subtitle']");
            return myActions.action_getText(deliveryChargeValue);
        }

        public String getCodChargeValue()
        {
            codChargeValue = xpathSetter("//div[@class='customer-info']//div[@class='info-wrapper'][9]//p[@class='subtitle']");
            return myActions.action_getText(codChargeValue);
        }

        /*----------Functions----------*/

        public void getCustomerDetailsValue()
        {
            List<String> customerDetailsValue = new ArrayList<>();
            customerDetailsValue.add(getParcelIdValue());
            customerDetailsValue.add(getCustomerAddressValue());
            customerDetailsValue.add(getCustomerPhoneValue());
            customerDetailsValue.add(getCustomerNameValue());
            customerDetailsValue.add(getAreaValue());
            customerDetailsValue.add(getWeightValue());
            customerDetailsValue.add(getPriceValue());
            customerDetailsValue.add(getDeliveryChargeValue());
            customerDetailsValue.add(getCodChargeValue());
            System.out.println(customerDetailsValue.toString());
        }
    }
}
