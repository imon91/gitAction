package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.StoreWapActions;

import java.util.Random;

import static utils.StoreWapBaseClass.getBaseDriver;

public class EditProductsPageObjects {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;
    private Random random;


    @FindBy(xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Edit Products']//parent::div//parent::div//parent::div//parent::div//following-sibling::div")
    private WebElement navButton;

    @FindBy(xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='navback']")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='headerTitle']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//input")
    private WebElement customerName;

    @FindBy(xpath = "//div[text()='Next']")
    private WebElement nextButtonInEditProducts;

    public EditProductsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
        random = new Random();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickOnBackButton(){storeWapActions.action_click(backButton);}

    public void clickOnNextButton() throws Exception {
        WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Edit Products']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Next']"))).click();
    }


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getPageTitleText(){
        return storeWapActions.action_getText(pageTitle);
    }

    public void editProductName(String name, int productIndex){
        String xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr']/div[@class='css-1dbjc4n']["+ productIndex +"]/div/div[1]//input";
        WebElement nameElement = androidDriver.findElement(By.xpath(xpath));
        new Actions(androidDriver).click(nameElement).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(name).perform();
    }

    public void editProductQuantity(String quantity, int productIndex){
        String xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr']/div[@class='css-1dbjc4n']["+ productIndex +"]/div/div[2]//input";
        WebElement quantityElement = androidDriver.findElement(By.xpath(xpath));
        if (quantity == ""){
            quantity = ""+random.nextInt(10)+1;
        }
        new Actions(androidDriver).click(quantityElement).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(quantity).perform();
    }

    public void editProductAmount(String amount, int productIndex){
        String xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr']/div[@class='css-1dbjc4n']["+ productIndex +"]/div/div[3]//input";
        WebElement amountElement = androidDriver.findElement(By.xpath(xpath));
        if (amount == ""){
            amount = ""+random.nextInt(2000)+1;
        }
        new Actions(androidDriver).click(amountElement).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(amount).perform();
    }

    public void deleteProduct(int productIndex){
        String xpath = "//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr']/div[@class='css-1dbjc4n']["+ productIndex +"]/div/div[3]/div[2]";
        WebElement deleteElement = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(deleteElement);
    }

}
