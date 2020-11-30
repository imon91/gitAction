package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;
import java.util.*;


public class CreateParcelPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private HomePageObjects homePageObjects;

    public CreateParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        homePageObjects = new HomePageObjects(driver);
    }



    private WebElement editNameText;
    private WebElement editAddressText;
    private WebElement editMobileText;
    private WebElement editAmount;
    private WebElement editSellingPriceText;
    private WebElement editAreaText;
    private List<WebElement> areaDropDown;
    private List<WebElement> acknowledgeBoxButton;
    private WebElement newParcelSubmitButton;
    private WebElement deliveryCharge;
    private WebElement CODCharge;
    private WebElement deliveryOnChargeParcelPage;
    private WebElement parcelPopup;



    /*********************Actions*********************/

    public void enterCustomerName(String name)
    {
        editNameText = driver.findElement(By.xpath("//div[@class='left-form']/div[1]/input"));
        editNameText.clear();
        myActions.action_sendKeys(editNameText,name);
    }
    public void enterMobileNoOnParcelPage(String mobileNo)
    {
        editMobileText = driver.findElement(By.xpath("//div[@class='left-form']/div[2]/input"));
        editMobileText.clear();
        myActions.action_sendKeys(editMobileText,mobileNo);
    }
    public void enterAddress(String address)
    {
        editAddressText = driver.findElement(By.xpath("//div[@class='left-form']/div[3]/*"));
        editAddressText.clear();
        myActions.action_sendKeys(editAddressText,address);
    }
    public void enterCashCollectionAmount(String amount)
    {
        editAmount = driver.findElement(By.xpath("//div[@class='right-form']/div[3]/*"));
        editAmount.clear();
        myActions.action_sendKeys(editAmount,amount);
    }

    public void enterSellingPrice(String amount)
    {
        editSellingPriceText = driver.findElement(By.xpath("//div[@class='right-form']/div[4]/*"));
        editSellingPriceText.clear();
        myActions.action_sendKeys(editSellingPriceText,amount);
    }

    public void clickAcknowledgeButton()
    {
        acknowledgeBoxButton = driver.findElements(By.xpath("//div[@class='right-form']//span[@class='ant-checkbox']/input"));
        myActions.action_click(acknowledgeBoxButton.get(2));
    }

    public void enterAreaTerm(String location,String lastletter)
    {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div[2]/input"))).sendKeys(location);
        sleep(500);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div[2]/input"))).sendKeys(lastletter);
        sleep(1000);
    }

    public WebElement deliveryCharge()
    {
        deliveryCharge = driver.findElement(By.xpath("//div[@class='delivery-charge']/div[@class='body']/div[2]/p[2]"));
        return deliveryCharge;
    }

    public WebElement CODCharge()
    {
        CODCharge = driver.findElement(By.xpath("//div[@class='delivery-charge']/div[@class='body']/div[3]/p[2]"));
        return CODCharge;
    }
    public void clickOnSubmitNewParcelButton()
    {
        newParcelSubmitButton = driver.findElement(By.xpath("//div[@class='btn-wrappper']/button"));
        myActions.action_click(newParcelSubmitButton);
    }

    public void clickOnParcelPopupOkButton()
    {
        parcelPopup = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-btns']/button"));
        myActions.action_click(parcelPopup);
    }

    public List<WebElement> areaDropDown()
    {
        return areaDropDown = driver.findElements(By.xpath("//div[@class='right-form']/div[1]//div[@class='area-tree']/p"));
    }

    public WebElement deliveryChargeParcelPage()
    {
        deliveryOnChargeParcelPage = driver.findElement(By.xpath("//div[@tabindex='-1']/table[@class='ant-table-fixed']/tbody/tr[1]/td[7]"));
        return deliveryOnChargeParcelPage;
    }


    //**************************Functions************************//

    public void createNewParcel(String divisionTerm,String districtTerm,String location_or_AreaTerm,int addressIndex,String lastLetter)
    {
        homePageObjects.clickOnCreateParcelButton();
        sleep(1000);
        enterCustomerName("Customer Name Savar");
        enterMobileNoOnParcelPage("01877755590");
        enterAddress("Address");
        enterCashCollectionAmount(System.getProperty("selling price"));
        enterSellingPrice(System.getProperty("selling price"));

        enterAndApplyAddress(divisionTerm,districtTerm,location_or_AreaTerm,addressIndex);
        sleep(1000);
        clickAcknowledgeButton();
    }

    public void enterAndApplyAddress(String divisionTerm,String districtTerm,String location_or_AreaTerm,int addressIndex) {
        enterSellingPrice(System.getProperty("selling price"));
        enterAreaTerm(divisionTerm, "");
        sleep(500);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
        sleep(100);
        enterAreaTerm(districtTerm, "");
        sleep(100);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
        sleep(100);
        enterAreaTerm(location_or_AreaTerm, "");
        sleep(100);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
    }


}
