package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class LatestPageObjects {
    private final WebDriver driver;
    private final MyActions myActions;

    public LatestPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    //Men Icon
    @FindBy(xpath = "//li[contains(@data-reactid,'.wey0nwp5gy.1.2.0.0.0:1')]")
    private WebElement menIcon;

    //Women Icon
    @FindBy(xpath = "//li[contains(@data-reactid,'.wey0nwp5gy.1.2.0.0.0:0')]")
    private WebElement womenIcon;

    /*--------PLP icons------*/
    //home icon
    @FindBy(xpath = "//li[@class='breadcrumb-item'][1]")
    private WebElement homeIcon;

    @FindBy(xpath = "//h1[@class='listingname']/following-sibling::span[2]/span[1]")
    private WebElement numberOfItems;

    //show 3 button
    @FindBy(xpath = "//button[text()='3']")
    private WebElement showThreeButton;

    //show 4 button
    @FindBy(xpath = "//button[text()='4']")
    private WebElement showFourButton;


    /*-----------Sort Functionalities--------*/

    //sort by personalise
    @FindBy(xpath = "//span[text()='Personalize']")
    private WebElement sortByPersonalizeOption;

    //sort by new
    @FindBy(xpath = "//span[contains(text(),'New')]")
    private WebElement sortByNewOption;

    //sort by discount
    @FindBy(xpath = "//span[contains(text(),'Discount')]")
    private WebElement sortByDicountOption;

    //sort by price low
    @FindBy(xpath = "//span[text()='Low']")
    private WebElement sortByPriceLow;

    //sort by price high
    @FindBy(xpath = "//span[text()='High']")
    private WebElement sortByPriceHigh;


    public void clickOnIcon() {
        myActions.action_click(menIcon);
    }

    public void clickOnWomenIcon() {
        myActions.action_click(womenIcon);
    }

    public void clickOnHomeIcon() {
        myActions.action_click(homeIcon);
    }

    //public void clickOnNumberOfItems() {myActions.action_click(numberOfItems);}

    public void clickOnShowThreeButton() {
        myActions.action_click(showThreeButton);
    }

    public void clickOnShowFourButton() {
        myActions.action_click(showFourButton);
    }

    public void clickOnSortByPersonalizeOption() {
        myActions.action_click(sortByPersonalizeOption);
    }

    public void clickOnSortByNewOption() {
        myActions.action_click(sortByNewOption);
    }

    public void clickOnSortByDiscountOption() {
        myActions.action_click(sortByDicountOption);
    }

    public void clickOnSortByPriceLow() {
        myActions.action_click(sortByPriceLow);
    }

    public void clickOnSortByPriceHigh() {
        myActions.action_click(sortByPriceLow);
    }


    /*---------Function---------*/
    public void totalNumberOFItems() {
        String totalItems = myActions.action_getText(numberOfItems);
        System.out.println("Total number of items are : "+totalItems);
    }




}