package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;
import java.util.Random;

public class BagPageObjects {


    private final WebDriver driver;
    private final MyActions myActions;
    Random random = new Random();



    public BagPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();

    }

    //Place Order button
    @FindBy(xpath = "//button[text()='PLACE ORDER']")
    private WebElement placeOrderButton;

    //Quantity + button
    @FindBy(xpath = "//input[@value='+']")
    private WebElement quantityPlus;

    //Quantity - button
    @FindBy(xpath = "//input[@value='-']")
    private WebElement quantityMinus;

    //Custom Price Entry
    @FindBy(xpath = "//input[@name='custom_price']")
    private WebElement customPriceEntry;

    //Get text from custom price
    @FindBy(xpath = "//ul[@class='list-unstyled cart-list-of-items'][1]/li//p[@class='toltal-amount-per-item']/span[2]")
    private WebElement minimumCustomprice;

    //Custom Price Save Button
    @FindBy(xpath = "//div[@class='prize-offer-zone col-sm-6 flex text-right']/div[2]/button")
    private WebElement customPriceSaveButton;

    //Delivery Charge
    @FindBy(xpath = "//input[@id='deliveryCharge']")
    private WebElement deliveryChargeEntry;

    //Delivery Charge Save Button
    @FindBy(xpath = "//div[@class='sub-total border_bottom']/div/button")
    private WebElement deliveryChargeSaveButton;

    //Continue Shopping
    @FindBy(xpath = "//span[text()='CONTINUE SHOPPING']")
    private WebElement continueShopping;

    //coupon button
    @FindBy(xpath = "//a[text()='APPLY NOW']")
    private WebElement couponButton;

    //enter coupon text
    @FindBy(xpath = "//input[@type='text'][@name='coupon_code']")
    private WebElement couponText;

    //coupon apply
    @FindBy(xpath = "//button[text()='APPLY']")
    private WebElement applycoupon;

    //click on product_1  (change ul in xpath to shift second product)
    @FindBy(xpath = "//div[@class='col-sm-8 items-in-cart']/ul[1]/li/ul/li/div/div[2]/div/p/a")
    private WebElement product1;

    //click on product_2
    @FindBy(xpath = "//div[@class='col-sm-8 items-in-cart']/ul[2]/li/div")
      private WebElement product2;



    /*--------------Actions-------------------*/

    public void clickQuantityPlus() {
        myActions.action_click(quantityPlus);
    }

    public void clickQuantityMinus() {
        myActions.action_click(quantityMinus);
    }

    public void enterCustomPrice(String customprice) {
        myActions.action_sendKeys(customPriceEntry,customprice);
    }


    public void saveCustomPrice() {
        myActions.action_click(customPriceSaveButton);
    }

    public void enterDeliveryCharge(String deliveryCharge) {
        myActions.action_sendKeys(deliveryChargeEntry, deliveryCharge);
    }

    public void saveDeliveryCharge() {
        myActions.action_click(deliveryChargeSaveButton);
    }

    public void clickOnCouponButton() {
        myActions.action_click(couponButton);
    }

    public void enterCouponText(String coupon) {
        myActions.action_sendKeys(couponText,coupon);
    }

    public void clickOnApplyCoupon() { myActions.action_click(applycoupon);
    }

    public void clickContinueShopping() {
        myActions.action_click(continueShopping);
    }

    public void clickOnPlaceOrder() {
        myActions.action_click(placeOrderButton);
    }

    public void clickProduct1() {
        myActions.action_click(product1); }




    /*------Function-------*/

    public void enterQuantity(int qunatity) throws InterruptedException {
        int i;
        for (i = 1; i < qunatity; i++) {
            clickQuantityPlus();
        Thread.sleep(500);} }

    public void enterCustomPrice() {
        String minimumPrice = myActions.action_getText(minimumCustomprice);
       //Double minimumAmount = Double.parseDouble(minimumPrice);
        System.out.println(minimumPrice);
        //myActions.action_sendKeys(customPriceEntry,minimumAmount);
    }

      /////////////////////////////*****Dynamic functions********////////////////
    ///////////////////////////////*Outer and InnerClasses*////////////////////////

    public class OuterClass {
        //Place Order button
        @FindBy(xpath = "//button[text()='PLACE ORDER']")
        private WebElement placeOrderButton;
        public void clickOnPlaceOrder() {
            myActions.action_click(placeOrderButton);
        }

        //Delivery Charge
        @FindBy(xpath = "//input[@id='deliveryCharge']")
        private WebElement deliveryChargeEntry;
        public void enterDeliveryCharge(String deliveryCharge) {
            myActions.action_sendKeys(deliveryChargeEntry, deliveryCharge); }

        //Delivery Charge Save Button
        @FindBy(xpath = "//div[@class='sub-total border_bottom']/div/button")
        private WebElement deliveryChargeSaveButton;
        public void saveDeliveryCharge() {
            myActions.action_click(deliveryChargeSaveButton);
        }

        //coupon button
        @FindBy(xpath = "//a[text()='APPLY NOW']")
        private WebElement couponButton;
        public void clickOnCouponButton() {
            myActions.action_click(couponButton);
        }

        //enter coupon text
        @FindBy(xpath = "//input[@type='text'][@name='coupon_code']")
        private WebElement couponText;
        public void enterCouponText(String coupon) {
            myActions.action_sendKeys(couponText,coupon);
        }

        //coupon apply
        @FindBy(xpath = "//button[text()='APPLY']")
        private WebElement applycoupon;
        public void clickOnApplyCoupon() { myActions.action_click(applycoupon); }

        //Continue Shopping
        @FindBy(xpath = "//span[text()='CONTINUE SHOPPING']")
        private WebElement continueShopping;
        public void clickContinueShopping() {
            myActions.action_click(continueShopping);
        }

        //total items in kart
        @FindBy(xpath = "//div[@class='cart-value-right_header']/p/span[2]")
        private WebElement totalKartItems;
        public void printTotalKartItem(){String kartItems=myActions.action_getText(totalKartItems);
            System.out.println("Total kart Items are "+kartItems);}

        //total kart value
        @FindBy(xpath = "//div[@class='cart-value-right_header']/h2/span[2]")
        private WebElement totalKartValue;
        public void printTotalKartValue(){String kartValue=myActions.action_getText(totalKartValue);
        System.out.println("Total kart values are "+kartValue);}
    }


    //**************************Dynamic Xpaths function***********************//

    /*---------product all detail in kart------------*/

     public class Innnerclass {

        String productsXpath = "//div[@class='col-sm-8 items-in-cart']//ul[@class='list-unstyled cart-list-of-items']/li";
        List<WebElement> productList = driver.findElements(By.xpath(productsXpath));

        public String allDetailsOfProduct(int productNo) {
            String productName = "";
            String productSize = "";
            String productQuantity = "";
            String productEarnings = "";
            String productTotalAmount = "";
            if (productNo != 0 && productNo <= productList.size()) {
                //product name
                String product = productsXpath + "[" + productNo + "]//div[@class='col-sm-10']//a";
                WebElement productname = driver.findElement(By.xpath(product));
                productName = myActions.action_getText(productname);
                //product size
                String productsiz = productsXpath + "[" + productNo + "]//div[@class='row reduce-left-margin']//select";
                WebElement productsize = driver.findElement(By.xpath(productsiz));
                productSize = myActions.action_getText(productsize);
                //product quantity
                String productquant = productsXpath + "[" + productNo + "]//div[@class='qty-selection flex']//input[@type='text']";
                WebElement productquantity = driver.findElement(By.xpath(productquant));
                productQuantity = myActions.action_getText(productquantity);
                //product earnings
                String productearn = productsXpath + "[" + productNo + "]//div[@class='save_to_wishlist flex row']/p[2]/span[2]";
                WebElement productearning = driver.findElement(By.xpath(productearn));
                productQuantity = myActions.action_getText(productearning);
                //product total
                String producttot = productsXpath + "[" + productNo + "]//div[@class='save_to_wishlist flex row']/p[3]/span[2]";
                WebElement producttotal = driver.findElement(By.xpath(producttot));
                productTotalAmount = myActions.action_getText(producttotal);
            } else {
                int index = random.nextInt(productList.size());
                index++;
                //product name
                String product = productsXpath + "[" + index + "]//div[@class='col-sm-10']//a";
                WebElement productname = driver.findElement(By.xpath(product));
                productName = myActions.action_getText(productname);
                //product size
                String productsiz = productsXpath + "[" + index + "]//div[@class='row reduce-left-margin']//select";
                WebElement productsize = driver.findElement(By.xpath(productsiz));
                productSize = myActions.action_getText(productsize);
                //product quantity
                String productquant = productsXpath + "[" + index + "]//div[@class='qty-selection flex']//input[@type='text']";
                WebElement productquantity = driver.findElement(By.xpath(productquant));
                productQuantity = myActions.action_getText(productquantity);
                //product earnings
                String productearn = productsXpath + "[" + index + "]//div[@class='save_to_wishlist flex row']/p[2]/span[2]";
                WebElement productearning = driver.findElement(By.xpath(productearn));
                productQuantity = myActions.action_getText(productearning);
                //product total
                String producttot = productsXpath + "[" + index + "]//div[@class='save_to_wishlist flex row']/p[3]/span[2]";
                WebElement producttotal = driver.findElement(By.xpath(producttot));
                productTotalAmount = myActions.action_getText(producttotal);
            }
            System.out.println("product Size of paticular product is " + productSize);
            System.out.println("product Quantity of paticular product is " + productQuantity);
            System.out.println("product earnings of paticular product is " + productEarnings);
            System.out.println("product Total amount of paticular product is " + productTotalAmount);
            return productName;
        }


        /*--------Minimum amount of product--------*/
        public void getMinimumAmountOfProduct(int productNo) {
            if (productNo != 0) {
                String amount = productsXpath + "[" + productNo + "]//div[@class='save_to_wishlist flex row']/p[3]/span[2]";
                WebElement amountPath = driver.findElement(By.xpath(amount));
                String minamount = myActions.action_getText(amountPath);
                String minimumamount = minamount.replaceAll("[^0-5000]", "");
                String amountInputText = productsXpath + "[" + productNo + "]//input[@class='form-control custom-price white-bg']";
                WebElement amountInput = driver.findElement(By.xpath(amountInputText));
                myActions.action_sendKeys(amountInput, minimumamount + 5);
                String savebutton = productsXpath + "[" + productNo + "]//button";
                WebElement saveButton = driver.findElement(By.xpath(savebutton));
                myActions.action_click(saveButton);
                System.out.println(minimumamount);
            } else {
                int index;
                for (index = 1; index <= productList.size(); index++) {
                    String amount = productsXpath + "[" + index + "]//div[@class='save_to_wishlist flex row']/p[3]/span[2]";
                    WebElement amountPath = driver.findElement(By.xpath(amount));
                    String minamount = myActions.action_getText(amountPath);
                    String minimumamount = minamount.replaceAll("[^0-5000]", "");
                    String amountInputText = productsXpath + "[" + index + "]//input[@class='form-control custom-price white-bg']";
                    WebElement amountInput = driver.findElement(By.xpath(amountInputText));
                    myActions.action_sendKeys(amountInput, minimumamount + 5);
                    String savebutton = productsXpath + "[" + index + "]//button";
                    WebElement saveButton = driver.findElement(By.xpath(savebutton));
                    myActions.action_click(saveButton);
                    System.out.println(minimumamount);
                }
            }
        }

        //Delete product

        public void deleteProduct(int productNo) {
            String deletebut = productsXpath + "[" + productNo + "]//div[@class='save_to_wishlist flex row']/p[@class='pointer']";
            WebElement deleteButton = driver.findElement(By.xpath(deletebut));
            myActions.action_click(deleteButton);
        }

        //view product in pdp page
        public void viewProduct(int productNo) {
            String productname = productsXpath + "[" + productNo + "]//div[@class='col-sm-10']//a";
            WebElement productnam = driver.findElement(By.xpath(productname));
            myActions.action_click(productnam);
        }

        /*----product Size Selection----------*/
        //This function change the size of products by declaring productNo and sizeIndex. If dosent given both, it takes random value.
         public void changeSizeOfProduct(int productNo,int sizeIndex)
         {
            List<WebElement> productSizesList = driver.findElements(By.xpath(productsXpath+"["+productNo+"]//div[@class='item-details']//div[@class='size-selection flex']/select/option"));
            if((sizeIndex!=0)&&(sizeIndex<=productSizesList.size()))
            {
                //click on size
                String size = productsXpath+"["+productNo+"]//div[@class='item-details']//div[@class='size-selection flex']/select";
                WebElement productSize = driver.findElement(By.xpath(size));
                myActions.action_click(productSize);
                //select size
                String whichSize = size+"/option["+sizeIndex+"]";
                WebElement sizeClicked = driver.findElement(By.xpath(whichSize));
                myActions.action_click(sizeClicked);
            }
            else
            {
                int index1 = random.nextInt(productList.size());
                index1++;
                int index2 = random.nextInt(productSizesList.size());
                index2++;
                //click on size
                String size= productsXpath+"["+index1+"[//div[@class='item-details']//div[@class='size-selection flex']/select";
                WebElement productSize = driver.findElement(By.xpath(size));
                myActions.action_click(productSize);
                //select size
                String whichSize = size+"/option["+index2+"]";
                WebElement sizeClicked = driver.findElement(By.xpath(whichSize));
                myActions.action_click(sizeClicked);
            }


        }

        /*click product image*/
         //this function click the product image
         public void clickOnProductImage(int productNo)
         {
             String img;
             if(productNo!=0)
             {
                 img = productsXpath + "[" + productNo + "]//img";
             }
             else
                 {
                     int index=random.nextInt(productList.size());
                     img = productsXpath+"["+ ++index+"]//img";
                 }
             WebElement image = driver.findElement(By.xpath(img));
             myActions.action_click(image);
         }

         /*Total number of quantity in bag */
         public void getTotalQuantityOfProductsInBag()
         {
             int prNo= productList.size();
             int i,quant,quanties=0;
             for (i=1;i<=prNo;i++)
             {
                 String quantity=productsXpath+"["+i+"]//div[@class='qty-selection flex']//input[@type='text']";
                 WebElement Quanti=driver.findElement(By.xpath(quantity));
                 String totquant = myActions.action_getText(Quanti);
                 quant = Integer.parseInt(totquant);
                 quanties = quant + quanties;
                 System.out.println(quanties);
             }
         }





    }




}



