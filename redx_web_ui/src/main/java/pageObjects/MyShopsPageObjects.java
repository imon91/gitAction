package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class MyShopsPageObjects {
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



    public void clickOnShop(int index)
    {
        shop = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));

        myActions.action_click(shop.get(++index));
    }

    public void clickOnEditShopIcon(int index)
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));
        myActions.action_click(editShopIcon.get(++index));
    }

    public void clickOnNewShopIcon()
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));
        myActions.action_click(editShopIcon.get(0));
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
}
