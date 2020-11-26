package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;
import java.util.*;

public class MyShopsPageObjects extends RedXWebBaseClass{
    private WebDriver driver;
    private MyActions myActions;

    public MyShopsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private WebElement shop1;
    private WebElement shop2;
    private WebElement shop3;
    private List<WebElement> shop;
    private List<WebElement> editShopIcon;
    private List<WebElement> deliveryZoneDropDownWhileEditShop;
    private List<WebElement> locationDropDownWhileEditShop;
    private WebElement saveButtonWhileEditShop;



    public void clickOnShop(int index)
    {
        shop = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));

        myActions.action_click(shop.get(++index));
    }

    public void clickOnEditShopIcon(int index)
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']//div[@class='action-icon-wrapper']/img"));
        //EditButton was less than shopList
        myActions.action_click(editShopIcon.get(index));
    }

    public void clickOnNewShopIcon()
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));
        myActions.action_click(editShopIcon.get(0));
    }

    public void enterAndApplyAreaOnEditShop(String areaTerm,int index)
    {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select ant-select-enabled ant-select-no-arrow']"))).click();
        sleep(1500);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='required css-37yrso']//input"))).sendKeys(areaTerm);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//ul[@class='ant-select-dropdown-menu-item-group-list']/li"));
        myActions.action_click(locationDropDownWhileEditShop.get(index));

    }

    public void selectTheDeliveryZone(int ID_SU_OD)
    {
        WebElement dropDownButton = driver.findElement(By.xpath("//div[@class='ant-select ant-select-enabled']/div"));
        myActions.action_click(dropDownButton);
        deliveryZoneDropDownWhileEditShop = driver.findElements(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']/div[1]/ul/li"));
        sleep(500);
        myActions.action_click(deliveryZoneDropDownWhileEditShop.get(ID_SU_OD));
    }

    public void clickOnSaveButtonWhileEditShop()
    {
        saveButtonWhileEditShop = driver.findElement(By.xpath("//div[@class='form-wrapper']//button"));
        myActions.action_click(saveButtonWhileEditShop);
    }



    /**************************ISSUE Automation special functions**********************/
    public void clickOnShop1KALABAGAN()
    {
        shop1 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][2]/div[1]/div[1]"));
        myActions.action_click(shop1);
    }

    public void clickOnShop2NARORE()
    {
        shop2 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][3]/div[1]/div[1]"));
        myActions.action_click(shop2);
    }
    public void clickOnShop3SAVAR()
    {
        shop3 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][4]/div[1]/div[1]"));
        myActions.action_click(shop3);
    }

    public void editShopDetails(int shopIndex,String areaTerm,int areaIndex,int zoneIndex_ID_SU_OD)
    {
        clickOnEditShopIcon(shopIndex);
        enterAndApplyAreaOnEditShop(areaTerm,areaIndex);
        selectTheDeliveryZone(zoneIndex_ID_SU_OD);
        sleep(500);
        clickOnSaveButtonWhileEditShop();
        sleep(1000);
    }
}
