package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.AndroidBaseClass;
import utils.MyActions;
import utils.ServiceRequestLayer;

import java.util.*;


public class ProductDescriptionPage  extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ServiceRequestLayer serviceRequestLayer;
    private LoginPageObjects loginPageObjects;
    private MyActions myActions;
    private HomePageObjects homePageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    private ProductListingPageObjects productListingPageObjects;
    private ProductDescriptionPageObjects productDescriptionPageObjects;
    private ProductDescriptionPageObjects.NewProductDescriptionObjects newProductDescriptionObjects;
    private Random random;

    public String validMobileNumber = "01877755590";
    public String validOTP = "666666";
    public String productName = "Dettol";
    public String priceText = "Price";
    public String aboutThisProductText = "About this Product";
    public String codeText = "Code:";
    public String categoryText = "Category:";
    public String recentlyViewedByYouText = "Recently viewed by you";
    public String goToCartText = "Go to Cart";
    public String continueShoppingText = "Continue Shopping";
    public String packSizesText = "Pack Sizes";
    public String outOfStockText = "OUT OF STOCK";
    public String requestStockText = "Request Stock";
    public String plusText = "+";
    public String addText = "Add";
    public String minusText = "-";
    public String selectQuantityText = "Select Quantity";

    private String itemName;
    private int cartQuantity;
    private int productIndexInPLP;

    private Map<String, List<Object>> productDetailsOfItemsInCart = new HashMap<>();
    private Map<String ,List<Object>> productDetailsOfItemsInPLPPage = new HashMap<>();
    private Map<String,Object> productDetailsOfProductInPDPPage = new HashMap<>();
    private List<String> productQuantityOfItemsInPLPPage = new ArrayList<>();
    private List<String> productQuantityOfItemsInCart = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHas0Quantity = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHasMoreThanMinQuantity = new ArrayList<>();
    private List<String> productNameOfItemsInPLPPage = new ArrayList<>();
    private List<String> productIdOfItemsInCart= new ArrayList<>();
    private List<String> productIdOfItemsInPLPPage = new ArrayList<>();
    private String slug ;


    @BeforeSuite(alwaysRun = true)
    public void productDescriptionPageBeforeSuite (){
        System.out.println("ProductDescriptionPageBeforeSuite is called");
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication(validMobileNumber,validOTP);
        sleep(4000);
        homePageObjects.selectAddress(0);
        sleep(3000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        searchAProduct();
        getApiData();
        productIndexInPLP = indexOfItemsInPLPWhichHasMoreThanMinQuantity.get(0);
        itemName = productNameOfItemsInPLPPage.get(productIndexInPLP);
        productListingPageObjects.selectAProductInPLPPage(itemName);
        //System.out.println(EndPoints.RECOMMENDATIONS+slug);
        productDetailsOfProductInPDPPage = productDescriptionPageObjects.getProductDetailsOfProductInPDPPage(slug);
    }

    public void pageInitializer(){
        serviceRequestLayer = new ServiceRequestLayer();
        //new MokamPdpPageObjects().clickOnContinueShoppingButton();
        myActions = new MyActions();
        loginPageObjects = new LoginPageObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(androidDriver);
        newProductDescriptionObjects = productDescriptionPageObjects.new NewProductDescriptionObjects(androidDriver);
        random = new Random();
    }

    private void searchAProduct(){
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects.enterProductName(productName);
        searchPageObjects.clickOnSearchButton();
        sleep(4000);
    }

    private void getApiData(){
        productDetailsOfItemsInCart = productListingPageObjects.getProductDetailsOfItemsInCart();
        productDetailsOfItemsInPLPPage = productListingPageObjects.getProductDetailsOfItemsInPLPPage(productName);
        productQuantityOfItemsInPLPPage = productListingPageObjects.getProductQuantityOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        productNameOfItemsInPLPPage = productListingPageObjects.getProductNameOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        productIdOfItemsInCart = productListingPageObjects.getProductIdOfItemsInCart(productDetailsOfItemsInCart);
        productQuantityOfItemsInCart = productListingPageObjects.getProductQuantityOfItemsInCart(productDetailsOfItemsInCart);
        productIdOfItemsInPLPPage = productListingPageObjects.getProductIdOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        getIndexOfItemsBasedOnQuantity();
        slug = productListingPageObjects.getProductSlug(productName,indexOfItemsInPLPWhichHasMoreThanMinQuantity.get(0));
        System.out.println(slug);
    }

    private void getIndexOfItemsBasedOnQuantity(){
        for(int i=0;i<productQuantityOfItemsInPLPPage.size();i++){
            if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))==0){
                indexOfItemsInPLPWhichHas0Quantity.add(i);
            }
            else if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))>50){
                indexOfItemsInPLPWhichHasMoreThanMinQuantity.add(i);
            }
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonFunctionality(){
        sleep(3000);
        actionBarObjects.clickOnBackButton();
        sleep(3000);
        productListingPageObjects.selectAProductInPLPPage(itemName);
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyHardBackButtonFunctionality() throws Exception {
        myActions.clickOnHardKeyBack();
        sleep(3000);
        productListingPageObjects.selectAProductInPLPPage(itemName);
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyProductNameInPDPPageActionBar(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getTextOnHeader());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyProductNameInPDPPage(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getNameOfProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyNumberOfItemsInCart(){
        for(int i=0;i<productIdOfItemsInCart.size();i++){
            cartQuantity += Integer.parseInt(productQuantityOfItemsInCart.get(i));
        }
        Assert.assertEquals(actionBarObjects.getNumberOfItemsInCart(),cartQuantity+"");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifySearchIconFunctionality(){
        Assert.assertEquals(actionBarObjects.getSearchIconElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyCartIconFunctionality(){
        Assert.assertEquals(actionBarObjects.getCartIconElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyPriceText(){
        Assert.assertEquals(priceText,productDescriptionPageObjects.getPriceText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyBrandName(){
        //System.out.println(productDetailsOfProductInPDPPage);
        //System.out.println("Api : "+productDescriptionPageObjects.getBrandApi(productDetailsOfProductInPDPPage));
        //System.out.println(productDescriptionPageObjects.getBrandNameFromPDP());
        Assert.assertEquals(productDescriptionPageObjects.getBrandApi(productDetailsOfProductInPDPPage),productDescriptionPageObjects.getBrandNameFromPDP());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyPriceUnderProductName(){
        //System.out.println("Api : "+ productDescriptionPageObjects.getPriceApi(productDetailsOfProductInPDPPage) );
        //System.out.println("Tk."+(productDescriptionPageObjects.getPriceFromPDPPage().replace('৳',' ')));
        Assert.assertEquals("Tk."+productDescriptionPageObjects.getPriceFromPDPPage().replace('৳',' '),productDescriptionPageObjects.getPriceApi(productDetailsOfProductInPDPPage));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyPackSize(){
        Assert.assertEquals(productDescriptionPageObjects.getPackSizeFromPDP(), productDescriptionPageObjects.getProductSizeApi(productDetailsOfProductInPDPPage));//
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyPriceUnderPackSizes(){
        //System.out.println(productDescriptionPageObjects.getPriceUnderPackSizeFromPDP());
        //System.out.println(productDescriptionPageObjects.getProductPriceUnderSizeApi(productDetailsOfProductInPDPPage));
        Assert.assertEquals(productDescriptionPageObjects.getPriceUnderPackSizeFromPDP(),"৳"+productDescriptionPageObjects.getProductPriceUnderSizeApi(productDetailsOfProductInPDPPage));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyImageClickability(){
        Assert.assertEquals(productDescriptionPageObjects.getImageButton().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyCloseImageButtonFunctionality(){
        productDescriptionPageObjects.getImageButton().click();
        productDescriptionPageObjects.clickOnCloseImageButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyImageButtonFunctionality(){
        productDescriptionPageObjects.getImageButton().click();
        Assert.assertEquals(productDescriptionPageObjects.getButtonRightArrow().getAttribute("clickable"),"true");
        Assert.assertEquals(productDescriptionPageObjects.getButtonLeftArrow().getAttribute("clickable"),"true");
        productDescriptionPageObjects.clickOnCloseImageButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 16)
    public void verifyPackSizesText(){
        Assert.assertEquals(packSizesText,productDescriptionPageObjects.getPackSizesText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 17)
    public void verifyAboutThisProductText(){
        Assert.assertEquals(aboutThisProductText,productDescriptionPageObjects.getAboutThisProductText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 18)
    public void verifyCodeTextAndIdOfProduct(){
        String [] codeTextArrayActual = productDescriptionPageObjects.getCodeTextAndIDOfProduct().split("\\s");
        Assert.assertEquals(codeText,codeTextArrayActual[0]);
        Assert.assertEquals(productDescriptionPageObjects.getProductCodeApi(productDetailsOfProductInPDPPage),codeTextArrayActual[1]);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority =19)
    public void verifyCategoryTextAndProductCategory(){
        String [] categoryArrayText = productDescriptionPageObjects.getCategoryTextAndCategoryOfProduct().split("\\s");
        String [] expectedCategoryArrayText = productDescriptionPageObjects.getProductCategoryApi(productDetailsOfProductInPDPPage).split("\\s");
        Assert.assertEquals(categoryText,categoryArrayText[0]);
        for(int i=0;i<expectedCategoryArrayText.length;i++) {
            Assert.assertEquals(expectedCategoryArrayText[i], categoryArrayText[i+1]);
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 20)
    public void verifyProductNameInUnderAboutThisProduct(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getProductNameUnderAboutThisProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 21)
    public void verifyRecentlyViewedByYouText(){
        Assert.assertEquals(recentlyViewedByYouText,productDescriptionPageObjects.getRecentlyViewedByYouText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 22)
    public void verifyGoToCartButtonText(){
        Assert.assertEquals(goToCartText,productDescriptionPageObjects.getGoToCartButtonElement().getText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 23)
    public void verifyContinueShoppingButtonText(){
        Assert.assertEquals(continueShoppingText,productDescriptionPageObjects.getContinueShoppingButtonElement().getText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 24)
    public void verifyGoToCartButtonFunctionality(){
        Assert.assertEquals(productDescriptionPageObjects.getGoToCartButtonElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 25)
    public void verifyContinueShoppingButtonFunctionality(){
        Assert.assertEquals(productDescriptionPageObjects.getContinueShoppingButtonElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 26)
    public void verifyAddButtonText(){
        Assert.assertEquals(plusText,productDescriptionPageObjects.getAddItemToCart().getText());
        //System.out.println(productDescriptionPageObjects.checkIfItemIsInCart(productIdOfItemsInCart,productIdOfItemsInPLPPage.get(productIndexInPLP)));
        if(productDescriptionPageObjects.checkIfItemIsInCart(productIdOfItemsInCart,productIdOfItemsInPLPPage.get(productIndexInPLP))){
            Assert.assertEquals(minusText,productDescriptionPageObjects.getRemoveItemFromCart().getText());
        }
        else {
            Assert.assertEquals(addText,productDescriptionPageObjects.getAddButton().getText());
        }
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 27)
    public void selectMinQuantityFunctionality(){
        if(productDescriptionPageObjects.checkIfItemIsInCart(productIdOfItemsInCart,productIdOfItemsInPLPPage.get(productIndexInPLP))){
            productDescriptionPageObjects.getItemCountContainer().click();
        }
        else{
            productDescriptionPageObjects.getAddButton().click();
        }
        newProductDescriptionObjects.scrollInQuantityList(random.nextInt(48)+1);
        sleep(3000);
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 28)
    public void verifyAddItemToCartButtonFunctionality(){
        productDescriptionPageObjects.getAddItemToCart().click();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 29)
    public void verifyRemoveItemFromCartButtonFunctionality(){
        productDescriptionPageObjects.getRemoveItemFromCart().click();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 30)
    public void verifySelectQuantityText(){
        productDescriptionPageObjects.getItemCountContainer().click();
        Assert.assertEquals(selectQuantityText,productListingPageObjects.getSelectQuantityText());
        productListingPageObjects.getCloseItemQuantityButton().click();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 31)
    public void verifyCloseItemCountPopUpButton(){
        productDescriptionPageObjects.getItemCountContainer().click();
        productListingPageObjects.getCloseItemQuantityButton().click();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 32) //	৳
    public void selectMaxQuantityFunctionality(){
        productDescriptionPageObjects.getItemCountContainer().click();
        newProductDescriptionObjects.scrollInQuantityList(51);
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 33)
    public void verifyItemCount(){
        Assert.assertEquals(50+"",productDescriptionPageObjects.getItemCountContainer().getText());
        actionBarObjects.clickOnBackButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 34)
    public void verifyOutOfStockText(){
        System.out.println(indexOfItemsInPLPWhichHas0Quantity);
        if(indexOfItemsInPLPWhichHas0Quantity.size()>0){
            productListingPageObjects.selectAProductInPLPPage(productNameOfItemsInPLPPage.get(indexOfItemsInPLPWhichHas0Quantity.get(0)+1));
            //System.out.println(productNameOfItemsInPLPPage.get(indexOfItemsInPLPWhichHas0Quantity.get(0)));
            sleep(3000);
            Assert.assertEquals(outOfStockText,productDescriptionPageObjects.getOutOfStockText());
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 35)
    public void verifyRequestStockButtonText(){
        if(indexOfItemsInPLPWhichHas0Quantity.size()>0) {
            Assert.assertEquals(requestStockText, productDescriptionPageObjects.getRequestStockButtonElement().getText());
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 36)
    public void verifyRequestStockButtonFunctionality(){
        if(indexOfItemsInPLPWhichHas0Quantity.size()>0) {
            Assert.assertEquals(productDescriptionPageObjects.getRequestStockButtonElement().getAttribute("clickable"), "true");
        }
    }


    @AfterSuite(alwaysRun = true)
    public void loginScreenAfterSuite(){
        //actionBarObjects.clickOnCartButton();
        //sleep(3000);
        switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
        //myBagPageObjects.clickOnPlaceOrderButton();
        //sleep(3000);
        //checkoutAddressPageObjects.clickOnConfirmButton();
        System.out.println("ProductListingPageAfterSuite is called");
        quitBaseDriver();
    }



}