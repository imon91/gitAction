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

    private WebElement shop;
    private WebElement shop1;
    private WebElement shop2;
    private WebElement shop3;
    private List<WebElement> shops;
    private List<WebElement> editShopIcon;
    private List<WebElement> deliveryZoneDropDownWhileEditShop;
    private List<WebElement> locationDropDownWhileEditShop;
    private WebElement saveButtonWhileEditShop;

    public void clickShopByName(String name)
    {
        System.out.println("Changing Shop Name");
        shop = xpathSetter("//div[@class='shoplist']/div/div//p[text()='" + name + "']/..");
        myActions.action_click(shop);
    }

    public void clickOnShop(int index)
    {
        shops = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));

        myActions.action_click(shops.get(++index));
    }

    public void clickOnEditShopIcon(int index)
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']//div[@class='action-icon-wrapper']/*"));
        //EditButton was less than shopList
        myActions.action_click(editShopIcon.get(index));
        sleep(2000);
    }

    public void clickOnNewShopIcon()
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));
        myActions.action_click(editShopIcon.get(0));
    }

    public void enterAndApplyAreaOnEditShop(String division,String District,String areaTerm)
    {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div"))).click();
        sleep(1500);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(division);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(District);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(areaTerm);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));

    }

    public void enterFullName(String name)
    {
        WebElement fullName = xpathSetter("//input[@type='text'][@name='name']");
        myActions.action_sendKeys(fullName,name);
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

    public void editShopDetails(int shopIndex,String division,String district,String areaTerm,String name)
    {
        clickOnEditShopIcon(shopIndex);
        enterAndApplyAreaOnEditShop(division,district,areaTerm);
        enterFullName(name);
        sleep(500);
        clickOnSaveButtonWhileEditShop();
        sleep(1000);
    }
}
