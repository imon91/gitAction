package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class CouponPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;

    public CouponPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private List<WebElement> couponIDList;
    private List<WebElement> couponStatusList;
    private WebElement couponText;
    private WebElement applyButton;

    public String getCouponID(int index)
    {
        couponIDList = xpathListSetter("//div[@class='ant-table-body']/table/tbody/tr/td[1]");
        return myActions.action_getText(couponIDList.get(index));
    }

    public String getCouponStatus(int index)
    {
        couponStatusList = xpathListSetter("//div[@class='ant-table-body']/table/tbody/tr/td[4]");
        return myActions.action_getText(couponStatusList.get(index));
    }

    public void enterCouponText(String couponID)
    {
        couponText = xpathSetter("//div[@class='coupon-code__inpput']/input");
        myActions.action_sendKeys(couponText,couponID);
    }

    public void clickOnApplyButton()
    {
        applyButton = xpathSetter("//div[@class='coupon-code__btn__wrapper']/button");
        myActions.action_click(applyButton);
    }



}
