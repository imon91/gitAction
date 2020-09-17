package pageObjects;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.responseModels.omsModels.AdminMasterTemplate;
import utils.*;
import java.io.*;
import java.util.*;

public class CatalogPageObjects extends OmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public CatalogPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickSelectCategory() {
        WebElement selectCategory = xpathSetter("//body/div/div/div/div/form/div/button[1]");
        myActions.action_click(selectCategory);
    }

    public void selectAMT() {
        WebElement selectCategory = xpathSetter("//li[78]//a[1]//label[1]");
        myActions.action_click(selectCategory);
    }

    public void clickDownloadTemplate() {
        WebElement downloadTemplate = xpathSetter("//a[@id='template_download_link']");
        myActions.action_click(downloadTemplate);
    }

    public void catalogUpload(String filePath){
        WebElement uploadTemplate = xpathSetter("//input[@id='catalog_file']");
        myActions.action_sendKeys(uploadTemplate, filePath);
    }

    public void clickUpload() {
        WebElement uploadTemplate = xpathSetter("//body//form//button[4]");
        myActions.action_click(uploadTemplate);
    }

    public boolean uploadConfirmation(){
        WebElement confirm = xpathSetter("//p[contains(text(),'Catalog is getting uploaded.')]");
        return confirm.isDisplayed();
    }

    public void clickUploadHistory() {
        WebElement uploadHistory = xpathSetter("//a[contains(text(),'View upload History')]");
        myActions.action_click(uploadHistory);
    }


    /*--------------Functions-------------------*/
    public void downloadCatalog() {
        clickSelectCategory();
        selectAMT();
        clickDownloadTemplate();
    }

    public boolean uploadCatalog(String filePath){
        catalogUpload(filePath);
        clickUpload();
        return uploadConfirmation();
    }

    public class ViewUploadHistory{
        private WebDriver driver;
        private MyActions myActions;

        public ViewUploadHistory(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements((driver), this);
            myActions = new MyActions();
        }


        /*--------------Actions-------------------*/
        public void downloadRecent(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[1]/a");
            myActions.action_click(downloadRecentUpload);
        }

        public String recentUploadTime(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[1]/small");
            return myActions.action_getText(downloadRecentUpload);
        }

        public String recentUploadType(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[2]");
            return myActions.action_getText(downloadRecentUpload);
        }

        public String recentUploadStatus(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[3]");
            return myActions.action_getText(downloadRecentUpload);
        }

        public String recentUploadMessage(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[4]");
            return myActions.action_getText(downloadRecentUpload);
        }

        public String recentUploadStats(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[5]");
            return myActions.action_getText(downloadRecentUpload);
        }

        public void downloadErrorSheet(int index) {
            index++;
            WebElement downloadRecentUpload = xpathSetter("//tbody/tr["+index+"]/td[6]/a");
            myActions.action_click(downloadRecentUpload);
        }
    }

    public class ExcelSheetEditor{
        private WebDriver driver;
        private MyActions myActions;
        private FileInputStream fis;
        private FileOutputStream fileOut;
        private Workbook wb;
        private Sheet sh;
        private Map<String, Integer> columns = new HashMap<>();

        public ExcelSheetEditor(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements((driver), this);
            myActions = new MyActions();
        }


        /*--------------Functions-------------------*/
        public void excelSheetEditor(String filePath, String imageURL) throws Exception {
            fis = new FileInputStream(filePath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet("Product Feed");
            int rows = sh.getLastRowNum();
            System.out.println(rows);

            ArrayList<AdminMasterTemplate> a = inputData(imageURL);
            int rowNum = 4;
            for(AdminMasterTemplate c : a){
                Row row = sh.createRow(rowNum++);
                row.createCell(0).setCellValue(c.getCategory());
                row.createCell(1).setCellValue(c.getSellerCode());
                row.createCell(2).setCellValue(c.getSku());
                row.createCell(3).setCellValue(c.getProductId());
                row.createCell(4).setCellValue(c.getItemName());
                row.createCell(5).setCellValue(c.getDescription());
                row.createCell(6).setCellValue(c.getUpdateOrDelete());
                row.createCell(7).setCellValue(c.getMaxSalePrice());
                row.createCell(8).setCellValue(c.getDiscountedSalePrice());
                row.createCell(9).setCellValue(c.getLiftingPrice());
                row.createCell(10).setCellValue(c.getQuantity());
                row.createCell(11).setCellValue(c.getSize());
                row.createCell(12).setCellValue(c.getLeadTime());
                row.createCell(13).setCellValue(c.getWeight());
                row.createCell(14).setCellValue(c.getUrl());
            }

            fileOut = new FileOutputStream(filePath);
            wb.write(fileOut);
            fileOut.close();
            wb.close();


        }

        public ArrayList<AdminMasterTemplate> inputData(String imageURL) {
            ArrayList<AdminMasterTemplate> a = new ArrayList<>();
            a.add(new AdminMasterTemplate("Track Pants",287000423,"p01",90909090,"Track Pants","Comfortable Track Pants","update",999,700,700,5,"S",24,"500",imageURL));
            a.add(new AdminMasterTemplate("Track Pants",287000423,"p02",90909090,"Track Pants","comfortable Track Pants","update",999,700,700,3,"M",24,"500","www.maggi.co"));
            a.add(new AdminMasterTemplate("Track Pants",287000423,"p03",90909090,"Track Pants","comfortable Track Pants","update",999,700,700,3,"S",24,"500",imageURL));
            a.add(new AdminMasterTemplate("Track Pants",287000423,"p04",90909090,"Track Pants","comfortable Track Pants","update",999,700,700,3,"M",24,"500",imageURL));
            a.add(new AdminMasterTemplate("Track Pants",287000423,"p05",418406,"Track Pants","comfortable Track Pants","update",999,700,700,3,"M",24,"500",imageURL));
            return a;
        }
    }



}
