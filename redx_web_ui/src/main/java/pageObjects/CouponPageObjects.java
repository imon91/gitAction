package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.List;

public class CouponPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;

    public CouponPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement titleWrapper;
    private List<WebElement> coupons;
    private WebElement couponId;
    private WebElement couponDescription;
    private WebElement couponExpireDate;
    private WebElement couponStatus;
    private WebElement couponCodeInput;
    private WebElement applyButton;
    private WebElement toastMsg;

    /*----------Actions----------*/

    public String getTitleWrapper()
    {
        titleWrapper = xpathSetter("//div[@class='padding-bottom-for-title']/p");
        return myActions.action_getText(titleWrapper);
    }

    public int getCouponSize()
    {
        coupons = xpathListSetter("//tbody/tr");
        return coupons.size();
    }

    public String getCouponID(int index)
    {
        couponId = xpathSetter("//tbody/tr[" + index + "]/td[1]/span");
        return myActions.action_getText(couponId);
    }

    public String getCouponDescriptionValue(int index)
    {
        couponDescription = xpathSetter("//tbody/tr[" + index + "]//p[@class='coupon-details__title']");
        return myActions.action_getText(couponDescription);
    }

    public String getCouponExpireDate(int index)
    {
        couponExpireDate = xpathSetter("//tbody/tr[" + index + "]/td[3]");
        return myActions.action_getText(couponExpireDate);
    }

    public String getCouponStatus(int index)
    {
        couponStatus = xpathSetter("//tbody/tr[" + index + "]/td[4]/span");
        return myActions.action_getText(couponStatus);
    }

    public void enterCouponCodeInput(String couponID)
    {
        couponCodeInput = xpathSetter("//div[@class='coupon-code__inpput']/input");
        myActions.action_sendKeys(couponCodeInput,couponID);
    }

    public void clickOnApplyButton()
    {
        applyButton = xpathSetter("//div[@class='coupon-code__btn__wrapper']/button");
        myActions.action_click(applyButton);
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        return myActions.action_getText(toastMsg);
    }

}
