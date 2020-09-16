package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.OmsBaseClass;

public class CatalogPageObjects extends OmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private String ck;

    public CatalogPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    private void clickSelectCategory() {
        WebElement selectCategory = xpathSetter("//body/div/div/div/div/form/div/button[1]");
        myActions.action_click(selectCategory);
    }

    private void selectAMT() {
        WebElement selectCategory = xpathSetter("//li[78]//a[1]//label[1]");
        myActions.action_click(selectCategory);
    }

    private void clickDownloadTemplate() {
        WebElement downloadTemplate = xpathSetter("//a[@id='template_download_link']");
        myActions.action_click(downloadTemplate);
    }

    private void catalogUpload(String filePath){
        WebElement uploadTemplate = xpathSetter("//input[@id='catalog_file']");
        myActions.action_sendKeys(uploadTemplate, filePath);
    }

    private void clickUpload() {
        WebElement uploadTemplate = xpathSetter("//body//form//button[4]");
        myActions.action_click(uploadTemplate);
    }


    /*--------------Functions-------------------*/
    public void downloadCatalog() {
        clickSelectCategory();
        selectAMT();
        clickDownloadTemplate();
    }

    public void uploadCatalog(String filePath){
        catalogUpload(filePath);
        clickUpload();
    }

}
